(ns manufaktura.stories.input.input-disabled
  (:require
   [manufaktura.ui.components.input :as input]))

(defn example
  []
  [:div {:class "p-6 max-w-sm"}
   [input/input {:disabled true
                 :type "email"
                 :placeholder "Email"}]])
