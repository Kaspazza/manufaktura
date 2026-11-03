(ns manufaktura.ui.components.aspect-ratio
  "Aspect-ratio container for maintaining fixed proportions around content.

  Version: 1.0.0
  Last updated: 2026-11-03"
  (:require
   ["@radix-ui/react-aspect-ratio" :as primitive]
   [manufaktura.utils.props        :refer [normalize-props]]
   [manufaktura.utils.styles       :refer [merge-classes]]))

(defn aspect-ratio
  [{:as raw-props} & children]
  (let [{:keys [class]
         :as props}
        (normalize-props raw-props)]
    (into [:>
           primitive/Root
           (-> props
               (assoc :data-slot "aspect-ratio" :class (merge-classes class))
               (dissoc :class-name))]
          children)))
