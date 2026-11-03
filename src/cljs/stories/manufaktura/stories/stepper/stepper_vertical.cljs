(ns manufaktura.stories.stepper.stepper-vertical
  (:require
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
        current-step (r/atom :billing)]
    (fn [] [:div {:class "w-full max-w-2xl p-4 sm:p-6"}
            [stepper/stepper {:current-step @current-step
                              :variant :vertical
                              :on-step-change #(reset! current-step %)}
             [stepper/stepper-navigation {}
              (for [{:keys [id title description]} steps]
                ^{:key id}
                [stepper/stepper-step {:id id}
                 [stepper/stepper-title {}
                  title]
                 [stepper/stepper-description {}
                  description]])]
             [stepper/stepper-panel {:id :details}
              [:div {:class "text-sm text-muted-foreground"}
               "Account setup details."]]
             [stepper/stepper-panel {:id :billing}
              [:div {:class "text-sm text-muted-foreground"}
               "Billing preferences."]]
             [stepper/stepper-panel {:id :confirm}
              [:div {:class "text-sm text-muted-foreground"}
               "Confirmation step."]]]])))
