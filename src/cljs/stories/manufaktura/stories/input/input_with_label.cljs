(ns manufaktura.stories.input.input-with-label
  (:require
   [manufaktura.ui.components.input :as input]
   [manufaktura.ui.components.label :as label]))

(defn example
  []
  [:div {:class "p-6 max-w-sm space-y-2"}
   [label/label {:html-for "contact-email"}
    "Email"]
   [input/input {:id "contact-email"
                 :type "email"
                 :placeholder "Email"}]])
