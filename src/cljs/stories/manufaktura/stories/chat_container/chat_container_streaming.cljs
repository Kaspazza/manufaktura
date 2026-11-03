(ns manufaktura.stories.chat-container.chat-container-streaming
  (:require
   [clojure.string                           :as str]
   [manufaktura.ui.components.button         :refer [button]]
   [manufaktura.ui.components.chat-container :as chat-container]
   [reagent.core                             :as r]))

(def ^:private response
  (str "The release is on track. All planned features have been merged, and the latest build "
       "has passed the automated checks.\n\n"
       "Testing: The team has finished the core regression suite. We are now checking keyboard "
       "navigation, mobile layouts, and the upgrade path for existing users.\n\n"
       "Documentation: The migration guide is ready for review. Each breaking change includes "
       "a before-and-after example so users can update without guessing.\n\n"
       "Rollout: We will start with a small group of users, monitor errors and response times, "
       "then expand gradually if the metrics remain healthy.\n\n"
       "Next steps: Complete the final accessibility review, confirm the rollback procedure, "
       "and publish the release notes. No blocking issues have been reported so far."))

(defn example
  []
  (r/with-let
   [chunks
    (vec (re-seq #"\s*\S+" response))
    index
    (r/atom 0)
    timer
    (atom nil)
    stop!
    (fn [] (when @timer (js/clearInterval @timer) (reset! timer nil)))
    start!
    (fn []
      (stop!)
      (reset! index 0)
      (reset! timer (js/setInterval
                     (fn [] (swap! index inc) (when (>= @index (count chunks)) (stop!)))
                     100)))
    _
    (start!)]
   (let [streaming? (< @index (count chunks))]
     [:div {:class "w-full max-w-xl space-y-3"}
      [:div {:class "flex items-center justify-between gap-3"}
       [:span {:class "text-sm text-muted-foreground"
               :role "status"}
        (if streaming? "Streaming response…" "Response complete")]
       [button {:variant :outline
                :size :sm
                :on-click start!}
        "Replay streaming"]]
      [:p {:class "text-xs text-muted-foreground"}
       "Scroll up while the response grows to pause following. Scroll back to the bottom to resume."]
      [chat-container/chat-container-root {:class "h-64 rounded-md border"}
       [chat-container/chat-container-content {:class "space-y-3 p-4"}
        [:div {:class "ml-8 rounded-lg bg-muted px-3 py-2 text-sm"}
         "What is left before we can ship the release?"]
        [:div {:class "mr-8 rounded-lg border px-3 py-2 text-sm"}
         "The remaining work is final testing, documentation review, and rollout preparation."]
        [:div {:class "ml-8 rounded-lg bg-muted px-3 py-2 text-sm"}
         "Summarize the release status and next steps."]
        [:div {:class "mr-8 whitespace-pre-wrap rounded-lg border px-3 py-2 text-sm"
               :aria-busy streaming?}
         (str/join (take @index chunks))
         (when streaming?
           [:span {:class "ml-1 inline-block h-4 w-1.5 animate-pulse bg-current align-middle"
                   :aria-hidden true}])]
        [chat-container/chat-container-scroll-anchor {}]]]])
   (finally (stop!))))
