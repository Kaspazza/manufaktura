(ns manufaktura.stories.stepper.stepper-label-orientation
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
        current-step (r/atom :details)]
    (fn [] [:div {:class "w-full max-w-2xl p-4 sm:p-6"}
            [stepper/stepper {:current-step @current-step
                              :label-orientation :vertical
                              :on-step-change #(reset! current-step %)}
             [stepper/stepper-navigation {}
              (for [{:keys [id title description]} steps]
                ^{:key id}
                [stepper/stepper-step {:id id}
                 [stepper/stepper-title {}
                  title]
                 [stepper/stepper-description {}
                  description]])]]])))
