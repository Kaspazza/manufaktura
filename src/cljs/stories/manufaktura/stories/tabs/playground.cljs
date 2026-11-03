(ns manufaktura.stories.tabs.playground
  (:require
   [manufaktura.ui.components.tabs :as tabs]
   [reagent.core                   :as r]))

(defn- preview
  [args]
  (r/with-let [selected (r/atom (:default-value args))]
              [:div {:class "space-y-4"}
               [tabs/tabs {:value @selected
                           :on-value-change #(reset! selected %)
                           :orientation (:orientation args)}
                [tabs/tabs-list {:variant (:list-variant args)
                                 :aria-label "Settings"}
                 [tabs/tabs-trigger {:value "account"}
                  "Account"]
                 [tabs/tabs-trigger {:value "password"}
                  "Password"]]
                [tabs/tabs-content {:value "account"
                                    :class "rounded-md border p-4"}
                 "Manage your account profile."]
                [tabs/tabs-content {:value "password"
                                    :class "rounded-md border p-4"}
                 "Update your password and security settings."]]
               [:p {:class "text-sm text-muted-foreground"}
                (str
                 "Selected: "
                 @selected
                 ". Initial tab resets selection; orientation and list variant update live.")]]))

(defn example
  ([]
   (example {:default-value "account"
             :orientation "horizontal"
             :list-variant "default"}))
  ([args] ^{:key (:default-value args)} [preview args]))
