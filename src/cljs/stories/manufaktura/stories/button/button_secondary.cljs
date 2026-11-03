(ns manufaktura.stories.button.button-secondary
  (:require
   [manufaktura.ui.components.button :as button]))

(defn example
  []
  [:div {:class "p-6"}
   (button/button {:variant :secondary} "Secondary action")])
