(ns manufaktura.stories.label.playground
  (:require
   [manufaktura.ui.components.checkbox :as checkbox]
   [manufaktura.ui.components.label    :as label]
   [reagent.core                       :as r]))

(defn example
  ([] (example {}))
  ([consumer-args]
   (r/with-let [id (str (gensym "terms-"))]
               (let [args (merge {:label "Accept terms and conditions"
                                  :disabled false}
                                 consumer-args)]
                 [:div {:class "p-6"}
                  [:div {:class "flex items-center gap-2"}
                   [checkbox/checkbox {:id id
                                       :disabled (:disabled args)}]
                   [label/label {:html-for id}
                    (:label args)]]]))))
