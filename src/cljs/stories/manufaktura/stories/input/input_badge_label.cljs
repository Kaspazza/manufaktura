(ns manufaktura.stories.input.input-badge-label
  (:require
   [manufaktura.ui.components.badge :as badge]
   [manufaktura.ui.components.field :as field]
   [manufaktura.ui.components.input :as input]))

(defn example
  []
  [:div {:class "max-w-sm p-6"}
   [field/field {}
    [field/field-label {:html-for "work-email"}
     "Work email"
     [badge/badge {:variant :secondary}
      "Recommended"]]
    [input/input {:id "work-email"
                  :type "email"
                  :placeholder "you@company.com"}]]])
