(ns manufaktura.stories.carousel.carousel-loop
  (:require
   [manufaktura.ui.components.carousel :as carousel]))

(defn- slide-card
  [label]
  [:div {:class "p-1"}
   [:div {:class "flex aspect-square items-center justify-center rounded-lg border bg-card"}
    [:span {:class "text-3xl font-semibold"}
     label]]])

(defn example
  []
  [:div {:class "w-full max-w-xl space-y-4 px-12 py-6"}
   [:p {:class "text-sm text-muted-foreground"}
    "Navigate past slide 5 to return to slide 1. Loop wraps manual navigation; it does not autoplay."]
   [carousel/carousel {:opts {:loop true}
                       :class "w-full max-w-xs"}
    (into [carousel/carousel-content {}]
          (for [idx (range 1 6)]
            [carousel/carousel-item {:key idx}
             [slide-card idx]]))
    [carousel/carousel-previous {}]
    [carousel/carousel-next {}]]])
