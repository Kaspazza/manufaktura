(ns manufaktura.stories.input.input-demo
  (:require
   [manufaktura.ui.components.input :as input]))

(defn example
  []
  [:div {:class "p-6 max-w-sm"}
   [input/input {:type "email"
                 :placeholder "Email"}]])
