(ns manufaktura.stories.spinner.spinner-button
  (:require
   [manufaktura.ui.components.button  :as button]
   [manufaktura.ui.components.spinner :as spinner]))

(defn example
  []
  [:div {:class "p-6 flex flex-col items-start gap-4"}
   (button/button {:disabled true
                   :size :sm}
                  [spinner/spinner {}]
                  "Loading...")
   (button/button {:variant :outline
                   :disabled true
                   :size :sm}
                  [spinner/spinner {}]
                  "Please wait")
   (button/button {:variant :secondary
                   :disabled true
                   :size :sm}
                  [spinner/spinner {}]
                  "Processing")])
