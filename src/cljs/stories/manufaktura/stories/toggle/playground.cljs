(ns manufaktura.stories.toggle.playground
  (:require
   [manufaktura.ui.components.toggle :as toggle]))

(defn example
  ([]
   (example ((fn [{:keys [variant size]
                   :as args}]
               (cond-> args
                 variant (update :variant keyword)
                 size (update :size keyword)))
             {:variant "outline"
              :size "default"})))
  ([args] [toggle/toggle (select-keys args [:variant :size]) "Toggle"]))
