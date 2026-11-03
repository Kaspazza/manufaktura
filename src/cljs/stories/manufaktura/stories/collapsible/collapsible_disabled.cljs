(ns manufaktura.stories.collapsible.collapsible-disabled
  (:require
   [manufaktura.ui.components.button      :as button]
   [manufaktura.ui.components.collapsible :as collapsible]))

(defn example
  []
  [:div {:class "p-6"}
   [collapsible/collapsible {:open true
                             :disabled true}
    [collapsible/collapsible-trigger {:as-child true}
     (button/button {:variant :outline
                     :disabled true}
                    "Locked")]
    [collapsible/collapsible-content {:class "mt-4"}
     [:div {:class "rounded-md border bg-muted p-4 text-sm"}
      "Disabled collapsible remains open and cannot be toggled."]]]])
