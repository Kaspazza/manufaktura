(ns manufaktura.stories.accordion.playground
  (:require
   [manufaktura.ui.components.accordion :as accordion]))

(defn example
  ([]
   (example {:mode "single"
             :collapsible true}))
  ([{:keys [mode collapsible]
     :or {mode "single"}}]
   [:div {:class "w-full max-w-lg"}
    [:p {:class "mb-3 text-sm text-muted-foreground"}
     "Single mode opens one section; multiple mode keeps several open. Changing mode resets open sections. Collapsible applies only to single mode."]
    (into [accordion/accordion
           (cond-> {:key mode
                    :type mode}
             (= mode "single") (assoc :collapsible collapsible))]
          (for [[value title content]
                [["shipping" "Shipping" "Orders ship within two business days."]
                 ["returns" "Returns" "Return unused items within 30 days."]
                 ["support" "Support" "Contact support with your order number."]]]
            [accordion/accordion-item {:key value
                                       :value value}
             [accordion/accordion-trigger {}
              title]
             [accordion/accordion-content {}
              content]]))]))
