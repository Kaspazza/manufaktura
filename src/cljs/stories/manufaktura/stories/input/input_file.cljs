(ns manufaktura.stories.input.input-file
  (:require
   [manufaktura.ui.components.input :as input]
   [manufaktura.ui.components.label :as label]))

(defn example
  []
  [:div {:class "p-6 max-w-sm space-y-2"}
   [label/label {:html-for "resume"}
    "Resume"]
   [input/input {:id "resume"
                 :type "file"}]])
