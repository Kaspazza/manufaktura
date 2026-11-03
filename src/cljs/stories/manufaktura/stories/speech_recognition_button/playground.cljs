(ns manufaktura.stories.speech-recognition-button.playground
  (:require
   [manufaktura.ui.components.prompt-input              :as prompt-input]
   [manufaktura.ui.components.speech-recognition-button :as speech-recognition-button]
   [reagent.core                                        :as r]))

(defn example
  ([]
   (example {:language "en-US"
             :continuous true}))
  ([args]
   (r/with-let
    [value (r/atom "")]
    [:div {:class "max-w-xl p-6"}
     [:p {:class "mb-3 text-sm text-muted-foreground"}
      "Stop listening before changing language or continuous mode, then start again. Microphone permission and browser speech-recognition support are required."]
     [prompt-input/prompt-input {:value @value
                                 :on-value-change #(reset! value %)}
      [prompt-input/prompt-input-textarea {:placeholder "Speak or type…"}]
      [prompt-input/prompt-input-actions {}
       [speech-recognition-button/speech-recognition-button
        (assoc args :on-transcript-change #(reset! value %))]]]])))
