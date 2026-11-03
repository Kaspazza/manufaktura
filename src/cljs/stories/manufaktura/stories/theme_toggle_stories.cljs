(ns manufaktura.stories.theme-toggle-stories
  "Storybook stories for the Theme Toggle component."
  (:require
   [manufaktura.stories.helpers                                :as helpers]
   [manufaktura.stories.theme-toggle.theme-toggle-basic        :as example-theme-toggle-basic]
   [manufaktura.stories.theme-toggle.theme-toggle-dark         :as example-theme-toggle-dark]
   [manufaktura.stories.theme-toggle.theme-toggle-in-header    :as example-theme-toggle-in-header]
   [manufaktura.stories.theme-toggle.theme-toggle-light        :as example-theme-toggle-light]
   [manufaktura.stories.theme-toggle.theme-toggle-settings-row :as
                                                               example-theme-toggle-settings-row]
   [reagent.core                                               :as r])
  (:require-macros [manufaktura.stories.macros :refer [embed-source defstory defdoc]]))

(def ^:export default
  #js {:title "Components/ThemeToggle"
       :parameters #js {:layout "padded"}})

(defdoc Installation
        "Install dependencies and copy the component code into your project."
        []
        (r/as-element
         [helpers/installation-scene
          {:description
           "Controlled theme toggle button for switching between light and dark themes."
           :npm-install "npm install lucide-react"
           :source-code (embed-source "manufaktura.ui.components.theme-toggle")
           :namespace-path "src/cljs/manufaktura/ui/components/theme_toggle.cljs"
           :filename "theme_toggle.cljs"}]))

(defstory
 ApiReference
 []
 (r/as-element
  (helpers/wrap-component
   [:div {:class "p-6 max-w-4xl"}
    [:div {:class "space-y-4"}
     [helpers/api-component-card
      {:component-name "theme-toggle"
       :description
       "Controlled theme switch button. Pure presentation: reads nothing from global state; the caller passes :theme and :on-toggle."
       :props
       [{:name ":theme"
         :type "keyword"
         :default ":light"
         :description ":light | :dark - decides which icon (Sun/Moon) is shown."}
        {:name ":on-toggle"
         :type "fn"
         :default nil
         :description "(fn []) click handler; flip theme in whatever state layer you use."}
        {:name ":label"
         :type "string"
         :default "\"Toggle theme\""
         :description "Accessible button name, used when :aria-label is not supplied."}
        {:name ":class"
         :type "string"
         :default nil
         :description "Extra Tailwind classes merged with the base ones via tailwind-merge."}
        {:name "additional props"
         :type "button attributes"
         :default nil
         :description
         "Forwarded to the underlying button; :aria-label overrides :label and an explicit :type overrides the default button type."}]}]
     [:div {:class "border rounded-lg p-4 bg-amber-500/10 border-amber-500/30 mb-4"}
      [:h4 {:class "text-sm font-semibold mb-2"}
       "⚠️ Important Notes"]
      [:ul {:class "text-xs text-muted-foreground space-y-1 list-disc pl-4"}
       [:li
        "Controlled component: render as [theme-toggle {:theme @theme :on-toggle #(swap! ... )}]."]
       [:li
        "The component never touches document or state - wire the theme change yourself (e.g. toggle the `dark` class on document.documentElement, persist to localStorage, dispatch to re-frame)."]]]
     [:div {:class "border rounded-lg p-4 bg-muted/50"}
      [:h4 {:class "text-sm font-semibold mb-2"}
       "Usage Example"]
      [:pre {:class "text-xs overflow-x-auto"}
       [:code
        "[:div {:class \"flex items-center justify-between\"}\n [:span {:class \"text-sm\"} \"Theme\"]\n [theme-toggle {:theme @theme\n                :on-toggle #(toggle-theme!)}]]"]]]]])))

;; ── Private helpers (no ^:export - not stories)
;; ──────────────────────────────

;; ── Stories ─────────────────────────────────────────────────────────────────

(defstory ThemeToggleBasic
          "Live theme toggle inside a locally scoped preview; it never changes the document theme."
          {:source-code (embed-source "manufaktura.stories.theme-toggle.theme-toggle-basic")}
          []
          (r/as-element (helpers/wrap-component [example-theme-toggle-basic/example])))

(defstory
 ThemeToggleLight
 "Disabled visual specimen pinned to :light; it is intentionally not presented as an interactive toggle."
 {:source-code (embed-source "manufaktura.stories.theme-toggle.theme-toggle-light")}
 []
 (r/as-element (helpers/wrap-component [example-theme-toggle-light/example])))

(defstory
 ThemeToggleDark
 "Disabled visual specimen pinned to :dark; it is intentionally not presented as an interactive toggle."
 {:source-code (embed-source "manufaktura.stories.theme-toggle.theme-toggle-dark")}
 []
 (r/as-element (helpers/wrap-component [example-theme-toggle-dark/example])))

(defstory ThemeToggleInHeader
          "Composition demo: toggle inside a minimal header."
          {:source-code (embed-source "manufaktura.stories.theme-toggle.theme-toggle-in-header")}
          []
          (r/as-element (helpers/wrap-component [example-theme-toggle-in-header/example])))

(defstory ThemeToggleSettingsRow
          "Settings panel row with descriptive text next to the live toggle."
          {:source-code (embed-source "manufaktura.stories.theme-toggle.theme-toggle-settings-row")}
          []
          (r/as-element (helpers/wrap-component [example-theme-toggle-settings-row/example])))
