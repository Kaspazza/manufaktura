(ns manufaktura.stories.avatar.avatar-with-badge
  (:require
   [manufaktura.ui.components.avatar :as avatar]))

(defn example
  []
  [:div {:class "p-6"}
   [avatar/avatar {}
    [avatar/avatar-image {:src "https://github.com/shadcn.png"
                          :alt "@shadcn"}]
    [avatar/avatar-fallback {}
     "CN"]
    [avatar/avatar-badge {:class "bg-green-600 dark:bg-green-800"}]]])
