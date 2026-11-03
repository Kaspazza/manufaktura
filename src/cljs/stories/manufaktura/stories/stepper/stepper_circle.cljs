(ns manufaktura.stories.stepper.stepper-circle
  (:require
   [manufaktura.ui.components.button  :as button]
   [manufaktura.ui.components.stepper :as stepper]
   [reagent.core                      :as r]))

(defn- step-data
  []
  [{:id :details
    :title "Details"
    :description "Account info"}
   {:id :billing
    :title "Billing"
    :description "Payment setup"}
   {:id :confirm
    :title "Confirm"
    :description "Review"}])

(defn example
  []
  (let [steps (step-data)
        step-ids (mapv :id steps)
        current-step (r/atom (first step-ids))]
    (fn []
      (let [current-index (.indexOf step-ids @current-step)
            prev-id (get step-ids (dec current-index))
            next-id (get step-ids (inc current-index))]
        [:div {:class "w-full max-w-2xl p-4 sm:p-6"}
         [stepper/stepper {:current-step @current-step
                           :variant :circle
                           :on-step-change #(reset! current-step %)}
          [stepper/stepper-navigation {}
           (for [{:keys [id title description]} steps]
             ^{:key id}
             [stepper/stepper-step {:id id}
              [stepper/stepper-title {}
               title]
              [stepper/stepper-description {}
               description]])]
          [stepper/stepper-controls {}
           (button/button {:type "button"
                           :variant :outline
                           :disabled (nil? prev-id)
                           :on-click #(when prev-id (reset! current-step prev-id))}
                          "Previous")
           (button/button {:type "button"
                           :disabled (nil? next-id)
                           :on-click #(when next-id (reset! current-step next-id))}
                          "Next")]]]))))
