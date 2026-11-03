(ns manufaktura.stories.notification.notification-promise
  (:require
   [manufaktura.ui.components.button       :as button]
   [manufaktura.ui.components.notification :as notification]))

(defn example
  []
  [:div {:class "flex gap-2 p-6"}
   [notification/toaster]
   [button/button {:on-click (fn []
                               (notification/show-promise
                                (js/Promise. (fn [resolve _]
                                               (js/setTimeout #(resolve "done") 1200)))
                                {:loading "Saving…"
                                 :success "Saved"
                                 :error "Save failed"}))}
    "Resolve promise"]
   [button/button {:variant :destructive
                   :on-click (fn []
                               (notification/show-promise
                                (js/Promise. (fn [_ reject]
                                               (js/setTimeout #(reject (js/Error. "failed")) 1200)))
                                {:loading "Saving…"
                                 :success "Saved"
                                 :error "Save failed"}))}
    "Reject promise"]])
