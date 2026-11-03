(ns manufaktura.stories.switch.switch-rtl
  (:require
   [manufaktura.ui.components.field  :as field]
   [manufaktura.ui.components.switch :as switch]))

(defn example
  []
  [:div {:dir "rtl"
         :class "max-w-md p-6"}
   [field/field {:orientation :horizontal}
    [field/field-content {}
     [field/field-label {:html-for "switch-rtl"}
      "الوضع الداكن"]
     [field/field-description {}
      "استخدم مظهرًا داكنًا."]]
    [switch/switch {:id "switch-rtl"
                    :dir "rtl"}]]])
