(ns manufaktura.stories.bubble.bubble-markdown-composition
  (:require
   [manufaktura.ui.components.bubble   :as bubble]
   [manufaktura.ui.components.markdown :as markdown]))

(defn example
  []
  [bubble/bubble-group {:class "max-w-2xl"}
   [bubble/bubble {:variant :muted}
    [bubble/bubble-content {}
     [markdown/markdown
      {:children
       "### Build summary\n\n- **18** tests passed\n- `release.jar` created\n\n[Open artifacts](https://example.com)"}]]]])
