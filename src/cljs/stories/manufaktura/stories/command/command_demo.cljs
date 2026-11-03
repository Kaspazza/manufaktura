(ns manufaktura.stories.command.command-demo
  (:require
   ["lucide-react"                    :refer [Calendar CreditCard Settings Smile User]]
   [manufaktura.ui.components.command :as command]))

(defn example
  []
  [:div {:class "p-6"}
   ;; A non-matching initial value leaves selection empty until interaction.
   ;; cmdk otherwise selects and scrolls the first item into view on mount,
   ;; pulling the entire Overview page down to this embedded demo.
   [command/command {:class "rounded-lg border shadow-md md:min-w-[450px]"
                     :defaultValue "__no_initial_selection__"}
    [command/command-input {:placeholder "Type a command or search..."}]
    [command/command-list {}
     [command/command-empty {}
      "No results found."]
     [command/command-group {:heading "Suggestions"}
      [command/command-item {}
       [:> Calendar]
       [:span "Calendar"]]
      [command/command-item {}
       [:> Smile]
       [:span "Search Emoji"]]
      [command/command-item {:disabled true}
       [:> CreditCard]
       [:span "Calculator"]]]
     [command/command-separator {}]
     [command/command-group {:heading "Settings"}
      [command/command-item {}
       [:> User]
       [:span "Profile"]]
      [command/command-item {}
       [:> Settings]
       [:span "Settings"]]]]]])
