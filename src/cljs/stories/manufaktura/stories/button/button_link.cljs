(ns manufaktura.stories.button.button-link
  (:require
   [manufaktura.ui.components.button :as button]))

(defn example
  []
  [:div {:class "p-6"}
   (button/button {:variant :link} "Learn more")])
