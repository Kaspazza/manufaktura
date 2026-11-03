(ns manufaktura.stories.empty.playground
  (:require
   ["lucide-react"                   :refer [Inbox]]
   [manufaktura.ui.components.button :as button]
   [manufaktura.ui.components.empty  :as empty]
   [reagent.core                     :as r]))

(defn example
  ([]
   (example {:media-variant :icon
             :title "No Projects Yet"
             :description "You haven't created any projects yet."
             :action-label "Create Project"}))
  ([args]
   (r/with-let [created? (r/atom false)]
               [:div {:class "p-6"}
                [empty/empty {}
                 [empty/empty-header {}
                  [empty/empty-media {:variant (:media-variant args)}
                   [:> Inbox]]
                  [empty/empty-title {}
                   (:title args)]
                  [empty/empty-description {}
                   (:description args)]]
                 [empty/empty-content {}
                  [button/button {:on-click #(reset! created? true)}
                   (:action-label args)]]]
                [:p {:role "status"}
                 (when @created? "Project created (demo only; nothing is saved).")]])))
