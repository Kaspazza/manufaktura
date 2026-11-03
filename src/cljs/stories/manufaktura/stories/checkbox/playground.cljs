(ns manufaktura.stories.checkbox.playground
  (:require
   [manufaktura.ui.components.checkbox :as checkbox]
   [reagent.core                       :as r]))

(defn example
  ([] (example {:disabled false}))
  ([args]
   (r/with-let [checked? (r/atom false)]
               [:div {:class "space-y-3 p-6"}
                [:div {:class "flex items-center gap-2"}
                 [checkbox/checkbox {:id "checkbox-playground"
                                     :disabled (:disabled args)
                                     :checked @checked?
                                     :on-checked-change #(reset! checked? %)}]
                 [:label {:for "checkbox-playground"}
                  "Receive product updates"]]
                [:p {:role "status"
                     :class "text-sm"}
                 (if @checked? "Updates enabled." "Updates disabled.")]])))
