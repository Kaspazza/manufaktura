(ns manufaktura.stories.switch.switch-demo
  (:require
   [manufaktura.ui.components.label  :as label]
   [manufaktura.ui.components.switch :as switch]))

(defn example
  []
  [:div {:class "p-6"}
   [:div {:class "flex items-center gap-2"}
    [switch/switch {:id "airplane-mode"}]
    [label/label {:html-for "airplane-mode"}
     "Airplane Mode"]]])
