(ns manufaktura.stories.tag-combobox.playground
  (:require
   [manufaktura.ui.components.tag-combobox :as tag-combobox]
   [reagent.core                           :as r]))

(defn example
  ([]
   (example {:placeholder "+ Add tag"
             :allow-create true}))
  ([args]
   (r/with-let [tags (r/atom #{"bug" "feature" "urgent"}) selected (r/atom nil)]
               [:div {:class "p-6"}
                [tag-combobox/tag-combobox
                 {:tags @tags
                  :selected-tag @selected
                  :placeholder (:placeholder args)
                  :on-select #(reset! selected %)
                  :on-create (when (:allow-create args)
                               (fn [tag] (swap! tags conj tag) (reset! selected tag)))}]
                [:div {:class "mt-3 flex gap-3"}
                 [:button {:type "button"
                           :class "rounded border px-3 py-1"
                           :disabled (nil? @selected)
                           :on-click #(reset! selected nil)}
                  "Clear selection"]
                 [:button {:type "button"
                           :class "rounded border px-3 py-1"
                           :on-click #(do (reset! tags #{"bug" "feature" "urgent"})
                                          (reset! selected nil))}
                  "Reset tags"]]])))
