(ns manufaktura.stories.button.button-rounded
  (:require
   ["lucide-react"                   :refer [ArrowUpRight]]
   [manufaktura.ui.components.button :as button]))

(defn example
  []
  [:div {:class "p-6"}
   (button/button {:variant :outline
                   :size :icon
                   :class "rounded-full"
                   :aria-label "Move up"}
                  [:> ArrowUpRight])])
