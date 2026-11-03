(ns manufaktura.stories.marker-stories
  (:require
   [manufaktura.stories.helpers                                  :as helpers]
   [manufaktura.stories.marker.marker-aggregate                  :as marker-aggregate]
   [manufaktura.stories.marker.marker-as-child-links-and-buttons :as
                                                                 marker-as-child-links-and-buttons]
   [manufaktura.stories.marker.marker-shimmer-and-spinner-status :as
                                                                 marker-shimmer-and-spinner-status]
   [manufaktura.stories.marker.marker-timeline                   :as marker-timeline]
   [manufaktura.stories.marker.marker-variants                   :as marker-variants]
   [reagent.core                                                 :as r])
  (:require-macros [manufaktura.stories.macros :refer [embed-source defstory defdoc]]))

(def ^:export default
  #js {:title "Components/Marker"
       :parameters #js {:layout "padded"}})

(defdoc Installation
        []
        (r/as-element [helpers/installation-scene
                       {:description "Current shadcn/ui marker primitive."
                        :npm-install "npm install @radix-ui/react-slot"
                        :source-code (embed-source "manufaktura.ui.components.marker")
                        :namespace-path "src/cljs/manufaktura/ui/components/marker.cljs"
                        :filename "marker.cljs"}]))

(defstory ApiReference
          []
          (r/as-element
           (helpers/wrap-component
            [:div {:class "p-6 max-w-4xl"}
             [helpers/api-component-card
              {:component-name "marker / marker-icon / marker-content / marker-variants"
               :description
               "Status or timeline marker with optional separator/border and public class helper."
               :props [{:name ":variant"
                        :type ":default | :separator | :border"
                        :default ":default"}
                       {:name ":as-child?"
                        :type "boolean"
                        :default "false"}
                       {:name ":class"
                        :type "string"
                        :default nil}]}]])))

(defstory MarkerVariants
          "Interactive marker playground."
          {:source-code (embed-source "manufaktura.stories.marker.marker-variants")
           :args {:variant "default"
                  :content "Deployment completed"}
           :arg-types {:variant {:name "Variant"
                                 :control {:type "select"}
                                 :options ["default" "separator" "border"]}
                       :content {:name "Content"
                                 :control {:type "text"}}}
           :parameters {:playground {:description
                                     "Explore marker variant and content with a live preview."}
                        :controls {:expanded false
                                   :exclude ["class" "as-child?"]}}
           :decode-args (fn [{:keys [variant]
                              :as args}]
                          (cond-> args
                            variant (update :variant keyword)))}
          [args]
          (r/as-element (helpers/wrap-component [marker-variants/example args])))

(defstory MarkerAggregate
          "All marker primitives and variants in one comparison."
          {:source-code (embed-source "manufaktura.stories.marker.marker-aggregate")}
          []
          (r/as-element (helpers/wrap-component [marker-aggregate/example])))

(defstory MarkerTimeline
          "Timeline composition using border markers and semantic status text."
          {:source-code (embed-source "manufaktura.stories.marker.marker-timeline")}
          []
          (r/as-element (helpers/wrap-component [marker-timeline/example])))

(defstory
 MarkerAsChildLinksAndButtons
 "Slot-based polymorphism: the marker classes and data attributes are applied to one link or button child."
 {:source-code (embed-source "manufaktura.stories.marker.marker-as-child-links-and-buttons")}
 []
 (r/as-element (helpers/wrap-component [marker-as-child-links-and-buttons/example])))

(defstory MarkerShimmerAndSpinnerStatus
          "Markers can compose loading visuals while the content supplies readable status text."
          {:source-code (embed-source
                         "manufaktura.stories.marker.marker-shimmer-and-spinner-status")}
          []
          (r/as-element (helpers/wrap-component [marker-shimmer-and-spinner-status/example])))
