(ns manufaktura.stories.input.input-field-group-actions
  (:require
   [manufaktura.ui.components.button :as button]
   [manufaktura.ui.components.field  :as field]
   [manufaktura.ui.components.input  :as input]))

(defn example
  []
  [:form {:class "max-w-md p-6"
          :on-submit #(.preventDefault %)}
   [field/field-group {}
    [field/field {}
     [field/field-label {:html-for "profile-name"}
      "Display name"]
     [input/input {:id "profile-name"
                   :name "display-name"
                   :default-value "Ada Lovelace"}]]
    [:div {:class "flex gap-2"}
     (button/button {:type "reset"
                     :variant :outline}
                    "Reset")
     (button/button {:type "submit"} "Save")]]])
