(ns manufaktura.stories.select.playground
  (:require
   [manufaktura.ui.components.select :as select]))

(defn example
  ([]
   (example {:default-value "banana"
             :disabled false
             :trigger-size "default"}))
  ([args]
   [:div {:class "p-6"}
    [select/select
     (assoc (select-keys args [:default-value :disabled]) :key (:default-value args))
     [select/select-trigger {:aria-label "Fruit"
                             :class "w-[180px]"
                             :size (:trigger-size args)}
      [select/select-value {:placeholder "Select a fruit"}]]
     [select/select-content {}
      [select/select-item {:value "apple"}
       "Apple"]
      [select/select-item {:value "banana"}
       "Banana"]
      [select/select-item {:value "blueberry"}
       "Blueberry"]]]]))
