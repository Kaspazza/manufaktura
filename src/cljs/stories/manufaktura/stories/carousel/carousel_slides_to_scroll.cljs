(ns manufaktura.stories.carousel.carousel-slides-to-scroll
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
    "Three slides are visible; each arrow advances a group of two. Dragging also snaps to these groups."]
   [carousel/carousel {:opts {:align "start"
                              :slidesToScroll 2}
                       :class "w-full max-w-sm"}
    (into [carousel/carousel-content {}]
          (for [idx (range 1 11)]
            [carousel/carousel-item {:key idx
                                     :class "basis-1/3"}
             [slide-card idx]]))
    [carousel/carousel-previous {}]
    [carousel/carousel-next {}]]])
