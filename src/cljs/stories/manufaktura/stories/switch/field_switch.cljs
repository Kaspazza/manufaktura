(ns manufaktura.stories.switch.field-switch
  (:require
   [manufaktura.ui.components.field  :as field]
   [manufaktura.ui.components.switch :as switch]))

(defn example
  []
  [:div {:class "p-6 max-w-md"}
   [field/field {:orientation :horizontal}
    [field/field-content {}
     [field/field-label {:html-for "mfa"}
      "Multi-factor authentication"]
     [field/field-description {}
      "Enable MFA for additional account security."]]
    [switch/switch {:id "mfa"}]]])
