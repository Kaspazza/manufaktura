(ns manufaktura.stories.button.button-loading
  (:require
   [manufaktura.ui.components.button  :as button]
   [manufaktura.ui.components.spinner :as spinner]))

(defn example
  []
  [:div {:class "p-6"}
   (button/button {:variant :outline
                   :size :sm
                   :disabled true}
                  [spinner/spinner {:class "size-4"}]
                  "Submitting")])
