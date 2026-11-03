(ns manufaktura.stories.alert.playground
  (:require
   ["lucide-react"                  :refer [Info TriangleAlert]]
   [manufaktura.ui.components.alert :as alert]))

(defn example
  ([]
   (example {:variant :default
             :title "Success"
             :description "Your changes have been saved."}))
  ([args]
   [:div {:class "max-w-xl p-6"}
    [alert/alert
     (select-keys args [:variant])
     [:> (if (= :destructive (:variant args)) TriangleAlert Info)]
     [alert/alert-title {}
      (:title args)]
     [alert/alert-description {}
      (:description args)]]]))
