(ns manufaktura.stories.date-picker.uncontrolled-single
  (:require
   [manufaktura.ui.components.date-picker :as date-picker]))

(defn example
  []
  [date-picker/composed-date-picker {:default-open false}
   [date-picker/date-picker-trigger {}
    [date-picker/date-picker-button {:data-placeholder true}
     "Pick a date"]]
   [date-picker/date-picker-content {}
    [date-picker/date-picker-calendar {:mode "single"}]]])
