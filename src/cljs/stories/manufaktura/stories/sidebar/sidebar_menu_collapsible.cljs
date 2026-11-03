(ns manufaktura.stories.sidebar.sidebar-menu-collapsible
  (:require
   ["lucide-react"                    :refer [Folder Kanban Users]]
   [manufaktura.ui.components.sidebar :as sidebar]
   [reagent.core                      :as r]))

(defn example
  []
  (r/with-let
   [open? (r/atom false)]
   [:div
    {:class
     "relative flex h-[320px] w-full overflow-hidden rounded-xl border [&>[data-slot=sidebar]]:block [&_[data-slot=sidebar-container]]:flex"}
    [sidebar/sidebar {:open? @open?
                      :is-mobile false
                      :class "absolute h-full"
                      :collapsible "icon"}
     [sidebar/sidebar-content {}
      [sidebar/sidebar-menu {:class "p-2"}
       [sidebar/sidebar-menu-item {}
        [sidebar/sidebar-menu-button {:tooltip "Dashboard"
                                      :collapsed? (not @open?)
                                      :is-mobile false
                                      :aria-label "Dashboard"}
         [:> Kanban]
         "Dashboard"]]
       [sidebar/sidebar-menu-item {}
        [sidebar/sidebar-menu-button {:tooltip "Projects"
                                      :collapsed? (not @open?)
                                      :is-mobile false
                                      :aria-label "Projects"}
         [:> Folder]
         "Projects"]]
       [sidebar/sidebar-menu-item {}
        [sidebar/sidebar-menu-button {:tooltip "Team"
                                      :collapsed? (not @open?)
                                      :is-mobile false
                                      :aria-label "Team"}
         [:> Users]
         "Team"]]]]]
    [sidebar/sidebar-inset {:class "h-auto min-h-0 min-w-0"}
     [:header {:class "flex min-h-14 shrink-0 items-center gap-3 border-b px-4"}
      [sidebar/sidebar-trigger {:on-click #(swap! open? not)}]
      [:span {:class "text-sm"}
       "Icon navigation"]]
     [:section {:class "overflow-auto p-6"}
      [:h2 {:class "font-semibold"}
       "Dashboard"]
      [:p {:class "mt-2 text-sm text-muted-foreground"}
       "Collapse to icons, then hover or focus a menu item to see its label."]]]]))
