(ns manufaktura.stories.skeleton-stories
  "Storybook stories for the Skeleton component. Ported from mateuszmazurczak.portfolio.ui-components.skeleton."
  (:require
   [manufaktura.stories.helpers                        :as helpers]
   [manufaktura.stories.skeleton.skeleton-card         :as example-skeleton-card]
   [manufaktura.stories.skeleton.skeleton-form         :as example-skeleton-form]
   [manufaktura.stories.skeleton.skeleton-grid         :as example-skeleton-grid]
   [manufaktura.stories.skeleton.skeleton-identity-row :as example-skeleton-identity-row]
   [manufaktura.stories.skeleton.skeleton-real-card    :as example-skeleton-real-card]
   [manufaktura.stories.skeleton.skeleton-rtl          :as example-skeleton-rtl]
   [manufaktura.stories.skeleton.skeleton-table        :as example-skeleton-table]
   [reagent.core                                       :as r])
  (:require-macros [manufaktura.stories.macros :refer [embed-source defstory defdoc]]))

(def ^:export default
  #js {:title "Components/Skeleton"
       :parameters #js {:layout "padded"}})

(defdoc Installation
        "Copy the component code into your project."
        []
        (r/as-element [helpers/installation-scene
                       {:description "Skeleton component for loading placeholders."
                        :source-code (embed-source "manufaktura.ui.components.skeleton")
                        :namespace-path "src/cljs/manufaktura/ui/components/skeleton.cljs"
                        :filename "skeleton.cljs"}]))

(defstory
 ApiReference
 []
 (r/as-element
  (helpers/wrap-component
   [:div {:class "p-6 max-w-4xl"}
    [:div {:class "space-y-4"}
     [helpers/api-component-card
      {:component-name "skeleton"
       :description
       "Animated loading placeholder block. Additional props are forwarded to underlying <div>."
       :props [{:name ":class"
                :type "string"
                :default nil
                :description "Additional Tailwind classes."}
               {:name ":role"
                :type "string"
                :default nil
                :description "Accessibility role, e.g. \"status\"."}
               {:name ":aria-label"
                :type "string"
                :default nil
                :description "Screen reader label for loading context."}
               {:name ":aria-live"
                :type "string"
                :default nil
                :description "Announce updates politely/assertively."}
               {:name "additional props"
                :type "map entries"
                :default nil
                :description "Forwarded to native <div>."}]}]
     [:div {:class "border rounded-lg p-4 bg-amber-500/10 border-amber-500/30 mb-4"}
      [:h4 {:class "text-sm font-semibold mb-2"}
       "⚠️ Important Notes"]
      [:ul {:class "text-xs text-muted-foreground space-y-1 list-disc pl-4"}
       [:li
        "Skeleton is purely visual by default; add ARIA attributes when used as a status indicator."]
       [:li "Use realistic width/height classes to reduce layout shift during content hydration."]]]
     [:div {:class "border rounded-lg p-4 bg-muted/50"}
      [:h4 {:class "text-sm font-semibold mb-2"}
       "Usage Example"]
      [:pre {:class "text-xs overflow-x-auto"}
       [:code
        "[:div {:class \"space-y-2 w-64\"}\n [skeleton {:class \"h-4 w-40\"}]\n [skeleton {:class \"h-4 w-full\"}]\n [skeleton {:class \"h-4 w-5/6\" :role \"status\" :aria-label \"Loading profile\"}]]"]]]]])))

(defstory
 SkeletonCard
 "Card-like skeleton placeholder.

  Native element: <div>

  Use for cards, previews, or media blocks."
 {:source-code (embed-source "manufaktura.stories.skeleton.skeleton-card")}
 []
 (r/as-element (helpers/wrap-component [example-skeleton-card/example])))

(defstory
 SkeletonGrid
 "Multi-column skeleton grid.

  Native element: <div>

  Useful for list or gallery loading states."
 {:source-code (embed-source "manufaktura.stories.skeleton.skeleton-grid")}
 []
 (r/as-element (helpers/wrap-component [example-skeleton-grid/example])))

(defstory SkeletonIdentityRow
          "Identity row - upstream avatar-and-copy placeholder sized to the eventual content."
          {:source-code (embed-source "manufaktura.stories.skeleton.skeleton-identity-row")}
          []
          (r/as-element (helpers/wrap-component [example-skeleton-identity-row/example])))

(defstory
 SkeletonRealCard
 "Card - real Card composition preserves the final component's regions while content loads."
 {:source-code (embed-source "manufaktura.stories.skeleton.skeleton-real-card")}
 []
 (r/as-element (helpers/wrap-component [example-skeleton-real-card/example])))

(defstory SkeletonForm
          "Form - realistic labels and controls minimize layout shift during form loading."
          {:source-code (embed-source "manufaktura.stories.skeleton.skeleton-form")}
          []
          (r/as-element (helpers/wrap-component [example-skeleton-form/example])))

(defstory SkeletonTable
          "Table - upstream row-and-column placeholder mirrors a compact data table."
          {:source-code (embed-source "manufaktura.stories.skeleton.skeleton-table")}
          []
          (r/as-element (helpers/wrap-component [example-skeleton-table/example])))

(defstory SkeletonRTL
          "RTL - identity and text placeholders align with right-to-left content."
          {:source-code (embed-source "manufaktura.stories.skeleton.skeleton-rtl")}
          []
          (r/as-element (helpers/wrap-component [example-skeleton-rtl/example])))
