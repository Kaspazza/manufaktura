(ns manufaktura.stories.notification.playground
  (:require
   [manufaktura.ui.components.button       :as button]
   [manufaktura.ui.components.notification :as notification]))

(defn example
  ([] (example {}))
  ([consumer-args]
   (let [args (merge {:message "Changes saved"
                      :type "success"
                      :duration 4000
                      :description "Your changes are available now."}
                     consumer-args)
         show! (get {"default" notification/show-toast
                     "success" notification/show-success
                     "error" notification/show-error
                     "info" notification/show-info
                     "warning" notification/show-warning}
                    (:type args)
                    notification/show-toast)]
     [:div {:class "space-y-3 p-6"}
      [notification/toaster {}]
      [:p {:class "text-sm text-muted-foreground"}
       "Change controls, then click to preview a new toast. Existing toasts are not updated. Duration is in milliseconds."]
      [button/button {:on-click #(show! (:message args)
                                        (select-keys args [:description :duration]))}
       "Preview toast"]])))
