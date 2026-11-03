(ns manufaktura.stories.alert.alert-action
  (:require
   [manufaktura.ui.components.alert  :as alert]
   [manufaktura.ui.components.button :as button]))

(defn example
  []
  [alert/alert {:class "max-w-md"}
   [alert/alert-title {}
    "Dark mode is now available"]
   [alert/alert-description {}
    "Enable it under your profile settings to get started."]
   [alert/alert-action {}
    [button/button {:variant :default
                    :size :xs}
     "Enable"]]])
