(ns manufaktura.stories.table.table-with-actions
  (:require
   [clojure.string                          :as str]
   [manufaktura.ui.components.badge         :as badge]
   [manufaktura.ui.components.button        :as button]
   [manufaktura.ui.components.dropdown-menu :as dropdown-menu]
   [manufaktura.ui.components.table         :as table]))

(defn example
  []
  (let [rows [{:id "PRJ-104"
               :title "Marketing Site"
               :status :active}
              {:id "PRJ-105"
               :title "Mobile App"
               :status :paused}
              {:id "PRJ-106"
               :title "Data Pipeline"
               :status :blocked}]
        row->view (fn [{:keys [id title status]}]
                    [table/table-row {:key id}
                     [table/table-cell {}
                      [:div {:class "font-medium"}
                       title]
                      [:div {:class "text-xs text-muted-foreground"}
                       id]]
                     [table/table-cell {}
                      [badge/badge {:variant (case status
                                               :active :default
                                               :paused :secondary
                                               :blocked :destructive
                                               :default)}
                       (str/capitalize (name status))]]
                     [table/table-cell {:class "text-right"}
                      [dropdown-menu/dropdown-menu {}
                       [dropdown-menu/dropdown-menu-trigger {:as-child true}
                        (button/button {:variant :ghost
                                        :size :icon
                                        :aria-label (str "Actions for " title)}
                                       [:span {:aria-hidden true}
                                        "⋯"])]
                       [dropdown-menu/dropdown-menu-content {:align "end"}
                        [dropdown-menu/dropdown-menu-item {}
                         "View"]
                        [dropdown-menu/dropdown-menu-item {}
                         "Edit"]
                        [dropdown-menu/dropdown-menu-item {}
                         "Archive"]]]]])]
    [:div {:class "p-6"}
     [table/table {}
      [table/table-header {}
       [table/table-row {}
        [table/table-head {}
         "Project"]
        [table/table-head {}
         "Status"]
        [table/table-head {:class "text-right"}
         "Actions"]]]
      (into [table/table-body {}]
            (map row->view rows))]]))
