(ns manufaktura.stories.aspect-ratio.playground
  (:require
   [manufaktura.ui.components.aspect-ratio :as aspect-ratio]))

(defn example
  ([] (example {:ratio 1.7778}))
  ([args]
   [:div {:class "w-full max-w-md p-6"}
    [aspect-ratio/aspect-ratio {:ratio (or (:ratio args) 1.7778)
                                :class "overflow-hidden rounded-lg bg-muted"}
     [:img
      {:src
       "https://images.unsplash.com/photo-1472214103451-9374bd1c798e?auto=format&fit=crop&w=900&q=80"
       :alt "Green landscape"
       :class "size-full object-cover"}]]]))
