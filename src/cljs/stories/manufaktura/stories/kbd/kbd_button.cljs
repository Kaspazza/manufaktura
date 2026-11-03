(ns manufaktura.stories.kbd.kbd-button
  (:require
   ["lucide-react"                   :refer [Command]]
   [manufaktura.ui.components.button :as button]
   [manufaktura.ui.components.kbd    :as kbd]))

(defn example
  []
  (button/button {:variant :outline
                  :class "gap-4"}
                 "Open command menu"
                 [kbd/kbd-group {}
                  [kbd/kbd {}
                   [:> Command]]
                  [kbd/kbd {}
                   "K"]]))
