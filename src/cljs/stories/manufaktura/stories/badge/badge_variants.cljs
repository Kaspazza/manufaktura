(ns manufaktura.stories.badge.badge-variants
  (:require
   [manufaktura.ui.components.badge :as badge]))

(defn example
  []
  [:div {:class "flex flex-wrap items-center gap-2 p-6"}
   [badge/badge {}
    "Default"]
   [badge/badge {:variant :secondary}
    "Secondary"]
   [badge/badge {:variant :outline}
    "Outline"]
   [badge/badge {:variant :destructive}
    "Destructive"]
   [badge/badge {:variant :ghost}
    "Ghost"]
   [badge/badge {:variant :link}
    "Link"]])
