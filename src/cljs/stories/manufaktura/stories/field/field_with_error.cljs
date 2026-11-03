(ns manufaktura.stories.field.field-with-error
  (:require
   [manufaktura.ui.components.field :as field]
   [manufaktura.ui.components.input :as input]))

(defn example
  []
  [:div {:class "p-6 max-w-md"}
   [field/field {}
    [field/field-label {:html-for "email"}
     "Email"]
    [field/field-content {}
     [input/input {:id "email"
                   :placeholder "name@example.com"
                   :aria-invalid true}]
     [field/field-error {:errors [{:message "Email is required"}
                                  {:message "Email must be valid"}]}]]]])
