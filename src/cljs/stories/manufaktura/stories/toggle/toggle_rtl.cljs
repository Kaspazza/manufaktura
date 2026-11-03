(ns manufaktura.stories.toggle.toggle-rtl
  (:require
   ["lucide-react"                   :refer [Bold]]
   [manufaktura.ui.components.toggle :as toggle]))

(defn example
  []
  [:div {:dir "rtl"
         :class "p-6"}
   [toggle/toggle {:variant :outline
                   :aria-label "تبديل الخط العريض"}
    [:> Bold]
    "عريض"]])
