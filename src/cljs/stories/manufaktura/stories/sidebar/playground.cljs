(ns manufaktura.stories.sidebar.playground
  (:require
   [manufaktura.ui.components.sidebar :as sidebar]
   [reagent.core                      :as r]))

(defn example
  ([] (example {:variant "sidebar"}))
  ([args]
   (r/with-let
    [open? (r/atom true)]
    [:div
     {:class
      "relative flex h-[420px] w-full overflow-hidden rounded-xl border bg-sidebar [&>[data-slot=sidebar]]:block [&_[data-slot=sidebar-container]]:flex"}
     [sidebar/sidebar {:variant (:variant args)
                       :open? @open?
                       :class "absolute h-full"
                       :is-mobile false
                       :collapsible "offcanvas"}
      [sidebar/sidebar-header {}
       [:div {:class "px-2 text-sm font-semibold"}
        "Workspace"]]
      [sidebar/sidebar-content {}
       [sidebar/sidebar-menu {}
        [sidebar/sidebar-menu-item {}
         [sidebar/sidebar-menu-button {:is-active? true}
          "Dashboard"]]]]]
     [sidebar/sidebar-inset {:class "h-auto min-h-0 min-w-0"}
      [:header {:class "flex min-h-14 shrink-0 items-center gap-3 border-b px-4"}
       [sidebar/sidebar-trigger {:on-click #(swap! open? not)}]
       [:span {:class "text-sm"}
        "Workspace"]]
      [:section {:class "overflow-auto p-6"}
       [:h2 {:class "font-semibold"}
        "Dashboard"]
       [:p {:class "mt-2 text-sm text-muted-foreground"}
        "Toggle navigation and compare sidebar, floating and inset treatments using the Variant control."]]]])))
