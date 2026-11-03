(ns manufaktura.stories.spinner.spinner-input-group
  (:require
   [manufaktura.ui.components.input-group :as input-group]
   [manufaktura.ui.components.spinner     :as spinner]))

(defn example
  []
  [:div {:role "status"
         :class "max-w-sm"}
   [input-group/input-group {}
    [input-group/input-group-addon {}
     [spinner/spinner {}]]
    [input-group/input-group-input {:disabled true
                                    :value "Searching repositories…"
                                    :aria-label "Repository search"}]]
   [:span {:class "sr-only"}
    "Searching repositories"]])
