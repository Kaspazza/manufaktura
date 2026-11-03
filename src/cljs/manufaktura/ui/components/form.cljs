(ns manufaktura.ui.components.form
  "Practical Reagent adapter for React Hook Form.
  `use-form` returns the native RHF methods object; field render callbacks receive keywordized field/state maps.

  Version: 1.0.0
  Last updated: 2026-11-03"
  (:require
   ["@radix-ui/react-slot"          :refer [Slot]]
   ["react"                         :as react]
   ["react-hook-form"               :refer
                                    [Controller FormProvider useForm useFormContext useFormState]]
   [manufaktura.ui.components.label :as label]
   [manufaktura.utils.styles        :refer [merge-classes]]
   [reagent.core                    :as r]))

(def field-context (react/createContext nil))

(def item-context (react/createContext nil))

(defn options->js
  "Translate supported kebab-case useForm aliases. Native camelCase keys win conflicts.
  Field names and nested values are never renamed."
  [opts]
  (clj->js (reduce-kv (fn [result alias native]
                        (if (contains? result alias)
                          (cond-> (dissoc result alias)
                            (not (contains? result native)) (assoc native (get result alias)))
                          result))
                      opts
                      {:default-values :defaultValues
                       :re-validate-mode :reValidateMode
                       :criteria-mode :criteriaMode
                       :reset-options :resetOptions
                       :should-focus-error :shouldFocusError
                       :should-unregister :shouldUnregister
                       :should-use-native-validation :shouldUseNativeValidation
                       :delay-error :delayError})))

(defn use-form
  "Creates native RHF methods from CLJS options; accepts kebab aliases or native names."
  ([] (useForm))
  ([opts] (useForm (options->js opts))))

(defn- shallow-js-props
  [props]
  (reduce-kv (fn [result k value] (aset result (if (keyword? k) (name k) k) value) result)
             #js {}
             props))

(defn form
  [{:keys [methods]
    :as props}
   &
   children]
  (when-not methods (throw (js/Error. "form requires the React Hook Form methods object")))
  ;; Build only the shallow props envelope. RHF's identity-sensitive nested
  ;; objects and functions are copied by reference, and the methods object is
  ;; never converted or mutated during render.
  (let [provider-props (js/Object.assign #js {} methods (shallow-js-props (dissoc props :methods)))
        provider-children (r/as-element (into [:<>] children))]
    (r/create-element FormProvider provider-props provider-children)))

(defn handle-submit
  [^js methods on-valid & [on-invalid]]
  (.handleSubmit methods
                 #(on-valid (js->clj % :keywordize-keys true))
                 (when on-invalid #(on-invalid (js->clj % :keywordize-keys true)))))

(defn form-field
  [{:keys [name render]
    :as props}]
  [:>
   (.-Provider field-context)
   {:value #js {:name name}}
   [:>
    Controller
    (-> props
        (dissoc :render)
        (assoc :name name
               :render (fn [^js state]
                         (r/as-element
                          (render {:field (js->clj (.-field state) :keywordize-keys true)
                                   :field-state (js->clj (.-fieldState state) :keywordize-keys true)
                                   :form-state
                                   (js->clj (.-formState state) :keywordize-keys true)})))))]])

(defn use-form-field
  []
  (let [field (react/useContext field-context)
        item (react/useContext item-context)
        methods (useFormContext)]
    (when-not field (throw (js/Error. "use-form-field must be used within form-field")))
    (when-not item (throw (js/Error. "use-form-field must be used within form-item")))
    (let [name (.-name field)
          state (useFormState #js {:name name})
          field-state (.getFieldState methods name state)
          id (.-id item)]
      {:id id
       :name name
       :form-item-id (str id "-form-item")
       :form-description-id (str id "-form-item-description")
       :form-message-id (str id "-form-item-message")
       :error (some-> field-state
                      .-error
                      (js->clj :keywordize-keys true))
       :invalid? (boolean (.-invalid field-state))
       :touched? (boolean (.-isTouched field-state))
       :dirty? (boolean (.-isDirty field-state))})))

(defn form-item
  [{:keys [class]
    :as props}
   &
   children]
  (let [id (react/useId)]
    [:>
     (.-Provider item-context)
     {:value #js {:id id}}
     (into [:div
            (-> props
                (assoc :data-slot "form-item" :class (merge-classes "grid gap-2" class))
                (dissoc :class-name))]
           children)]))

(defn form-label
  [{:keys [class]
    :as props}
   &
   children]
  (let [{:keys [invalid? form-item-id]} (use-form-field)]
    (into [label/label
           (-> props
               (assoc :data-slot "form-label"
                      :data-error invalid?
                      :html-for form-item-id
                      :class (merge-classes "data-[error=true]:text-destructive" class))
               (dissoc :class-name))]
          children)))

(defn form-control
  [props & children]
  (let [{:keys [invalid? form-item-id form-description-id form-message-id]} (use-form-field)]
    (into [:>
           Slot
           (assoc props
                  :data-slot "form-control"
                  :id form-item-id
                  :aria-invalid invalid?
                  :aria-describedby
                  (if invalid? (str form-description-id " " form-message-id) form-description-id))]
          children)))

(defn form-description
  [{:keys [class]
    :as props}
   &
   children]
  (let [{:keys [form-description-id]} (use-form-field)]
    (into [:p
           (-> props
               (assoc :data-slot "form-description"
                      :id form-description-id
                      :class (merge-classes "text-sm text-muted-foreground" class))
               (dissoc :class-name))]
          children)))

(defn form-message
  [{:keys [class]
    :as props}
   &
   children]
  (let [{:keys [error form-message-id]} (use-form-field)
        body (or (get error "message") (:message error) (first children))]
    (when body
      [:p
       (-> props
           (assoc :data-slot "form-message"
                  :id form-message-id
                  :class (merge-classes "text-sm text-destructive" class))
           (dissoc :class-name))
       body])))
