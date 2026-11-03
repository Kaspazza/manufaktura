(ns manufaktura.stories.message.message-grouped-metadata
  (:require
   ["lucide-react"                    :refer [Copy]]
   [manufaktura.ui.components.bubble  :as bubble]
   [manufaktura.ui.components.button  :as button]
   [manufaktura.ui.components.message :as message]))

(defn example
  []
  [message/message-group {:class "max-w-2xl"}
   [message/message {}
    [message/message-avatar {:src ""
                             :alt "Avery"
                             :fallback "AV"}]
    [message/message-content {}
     [message/message-header {}
      "Avery · 09:41"]
     [bubble/bubble {:variant :muted}
      [bubble/bubble-content {}
       "I’ve attached the approved brief."]]
     [message/message-footer {:class "gap-2"}
      [:span "Delivered"]
      [message/message-actions {}
       [message/message-action {:tooltip "Copy message"}
        (button/button {:variant :ghost
                        :size :icon-xs
                        :aria-label "Copy message"}
                       [:> Copy])]]]]]
   [message/message {:align :end}
    [message/message-avatar {:src ""
                             :alt "You"
                             :fallback "ME"}]
    [message/message-content {}
     [message/message-header {}
      "You · 09:42"]
     [bubble/bubble {:align :end}
      [bubble/bubble-content {}
       "Thanks, I’ll review it now."]]
     [message/message-footer {}
      "Read"]]]])
