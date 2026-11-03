(ns manufaktura.stories.input.input-with-text
  (:require
   [manufaktura.ui.components.input :as input]
   [manufaktura.ui.components.label :as label]))

(defn example
  []
  [:div {:class "p-6 max-w-sm space-y-2"}
   [label/label {:html-for "support-email"}
    "Email"]
   [input/input {:id "support-email"
                 :type "email"
                 :placeholder "Email"}]
   [:p {:class "text-muted-foreground text-sm"}
    "Enter your support email address."]])
