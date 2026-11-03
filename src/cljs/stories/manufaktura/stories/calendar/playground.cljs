(ns manufaktura.stories.calendar.playground
  (:require
   [manufaktura.ui.components.button   :as button]
   [manufaktura.ui.components.calendar :as calendar]
   [reagent.core                       :as r]))

(defn example
  ([]
   (example {:show-outside-days true
             :caption-layout "label"
             :number-of-months 1}))
  ([args]
   (r/with-let
    [selected (r/atom nil)]
    [:div {:class "space-y-3"}
     [calendar/calendar
      (-> args
          (update :caption-layout keyword)
          (assoc :mode "single" :selected @selected :on-select #(reset! selected %)))]
     [:p {:role "status"
          :class "text-sm"}
      (if @selected (str "Selected: " (.toLocaleDateString @selected)) "No date selected.")]
     [button/button {:variant :outline
                     :on-click #(reset! selected nil)}
      "Clear selection"]])))
