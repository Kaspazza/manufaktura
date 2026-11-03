(ns manufaktura.stories.badge.badge-ghost
  (:require
   [manufaktura.ui.components.badge :as badge]))

(defn example
  []
  [:div {:class "p-6"}
   [badge/badge {:variant :ghost}
    "Ghost"]])
