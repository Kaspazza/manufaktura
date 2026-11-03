(ns manufaktura.stories.button.button-ghost
  (:require
   [manufaktura.ui.components.button :as button]))

(defn example
  []
  [:div {:class "p-6"}
   (button/button {:variant :ghost} "Dismiss")])
