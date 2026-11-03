(ns manufaktura.stories.hover-card-stories
  (:require
   [manufaktura.stories.helpers                           :as helpers]
   [manufaktura.stories.hover-card.hover-card-basic       :as hover-card-basic]
   [manufaktura.stories.hover-card.hover-card-delays      :as hover-card-delays]
   [manufaktura.stories.hover-card.hover-card-positioning :as hover-card-positioning]
   [manufaktura.stories.hover-card.hover-card-rtl         :as hover-card-rtl]
   [reagent.core                                          :as r])
  (:require-macros [manufaktura.stories.macros :refer [embed-source defstory defdoc]]))

(def ^:export default
  #js {:title "Components/Hover Card"
       :parameters #js {:layout "padded"}})

(defdoc Installation
        []
        (r/as-element [helpers/installation-scene
                       {:description "Preview content revealed on hover or keyboard focus."
                        :npm-install "npm install @radix-ui/react-hover-card"
                        :source-code (embed-source "manufaktura.ui.components.hover-card")
                        :namespace-path "src/cljs/manufaktura/ui/components/hover_card.cljs"
                        :filename "hover_card.cljs"}]))

(defstory
 ApiReference
 []
 (r/as-element
  (helpers/wrap-component
   [helpers/api-component-card
    {:component-name "hover-card / hover-card-trigger / hover-card-content"
     :link {:href "https://www.radix-ui.com/primitives/docs/components/hover-card"
            :label "Radix Hover Card Docs"}
     :description
     "Accessible Radix wrappers with collision-aware portalled content. Normalized additional props are forwarded to each primitive."
     :props [{:name ":open / :default-open / :on-open-change"
              :type "boolean | function"
              :default nil
              :description "Controlled or uncontrolled visibility."}
             {:name ":open-delay / :close-delay"
              :type "number"
              :default nil
              :description "Pointer timing in milliseconds."}
             {:name ":side / :align / :side-offset"
              :type "keyword|string|number"
              :default nil
              :description "Content positioning."}]}])))

(defstory HoverCardBasic
          {:source-code (embed-source "manufaktura.stories.hover-card.hover-card-basic")}
          []
          (r/as-element (helpers/wrap-component [hover-card-basic/example])))

(defstory HoverCardDelays
          "Both opening and closing delays tuned for a fast preview interaction."
          {:source-code (embed-source "manufaktura.stories.hover-card.hover-card-delays")}
          []
          (r/as-element (helpers/wrap-component [hover-card-delays/example])))

(defstory HoverCardPositioning
          "All preferred sides combined with start, center, and end alignment."
          {:source-code (embed-source "manufaktura.stories.hover-card.hover-card-positioning")}
          []
          (r/as-element (helpers/wrap-component [hover-card-positioning/example])))

(defstory HoverCardRtl
          "Right-to-left trigger and preview content."
          {:source-code (embed-source "manufaktura.stories.hover-card.hover-card-rtl")}
          []
          (r/as-element (helpers/wrap-component [hover-card-rtl/example])))
