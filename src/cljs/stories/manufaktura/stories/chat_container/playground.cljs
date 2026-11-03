(ns manufaktura.stories.chat-container.playground
  (:require
   [manufaktura.ui.components.button         :as button]
   [manufaktura.ui.components.chat-container :as chat-container]
   [reagent.core                             :as r]))

(defn example
  ([]
   (example {:resize "smooth"
             :initial "instant"}))
  ([args]
   (r/with-let
    [message-count (r/atom 12) reset-id (r/atom 0)]
    [:div {:class "w-full max-w-lg space-y-3"}
     [:p {:class "text-sm text-muted-foreground"}
      "Append while at the bottom to observe resize scrolling. Scroll up to read history. Changing Initial remounts only the scroll container, preserving messages."]
     [:div {:class "flex gap-2"}
      [button/button {:on-click #(swap! message-count inc)}
       "Append message"]
      [button/button {:variant :outline
                      :on-click #(do (reset! message-count 12) (swap! reset-id inc))}
       "Reset messages"]]
     [chat-container/chat-container-root
      (assoc (select-keys args [:resize :initial])
             :key [(:initial args) @reset-id]
             :class "h-64 w-full rounded-md border")
      [chat-container/chat-container-content {:class "p-4 space-y-3"}
       (for [idx (range 1 (inc @message-count))]
         ^{:key idx}
         [:div {:class "rounded-lg bg-muted px-3 py-2 text-sm"}
          (str "Message " idx " - a new update in the conversation.")])
       [chat-container/chat-container-scroll-anchor {}]]]
     [:p {:class "text-sm"}
      (str @message-count " messages")]])))
