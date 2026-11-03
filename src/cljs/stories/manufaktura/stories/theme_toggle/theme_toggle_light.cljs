(ns manufaktura.stories.theme-toggle.theme-toggle-light
  (:require
   [manufaktura.ui.components.theme-toggle :as theme-toggle]))

(defn example
  []
  [:div {:class "p-6"}
   [theme-toggle/theme-toggle {:theme :light
                               :label "Light theme specimen"
                               :disabled true}]])
