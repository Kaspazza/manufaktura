(ns manufaktura.stories.sidebar.provider-controlled
  (:require
   ["lucide-react"                    :refer [Building2 Kanban]]
   [manufaktura.ui.components.sidebar :as sidebar]
   [reagent.core                      :as r]))

(defn context-sidebar-layout
  [{:keys [dir label]}]
  (let [{:keys [open? set-open! open-mobile? set-open-mobile! is-mobile state toggle-sidebar!]}
        (sidebar/use-sidebar)
        active-open? (if is-mobile open-mobile? open?)]
    [:div
     {:class
      "relative flex h-[420px] w-full overflow-hidden rounded-xl border [&>[data-slot=sidebar]]:block [&_[data-slot=sidebar-container]]:flex"
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
         Building2
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
        (str "state=" state ", mobile=" is-mobile)]
       [:span {:class "ms-auto text-xs text-muted-foreground"}
        "Owner-controlled state"]]
      [:div {:class "p-6 text-sm text-muted-foreground"}
       "Provider state is read with use-sidebar and passed explicitly to every presentational component."]]]))

(defn example
  []
  (let [open? (r/atom true)]
    (fn [] [sidebar/sidebar-provider {:open? @open?
                                      :on-open-change #(reset! open? %)
                                      :is-mobile false
                                      :shortcut nil}
            [:f> context-sidebar-layout {:label "Controlled context"}]])))
