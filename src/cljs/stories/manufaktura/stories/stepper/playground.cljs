(ns manufaktura.stories.stepper.playground
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

(defn- preview
  ([args]
   (r/with-let [current (r/atom (:current-step args))]
               [:div {:class "w-[min(42rem,calc(100vw-4rem))] max-w-full p-4 sm:p-6"}
                [stepper/stepper
                 (assoc args :current-step @current :on-step-change #(reset! current %))
                 [stepper/stepper-navigation {}
                  (for [{:keys [id title description]} (step-data)]
                    ^{:key id}
                    [stepper/stepper-step {:id id}
                     [stepper/stepper-title {}
                      title]
                     [stepper/stepper-description {}
                      description]])]
                 [stepper/stepper-panel {:id :details}
                  "Account details."]
                 [stepper/stepper-panel {:id :billing}
                  "Billing preferences."]
                 [stepper/stepper-panel {:id :confirm}
                  "Review and confirm."]
                 [stepper/stepper-controls {}
                  (let [ids (mapv :id (step-data))
                        index (.indexOf ids @current)]
                    [:<>
                     (button/button {:type "button"
                                     :variant :outline
                                     :disabled (zero? index)
                                     :on-click #(reset! current (nth ids (dec index)))}
                                    "Previous")
                     (button/button {:type "button"
                                     :disabled (= index (dec (count ids)))
                                     :on-click #(reset! current (nth ids (inc index)))}
                                    "Next")])]]])))

(defn example
  ([]
   (example {:current-step :details
             :variant :horizontal
             :label-orientation :horizontal
             :reverse-progress? false}))
  ([args] ^{:key (:current-step args)} [preview args]))
