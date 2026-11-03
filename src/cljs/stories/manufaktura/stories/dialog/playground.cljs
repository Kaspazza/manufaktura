(ns manufaktura.stories.dialog.playground
  (:require
   [manufaktura.ui.components.button :as button]
   [manufaktura.ui.components.dialog :as dialog]))

(defn example
  ([] (example {:modal true}))
  ([args]
   [:div {:class "space-y-4 p-6"}
    [:p {:class "text-sm text-muted-foreground"}
     "Modal mode traps Tab focus and blocks the background. Non-modal mode allows outside focus. Escape closes and returns focus to the trigger."]
    [dialog/dialog
     (select-keys args [:modal])
     [dialog/dialog-trigger {:as-child true}
      ;; Radix must clone the React button, not a Reagent component wrapper.
      (button/button {:variant :outline} "Open dialog")]
     [dialog/dialog-content {}
      [dialog/dialog-header {}
       [dialog/dialog-title {}
        "Edit profile"]
       [dialog/dialog-description {}
        "Make changes to your profile here."]]]]]))
