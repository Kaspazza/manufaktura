(ns manufaktura.stories.textarea.playground
  (:require
   [manufaktura.ui.components.textarea :as textarea]))

(defn example
  ([]
   (example ((fn [{:keys [auto-size]
                   :as args}]
               (assoc (dissoc args :auto-size) :auto-size? auto-size))
             {:placeholder "Type your message…"
              :default-value ""
              :rows 4
              :disabled false
              :auto-size true})))
  ([args]
   [:div {:class "max-w-sm p-6"}
    [:label {:class "block space-y-2"}
     [:span {:class "text-sm font-medium"}
      "Message"]
     ^{:key (:default-value args)}
     [textarea/textarea
      (update args
              :rows
              #(if (and (number? %) (js/Number.isFinite %) (pos? %)) (js/Math.floor (max 1 %)) 4))]
     [:span {:class "text-xs text-muted-foreground"}
      "Changing initial value resets text. Auto size uses CSS field-sizing; browser support is required."]]]))
