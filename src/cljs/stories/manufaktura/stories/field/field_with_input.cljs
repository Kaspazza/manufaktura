(ns manufaktura.stories.field.field-with-input
  (:require
   [manufaktura.ui.components.field :as field]
   [manufaktura.ui.components.input :as input]))

(defn example
  []
  [:div {:class "p-6 max-w-md"}
   [field/field-set {}
    [field/field-legend {}
     "Profile"]
    [field/field {}
     [field/field-label {:html-for "name"}
      "Name"]
     [field/field-content {}
      [input/input {:id "name"
                    :placeholder "Jane Doe"}]
      [field/field-description {}
       "Use your full name for display purposes."]]]]])
