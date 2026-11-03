(ns manufaktura.stories.input.input-invalid
  (:require
   [manufaktura.ui.components.input :as input]
   [manufaktura.ui.components.label :as label]))

(defn example
  []
  [:div {:class "p-6 max-w-sm space-y-2"}
   [label/label {:html-for "email-invalid"}
    "Email"]
   [input/input {:id "email-invalid"
                 :type "email"
                 :aria-invalid true
                 :default-value "not-an-email"}]
   [:p {:class "text-destructive text-sm"}
    "Please enter a valid email address."]])
