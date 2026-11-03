(ns manufaktura.stories.loader.loader-text-variants
  (:require
   [manufaktura.ui.components.loader :as loader]))

(defn example
  []
  [:div {:class "p-6 space-y-3"}
   [loader/loader {:variant :text-blink
                   :text "Thinking"
                   :size :md}]
   [loader/loader {:variant :text-shimmer
                   :text "Processing"
                   :size :md}]
   [loader/loader {:variant :loading-dots
                   :text "Loading"
                   :size :md}]])
