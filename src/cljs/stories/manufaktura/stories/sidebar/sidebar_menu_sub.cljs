(ns manufaktura.stories.sidebar.sidebar-menu-sub
  (:require
   [manufaktura.ui.components.sidebar :as sidebar]))

(defn example
  []
  [:div {:class "mx-auto w-64 max-w-full overflow-hidden rounded-xl border"}
   [sidebar/sidebar {:open? true
                     :is-mobile false
                     :collapsible "none"
                     :class "h-auto w-full p-2"}
    [sidebar/sidebar-content {}
     [sidebar/sidebar-menu {}
      [sidebar/sidebar-menu-item {}
       [sidebar/sidebar-menu-button {:is-active? true}
        "Projects"]
       [sidebar/sidebar-menu-sub {}
        [sidebar/sidebar-menu-sub-item {}
         [sidebar/sidebar-menu-sub-button {:href "#roadmap"
                                           :is-active? true}
          "Roadmap"]]
        [sidebar/sidebar-menu-sub-item {}
         [sidebar/sidebar-menu-sub-button {:href "#backlog"}
          "Backlog"]]
        [sidebar/sidebar-menu-sub-item {}
         [sidebar/sidebar-menu-sub-button {:href "#archive"}
          "Archive"]]]]
      [sidebar/sidebar-menu-item {}
       [sidebar/sidebar-menu-button {}
        "Analytics"]]]]]])
