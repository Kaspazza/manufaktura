(ns manufaktura.stories.message.playground
  (:require
   [manufaktura.ui.components.message :as message]))

(defn example
  ([] (example {}))
  ([consumer-args]
   (let [args ((fn [{:keys [align]
                     :as args}]
                 (cond-> args
                   align (update :align keyword)))
               (merge {:align "start"
                       :content "Hello! This is a basic message."
                       :avatar-mode "fallback"
                       :fallback "JD"}
                      consumer-args))]
     [:div {:class "p-6"}
      [message/message
       (select-keys args [:align])
       [message/message-avatar {:src (when (= "image" (:avatar-mode args))
                                       "https://placehold.co/40x40/png")
                                :alt "User"
                                :fallback (:fallback args)}]
       [message/message-content {}
        (:content args)]]])))
