(ns manufaktura.stories.button-group.button-group-with-text
  (:require
   [manufaktura.ui.components.button       :as button]
   [manufaktura.ui.components.button-group :as button-group]))

(defn example
  []
  [button-group/button-group {}
   [button-group/button-group-text {}
    "https://"]
   [button/button {:variant :outline}
    "example.com"]])
