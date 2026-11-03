(ns manufaktura.stories.speech-recognition-button.speech-recognition-in-prompt
  (:require
   [manufaktura.ui.components.prompt-input              :as prompt-input]
   [manufaktura.ui.components.speech-recognition-button :as speech-recognition-button]
   [reagent.core                                        :as r]))

(defn example
  []
  (let [value (r/atom "")]
    (fn [] [:div {:class "p-6 max-w-xl"}
            [prompt-input/prompt-input {:value @value
                                        :on-value-change #(reset! value %)}
             [prompt-input/prompt-input-textarea {:placeholder "Speak or type a message..."}]
             [prompt-input/prompt-input-actions {}
              [speech-recognition-button/speech-recognition-button {:on-transcript-change
                                                                    #(reset! value %)}]]]])))
