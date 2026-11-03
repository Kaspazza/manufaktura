(ns manufaktura.stories.button-group.button-group-vertical
  (:require
   ["lucide-react"                         :refer [Bold Italic Underline]]
   [manufaktura.ui.components.button       :as button]
   [manufaktura.ui.components.button-group :as button-group]))

(defn example
  []
  [button-group/button-group {:orientation :vertical}
   [button/button {:variant :outline
                   :size :icon
                   :aria-label "Bold"}
    [:> Bold]]
   [button/button {:variant :outline
                   :size :icon
                   :aria-label "Italic"}
    [:> Italic]]
   [button/button {:variant :outline
                   :size :icon
                   :aria-label "Underline"}
    [:> Underline]]])
