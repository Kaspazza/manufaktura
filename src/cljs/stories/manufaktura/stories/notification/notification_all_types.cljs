(ns manufaktura.stories.notification.notification-all-types
  (:require
   [manufaktura.ui.components.button       :as button]
   [manufaktura.ui.components.notification :as notification]))

(defn example
  []
  [:div {:class "flex flex-wrap gap-2 p-6"}
   [notification/toaster {:rich-colors true}]
   (for [[label notify] [["Default" notification/show-toast]
                         ["Success" notification/show-success]
                         ["Info" notification/show-info]
                         ["Warning" notification/show-warning]
                         ["Error" notification/show-error]
                         ["Loading" notification/show-loading]]]
     ^{:key label}
     [button/button {:variant :outline
                     :on-click #(notify label)}
      label])])
