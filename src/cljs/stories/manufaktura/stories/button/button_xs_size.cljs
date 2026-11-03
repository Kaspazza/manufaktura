(ns manufaktura.stories.button.button-xs-size
  (:require
   [manufaktura.ui.components.button :as button]))

(defn example
  []
  [:div {:class "p-6"}
   (button/button {:size :xs
                   :variant :secondary}
                  "Compact action")])
