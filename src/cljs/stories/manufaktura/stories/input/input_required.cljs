(ns manufaktura.stories.input.input-required
  (:require
   [manufaktura.ui.components.field :as field]
   [manufaktura.ui.components.input :as input]))

(defn example
  []
  [:div {:class "max-w-sm p-6"}
   [field/field {}
    [field/field-label {:html-for "required-email"}
     "Email "
     [:span {:aria-hidden true
             :class "text-destructive"}
      "*"]]
    [input/input {:id "required-email"
                  :type "email"
                  :required true
                  :aria-required true}]]])
