(ns manufaktura.stories.notification.toast-basic
  (:require
   [manufaktura.ui.components.button       :as button]
   [manufaktura.ui.components.notification :as notification]))

(defn example
  []
  [:div {:class "p-6 space-y-4"}
   [notification/toaster]
   (button/button {:on-click (fn [] (notification/show-toast "Event has been created"))}
                  "Show Toast")])
