(ns manufaktura.stories.toggle-group.toggle-group-single
  (:require
   ["lucide-react"                         :refer [AlignCenter AlignLeft AlignRight]]
   [manufaktura.ui.components.toggle-group :as toggle-group]))

(defn example
  []
  [:div {:class "p-6"}
   [toggle-group/toggle-group {:type "single"
                               :default-value "left"
                               :variant :outline
                               :aria-label "Text alignment"}
    [toggle-group/toggle-group-item {:value "left"
                                     :aria-label "Align left"}
     [:> AlignLeft]]
    [toggle-group/toggle-group-item {:value "center"
                                     :aria-label "Align center"}
     [:> AlignCenter]]
    [toggle-group/toggle-group-item {:value "right"
                                     :aria-label "Align right"}
     [:> AlignRight]]]])
