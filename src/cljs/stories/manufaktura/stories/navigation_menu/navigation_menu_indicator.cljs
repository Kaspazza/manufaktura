(ns manufaktura.stories.navigation-menu.navigation-menu-indicator
  (:require
   [manufaktura.ui.components.navigation-menu :as navigation-menu]))

(defn example
  []
  [navigation-menu/navigation-menu {}
   [navigation-menu/navigation-menu-list {}
    [navigation-menu/navigation-menu-item {}
     [navigation-menu/navigation-menu-trigger {}
      "Resources"]
     [navigation-menu/navigation-menu-content {}
      [navigation-menu/navigation-menu-link {:href "#guides"}
       "Guides"]]]
    [navigation-menu/navigation-menu-indicator {}]]])
