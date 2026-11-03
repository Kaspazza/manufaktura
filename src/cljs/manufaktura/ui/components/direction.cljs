(ns manufaktura.ui.components.direction
  "Radix direction context with keyword-friendly props.

  Version: 1.0.0
  Last updated: 2026-11-03"
  (:require
   ["@radix-ui/react-direction" :refer [DirectionProvider useDirection]]))

(defn direction-provider
  [{:keys [direction dir]
    :as props}
   &
   children]
  (into [:>
         DirectionProvider
         (-> props
             (assoc :dir (name (or direction dir :ltr)))
             (dissoc :direction))]
        children))

(defn use-direction
  "Returns the current writing direction as :ltr or :rtl. Optionally accepts a local direction."
  ([] (keyword (useDirection)))
  ([direction]
   (keyword (useDirection (some-> direction
                                  name)))))
