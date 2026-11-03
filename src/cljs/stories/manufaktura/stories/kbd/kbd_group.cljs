(ns manufaktura.stories.kbd.kbd-group
  (:require
   ["lucide-react"                :refer [Command]]
   [manufaktura.ui.components.kbd :as kbd]))

(defn example
  []
  [kbd/kbd-group {}
   [kbd/kbd {}
    [:> Command]]
   [:span "+"]
   [kbd/kbd {}
    "Shift"]
   [:span "+"]
   [kbd/kbd {}
    "P"]])
