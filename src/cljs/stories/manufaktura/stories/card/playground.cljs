(ns manufaktura.stories.card.playground
  (:require
   [manufaktura.ui.components.card :as card]))

(defn example
  ([]
   (example {:size "default"
             :title "Project overview"
             :description "A summary of the current project."
             :body "Review the latest notes and milestones."}))
  ([args]
   [card/card {:size (keyword (:size args))
               :class "w-full max-w-sm"}
    [card/card-header {}
     [card/card-title {}
      (:title args)]
     [card/card-description {}
      (:description args)]]
    [card/card-content {}
     (:body args)]]))
