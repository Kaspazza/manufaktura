(ns manufaktura.stories.button.button-destructive
  (:require
   [manufaktura.ui.components.button :as button]))

(defn example
  []
  [:div {:class "p-6"}
   (button/button {:variant :destructive} "Delete project")])
