(ns manufaktura.stories.radio-group.radio-group-rtl
  (:require
   [manufaktura.ui.components.label       :as label]
   [manufaktura.ui.components.radio-group :as radio-group]))

(defn example
  []
  [:div {:dir "rtl"
         :class "max-w-md p-6"}
   [radio-group/radio-group {:default-value "daily"
                             :dir "rtl"
                             :aria-label "تكرار الملخص"}
    [:div {:class "flex items-center gap-3"}
     [radio-group/radio-group-item {:id "digest-daily"
                                    :value "daily"}]
     [label/label {:html-for "digest-daily"}
      "يومي"]]
    [:div {:class "flex items-center gap-3"}
     [radio-group/radio-group-item {:id "digest-weekly"
                                    :value "weekly"}]
     [label/label {:html-for "digest-weekly"}
      "أسبوعي"]]]])
