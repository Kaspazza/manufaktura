(ns manufaktura.stories.input.input-two-column-grid
  (:require
   [manufaktura.ui.components.field :as field]
   [manufaktura.ui.components.input :as input]))

(defn example
  []
  [:div {:class "grid max-w-xl gap-4 p-6 sm:grid-cols-2"}
   [field/field {}
    [field/field-label {:html-for "first-name"}
     "First name"]
    [input/input {:id "first-name"
                  :autocomplete "given-name"}]]
   [field/field {}
    [field/field-label {:html-for "last-name"}
     "Last name"]
    [input/input {:id "last-name"
                  :autocomplete "family-name"}]]])
