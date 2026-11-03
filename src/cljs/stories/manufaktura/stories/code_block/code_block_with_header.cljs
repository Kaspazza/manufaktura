(ns manufaktura.stories.code-block.code-block-with-header
  (:require
   [manufaktura.ui.components.button     :as button]
   [manufaktura.ui.components.code-block :as code-block]
   [reagent.core                         :as r]))

(defn example
  []
  (r/with-let
   [code
    "(defn handle-request [req]\n  {:status 200 :body \"OK\"})"
    status
    (r/atom :idle)
    reset-timer
    (atom nil)
    active?
    (atom true)
    report!
    (fn [result]
      (when @active?
        (js/clearTimeout @reset-timer)
        (reset! status result)
        (reset! reset-timer (js/setTimeout #(reset! status :idle) 2000))))]
   [:div {:class "p-6 max-w-xl space-y-2"}
    [code-block/code-block {}
     [code-block/code-block-group {:class "px-4 py-2 border-b text-xs text-muted-foreground"}
      [:span "handlers.cljs"]
      (button/button {:size :sm
                      :variant :ghost
                      :disabled (= :copying @status)
                      :on-click (fn []
                                  (js/clearTimeout @reset-timer)
                                  (reset! status :copying)
                                  (-> (js/Promise.resolve nil)
                                      (.then (fn [] (.writeText js/navigator.clipboard code)))
                                      (.then (fn [] (report! :copied)))
                                      (.catch (fn [_] (report! :failed)))))}
                     (case @status
                       :copying "Copying…"
                       :copied "Copied"
                       :failed "Retry copy"
                       "Copy"))]
     [code-block/code-block-code {:language "clojure"
                                  :code code}]]
    [:p {:role "status"
         :class "min-h-5 text-xs text-muted-foreground"}
     (case @status
       :copied "Code copied to clipboard."
       :failed
       "Clipboard access failed. Allow clipboard access or select and copy the code manually."
       "")]]
   (finally (reset! active? false) (js/clearTimeout @reset-timer))))
