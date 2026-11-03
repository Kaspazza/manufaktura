(ns manufaktura.stories.collapsible.collapsible-default-open
  (:require
   [manufaktura.ui.components.button      :as button]
   [manufaktura.ui.components.collapsible :as collapsible]))

(defn example
  []
  [:div {:class "p-6"}
   [collapsible/collapsible {:default-open true}
    [collapsible/collapsible-trigger {:as-child true}
     (button/button {:variant :outline} "Toggle details")]
    [collapsible/collapsible-content {:class "mt-4"}
     [:div {:class "rounded-md border bg-muted p-4 text-sm"}
      "Starts expanded without external state management."]]]])
