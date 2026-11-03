(ns manufaktura.stories.carousel.playground
  (:require
   [manufaktura.ui.components.carousel :as carousel]))

(defn example
  ([] (example {}))
  ([{:keys [orientation slide-size spacing loop align drag-free slides-to-scroll]
     :or {orientation :horizontal
          slide-size "50%"
          spacing "16px"
          loop false
          align "start"
          drag-free false
          slides-to-scroll "1"}}]
   (let [vertical? (= orientation :vertical)
         gap (get {"0px" 0
                   "8px" 8
                   "16px" 16
                   "32px" 32}
                  spacing
                  16)
         grouping (if (= slides-to-scroll "auto") "auto" (js/parseInt slides-to-scroll 10))]
     [:div {:class "w-full max-w-2xl space-y-3"}
      [:p {:class "text-sm text-muted-foreground"}
       "Drag or use the arrows. Loop wraps at the ends; it does not autoplay. Sizes are relative to the carousel viewport."]
      [:div {:class "px-12 py-14"}
       [carousel/carousel {:orientation orientation
                           :opts {:loop loop
                                  :align align
                                  :dragFree drag-free
                                  :slidesToScroll grouping}
                           :class "w-full"}
        (into
         [carousel/carousel-content {:class (when vertical? "h-80")
                                     :style
                                     (if vertical? {:margin-top (- gap)} {:margin-left (- gap)})}]
         (for [n (range 1 10)]
           [carousel/carousel-item {:key n
                                    :aria-label (str "Slide " n " of 9")
                                    :style (merge
                                            {:flex-basis slide-size}
                                            (if vertical? {:padding-top gap} {:padding-left gap}))}
            [:div
             {:class
              (str
               "flex items-center justify-center rounded-lg border bg-card text-2xl font-semibold "
               (if vertical? "h-full min-h-0" "h-40"))}
             (str n " / 9")]]))
        [carousel/carousel-previous {}]
        [carousel/carousel-next {}]]]
      [:p {:class "text-xs text-muted-foreground"}
       "Alignment is clearest on interior slides: Embla's default trimSnaps containment takes precedence at the edges. Auto grouping fits slides to the viewport; drag-free changes drag momentum, not arrow navigation."]])))
