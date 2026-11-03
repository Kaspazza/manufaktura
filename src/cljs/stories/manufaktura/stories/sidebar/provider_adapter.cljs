(ns manufaktura.stories.sidebar.provider-adapter
  (:require
   ["lucide-react"                    :refer [Kanban]]
   [manufaktura.ui.components.sidebar :as sidebar]))

(defn context-sidebar-layout
  [{:keys [dir label]}]
  (let [{:keys [open? set-open! open-mobile? set-open-mobile! is-mobile state toggle-sidebar!]}
        (sidebar/use-sidebar)
        active-open? (if is-mobile open-mobile? open?)]
    [:div {:class "relative flex h-[420px] w-full overflow-hidden rounded-xl border"
           :dir dir}
     [sidebar/sidebar {:open? active-open?
                       :is-mobile is-mobile
                       :on-open-change (if is-mobile set-open-mobile! set-open!)
                       :side (if (= dir "rtl") "right" "left")
                       :collapsible "icon"
                       :class (when-not is-mobile "absolute h-full")}
      [sidebar/sidebar-header {:class "min-w-0 overflow-hidden"}
       [:div {:class "flex h-8 min-w-0 items-center gap-2 overflow-hidden px-2"}
        [:>
         Kanban
         {:class "size-4 shrink-0"
          :aria-hidden true}]
        [:strong {:class "min-w-0 truncate text-sm group-data-[collapsible=icon]:sr-only"}
         label]]]
      [sidebar/sidebar-content {}
       [sidebar/sidebar-menu {:class "p-2"}
        [sidebar/sidebar-menu-item {}
         [sidebar/sidebar-menu-button {:is-active? true
                                       :collapsed? (= state "collapsed")
                                       :is-mobile is-mobile
                                       :tooltip "Overview"}
          [:> Kanban]
          [:span "Overview"]]]]]
      [sidebar/sidebar-rail {:on-click toggle-sidebar!}]]
     [sidebar/sidebar-inset {:class "h-auto min-h-0 min-w-0"}
      [:header {:class "flex shrink-0 flex-wrap items-center gap-3 border-b p-4"}
       [sidebar/sidebar-trigger {:on-click toggle-sidebar!}]
       [:span {:class "text-sm"}
        (str (if active-open? "Open" "Closed") " · " (if is-mobile "Mobile" "Desktop"))]
       [:span {:class "ms-auto text-xs text-muted-foreground"}
        "Press Ctrl/Cmd+B"]]
      [:div {:class "p-6 text-sm text-muted-foreground"}
       "Provider state is read with use-sidebar and passed explicitly to every presentational component."]]]))

(defn example
  []
  [sidebar/sidebar-provider {:default-open? true}
   [:f> context-sidebar-layout {:label "Context adapter"}]])
