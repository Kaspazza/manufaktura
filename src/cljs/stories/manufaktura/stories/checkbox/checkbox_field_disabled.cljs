(ns manufaktura.stories.checkbox.checkbox-field-disabled
  (:require
   [manufaktura.ui.components.checkbox :as checkbox]
   [manufaktura.ui.components.field    :as field]))

(defn example
  []
  [:div {:class "max-w-md p-6"}
   [field/field {:orientation :horizontal
                 :data-disabled true}
    [checkbox/checkbox {:id "checkbox-field-disabled"
                        :disabled true
                        :checked true}]
    [field/field-content {}
     [field/field-label {:html-for "checkbox-field-disabled"}
      "Share analytics"]
     [field/field-description {}
      "Managed by your organization."]]]])
