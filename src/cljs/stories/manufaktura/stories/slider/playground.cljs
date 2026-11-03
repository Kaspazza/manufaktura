(ns manufaktura.stories.slider.playground
  (:require
   [manufaktura.ui.components.slider :as slider]
   [reagent.core                     :as r]))

(defn- finite-number? [x] (and (number? x) (js/Number.isFinite x)))

(defn- preview
  [{:keys [default-value min max step disabled]}]
  (r/with-let
   [value (r/atom default-value)]
   [:div {:class "w-full max-w-md space-y-4 p-6"}
    [slider/slider {:value @value
                    :on-value-change #(reset! value %)
                    :min min
                    :max max
                    :step step
                    :disabled disabled
                    :aria-label "Value"}]
    [:output {:aria-live "polite"}
     (str "Value: " (first @value))]
    [:p {:class "text-xs text-muted-foreground"}
     "Changing initial value, bounds or step resets the preview. Invalid bounds use a one-unit range; step must be positive."]]))

(defn example
  ([]
   (example {:default-value [40]
             :min 0
             :max 100
             :step 1
             :disabled false}))
  ([args]
   (let [lo (if (finite-number? (:min args)) (:min args) 0)
         hi (if (and (finite-number? (:max args)) (> (:max args) lo)) (:max args) (+ lo 1))
         step (if (and (finite-number? (:step args)) (pos? (:step args))) (:step args) 1)
         step (min step (- hi lo))
         initial (first (:default-value args))
         initial (if (finite-number? initial) initial lo)
         ticks (js/Math.floor (/ (- hi lo) step))
         tick (max 0 (min ticks (js/Math.round (/ (- initial lo) step))))
         props (assoc args :min lo :max hi :step step :default-value [(+ lo (* tick step))])]
     ^{:key [(:default-value args) lo hi step]} [preview props])))
