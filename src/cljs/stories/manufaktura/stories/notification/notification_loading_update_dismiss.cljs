(ns manufaktura.stories.notification.notification-loading-update-dismiss
  (:require
   [manufaktura.ui.components.button       :as button]
   [manufaktura.ui.components.notification :as notification]))

(defn example
  []
  [:div {:class "flex gap-2 p-6"}
   [notification/toaster]
   [button/button {:on-click (fn []
                               (notification/show-loading "Uploading…" {:id "upload-demo"})
                               (js/setTimeout #(notification/show-success "Upload complete"
                                                                          {:id "upload-demo"})
                                              1400))}
    "Load then update"]
   [button/button {:variant :outline
                   :on-click #(notification/dismiss-toast "upload-demo")}
    "Dismiss"]])
