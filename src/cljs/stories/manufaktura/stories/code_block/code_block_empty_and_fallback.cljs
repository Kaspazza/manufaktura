(ns manufaktura.stories.code-block.code-block-empty-and-fallback
  (:require
   [manufaktura.ui.components.code-block :as code-block]))

(defn example
  []
  [:div {:class "grid gap-6 p-6 max-w-xl"}
   [:section {:class "space-y-2"}
    [:h3 {:class "text-sm font-medium"}
     "Empty input"]
    [:p {:class "text-xs text-muted-foreground"}
     "An empty string or nil renders an empty code block, not an error or placeholder."]
    [code-block/code-block
     [code-block/code-block-code {:code ""
                                  :language "clojure"}]]]
   [:section {:class "space-y-2"}
    [:h3 {:class "text-sm font-medium"}
     "Unsupported language"]
    [:p {:class "text-xs text-muted-foreground"}
     "If highlighting fails, the original source remains readable as plain code. This example intentionally uses an invalid language identifier."]
    [code-block/code-block
     [code-block/code-block-code {:language "not-a-real-language"
                                  :code "(defn greet [name]\n  (str \"Hello, \" name \"!\"))"}]]]])
