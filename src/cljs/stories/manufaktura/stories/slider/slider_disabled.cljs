(ns manufaktura.stories.slider.slider-disabled
  (:require
   [manufaktura.ui.components.slider :as slider]))

(defn example
  []
  [:div {:class "grid w-[420px] gap-8 p-6"}
   [slider/slider {:default-value [40]
                   :disabled true
                   :aria-label "Disabled volume"}]
   [slider/slider {:default-value [20 75]
                   :disabled true
                   :thumb-labels ["Disabled minimum" "Disabled maximum"]}]])
