(ns manufaktura.stories.avatar.empty-avatar
  (:require
   [manufaktura.ui.components.avatar :as avatar]))

(defn example
  []
  [:div {:class "p-6"}
   [avatar/avatar {:size :lg}
    [avatar/avatar-image {:src "https://github.com/shadcn.png"
                          :alt "@shadcn"
                          :class "grayscale"}]
    [avatar/avatar-fallback {}
     "LR"]]])
