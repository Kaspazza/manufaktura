(ns manufaktura.stories.spinner.spinner-empty
  (:require
   [manufaktura.ui.components.empty   :as empty]
   [manufaktura.ui.components.spinner :as spinner]))

(defn example
  []
  [empty/empty {:role "status"
                :class "border"}
   [empty/empty-header {}
    [empty/empty-media {}
     [spinner/spinner {:class "size-8"}]]
    [empty/empty-title {}
     "Loading results"]
    [empty/empty-description {}
     "This may take a moment."]]])
