(ns manufaktura.stories.switch.switch-choice-cards
  (:require
   [manufaktura.ui.components.field  :as field]
   [manufaktura.ui.components.switch :as switch]))

(defn example
  []
  [:div {:class "max-w-md space-y-3 p-6"}
   (for [[id title description checked?]
         [["switch-wifi" "Wi-Fi" "Connect automatically." true]
          ["switch-roaming" "Data roaming" "May incur charges." false]]]
     ^{:key id}
     [field/field-label {}
      [field/field {:orientation :horizontal}
       [field/field-content {}
        [field/field-title {}
         title]
        [field/field-description {}
         description]]
       [switch/switch {:id id
                       :default-checked checked?
                       :aria-label title}]]])])
