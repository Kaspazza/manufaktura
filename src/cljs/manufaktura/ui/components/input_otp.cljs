(ns manufaktura.ui.components.input-otp
  "One-time-password input preserving input-otp keyboard, paste and screen-reader behavior.

  Version: 1.0.0
  Last updated: 2026-11-03"
  (:require
   ["input-otp"              :refer [OTPInput OTPInputContext]]
   ["lucide-react"           :refer [MinusIcon]]
   ["react"                  :as react]
   [manufaktura.utils.props  :refer [normalize-props]]
   [manufaktura.utils.styles :refer [merge-classes]]
   [reagent.core             :as r]))

(defn input-otp
  [{:keys [class container-class]
    :as raw-props}
   &
   children]
  (let [props (normalize-props raw-props)]
    (into [:>
           OTPInput
           (-> props
               (assoc :data-slot "input-otp"
                      :className (merge-classes "disabled:cursor-not-allowed" class)
                      :containerClassName (merge-classes
                                           "flex items-center gap-2 has-disabled:opacity-50"
                                           container-class))
               (dissoc :class :class-name :container-class))]
          children)))

(defn input-otp-group
  [{:keys [class]
    :as props}
   &
   children]
  (into [:div
         (-> props
             (assoc :data-slot "input-otp-group" :class (merge-classes "flex items-center" class))
             (dissoc :class-name))]
        children))

(defn- input-otp-slot-root
  [^js react-props]
  (let [{:keys [index class]
         :as props}
        (.-slotProps react-props)
        ^js context (react/useContext OTPInputContext)
        ^js slot (some-> context
                         .-slots
                         (aget index))]
    (r/as-element
     [:div
      (->
        props
        (assoc
         :data-slot "input-otp-slot"
         :data-active (boolean (some-> slot
                                       .-isActive))
         :class
         (merge-classes
          "relative flex h-9 w-9 items-center justify-center border-y border-e border-input text-sm shadow-xs transition-all outline-none first:rounded-s-md first:border-s last:rounded-e-md aria-invalid:border-destructive data-[active=true]:z-10 data-[active=true]:border-ring data-[active=true]:ring-[3px] data-[active=true]:ring-ring/50 dark:bg-input/30"
          class))
        (dissoc :class-name :index))
      (some-> slot
              .-char)
      (when (some-> slot
                    .-hasFakeCaret)
        [:div {:class "pointer-events-none absolute inset-0 flex items-center justify-center"}
         [:div {:class "h-4 w-px animate-caret-blink bg-foreground duration-1000"}]])])))

(defn input-otp-slot [props] (r/create-element input-otp-slot-root #js {:slotProps props}))

(defn input-otp-separator
  [props]
  [:div
   (assoc props :data-slot "input-otp-separator" :role "separator")
   [:> MinusIcon {:className "size-4"}]])
