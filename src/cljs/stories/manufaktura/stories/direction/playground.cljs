(ns manufaktura.stories.direction.playground
  (:require
   ["@radix-ui/react-radio-group"       :as radio-group]
   [manufaktura.ui.components.direction :as direction]))

(defn- choices
  []
  (let [dir (direction/use-direction)]
    [:div {:dir (name dir)
           :class "space-y-3 rounded-md border p-4"}
     [:p (str "Inherited direction: " (name dir))]
     [:p {:class "text-sm text-muted-foreground"}
      "Tab into the choices, then use Left/Right. In RTL, Left moves to the next choice; in LTR, Right does. No local direction is passed to the radio group."]
     [:>
      (.-Root radio-group)
      {:orientation "horizontal"
       :defaultValue "team"
       :aria-label "Plan"
       :className "flex gap-4"}
      (for [[value label] [["solo" "Solo"] ["team" "Team"] ["org" "Organization"]]]
        ^{:key value}
        [:label {:class "flex items-center gap-2"}
         [:>
          (.-Item radio-group)
          {:value value
           :className "size-5 rounded-full border"}
          [:>
           (.-Indicator radio-group)
           {:className "block size-full scale-50 rounded-full bg-primary"}]]
         label])]]))

(defn example
  ([] (example {:dir "ltr"}))
  ([args] [direction/direction-provider (select-keys args [:dir]) [:f> choices]]))
