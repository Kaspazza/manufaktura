(ns manufaktura.stories.dialog.dialog-close-button
  (:require
   [manufaktura.ui.components.button :as button]
   [manufaktura.ui.components.dialog :as dialog]
   [manufaktura.ui.components.input  :as input]
   [manufaktura.ui.components.label  :as label]))

(defn example
  []
  [:div {:class "p-6"}
   [dialog/dialog {}
    [dialog/dialog-trigger {:as-child true}
     (button/button {:variant :outline} "Share")]
    [dialog/dialog-content {:class "sm:max-w-md"}
     [dialog/dialog-header {}
      [dialog/dialog-title {}
       "Share link"]
      [dialog/dialog-description {}
       "Anyone with this link will be able to view this."]]
     [:div {:class "flex items-center gap-2"}
      [:div {:class "grid flex-1 gap-2"}
       [label/label {:html-for "share-link"
                     :class "sr-only"}
        "Link"]
       [input/input {:id "share-link"
                     :read-only true
                     :default-value "https://ui.shadcn.com/docs/installation"}]]]
     [dialog/dialog-footer {:class "sm:justify-start"}
      [dialog/dialog-close {:as-child true}
       (button/button {:type "button"
                       :variant :secondary}
                      "Close")]]]]])
