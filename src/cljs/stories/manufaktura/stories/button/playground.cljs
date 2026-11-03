(ns manufaktura.stories.button.playground
  (:require
   ["lucide-react"                   :refer [ArrowRight]]
   [clojure.string                   :as str]
   [manufaktura.ui.components.button :as button]))

(defn example
  ([]
   (example {:label "Continue"
             :variant :default
             :size :default
             :disabled false}))
  ([args]
   [:div {:class "p-6"}
    (let [icon? (str/starts-with? (name (:size args)) "icon")]
      [button/button
       (cond-> (select-keys args [:variant :size :disabled])
         icon? (assoc :aria-label (:label args)))
       (if icon? [:> ArrowRight] (:label args))])]))
