(ns manufaktura.stories.tag-combobox.tag-combobox-localized-search
  (:require
   [manufaktura.ui.components.tag-combobox :as tag-combobox]
   [reagent.core                           :as r]))

(defn example
  []
  (let [tags (r/atom ["Project" "Urgent" "For review"])
        selected (r/atom nil)]
    (fn [] [:div {:class "max-w-sm space-y-3 p-6"}
            [:p {:class "text-sm text-muted-foreground"}
             "Search for ‘missing’ to see the custom empty state and create action."]
            [tag-combobox/tag-combobox {:tags @tags
                                        :selected-tag @selected
                                        :placeholder "+ Add tag"
                                        :search-placeholder "Search tags…"
                                        :empty-text "No tags found."
                                        :mobile-title "Select or create a tag"
                                        :create-label #(str "Create ‘" % "’")
                                        :on-select #(reset! selected %)
                                        :on-create
                                        (fn [tag] (swap! tags conj tag) (reset! selected tag))}]])))
