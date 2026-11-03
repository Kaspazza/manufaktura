(ns manufaktura.stories.button.button-icon
  (:require
   ["lucide-react"                   :refer [ArrowUpRight]]
   [manufaktura.ui.components.button :as button]))

(defn example
  []
  [:div {:class "p-6"}
   (button/button {:variant :outline
                   :size :icon
                   :aria-label "Open"}
                  [:> ArrowUpRight])])
