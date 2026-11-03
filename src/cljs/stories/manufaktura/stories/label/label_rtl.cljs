(ns manufaktura.stories.label.label-rtl
  (:require
   [manufaktura.ui.components.input :as input]
   [manufaktura.ui.components.label :as label]))

(defn example
  []
  [:div {:dir "rtl"
         :class "max-w-sm space-y-2 p-6"}
   [label/label {:html-for "label-rtl-email"}
    "البريد الإلكتروني"]
   [input/input {:id "label-rtl-email"
                 :type "email"
                 :placeholder "name@example.com"}]])
