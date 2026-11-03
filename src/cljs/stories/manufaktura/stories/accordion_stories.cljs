(ns manufaktura.stories.accordion-stories
  (:require
   [manufaktura.stories.accordion.accordion-appearances         :as accordion-appearances]
   [manufaktura.stories.accordion.accordion-basic               :as accordion-basic]
   [manufaktura.stories.accordion.accordion-card                :as accordion-card]
   [manufaktura.stories.accordion.accordion-disabled            :as accordion-disabled]
   [manufaktura.stories.accordion.accordion-disabled-comparison :as accordion-disabled-comparison]
   [manufaktura.stories.accordion.accordion-enclosing-border    :as accordion-enclosing-border]
   [manufaktura.stories.accordion.accordion-multiple            :as accordion-multiple]
   [manufaktura.stories.accordion.accordion-non-collapsible     :as accordion-non-collapsible]
   [manufaktura.stories.accordion.accordion-rtl                 :as accordion-rtl]
   [manufaktura.stories.accordion.playground                    :as playground]
   [manufaktura.stories.helpers                                 :as helpers]
   [reagent.core                                                :as r])
  (:require-macros [manufaktura.stories.macros :refer [embed-source defstory defdoc]]))

(def ^:export default
  #js {:title "Components/Accordion"
       :parameters #js {:layout "padded"}})

(defdoc Installation
        []
        (r/as-element [helpers/installation-scene
                       {:description "Accessible vertically stacked disclosure sections."
                        :npm-install "npm install @radix-ui/react-accordion lucide-react"
                        :source-code (embed-source "manufaktura.ui.components.accordion")
                        :namespace-path "src/cljs/manufaktura/ui/components/accordion.cljs"
                        :filename "accordion.cljs"}]))

(defstory
 ApiReference
 []
 (r/as-element
  (helpers/wrap-component
   [helpers/api-component-card
    {:component-name "accordion / accordion-item / accordion-trigger / accordion-content"
     :link {:href "https://www.radix-ui.com/primitives/docs/components/accordion"
            :label "Radix Accordion Docs"}
     :description
     "Data-oriented wrappers over Radix Accordion. Root accepts :type, :value, :default-value, :on-value-change, :collapsible and :orientation; all props are normalized and forwarded."
     :props [{:name ":type"
              :type ":single | :multiple"
              :default nil
              :description "Selection mode."}
             {:name ":value / :default-value"
              :type "string | vector"
              :default nil
              :description "Controlled or initial item values."}
             {:name ":collapsible"
              :type "boolean"
              :default false
              :description
              "For :type single, allow the open item to close so that no items remain open."}
             {:name ":disabled"
              :type "boolean"
              :default nil
              :description "Disable an item."}]}])))

(defstory
 AccordionBasic
 "The canonical shadcn product-information example: a full-width, collapsible accordion with the first item initially open."
 {:source-code (embed-source "manufaktura.stories.accordion.accordion-basic")}
 []
 (r/as-element (helpers/wrap-component [accordion-basic/example])))

(defstory
 AccordionNonCollapsible
 "A single accordion where one item must remain open. Clicking another item moves the open state, but clicking the open item does not close it."
 {:source-code (embed-source "manufaktura.stories.accordion.accordion-non-collapsible")}
 []
 (r/as-element (helpers/wrap-component [accordion-non-collapsible/example])))

(defstory
 AccordionMultiple
 "Allow several sections to remain open by using :type multiple and a vector of initial values."
 {:source-code (embed-source "manufaktura.stories.accordion.accordion-multiple")}
 []
 (r/as-element (helpers/wrap-component [accordion-multiple/example])))

(defstory
 AccordionAppearances
 "Four class-based treatments adapted from shadcn v4 presets. They demonstrate composition without adding a variant prop to the component."
 {:source-code (embed-source "manufaktura.stories.accordion.accordion-appearances")}
 []
 (r/as-element (helpers/wrap-component [accordion-appearances/example])))

(defstory AccordionDisabled
          {:source-code (embed-source "manufaktura.stories.accordion.accordion-disabled")}
          []
          (r/as-element (helpers/wrap-component [accordion-disabled/example])))

(defstory
 Playground
 "Compare single and multiple selection. Changing mode resets open sections; collapsible only affects single mode."
 {:source-code (embed-source "manufaktura.stories.accordion.playground")
  :args {:mode "single"
         :collapsible true}
  :arg-types {:mode {:name "Mode"
                     :control {:type "select"}
                     :options ["single" "multiple"]}
              :collapsible {:name "Collapsible"
                            :control {:type "boolean"}
                            :description
                            "Allow the open item to be closed, leaving every item closed."}}
  :parameters {:playground {:description "Explore accordion collapsible with a live preview."}
               :controls {:expanded false
                          :exclude ["children" "on-value-change" "value" "default-value"]}}}
 [args]
 (r/as-element (helpers/wrap-component [playground/example args])))

(defstory
 AccordionCard
 "Accordion Card - the upstream card composition places disclosure rows inside one rounded surface."
 {:source-code (embed-source "manufaktura.stories.accordion.accordion-card")}
 []
 (r/as-element (helpers/wrap-component [accordion-card/example])))

(defstory
 AccordionEnclosingBorder
 "Enclosing border - the upstream bordered example keeps a single outline around flush rows."
 {:source-code (embed-source "manufaktura.stories.accordion.accordion-enclosing-border")}
 []
 (r/as-element (helpers/wrap-component [accordion-enclosing-border/example])))

(defstory AccordionDisabledComparison
          "Disabled - comparative enabled and disabled items make the unavailable state explicit."
          {:source-code (embed-source
                         "manufaktura.stories.accordion.accordion-disabled-comparison")}
          []
          (r/as-element (helpers/wrap-component [accordion-disabled-comparison/example])))

(defstory AccordionRTL
          "RTL - direction-aware disclosure layout with Arabic content."
          {:source-code (embed-source "manufaktura.stories.accordion.accordion-rtl")}
          []
          (r/as-element (helpers/wrap-component [accordion-rtl/example])))
