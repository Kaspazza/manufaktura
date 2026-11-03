(ns manufaktura.stories.radio-group.playground
  (:require
   [manufaktura.ui.components.label       :as label]
   [manufaktura.ui.components.radio-group :as radio-group]
   [reagent.core                          :as r]))

(defn example
  ([] (example {}))
  ([consumer-args]
   (r/with-let [prefix (str (gensym "density-"))]
               (let [args (merge {:default-value "comfortable"
                                  :orientation "vertical"
                                  :disabled false}
                                 consumer-args)
                     horizontal? (= :horizontal (keyword (:orientation args)))]
                 [:div {:class "p-6"}
                  [radio-group/radio-group
                   (assoc (select-keys args [:default-value :disabled])
                          :key (:default-value args)
                          :aria-label "Density"
                          :orientation (name (:orientation args))
                          :class (if horizontal? "flex flex-row gap-4" "flex flex-col gap-3"))
                   (for [[value text] [["default" "Default"]
                                       ["comfortable" "Comfortable"]
                                       ["compact" "Compact"]]]
                     ^{:key value}
                     [:div {:class "flex items-center gap-2"}
                      [radio-group/radio-group-item {:id (str prefix value)
                                                     :value value}]
                      [label/label {:html-for (str prefix value)}
                       text]])]]))))
