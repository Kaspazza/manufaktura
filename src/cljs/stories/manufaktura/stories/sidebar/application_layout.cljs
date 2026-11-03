(ns manufaktura.stories.sidebar.application-layout
  (:require
   ["lucide-react"                    :refer [Building2 Folder Kanban Settings Users]]
   [manufaktura.ui.components.sidebar :as sidebar]
   [reagent.core                      :as r]))

(defn example
  []
  (let [open? (r/atom true)
        mobile? (r/atom false)
        mobile-open? (r/atom false)
        toggle! #(swap! (if @mobile? mobile-open? open?) not)]
    (fn []
      [:div
       {:class
        "relative flex h-[680px] w-full overflow-hidden rounded-xl border [&>[data-slot=sidebar]]:block [&_[data-slot=sidebar-container]]:flex"}
       [sidebar/sidebar {:open? (if @mobile? @mobile-open? @open?)
                         :is-mobile @mobile?
                         :on-open-change #(reset! (if @mobile? mobile-open? open?) %)
                         :variant "inset"
                         :collapsible "icon"
                         :class (when-not @mobile? "absolute h-full")}
        [sidebar/sidebar-header {}
         [sidebar/sidebar-menu {}
          [sidebar/sidebar-menu-item {}
           [sidebar/sidebar-menu-button {:as-child true
                                         :size :default}
            [:a {:href "#workspace"
                 :aria-label "Northstar"}
             [:> Building2 {:class "shrink-0"}]
             [:span {:class "truncate group-data-[collapsible=icon]:hidden"}
              "Northstar"]]]]]
         [sidebar/sidebar-input {:placeholder "Search projects"
                                 :aria-label "Search projects"
                                 :class "group-data-[collapsible=icon]:hidden"}]]
        [sidebar/sidebar-separator {}]
        [sidebar/sidebar-content {}
         [sidebar/sidebar-group {}
          [sidebar/sidebar-group-label {}
           "Platform"]
          [sidebar/sidebar-group-action {:aria-label "Add project"}
           "+"]
          [sidebar/sidebar-group-content {}
           [sidebar/sidebar-menu {}
            [sidebar/sidebar-menu-item {}
             [sidebar/sidebar-menu-button {:as-child true
                                           :is-active? true
                                           :tooltip "Dashboard"
                                           :collapsed? (not @open?)
                                           :is-mobile @mobile?}
              [:a {:href "#dashboard"}
               [:> Kanban]
               [:span "Dashboard"]]]]
            [sidebar/sidebar-menu-item {}
             [sidebar/sidebar-menu-button {:as-child true
                                           :tooltip "Projects"
                                           :collapsed? (not @open?)
                                           :is-mobile @mobile?}
              [:a {:href "#projects"}
               [:> Folder]
               [:span "Projects"]]]
             [sidebar/sidebar-menu-action {:aria-label "Project actions"
                                           :show-on-hover? true}
              "⋯"]
             [sidebar/sidebar-menu-badge {}
              "8"]]
            [sidebar/sidebar-menu-item {}
             [sidebar/sidebar-menu-button {:as-child true
                                           :tooltip "Team"
                                           :collapsed? (not @open?)
                                           :is-mobile @mobile?}
              [:a {:href "#team"}
               [:> Users]
               [:span "Team"]]]]]]]
         [sidebar/sidebar-group {}
          [sidebar/sidebar-group-label {}
           "Loading example"]
          [sidebar/sidebar-menu {}
           [sidebar/sidebar-menu-skeleton {:show-icon? true
                                           :width "62%"}]
           [sidebar/sidebar-menu-skeleton {:show-icon? true
                                           :width "78%"}]]]]
        [sidebar/sidebar-footer {}
         [sidebar/sidebar-menu {}
          [sidebar/sidebar-menu-item {}
           [sidebar/sidebar-menu-button {:as-child true
                                         :tooltip "Settings"
                                         :collapsed? (not @open?)
                                         :is-mobile @mobile?}
            [:a {:href "#settings"}
             [:> Settings]
             [:span "Settings"]]]]]]
        [sidebar/sidebar-rail {:on-click toggle!}]]
       [sidebar/sidebar-inset {:class "h-auto min-h-0 min-w-0"}
        [:header {:class "flex shrink-0 flex-wrap items-center gap-3 border-b p-4"}
         [sidebar/sidebar-trigger {:on-click toggle!}]
         [:span {:class "text-sm font-medium"}
          "Northstar / Dashboard"]
         [:button {:type "button"
                   :class "ms-auto rounded-md border px-3 py-2 text-sm"
                   :aria-pressed @mobile?
                   :on-click #(do (reset! mobile-open? false) (swap! mobile? not))}
          (if @mobile? "Use desktop preview" "Use mobile preview")]]
        [:section {:class "min-h-0 space-y-6 overflow-auto p-6"}
         [:div
          [:h2 {:class "text-xl font-semibold"}
           "Workspace overview"]
          [:p {:class "mt-2 text-sm text-muted-foreground"}
           (if @mobile?
             "Open navigation with the trigger. Dismiss the sheet with Escape or by clicking outside."
             "Use the trigger or rail to collapse navigation. Switch to mobile to try the sheet.")]]
         [:div {:class "grid gap-4 lg:grid-cols-2"}
          [:article {:class "rounded-lg border p-4"}
           [:h3 {:class "font-medium"}
            "Projects"]
           [:p {:class "mt-2 text-sm text-muted-foreground"}
            "8 active projects across your workspace."]]
          [:article {:class "rounded-lg border p-4"}
           [:h3 {:class "font-medium"}
            "Team"]
           [:p {:class "mt-2 text-sm text-muted-foreground"}
            "Review members and plan the next milestone."]]]]]])))
