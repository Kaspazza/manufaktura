(ns manufaktura.stories.kbd.kbd-tooltip
  (:require
   ["lucide-react"                    :refer [Command]]
   [manufaktura.ui.components.button  :as button]
   [manufaktura.ui.components.kbd     :as kbd]
   [manufaktura.ui.components.tooltip :as tooltip]))

(defn example
  []
  [:>
   tooltip/tooltip-provider-component
   {}
   [tooltip/tooltip {:trigger (button/button {:variant :outline} "Save")
                     :trigger-as-child? true
                     :content [kbd/kbd-group {}
                               [kbd/kbd {}
                                [:> Command]]
                               [kbd/kbd {}
                                "S"]]}]])
