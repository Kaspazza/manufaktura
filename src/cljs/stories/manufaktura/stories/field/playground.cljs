(ns manufaktura.stories.field.playground
  (:require
   [manufaktura.ui.components.field :as field]
   [manufaktura.ui.components.input :as input]))

(defn example
  ([]
   (example ((fn [args] (update args :orientation keyword))
             {:orientation "vertical"
              :placeholder "Jane Doe"
              :disabled false})))
  ([args]
   [:div {:class "max-w-md p-6"}
    [field/field {:orientation (:orientation args)}
     [field/field-label {:html-for "field-playground"}
      "Name"]
     [input/input {:id "field-playground"
                   :placeholder (:placeholder args)
                   :disabled (:disabled args)}]]]))
