(ns manufaktura.stories.progress.playground
  (:require
   [manufaktura.ui.components.progress :as progress]))

(defn example
  ([] (example {:value 60}))
  ([args]
   [:div {:class "w-80"}
    [progress/progress (assoc (select-keys args [:value]) :aria-label "Upload progress")]]))
