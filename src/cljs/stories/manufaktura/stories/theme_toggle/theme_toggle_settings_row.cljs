(ns manufaktura.stories.theme-toggle.theme-toggle-settings-row
  (:require
   [manufaktura.ui.components.theme-toggle :as theme-toggle]
   [reagent.core                           :as r]))





(defn example
  []
  (r/with-let [theme (r/atom :light)]
              (let [dark? (= @theme :dark)
                    palette {:color-scheme (name @theme)
                             "--background" (if dark? "#18181b" "#ffffff")
                             "--foreground" (if dark? "#fafafa" "#18181b")
                             "--muted-foreground" (if dark? "#a1a1aa" "#52525b")
                             "--border" (if dark? "#3f3f46" "#d4d4d8")}
                    button-style {:background-color (if dark? "#27272a" "#ffffff")
                                  :color (if dark? "#fafafa" "#18181b")
                                  :border-color (if dark? "#52525b" "#d4d4d8")}]
                [:div {:class (str (when (= @theme :dark) "dark ")
                                   "p-6 max-w-sm bg-background text-foreground")
                       :style palette}
                 [:div {:class "flex items-center justify-between rounded-md border px-4 py-3"}
                  [:div {:class "space-y-1"}
                   [:p {:class "text-sm font-medium"}
                    "Dark mode"]
                   [:p {:class "text-xs text-muted-foreground"}
                    "Switch theme for this preview."]]
                  [theme-toggle/theme-toggle
                   {:theme @theme
                    :style button-style
                    :on-toggle #(swap! theme (fn [t] (if (= t :dark) :light :dark)))}]]])))
