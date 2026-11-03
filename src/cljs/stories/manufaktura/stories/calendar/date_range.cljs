(ns manufaktura.stories.calendar.date-range
  (:require
   [manufaktura.ui.components.calendar :as calendar]
   [reagent.core                       :as r]))

(defn example
  []
  (r/with-let [selected (r/atom nil)]
              [calendar/calendar {:mode "range"
                                  :number-of-months 2
                                  :selected @selected
                                  :on-select #(reset! selected %)}]))
