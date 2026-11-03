(ns manufaktura.stories.label.input-with-label
  (:require
   [manufaktura.ui.components.input :as input]
   [manufaktura.ui.components.label :as label]))

(defn example
  []
  [:div {:class "p-6 max-w-sm space-y-2"}
   [label/label {:html-for "email"}
    "Email"]
   [input/input {:id "email"
                 :type "email"
                 :placeholder "Email"}]])
