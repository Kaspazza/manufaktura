(ns manufaktura.stories.dialog.dialog-without-corner-close
  (:require
   [manufaktura.ui.components.button :as button]
   [manufaktura.ui.components.dialog :as dialog]))

(defn example
  []
  [:div {:class "p-6"}
   [dialog/dialog {}
    [dialog/dialog-trigger {:as-child true}
     (button/button {:variant :outline} "Review invitation")]
    [dialog/dialog-content {:show-close-button false}
     [dialog/dialog-header {}
      [dialog/dialog-title {}
       "Team invitation"]
      [dialog/dialog-description {}
       "Review the invitation before returning to your workspace."]]
     [dialog/dialog-footer {}
      [dialog/dialog-close {:as-child true}
       (button/button {:variant :outline} "Close invitation")]]]]])
