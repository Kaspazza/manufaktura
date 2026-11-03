(ns manufaktura.stories.input.input-file-guidance
  (:require
   [manufaktura.ui.components.field :as field]
   [manufaktura.ui.components.input :as input]))

(defn example
  []
  [:div {:class "max-w-sm p-6"}
   [field/field {}
    [field/field-label {:html-for "avatar-upload"}
     "Profile image"]
    [input/input {:id "avatar-upload"
                  :name "avatar"
                  :type "file"
                  :accept "image/png,image/jpeg"}]
    [field/field-description {}
     "PNG or JPG, up to 2 MB."]]])
