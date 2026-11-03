(ns manufaktura.stories.sidebar.sidebar-controlled
  (:require
   [manufaktura.ui.components.sidebar :as sidebar]
   [reagent.core                      :as r]))

(defn example
  []
  (let [open? (r/atom true)]
    (fn []
      [:div
       {:class
        "relative flex h-[420px] w-full overflow-hidden rounded-xl border [&>[data-slot=sidebar]]:block [&_[data-slot=sidebar-container]]:flex"}
       [sidebar/sidebar {:open? @open?
                         :is-mobile false
                         :class "absolute h-full"
                         :collapsible "offcanvas"}
        [sidebar/sidebar-content {}
         [sidebar/sidebar-menu {}
          [sidebar/sidebar-menu-item {}
           [sidebar/sidebar-menu-button {:is-active? true}
            "Overview"]]
          [sidebar/sidebar-menu-item {}
           [sidebar/sidebar-menu-button {}
            "Reports"]]]]]
       [sidebar/sidebar-inset {:class "h-auto min-h-0 min-w-0"}
        [:header {:class "flex min-h-14 shrink-0 items-center gap-3 border-b px-4"}
         [sidebar/sidebar-trigger {:on-click #(swap! open? not)}]
         [:span {:class "text-sm"}
          (if @open? "Expanded" "Closed")]]
        [:section {:class "overflow-auto p-6"}
         [:h2 {:class "font-semibold"}
          "Overview"]
         [:p {:class "mt-2 text-sm text-muted-foreground"}
          "Toggle navigation to give your reports more room. The content stays in the preview."]]]])))
