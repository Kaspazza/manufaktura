(ns manufaktura.stories.card.card-rtl
  (:require
   [manufaktura.ui.components.button :as button]
   [manufaktura.ui.components.card   :as card]
   [manufaktura.ui.components.input  :as input]))

(defn example
  []
  [:div {:dir "rtl"
         :class "text-right"}
   [card/card {:class "w-full max-w-md"}
    [card/card-header {}
     [card/card-title {}
      [:h2 "إنشاء مشروع"]]
     [card/card-description {}
      "أدخل بيانات المشروع الجديد."]]
    [card/card-content {}
     [:div {:class "grid gap-2"}
      [:label {:for "rtl-project"
               :class "text-sm font-medium"}
       "اسم المشروع"]
      [input/input {:id "rtl-project"
                    :placeholder "موقع الشركة"}]]]
    [card/card-footer {:class "justify-end border-t"}
     (button/button {} "إنشاء")]]])
