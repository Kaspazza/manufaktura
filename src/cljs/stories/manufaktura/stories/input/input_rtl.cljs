(ns manufaktura.stories.input.input-rtl
  (:require
   [manufaktura.ui.components.field :as field]
   [manufaktura.ui.components.input :as input]))

(defn example
  []
  [:div {:dir "rtl"
         :class "max-w-sm p-6"}
   [field/field {}
    [field/field-label {:html-for "name-rtl"}
     "الاسم الكامل"]
    [input/input {:id "name-rtl"
                  :placeholder "اكتب اسمك"}]
    [field/field-description {}
     "كما يظهر في هويتك."]]])
