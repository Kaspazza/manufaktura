(ns manufaktura.stories.kbd.kbd-rtl
  (:require
   ["lucide-react"                :refer [Command]]
   [manufaktura.ui.components.kbd :as kbd]))

(defn example
  []
  [:p {:dir "rtl"
       :class "flex items-center gap-2 text-sm"}
   "اضغط"
   [kbd/kbd-group {}
    [kbd/kbd {}
     [:> Command]]
    [kbd/kbd {}
     "K"]]
   "للبحث"])
