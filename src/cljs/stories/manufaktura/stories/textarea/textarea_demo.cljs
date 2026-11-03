(ns manufaktura.stories.textarea.textarea-demo
  (:require
   [manufaktura.ui.components.textarea :as textarea]))

(defn example
  []
  [:div {:class "p-6 max-w-sm"}
   [textarea/textarea {:placeholder "Type your message here."}]])
