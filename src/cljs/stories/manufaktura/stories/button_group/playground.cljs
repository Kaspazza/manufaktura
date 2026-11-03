(ns manufaktura.stories.button-group.playground
  (:require
   [manufaktura.ui.components.button       :as button]
   [manufaktura.ui.components.button-group :as button-group]))

(defn example
  ([]
   (example {:orientation :horizontal
             :first-label "Back"
             :second-label "Next"}))
  ([args]
   [button-group/button-group
    (select-keys args [:orientation])
    [button/button {:variant :outline}
     (:first-label args)]
    [button/button {:variant :outline}
     (:second-label args)]]))
