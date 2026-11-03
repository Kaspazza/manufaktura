(ns manufaktura.stories.form.rhf-controls
  (:require
   [manufaktura.ui.components.button      :as button]
   [manufaktura.ui.components.form        :as form]
   [manufaktura.ui.components.radio-group :as radio]
   [manufaktura.ui.components.select      :as select]
   [manufaktura.ui.components.switch      :as switch]
   [manufaktura.ui.components.textarea    :as textarea]))

(defn example
  []
  [:f>
   (fn []
     (let [form-shell (fn [methods on-valid & children]
                        [form/form {:methods methods}
                         (into [:form {:class "grid w-full max-w-xl gap-5"
                                       :no-validate true
                                       :on-submit (form/handle-submit methods on-valid)}]
                               children)])
           methods (form/use-form {:default-values {:framework "reagent"
                                                    :updates true
                                                    :biography ""
                                                    :plan "free"}})
           control (.-control methods)]
       (form-shell
        methods
        (fn* [%1] (js/alert (str "Submitted controls: " (pr-str %1))))
        [form/form-field
         {:control control
          :name "framework"
          :rules #js {:required "Choose a framework"}
          :render (fn [{:keys [field]}] [:f>
                                         form/form-item
                                         {}
                                         [:f> form/form-label {} "Framework"]
                                         [select/select {:value (:value field)
                                                         :on-value-change (:onChange field)}
                                          [:f>
                                           form/form-control
                                           {}
                                           [select/select-trigger {:on-blur (:onBlur field)
                                                                   :ref (:ref field)}
                                            [select/select-value {:placeholder
                                                                  "Choose a framework"}]]]
                                          [select/select-content {}
                                           [select/select-item {:value "reagent"}
                                            "Reagent"]
                                           [select/select-item {:value "react"}
                                            "React"]
                                           [select/select-item {:value "clojure"}
                                            "Clojure"]]]
                                         [:f> form/form-message {}]])}]
        [form/form-field
         {:control control
          :name "updates"
          :render (fn [{:keys [field]}]
                    [:f>
                     form/form-item
                     {:class "rounded-lg border p-4"}
                     [:div {:class "flex items-center justify-between gap-4"}
                      [:div
                       [:f> form/form-label {} "Product updates"]
                       [:f> form/form-description {} "Receive release notes by email."]]
                      [:f>
                       form/form-control
                       {}
                       [switch/switch {:checked (boolean (:value field))
                                       :on-checked-change (:onChange field)}]]]
                     [:f> form/form-message {}]])}]
        [form/form-field {:control control
                          :name "biography"
                          :rules #js {:minLength #js {:value 10
                                                      :message "Use at least 10 characters"}}
                          :render (fn [{:keys [field]}]
                                    [:f>
                                     form/form-item
                                     {}
                                     [:f> form/form-label {} "Biography"]
                                     [:f>
                                      form/form-control
                                      {}
                                      [textarea/textarea
                                       (merge field {:placeholder "Tell us what you build"})]]
                                     [:f> form/form-description {} "A short public introduction."]
                                     [:f> form/form-message {}]])}]
        [form/form-field
         {:control control
          :name "plan"
          :render (fn [{:keys [field]}] [:f>
                                         form/form-item
                                         {}
                                         [:f> form/form-label {} "Plan"]
                                         [:f>
                                          form/form-control
                                          {}
                                          [radio/radio-group {:value (:value field)
                                                              :on-value-change (:onChange field)}
                                           [:div {:class "flex items-center gap-2"}
                                            [radio/radio-group-item {:id "plan-free"
                                                                     :value "free"}]
                                            [:label {:for "plan-free"}
                                             "Free"]]
                                           [:div {:class "flex items-center gap-2"}
                                            [radio/radio-group-item {:id "plan-pro"
                                                                     :value "pro"}]
                                            [:label {:for "plan-pro"}
                                             "Pro"]]]]
                                         [:f> form/form-message {}]])}]
        [button/button {:type "submit"}
         "Save preferences"])))])
