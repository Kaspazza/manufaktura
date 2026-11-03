(ns manufaktura.stories.popover.popover-rtl
  (:require
   [manufaktura.ui.components.button  :as button]
   [manufaktura.ui.components.input   :as input]
   [manufaktura.ui.components.label   :as label]
   [manufaktura.ui.components.popover :as popover]))

(defn example
  []
  [:div {:class "p-6"
         :dir "rtl"}
   [popover/popover {}
    [popover/popover-trigger {:as-child true}
     (button/button {:variant :outline} "تعديل الملف")]
    [popover/popover-content {:align "start"
                              :class "w-80"
                              :dir "rtl"}
     [popover/popover-header {}
      [popover/popover-title {}
       "بيانات الحساب"]
      [popover/popover-description {}
       "حدّث الاسم الظاهر في ملفك الشخصي."]]
     [:div {:class "mt-4 grid gap-2"}
      [label/label {:html-for "rtl-display-name"}
       "الاسم"]
      [input/input {:id "rtl-display-name"
                    :default-value "مريم"}]]]]])
