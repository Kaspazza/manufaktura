(ns manufaktura.stories.button-group.button-group-separator
  (:require
   [manufaktura.ui.components.button       :as button]
   [manufaktura.ui.components.button-group :as button-group]))

(defn example
  []
  [button-group/button-group {}
   [button/button {:variant :outline}
    "Save"]
   [button-group/button-group-separator {}]
   [button/button {:variant :outline}
    "Options"]])
