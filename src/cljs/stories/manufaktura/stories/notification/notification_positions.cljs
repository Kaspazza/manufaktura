(ns manufaktura.stories.notification.notification-positions
  (:require
   [manufaktura.ui.components.button       :as button]
   [manufaktura.ui.components.notification :as notification]))

(defn example
  []
  [:div {:class "flex max-w-xl flex-wrap gap-2 p-6"}
   [notification/toaster]
   (for [position
         ["top-left" "top-center" "top-right" "bottom-left" "bottom-center" "bottom-right"]]
     ^{:key position}
     [button/button {:variant :outline
                     :on-click #(notification/show-toast position {:position position})}
      position])])
