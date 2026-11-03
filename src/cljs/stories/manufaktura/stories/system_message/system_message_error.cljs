(ns manufaktura.stories.system-message.system-message-error
  (:require
   [manufaktura.ui.components.system-message :as system-message]))

(defn example
  []
  [:div {:class "p-6"}
   [system-message/system-message {:variant :error}
    "Something went wrong while saving."]])
