(ns manufaktura.stories.badge.badge-outline
  (:require
   [manufaktura.ui.components.badge :as badge]))

(defn example
  []
  [:div {:class "p-6"}
   [badge/badge {:variant :outline}
    "Outline"]])
