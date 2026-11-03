(ns manufaktura.stories.field.field-with-select
  (:require
   [manufaktura.ui.components.field  :as field]
   [manufaktura.ui.components.select :as select]))

(defn example
  []
  [:div {:class "p-6 max-w-md"}
   [field/field {}
    [field/field-label {}
     "Department"]
    [select/select {:default-value "design"}
     [select/select-trigger {}
      [select/select-value {:placeholder "Choose department"}]]
     [select/select-content {}
      [select/select-item {:value "engineering"}
       "Engineering"]
      [select/select-item {:value "design"}
       "Design"]
      [select/select-item {:value "marketing"}
       "Marketing"]]]
    [field/field-description {}
     "Select your department or area of work."]]])
