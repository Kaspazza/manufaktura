(ns manufaktura.stories.date-picker.playground
  (:require
   [manufaktura.ui.components.date-picker :as date-picker]))

(defn example
  ([]
   (example {:default-value "2026-03-01"
             :disabled false
             :min "2026-01-01"
             :max "2026-12-31"}))
  ([args]
   [:div {:class "max-w-sm p-6"}
    [:form {:key (:default-value args)
            :class "space-y-3"}
     [date-picker/date-picker (assoc (dissoc args :required) :aria-label "Date")]
     [:button {:type "reset"
               :class "underline text-sm"}
      "Reset to initial value"]
     [:p {:class "text-sm text-muted-foreground"}
      "Changing Initial value restarts this example; Reset restores it."]]]))
