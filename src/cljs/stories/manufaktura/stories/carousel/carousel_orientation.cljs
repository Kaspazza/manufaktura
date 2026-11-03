(ns manufaktura.stories.carousel.carousel-orientation
  (:require
   [manufaktura.ui.components.carousel :as carousel]))

(defn- slide-card
  [label]
  [:div {:class "h-full p-1"}
   [:div {:class "flex h-full items-center justify-center rounded-lg border bg-card"}
    [:span {:class "text-3xl font-semibold"}
     label]]])

(defn example
  []
  [:div {:class "px-12 py-16"}
   [carousel/carousel {:opts {:align "start"}
                       :orientation :vertical
                       :class "w-full max-w-xs"}
    (into [carousel/carousel-content {:class "h-[340px]"}]
          (for [idx (range 1 6)]
            [carousel/carousel-item {:key idx
                                     :class "basis-1/2"}
             [slide-card idx]]))
    [carousel/carousel-previous {}]
    [carousel/carousel-next {}]]])
