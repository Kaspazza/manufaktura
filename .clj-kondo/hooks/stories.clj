(ns hooks.stories
  (:require [clj-kondo.hooks-api :as api]))

(defn defstory
  [{:keys [node]}]
  (let [[_ story-name & declaration] (:children node)
        [docstring declaration] (if (string? (api/sexpr (first declaration)))
                                  [(first declaration) (next declaration)]
                                  [nil declaration])
        [config declaration] (if (api/map-node? (first declaration))
                               [(first declaration) (next declaration)]
                               [nil declaration])
        [params & body] declaration
        definition (api/list-node
                    (concat [(api/token-node 'defn) story-name]
                            (when docstring [docstring])
                            [params]
                            body))]
    {:node (api/list-node
            (concat [(api/token-node 'do)]
                    (when config [config])
                    [definition story-name]))}))
