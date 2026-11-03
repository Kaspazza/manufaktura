(ns manufaktura.stories.tooltip.simple-tooltip-compatibility
  (:require
   [manufaktura.ui.components.button  :as button]
   [manufaktura.ui.components.tooltip :as tooltip]))

(defn example
  []
  [tooltip/tooltip-provider {}
   [tooltip/simple-tooltip {:trigger (button/button {:variant :outline} "Convenience API")
                            :trigger-as-child? true
                            :content "One map still composes all Radix parts."
                            :side :bottom
                            :arrow? true}]])
