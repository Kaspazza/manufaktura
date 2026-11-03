(ns manufaktura.stories.badge.badge-rtl
  (:require
   ["lucide-react"                  :refer [BadgeCheck Bookmark]]
   [manufaktura.ui.components.badge :as badge]))

(defn example
  []
  [:div {:dir "rtl"
         :class "flex flex-wrap gap-2"}
   [badge/badge {}
    [:> BadgeCheck {:data-icon "inline-start"}]
    "موثّق"]
   [badge/badge {:variant :secondary}
    "محفوظ"
    [:> Bookmark {:data-icon "inline-end"}]]])
