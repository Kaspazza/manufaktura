(ns manufaktura.stories.carousel.carousel-size
  (:require
   [manufaktura.ui.components.carousel :as carousel]))

(defn comparison
  "One labeled, fixed-viewport comparison row. Spacing classes override the paired defaults."
  [{:keys [label description basis content-class item-class]}]
  [:section {:class "space-y-2"}
   [:h3 {:class "text-sm font-semibold"}
    label]
   [:p {:class "text-sm text-muted-foreground"}
    description]
   [:div {:class "px-12 py-3"}
    [carousel/carousel {:opts {:align "start"}
                        :class "w-full"}
     (into
      [carousel/carousel-content {:class content-class}]
      (for [idx (range 1 10)]
        [carousel/carousel-item {:key idx
                                 :class item-class
                                 :style {:flex-basis basis}
                                 :aria-label (str "Slide " idx " of 9")}
         [:div
          {:class
           "flex h-28 items-center justify-center rounded-lg border bg-card text-2xl font-semibold"}
          idx]]))
     [carousel/carousel-previous {}]
     [carousel/carousel-next {}]]]])

(defn example
  []
  [:div {:class "w-full max-w-2xl space-y-6"}
   [:p {:class "text-sm text-muted-foreground"}
    "Slide size is a percentage of the carousel viewport, not a small/medium/large component variant. Each row keeps the same viewport and 16px spacing."]
   (for [[basis label] [["100%" "100% - one slide"]
                        ["50%" "50% - two slides"]
                        ["33.333333%" "33⅓% - three slides"]]]
     ^{:key basis}
     [comparison {:label label
                  :description (str "Slide flex-basis: " basis)
                  :basis basis}])])
