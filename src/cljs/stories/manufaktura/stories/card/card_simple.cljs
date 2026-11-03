(ns manufaktura.stories.card.card-simple
  (:require
   [manufaktura.ui.components.card :as card]))

(defn example
  []
  [card/card {:class "max-w-md"}
   [card/card-header {}
    [card/card-title {}
     "Notifications"]
    [card/card-description {}
     "You have three unread messages."]]
   [card/card-content {}
    "Your latest activity appears here."]])
