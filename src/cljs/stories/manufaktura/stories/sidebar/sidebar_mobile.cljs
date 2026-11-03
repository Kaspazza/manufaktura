(ns manufaktura.stories.sidebar.sidebar-mobile
  (:require
   [manufaktura.ui.components.sidebar :as sidebar]
   [reagent.core                      :as r]))

(defn example
  []
  (r/with-let
   [open? (r/atom false)]
   [:div {:class
          "mx-auto flex h-[320px] w-full max-w-lg flex-col items-start gap-4 rounded-xl border p-6"}
    [:h2 {:class "font-semibold"}
     "Mobile workspace"]
    [:p {:class "text-sm text-muted-foreground"}
     "Open navigation, then dismiss with Escape, the backdrop, or the close button."]
    [:button {:class "mb-4 text-sm underline"
              :on-click #(reset! open? true)}
     "Open mobile navigation"]
    [sidebar/sidebar {:open? @open?
                      :on-open-change #(reset! open? %)
                      :is-mobile true
                      :collapsible "offcanvas"}
     [sidebar/sidebar-header {}
      [:div {:class "text-sm font-semibold px-2"}
       "Mobile Nav"]
      [:button {:type "button"
                :class "self-start rounded-md border px-3 py-2 text-sm"
                :on-click #(reset! open? false)}
       "Close navigation"]]
     [sidebar/sidebar-content {}
      [sidebar/sidebar-menu {}
       [sidebar/sidebar-menu-item {}
        [sidebar/sidebar-menu-button {:is-active? true}
         "Home"]]
       [sidebar/sidebar-menu-item {}
        [sidebar/sidebar-menu-button {}
         "Settings"]]]]]]))
