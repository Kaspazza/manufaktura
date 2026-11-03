(ns manufaktura.stories.message.message-markdown
  (:require
   [manufaktura.ui.components.message :as message]))

(defn example
  []
  [:div {:class "p-6"}
   [message/message {}
    [message/message-avatar {:src "https://placehold.co/40x40/png"
                             :alt "Assistant"
                             :fallback "AI"}]
    [message/message-content {:markdown? true}
     "**Markdown** supports lists:\n\n- First\n- Second\n- Third"]]])
