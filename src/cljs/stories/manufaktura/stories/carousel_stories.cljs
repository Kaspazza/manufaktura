(ns manufaktura.stories.carousel-stories
  (:require
   [manufaktura.stories.carousel.carousel-demo             :as carousel-demo]
   [manufaktura.stories.carousel.carousel-drag-free        :as carousel-drag-free]
   [manufaktura.stories.carousel.carousel-events           :as carousel-events]
   [manufaktura.stories.carousel.carousel-loop             :as carousel-loop]
   [manufaktura.stories.carousel.carousel-orientation      :as carousel-orientation]
   [manufaktura.stories.carousel.carousel-position         :as carousel-position]
   [manufaktura.stories.carousel.carousel-rtl              :as carousel-rtl]
   [manufaktura.stories.carousel.carousel-size             :as carousel-size]
   [manufaktura.stories.carousel.carousel-slides-to-scroll :as carousel-slides-to-scroll]
   [manufaktura.stories.carousel.carousel-spacing          :as carousel-spacing]
   [manufaktura.stories.carousel.playground                :as playground]
   [manufaktura.stories.helpers                            :as helpers]
   [reagent.core                                           :as r])
  (:require-macros [manufaktura.stories.macros :refer [embed-source defstory defdoc]]))

(def ^:export default
  #js {:title "Components/Carousel"
       :parameters #js {:layout "padded"}})

(defdoc Installation
        "Install dependencies and copy the component code into your project."
        []
        (r/as-element [helpers/installation-scene
                       {:description "Carousel component built on top of Embla Carousel."
                        :npm-install "npm install embla-carousel-react lucide-react"
                        :source-code (embed-source "manufaktura.ui.components.carousel")
                        :namespace-path "src/cljs/manufaktura/ui/components/carousel.cljs"
                        :filename "carousel.cljs"}]))

(defstory
 ApiReference
 []
 (r/as-element
  (helpers/wrap-component
   [:div {:class "p-6 max-w-4xl"}
    [:div {:class "space-y-4"}
     [helpers/api-component-card
      {:component-name "carousel"
       :link {:href "https://www.embla-carousel.com/api/options/"
              :label "Embla Carousel Docs"}
       :description
       "Carousel root component - creates container with embla-carousel. Sets role=\"region\" and aria-roledescription=\"carousel\" for accessibility."
       :props
       [{:name ":opts"
         :type "map"
         :default nil
         :description
         "Embla carousel options passed directly to embla-carousel. Keys must use camelCase to match Embla's JS API (e.g. :loop, :align, :dragFree, :slidesToScroll). Note: do NOT set :axis here - use :orientation instead, which takes precedence."}
        {:name ":plugins"
         :type "array"
         :default nil
         :description "Embla carousel plugins (see https://www.embla-carousel.com/api/plugins/)"}
        {:name ":orientation"
         :type "keyword"
         :default ":horizontal"
         :description
         ":horizontal | :vertical. Controls the scroll axis. Overrides any :axis value in :opts."}
        {:name ":set-api"
         :type "function"
         :default nil
         :description
         "Callback to receive the raw Embla carousel API instance: (fn [api] ...). Use this to attach event listeners or call methods like .scrollTo, .canScrollNext, etc."}
        {:name ":class"
         :type "string"
         :default nil
         :description "Additional Tailwind classes"}]}]
     [helpers/api-component-card
      {:component-name "carousel-content"
       :description
       "Carousel content wrapper - contains the carousel items. Applies default spacing via negative margin (-ml-4 horizontal, -mt-4 vertical). Override with custom -ml-* / -mt-* classes and matching pl-* / pt-* on carousel-item."
       :props
       [{:name ":class"
         :type "string"
         :default nil
         :description
         "Additional Tailwind classes. All additional props are forwarded to the underlying DOM element."}]}]
     [helpers/api-component-card
      {:component-name "carousel-item"
       :description
       "Carousel item - individual slide in the carousel. Sets role=\"group\" and aria-roledescription=\"slide\" for accessibility. Applies default spacing (pl-4 horizontal, pt-4 vertical) that pairs with carousel-content's negative margin."
       :props
       [{:name ":class"
         :type "string"
         :default nil
         :description
         "Additional Tailwind classes. Use basis-* for sizing (e.g. basis-1/3 for 3 visible slides). All additional props are forwarded to the underlying DOM element."}]}]
     [helpers/api-component-card
      {:component-name "carousel-previous"
       :description
       "Carousel previous button - navigates to previous slide. Automatically disabled when at the start (unless loop is enabled). See Button component for variant visual details."
       :props
       [{:name ":variant"
         :type "keyword"
         :default ":outline"
         :description
         "One of: :default | :destructive | :outline | :secondary | :ghost | :link. See Button component for visual details."}
        {:name ":size"
         :type "keyword"
         :default ":icon"
         :description "One of: :default | :sm | :lg | :icon"}
        {:name ":class"
         :type "string"
         :default nil
         :description
         "Additional Tailwind classes. All additional props are forwarded to the Button component."}]}]
     [helpers/api-component-card
      {:component-name "carousel-next"
       :description
       "Carousel next button - navigates to next slide. Automatically disabled when at the end (unless loop is enabled). See Button component for variant visual details."
       :props
       [{:name ":variant"
         :type "keyword"
         :default ":outline"
         :description
         "One of: :default | :destructive | :outline | :secondary | :ghost | :link. See Button component for visual details."}
        {:name ":size"
         :type "keyword"
         :default ":icon"
         :description "One of: :default | :sm | :lg | :icon"}
        {:name ":class"
         :type "string"
         :default nil
         :description
         "Additional Tailwind classes. All additional props are forwarded to the Button component."}]}]
     [:div {:class "border rounded-lg p-4 bg-amber-500/10 border-amber-500/30 mb-4"}
      [:h4 {:class "text-sm font-semibold mb-2"}
       "⚠️ Important Notes"]
      [:ul {:class "text-xs text-muted-foreground space-y-1 list-disc pl-4"}
       [:li "The props map {} is required on all components, even when empty."]
       [:li
        "Embla option keys must use camelCase (e.g. :dragFree, :slidesToScroll), not kebab-case."]
       [:li
        "Default item spacing is 1rem (pl-4/pt-4). Override both carousel-content (-ml-*/-mt-*) and carousel-item (pl-*/pt-*) together."]
       [:li "The :orientation prop overrides any :axis value passed in :opts."]
       [:li
        "The wrapper accepts Embla plugin instances through :plugins, but no plugin package (such as embla-carousel-autoplay) is installed in this project; a plugin story would not compile until that dependency is added."]
       [:li
        "Arrow key events are captured - may interfere with other key handlers in parent components."]]]
     [:div {:class "border rounded-lg p-4 bg-muted/50"}
      [:h4 {:class "text-sm font-semibold mb-2"}
       "Usage Example"]
      [:pre {:class "text-xs overflow-x-auto"}
       [:code
        "[carousel {:opts {:loop true :align \"start\"}\n            :set-api (fn [api] (println \"Carousel ready!\"))}\n  [carousel-content {}\n    [carousel-item {} \"Slide 1\"]\n    [carousel-item {} \"Slide 2\"]]\n  [carousel-previous {}]\n  [carousel-next {}]]"]]]]])))

(defstory
 CarouselDemo
 "Basic carousel with previous/next controls.

  Library: embla-carousel

  Use for showcasing images or featured content."
 {:source-code (embed-source "manufaktura.stories.carousel.carousel-demo")}
 []
 (r/as-element (helpers/wrap-component [carousel-demo/example])))

(defstory
 CarouselSize
 "Carousel with smaller item sizes showing multiple slides.

  Library: embla-carousel

  Compare 100%, 50%, and one-third slide widths in identical viewports."
 {:source-code (embed-source "manufaktura.stories.carousel.carousel-size")}
 []
 (r/as-element (helpers/wrap-component [carousel-size/example])))

(defstory CarouselPosition
          "Consumer-managed current slide and total using the API supplied by :set-api."
          {:source-code (embed-source "manufaktura.stories.carousel.carousel-position")}
          []
          (r/as-element (helpers/wrap-component [carousel-position/example])))

(defstory
 CarouselOrientation
 "Vertical carousel orientation.

  Library: embla-carousel

  Use :orientation :vertical for stacked slides. Container height determines visible area."
 {:source-code (embed-source "manufaktura.stories.carousel.carousel-orientation")}
 []
 (r/as-element (helpers/wrap-component [carousel-orientation/example])))

(defstory
 CarouselSpacing
 "Carousel with custom spacing between items.

  Library: embla-carousel

  Compare 0px, 16px, and 32px gaps with identical one-third-width slides."
 {:source-code (embed-source "manufaktura.stories.carousel.carousel-spacing")}
 []
 (r/as-element (helpers/wrap-component [carousel-spacing/example])))

(defstory
 CarouselLoop
 "Carousel with infinite looping enabled.

  Library: embla-carousel - https://www.embla-carousel.com/api/options

  Use :loop true to wrap manual navigation at the ends. Loop is not autoplay."
 {:source-code (embed-source "manufaktura.stories.carousel.carousel-loop")}
 []
 (r/as-element (helpers/wrap-component [carousel-loop/example])))

(defstory
 CarouselDragFree
 "Carousel with momentum-based dragging.

  Library: embla-carousel - https://www.embla-carousel.com/api/options

  Drag to coast freely; arrow buttons still navigate snap groups. Loop is also enabled here."
 {:source-code (embed-source "manufaktura.stories.carousel.carousel-drag-free")}
 []
 (r/as-element (helpers/wrap-component [carousel-drag-free/example])))

(defstory
 CarouselSlidesToScroll
 "Carousel scrolling multiple slides at once.

  Library: embla-carousel - https://www.embla-carousel.com/api/options

  Use :slidesToScroll in opts to advance multiple slides per navigation action."
 {:source-code (embed-source "manufaktura.stories.carousel.carousel-slides-to-scroll")}
 []
 (r/as-element (helpers/wrap-component [carousel-slides-to-scroll/example])))

(defstory
 CarouselRtl
 "RTL carousel with Embla direction configured as well as DOM direction, so dragging and previous/next behavior follow reading order."
 {:source-code (embed-source "manufaktura.stories.carousel.carousel-rtl")}
 []
 (r/as-element (helpers/wrap-component [carousel-rtl/example])))

(defstory
 CarouselEvents
 "Carousel with event listeners for selection, settling, and drag start.

  Library: embla-carousel - https://www.embla-carousel.com/api/events

  Registers select, settle, and pointerDown via :set-api and removes listeners on cleanup."
 {:source-code (embed-source "manufaktura.stories.carousel.carousel-events")}
 []
 (r/as-element (helpers/wrap-component [carousel-events/example])))

(defstory
 Playground
 "Controlled Storybook playground using only safe scalar component props."
 {:source-code (embed-source "manufaktura.stories.carousel.playground")
  :args {:orientation "horizontal"
         :slide-size "50%"
         :spacing "16px"
         :loop false
         :align "start"
         :drag-free false
         :slides-to-scroll "1"}
  :arg-types {:orientation {:name "Orientation"
                            :control {:type "select"}
                            :options ["horizontal" "vertical"]}
              :slide-size {:name "Slide size (viewport %)"
                           :control {:type "select"}
                           :options ["100%" "50%" "33.333333%"]}
              :spacing {:name "Slide spacing"
                        :control {:type "select"}
                        :options ["0px" "8px" "16px" "32px"]}
              :loop {:name "Loop (not autoplay)"
                     :control {:type "boolean"}}
              :align {:name "Alignment"
                      :control {:type "select"}
                      :options ["start" "center" "end"]}
              :drag-free {:name "Drag momentum"
                          :control {:type "boolean"}}
              :slides-to-scroll {:name "Slides per navigation step"
                                 :control {:type "select"}
                                 :options ["1" "2" "3" "auto"]}}
  :parameters
  {:playground
   {:description
    "Explore slide sizing, spacing, orientation, looping, alignment, momentum, and navigation grouping."}
   :controls {:expanded false
              :exclude ["children" "opts" "plugins" "set-api"]}}
  :decode-args (fn [{:keys [orientation]
                     :as args}]
                 (cond-> args
                   orientation (update :orientation keyword)))}
 [args]
 (r/as-element (helpers/wrap-component [playground/example args])))
