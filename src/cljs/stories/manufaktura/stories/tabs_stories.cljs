(ns manufaktura.stories.tabs-stories
  (:require
   [manufaktura.stories.helpers              :as helpers]
   [manufaktura.stories.tabs.playground      :as example-playground]
   [manufaktura.stories.tabs.tabs-basic      :as example-tabs-basic]
   [manufaktura.stories.tabs.tabs-disabled   :as example-tabs-disabled]
   [manufaktura.stories.tabs.tabs-rtl        :as example-tabs-rtl]
   [manufaktura.stories.tabs.tabs-with-icons :as example-tabs-with-icons]
   [reagent.core                             :as r])
  (:require-macros [manufaktura.stories.macros :refer [embed-source defstory defdoc]]))

(def ^:export default
  #js {:title "Components/Tabs"
       :parameters #js {:layout "padded"}})

(defdoc Installation
        []
        (r/as-element [helpers/installation-scene
                       {:description "Keyboard-accessible tabbed content."
                        :npm-install "npm install @radix-ui/react-tabs"
                        :source-code (embed-source "manufaktura.ui.components.tabs")
                        :namespace-path "src/cljs/manufaktura/ui/components/tabs.cljs"
                        :filename "tabs.cljs"}]))

(defstory ApiReference
          []
          (r/as-element
           (helpers/wrap-component
            [helpers/api-component-card
             {:component-name "tabs / tabs-list / tabs-trigger / tabs-content"
              :link {:href "https://www.radix-ui.com/primitives/docs/components/tabs"
                     :label "Radix Tabs Docs"}
              :description
              "Radix Tabs wrappers preserving roving focus, activation and ARIA relationships."
              :props [{:name ":value / :default-value"
                       :type "string"
                       :default nil
                       :description "Controlled or initial tab."}
                      {:name ":on-value-change"
                       :type "function"
                       :default nil
                       :description "Selection callback."}
                      {:name ":orientation / :activation-mode"
                       :type "keyword|string"
                       :default nil
                       :description "Keyboard behavior."}]}])))

(defstory TabsBasic
          {:source-code (embed-source "manufaktura.stories.tabs.tabs-basic")}
          []
          (r/as-element (helpers/wrap-component [example-tabs-basic/example])))

(defstory TabsDisabled
          {:source-code (embed-source "manufaktura.stories.tabs.tabs-disabled")}
          []
          (r/as-element (helpers/wrap-component [example-tabs-disabled/example])))


(defstory
 TabsWithIcons
 "Radix Tabs triggers with decorative Lucide icons and visible labels.

  Radix primitive: @radix-ui/react-tabs

  Pair icons with text so each tab retains a clear accessible name."
 {:source-code (embed-source "manufaktura.stories.tabs.tabs-with-icons")}
 []
 (r/as-element (helpers/wrap-component [example-tabs-with-icons/example])))

(defstory
 TabsRtl
 "Right-to-left Radix Tabs without custom orientation styling.

  Radix primitive: @radix-ui/react-tabs

  Set :dir on Root so horizontal arrow-key behavior follows reading direction."
 {:source-code (embed-source "manufaktura.stories.tabs.tabs-rtl")}
 []
 (r/as-element (helpers/wrap-component [example-tabs-rtl/example])))

(defstory
 Playground
 "Controlled Storybook playground using only safe scalar component props."
 {:args {:default-value "account"
         :orientation "horizontal"
         :list-variant "default"}
  :arg-types {:default-value {:name "Initial tab (resets selection)"
                              :control {:type "select"}
                              :options ["account" "password"]}
              :orientation {:control {:type "select"}
                            :options ["horizontal" "vertical"]}
              :list-variant {:control {:type "select"}
                             :options ["default" "line"]}}
  :parameters
  {:playground
   {:description
    "Initial tab resets selection. Orientation and list variant update live, preserving the selected tab."}
   :controls {:expanded false
              :exclude ["children" "value" "on-value-change"]}}
  :source-code (embed-source "manufaktura.stories.tabs.playground")}
 [args]
 (r/as-element (helpers/wrap-component [example-playground/example args])))
