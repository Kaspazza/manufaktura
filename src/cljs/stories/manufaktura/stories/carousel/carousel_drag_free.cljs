(ns manufaktura.stories.carousel.carousel-drag-free
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
    "Drag and release to coast without snapping. Arrow buttons still navigate snap groups. This example also loops."]
   [carousel/carousel {:opts {:dragFree true
                              :loop true}
                       :class "w-full max-w-sm"}
    (into [carousel/carousel-content {}]
          (for [idx (range 1 10)]
            [carousel/carousel-item {:key idx
                                     :class "basis-1/3"}
             [slide-card idx]]))
    [carousel/carousel-previous {}]
    [carousel/carousel-next {}]]])
