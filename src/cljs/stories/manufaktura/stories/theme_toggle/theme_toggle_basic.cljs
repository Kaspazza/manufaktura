(ns manufaktura.stories.theme-toggle.theme-toggle-basic
  (:require
   [manufaktura.ui.components.theme-toggle :as theme-toggle]
   [reagent.core                           :as r]))

(defn example
  []
  (r/with-let
   [theme (r/atom :light)]
   (let [dark? (= @theme :dark)]
     ;; Local tokens and explicit button colors also work under a dark ancestor.
     [:div {:class (if dark? "dark" "light")
            :style {:color-scheme (name @theme)
                    "--background" (if dark? "#18181b" "#ffffff")
                    "--foreground" (if dark? "#fafafa" "#18181b")
                    "--muted-foreground" (if dark? "#a1a1aa" "#52525b")
                    "--border" (if dark? "#3f3f46" "#d4d4d8")}}
      [:section {:class
                 "flex items-center gap-4 rounded-md border bg-background p-6 text-foreground"}
       [:span {:class "text-sm"}
        (str "Theme: " (name @theme))]
       [theme-toggle/theme-toggle
        {:theme @theme
         :label "Toggle preview theme"
         :style {:background-color (if dark? "#27272a" "#ffffff")
                 :color (if dark? "#fafafa" "#18181b")
                 :border-color (if dark? "#52525b" "#d4d4d8")}
         :on-toggle #(swap! theme (fn [current] (if (= current :dark) :light :dark)))}]]])))
