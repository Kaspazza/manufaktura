(ns manufaktura.stories.input.input-with-button
  (:require
   [manufaktura.ui.components.button :as button]
   [manufaktura.ui.components.input  :as input]))

(defn example
  []
  [:div {:class "p-6"}
   [:div {:class "flex w-full max-w-sm items-center gap-2"}
    [input/input {:type "email"
                  :placeholder "Email"}]
    (button/button {:type "submit"
                    :variant :outline}
                   "Subscribe")]])
