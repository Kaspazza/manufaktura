(ns manufaktura.stories.sidebar.sidebar-menu
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
       [sidebar/sidebar-menu-button {:is-active? true
                                     :class "pr-14"}
        "Inbox"]
       [sidebar/sidebar-menu-badge {:class "right-7"}
        "12"]
       [sidebar/sidebar-menu-action {:show-on-hover? true
                                     :aria-label "Edit inbox"}
        "✎"]]
      [sidebar/sidebar-menu-item {}
       [sidebar/sidebar-menu-button {}
        "Notifications"]
       [sidebar/sidebar-menu-badge {}
        "3"]]
      [sidebar/sidebar-menu-item {}
       [sidebar/sidebar-menu-button {}
        "Archives"]]]]]])
