(ns manufaktura.stories.sidebar.sidebar-demo
  (:require
   ["lucide-react"                    :refer [Folder Kanban Settings Users]]
   [manufaktura.ui.components.sidebar :as sidebar]))

(defn example
  []
  [:div {:class "mx-auto h-[360px] w-64 max-w-full overflow-hidden rounded-xl border"}
   [sidebar/sidebar {:open? true
                     :is-mobile false
                     :collapsible "none"
                     :variant "sidebar"
                     :class "w-full"}
    [sidebar/sidebar-header {}
     [:div {:class "text-sm font-semibold px-2"}
      "Workspace"]]
    [sidebar/sidebar-content {}
     [sidebar/sidebar-menu {}
      [sidebar/sidebar-menu-item {}
       [sidebar/sidebar-menu-button {:is-active? true}
        [:> Kanban]
        "Dashboard"]]
      [sidebar/sidebar-menu-item {}
       [sidebar/sidebar-menu-button {}
        [:> Folder]
        "Projects"]]
      [sidebar/sidebar-menu-item {}
       [sidebar/sidebar-menu-button {}
        [:> Users]
        "Team"]]
      [sidebar/sidebar-menu-item {}
       [sidebar/sidebar-menu-button {}
        [:> Settings]
        "Settings"]]]]
    [sidebar/sidebar-footer {}
     [:div {:class "text-xs text-muted-foreground px-2"}
      "v1.0"]]]])
