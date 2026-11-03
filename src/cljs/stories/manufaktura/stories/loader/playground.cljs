(ns manufaktura.stories.loader.playground
  (:require
   [manufaktura.ui.components.loader :as loader]))

(defn example
  ([] (example {}))
  ([consumer-args]
   (let [args ((fn [{:keys [variant size]
                     :as args}]
                 (cond-> args
                   variant (update :variant keyword)
                   size (update :size keyword)))
               (merge {:variant "text-shimmer"
                       :size "md"
                       :text "Thinking"}
                      consumer-args))]
     [:div {:class "p-6"}
      [loader/loader
       (cond-> (select-keys args [:variant :size])
         (#{:text-blink :text-shimmer :loading-dots} (:variant args)) (assoc :text
                                                                             (:text args)))]])))
