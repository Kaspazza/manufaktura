(ns manufaktura.stories.dropdown-menu.dropdown-menu-icons
  (:require
   ["lucide-react"                          :refer [CircleUser CreditCard LogOut Settings]]
   [manufaktura.ui.components.button        :as button]
   [manufaktura.ui.components.dropdown-menu :as dropdown-menu]))

(defn example
  []
  [dropdown-menu/dropdown-menu {}
   [dropdown-menu/dropdown-menu-trigger {:as-child true}
    (button/button {:variant :outline} "Account actions")]
   [dropdown-menu/dropdown-menu-content {:class "w-52"
                                         :align "start"}
    [dropdown-menu/dropdown-menu-item {}
     [:> CircleUser {:aria-hidden true}]
     "Profile"]
    [dropdown-menu/dropdown-menu-item {}
     [:> CreditCard {:aria-hidden true}]
     "Billing"]
    [dropdown-menu/dropdown-menu-item {}
     [:> Settings {:aria-hidden true}]
     "Settings"]
    [dropdown-menu/dropdown-menu-separator {}]
    [dropdown-menu/dropdown-menu-item {}
     [:> LogOut {:aria-hidden true}]
     "Sign out"]]])
