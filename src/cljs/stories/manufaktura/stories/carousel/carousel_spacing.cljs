(ns manufaktura.stories.carousel.carousel-spacing
  (:require
   [manufaktura.stories.carousel.carousel-size :as size]))

(defn example
  []
  [:div {:class "w-full max-w-2xl space-y-6"}
   [:p {:class "text-sm text-muted-foreground"}
    "All rows use one-third-width slides. Change both the content's negative margin and each item's padding to adjust the gap without adding an outer inset."]
   [size/comparison {:label "No gap - 0px"
                     :description "Content: ml-0 · Item: pl-0"
                     :basis "33.333333%"
                     :content-class "ml-0"
                     :item-class "pl-0"}]
   [size/comparison {:label "Default gap - 16px (1rem)"
                     :description "Content: -ml-4 · Item: pl-4"
                     :basis "33.333333%"
                     :content-class "-ml-4"
                     :item-class "pl-4"}]
   [size/comparison {:label "Wide gap - 32px (2rem)"
                     :description "Content: -ml-8 · Item: pl-8"
                     :basis "33.333333%"
                     :content-class "-ml-8"
                     :item-class "pl-8"}]])
