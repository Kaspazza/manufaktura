(ns manufaktura.stories.avatar.playground
  (:require
   [manufaktura.ui.components.avatar :as avatar]))

(defn example
  ([]
   (example {:mode "image"
             :size :default
             :alt "Shadcn"
             :fallback "CN"}))
  ([args]
   [:div {:class "p-6"}
    [avatar/avatar
     (select-keys args [:size])
     (when (= "image" (:mode args))
       [avatar/avatar-image {:src "https://github.com/shadcn.png"
                             :alt (:alt args)}])
     [avatar/avatar-fallback {}
      (:fallback args)]]]))
