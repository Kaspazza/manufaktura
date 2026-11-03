(ns manufaktura.stories.native-select.playground
  (:require
   [manufaktura.ui.components.native-select :as native-select]))

(defn example
  ([] (example {}))
  ([consumer-args]
   (let [args ((fn [args] (update args :size keyword))
               (merge {:default-value "reagent"
                       :size "default"
                       :disabled false}
                      consumer-args))]
     [native-select/native-select
      (assoc (dissoc args :required) :key (:default-value args) :aria-label "Framework")
      [native-select/native-select-option {:value "reagent"}
       "Reagent"]
      [native-select/native-select-option {:value "react"}
       "React"]
      [native-select/native-select-option {:value "clojure"}
       "Clojure"]])))
