(ns manufaktura.stories.attachment.playground
  (:require
   ["lucide-react"                       :refer [FileText X]]
   [manufaktura.ui.components.attachment :as attachment]
   [manufaktura.ui.components.button     :as button]
   [reagent.core                         :as r]))

(defn example
  ([]
   (example {:state :done
             :size :default
             :orientation :horizontal
             :title "invoice.pdf"}))
  ([args]
   (r/with-let [removed? (r/atom false)]
               [:div {:class "space-y-3"}
                [button/button {:variant :outline
                                :on-click #(reset! removed? false)}
                 "Reset attachment"]
                (if @removed?
                  [:p {:role "status"}
                   "Attachment removed."]
                  [attachment/attachment-group {}
                   [attachment/attachment
                    (select-keys args [:state :size :orientation])
                    [attachment/attachment-media {}
                     [:> FileText]]
                    [attachment/attachment-content {}
                     [attachment/attachment-title {}
                      (:title args)]
                     [attachment/attachment-description {}
                      (let [state (:state args)]
                        (cond
                          (keyword? state) (name state)
                          (some? state) (str state)
                          :else ""))]]
                    [attachment/attachment-actions {}
                     [attachment/attachment-action {:aria-label "Remove"
                                                    :on-click #(reset! removed? true)}
                      [:> X]]]]])])))
