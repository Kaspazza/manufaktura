(ns manufaktura.stories.item.playground
  (:require
   [manufaktura.ui.components.item :as item]))

(defn example
  ([] (example {}))
  ([consumer-args]
   (let [args ((fn [{:keys [variant size]
                     :as args}]
                 (cond-> args
                   variant (update :variant keyword)
                   size (update :size keyword)))
               (merge {:variant "outline"
                       :size "default"}
                      consumer-args))]
     [item/item
      (select-keys args [:variant :size])
      [item/item-content {}
       [item/item-title {}
        "Quarterly report"]
       [item/item-description {}
        "PDF · 2.4 MB"]]])))
