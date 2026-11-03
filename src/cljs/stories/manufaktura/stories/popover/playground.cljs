(ns manufaktura.stories.popover.playground
  (:require
   [manufaktura.ui.components.button  :as button]
   [manufaktura.ui.components.popover :as popover]))

(defn example
  ([] (example {:side "bottom"}))
  ([args]
   [popover/popover {}
    [popover/popover-trigger {:as-child true}
     (button/button {:variant :outline} "Open popover")]
    [popover/popover-content (select-keys args [:side]) "Place content here."]]))
