(ns manufaktura.stories.spinner.spinner-rtl
  (:require
   [manufaktura.ui.components.spinner :as spinner]))

(defn example
  []
  [:div {:dir "rtl"
         :role "status"
         :class "flex items-center gap-2 text-sm"}
   [spinner/spinner {}]
   [:span "جارٍ تحميل البيانات…"]])
