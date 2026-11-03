(ns manufaktura.stories.button.button-outline
  (:require
   [manufaktura.ui.components.button :as button]))

(defn example
  []
  [:div {:class "p-6"}
   (button/button {:variant :outline} "View details")])
