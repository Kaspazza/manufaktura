(ns manufaktura.stories.message-scroller-composite-stories
  (:require
   [manufaktura.stories.helpers                         :as helpers]
   [manufaktura.stories.message-scroller-composite.demo :as demo]
   [reagent.core                                        :as r])
  (:require-macros [manufaktura.stories.macros :refer [embed-source defstory]]))

(def ^:export default
  #js {:title "Composites/Message Scroller"
       :parameters #js {:layout "centered"}})


(defstory Demo
          "Read-only queued chat demonstrating anchored, intent-aware scrolling."
          {:source-code (embed-source "manufaktura.stories.message-scroller-composite.demo")}
          []
          (r/as-element (helpers/wrap-component [demo/example])))
