(ns manufaktura.stories.message.message-stateful-feedback
  (:require
   ["lucide-react"                    :refer [ThumbsDown ThumbsUp]]
   [manufaktura.ui.components.bubble  :as bubble]
   [manufaktura.ui.components.button  :as button]
   [manufaktura.ui.components.message :as message]
   [reagent.core                      :as r]))

(defn example
  []
  [(fn []
     (let [feedback (r/atom nil)]
       (fn [] [message/message {:class "max-w-2xl"}
               [message/message-avatar {:src ""
                                        :alt "Assistant"
                                        :fallback "AI"}]
               [message/message-content {}
                [bubble/bubble {:variant :muted}
                 [bubble/bubble-content {}
                  "The deployment completed successfully."]]
                [message/message-footer {}
                 [message/message-actions {}
                  (for [[value label icon] [[:helpful "Helpful" ThumbsUp]
                                            [:not-helpful "Not helpful" ThumbsDown]]]
                    ^{:key value}
                    [message/message-action {:tooltip label}
                     (button/button {:variant (if (= @feedback value) :secondary :ghost)
                                     :size :icon-xs
                                     :aria-label label
                                     :aria-pressed (= @feedback value)
                                     :on-click #(reset! feedback value)}
                                    [:> icon])])]]]])))])
