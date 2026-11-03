(ns manufaktura.ui.components.stepper
  "Pure presentational stepper components using React Context.

  Design:
  - Context-based: stepper provider shares state with child components
  - Composable: small components that work together
  - Custom stepper UI based on shadcn/ui styling patterns
  - Purely presentational: parent manages current-step state

Version: 1.0.0
Last updated: 2026-02-06

Based on shadcn/ui component patterns.
Documentation: https://ui.shadcn.com/docs/components"
  (:require
   ["react"                  :as react]
   [manufaktura.utils.props  :refer [normalize-props]]
   [manufaktura.utils.styles :refer [merge-classes]]
   [reagent.core             :refer [defc]]
   [reagent.hooks            :as rhooks]))

(def ^:private stepper-context (react/createContext nil))

(defn- step-state
  "Calculate display state for a step: active, completed, or inactive.
   When reverse-progress? is true, steps after current are completed (for newest-first lists).
   When current-idx is negative (nothing selected), all steps are inactive."
  [current-idx step-idx reverse-progress?]
  (cond
    (neg? current-idx) "inactive"
    (= current-idx step-idx) "active"
    (and reverse-progress? (< current-idx step-idx)) "completed"
    (and (not reverse-progress?) (> current-idx step-idx)) "completed"
    :else "inactive"))

;; =============================================================================
;; Public components
;; =============================================================================

(defc stepper
 "Root stepper component. Provides context to child components.
  
  Props:
  - :current-step - ID of current/active step (required)
  - :on-step-change - (fn [step-id]) callback when step is clicked
  - :variant - :horizontal | :vertical | :circle (default: :horizontal)
  - :label-orientation - :horizontal | :vertical (default: :horizontal)
  - :reverse-progress? - When true, steps after current are 'completed' (for newest-first lists)
  - :class - Additional CSS classes
  Both kebab-case and camelCase prop spellings are accepted.
  
  Children: stepper-navigation, stepper-panel, stepper-controls, etc."
 [{:as raw-props} & children]
 (let [{:keys [current-step on-step-change variant label-orientation reverse-progress? class]
        :or {variant :horizontal
             label-orientation :horizontal
             reverse-progress? false}}
       (normalize-props raw-props)
       id-prefix (react/useId)
       context #js {:idPrefix id-prefix
                    :currentStep current-step
                    :onStepChange on-step-change
                    :variant (name variant)
                    :labelOrientation (name label-orientation)
                    :reverseProgress reverse-progress?}]
   [:>
    (.-Provider stepper-context)
    {:value context}
    (into [:div {:data-component "stepper"
                 :data-variant (name variant)
                 :data-label-orientation (name label-orientation)
                 :class (merge-classes "flex w-full flex-col gap-6" class)}]
          children)]))

(defn stepper-title
  "Title component for step labels.
  
  Props:
  - :class - Additional CSS classes
  
  Children: Title text or elements"
  [{:keys [class]} & children]
  (into [:span {:data-component "stepper-step-title"
                :class (merge-classes "text-base font-medium" class)}]
        children))

(defn stepper-description
  "Description component for step labels.
  
  Props:
  - :class - Additional CSS classes
  
  Children: Description text or elements"
  [{:keys [class]} & children]
  (into [:span {:data-component "stepper-step-description"
                :class (merge-classes "text-sm text-muted-foreground" class)}]
        children))

(defn stepper-controls
  "Navigation controls container for prev/next buttons.
  
  Props:
  - :class - Additional CSS classes
  
  Children: Button components or other navigation controls"
  [{:keys [class]} & children]
  (into [:div {:data-component "stepper-controls"
               :class (merge-classes "flex justify-end gap-4" class)}]
        children))

;; =============================================================================
;; Internal UI components (private helpers)
;; =============================================================================

(defn- circle-step-indicator
  "SVG-based circular progress indicator for circle variant."
  [{:as raw-props}]
  (let [{:keys [current-step total-steps size stroke-width]
         :or {size 80
              stroke-width 6}}
        (normalize-props raw-props)
        radius (/ (- size stroke-width) 2)
        circumference (* radius 2 js/Math.PI)
        safe-total (max 1 (or total-steps 0))
        safe-current (-> (or current-step 0)
                         (max 0)
                         (min safe-total))
        fill-perc (* (/ safe-current safe-total) 100)
        dash-offset (- circumference (/ (* circumference fill-perc) 100))]
    [:div {:data-component "stepper-step-indicator"
           :role "progressbar"
           :aria-label "Step progress"
           :aria-valuenow safe-current
           :aria-valuemin 0
           :aria-valuemax safe-total
           :tab-index -1
           :class "relative inline-flex items-center justify-center"}
     [:svg {:width size
            :height size}
      [:title "Step Indicator"]
      [:circle {:cx (/ size 2)
                :cy (/ size 2)
                :r radius
                :fill "none"
                :stroke "currentColor"
                :stroke-width stroke-width
                :class "text-muted-foreground"}]
      [:circle {:cx (/ size 2)
                :cy (/ size 2)
                :r radius
                :fill "none"
                :stroke "currentColor"
                :stroke-width stroke-width
                :stroke-dasharray circumference
                :stroke-dashoffset dash-offset
                :class
                "text-primary transition-all duration-500 ease-in-out motion-reduce:transition-none"
                :transform (str "rotate(-90 " (/ size 2) " " (/ size 2) ")")}]]
     [:div {:class "absolute inset-0 flex items-center justify-center"}
      [:span {:class "text-sm font-medium"
              :aria-live "polite"}
       safe-current
       " of "
       (or total-steps 0)]]]))

(defc stepper-step
 "Individual step trigger. Navigation supplies index, total, and current-idx.
  Props: :id, :disabled?, :icon, :class. Children are the step label.
  Both kebab-case and camelCase prop spellings are accepted."
 [{:as raw-props} & children]
 (let [{:keys [id index total current-idx disabled? icon class]} (normalize-props raw-props)
       ctx (rhooks/use-context stepper-context)
       variant (.-variant ctx)
       stacked? (and (= variant "horizontal") (= (.-labelOrientation ctx) "vertical"))
       vertical? (= variant "vertical")
       circle? (= variant "circle")
       active? (= id (.-currentStep ctx))
       on-step-change (.-onStepChange ctx)
       reverse-progress? (.-reverseProgress ctx)
       is-last? (= index (dec total))
       state (step-state current-idx index reverse-progress?)
       sep-state (if (and vertical? reverse-progress?)
                   (step-state current-idx (inc index) reverse-progress?)
                   state)
       trigger-id (str (.-idPrefix ctx) "-step-" id)]
   [:li
    (cond-> {:data-component "stepper-step"
             :data-variant variant
             :data-label-orientation (if vertical? "horizontal" (.-labelOrientation ctx))
             :data-state state
             :class (merge-classes
                     "relative min-w-0"
                     (cond
                       circle? (if active? "flex items-center gap-4" "hidden")
                       vertical? (when-not is-last? "pb-6")
                       stacked? "flex flex-1 flex-col items-center"
                       :else "flex flex-1 items-center gap-2 @max-lg:flex-col @max-lg:gap-0")
                     class)
             ;; Inline display also prevents consumer flex classes overriding hidden.
             :style (when (and circle? (not active?)) {:display "none"})}
      disabled? (assoc :data-disabled true)
      (and circle? (not active?)) (assoc :hidden true :aria-hidden true))
    (if circle?
      [:<>
       [circle-step-indicator {:current-step (inc current-idx)
                               :total-steps total}]
       (into [:div {:id trigger-id
                    :data-component "stepper-step-content"
                    :class "flex flex-col items-start gap-1"}]
             children)]
      [:button
       {:id trigger-id
        :data-component "stepper-step-trigger"
        :type "button"
        :disabled (boolean disabled?)
        :aria-current (when active? "step")
        :class
        (merge-classes
         "relative z-10 flex min-w-0 items-center gap-2 rounded-md text-left outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:cursor-not-allowed disabled:text-muted-foreground disabled:opacity-50"
         (cond
           stacked? "w-full flex-col px-2 text-center"
           vertical? "max-w-full items-start"
           :else "max-w-full @max-lg:w-full @max-lg:flex-col @max-lg:px-2 @max-lg:text-center"))
        :on-click #(when (and (not disabled?) on-step-change) (on-step-change id))}
       [:span {:data-component "stepper-step-indicator"
               :data-state state
               :class
               (merge-classes
                "flex size-8 shrink-0 items-center justify-center rounded-full text-sm font-medium"
                (if (= state "inactive")
                  "bg-secondary text-secondary-foreground"
                  "bg-primary text-primary-foreground"))}
        (or icon (inc index))]
       (into [:span {:data-component "stepper-step-content"
                     :class (merge-classes "flex min-w-0 flex-col"
                                           (cond
                                             stacked? "items-center"
                                             vertical? "items-start"
                                             :else "items-start @max-lg:items-center"))}]
             children)])
    (when (and (not circle?) (not is-last?))
      [:div
       {:data-component "stepper-separator"
        :data-orientation (if vertical? "vertical" "horizontal")
        :data-state sep-state
        :aria-hidden true
        :class
        (merge-classes
         "pointer-events-none bg-muted data-[state=completed]:bg-primary"
         (when disabled? "opacity-50")
         (cond
           vertical? "absolute left-4 top-10 bottom-2 w-0.5 -translate-x-1/2"
           stacked?
           "absolute left-[calc(50%+1.5rem)] top-4 h-0.5 w-[calc(100%-3rem)] -translate-y-1/2"
           :else
           "mr-2 h-0.5 min-w-2 flex-1 @max-lg:absolute @max-lg:left-[calc(50%+1.5rem)] @max-lg:top-4 @max-lg:mr-0 @max-lg:w-[calc(100%-3rem)] @max-lg:min-w-0 @max-lg:-translate-y-1/2"))}])]))

(defn- step-child? [child] (and (vector? child) (= (first child) stepper-step)))

(defn- expand-child-sequences
  "Expand only top-level sequence children produced by `for`/`map`.
   Hiccup vectors are opaque: nested markup and its metadata must not be traversed."
  [children]
  (mapcat #(if (and (sequential? %) (not (vector? %))) % [%]) children))

(defn- number-step
  [idx total current-idx child]
  (if-not (step-child? child)
    child
    (let [[component maybe-props & child-content] child
          props (if (map? maybe-props) maybe-props {})
          child-content (if (map? maybe-props) child-content (cons maybe-props child-content))]
      (with-meta (into [component (assoc props :index idx :total total :current-idx current-idx)]
                       child-content)
                 (meta child)))))

(defc stepper-navigation
 "Navigation container for steps. Auto-numbers steps and injects context.
  
  Props:
  - :class - Additional CSS classes
  
  Children: stepper-step components"
 [{:keys [class]} & children]
 (let [ctx (rhooks/use-context stepper-context)
       variant (.-variant ctx)
       current-step (.-currentStep ctx)
       expanded-children (vec (expand-child-sequences children))
       step-ids (->> expanded-children
                     (filter step-child?)
                     (mapv #(some-> (second %)
                                    :id)))
       current-idx (if (some? current-step)
                     (or (first (keep-indexed #(when (= %2 current-step) %1) step-ids)) -1)
                     -1)
       total (count step-ids)
       numbered-children (loop [remaining expanded-children
                                step-idx 0
                                result []]
                           (if-let [child (first remaining)]
                             (if (step-child? child)
                               (recur (next remaining)
                                      (inc step-idx)
                                      (conj result (number-step step-idx total current-idx child)))
                               (recur (next remaining) step-idx (conj result child)))
                             result))]
   [:nav {:data-component "stepper-navigation"
          :aria-label "Stepper Navigation"
          :class (merge-classes "@container" class)}
    (into [:ol {:data-component "stepper-navigation-list"
                :class (merge-classes "flex"
                                      (case variant
                                        "horizontal" "flex-row items-start"
                                        "vertical" "flex-col"
                                        "circle" "flex-row items-start"
                                        "flex-row items-start"))}]
          numbered-children)]))

(defc stepper-panel
 "Panel component for step content. Only renders if this is the active step.
  
  Props:
  - :id - Step ID this panel belongs to (required)
  - :class - Additional CSS classes
  
  Children: Panel content"
 [{:keys [id class]} & children]
 (let [ctx (rhooks/use-context stepper-context)
       current-step (.-currentStep ctx)]
   (when (= id current-step)
     (into [:div {:id (str (.-idPrefix ctx) "-step-panel-" id)
                  :data-component "stepper-step-panel"
                  :role "region"
                  :aria-labelledby (str (.-idPrefix ctx) "-step-" id)
                  :class class}]
           children))))
