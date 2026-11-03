(ns manufaktura.stories.native-select-stories
  (:require
   [manufaktura.stories.helpers                             :as helpers]
   [manufaktura.stories.native-select.native-select-demo    :as native-select-demo]
   [manufaktura.stories.native-select.native-select-invalid :as native-select-invalid]
   [manufaktura.stories.native-select.native-select-rtl     :as native-select-rtl]
   [manufaktura.stories.native-select.native-select-sizes   :as native-select-sizes]
   [reagent.core                                            :as r])
  (:require-macros [manufaktura.stories.macros :refer [embed-source defstory defdoc]]))

(def ^:export default
  #js {:title "Components/Native Select"
       :parameters #js {:layout "padded"}})

(defdoc Installation
        []
        (r/as-element [helpers/installation-scene
                       {:description
                        "Styled native select preserving platform semantics and accessibility."
                        :npm-install "npm install lucide-react"
                        :source-code (embed-source "manufaktura.ui.components.native_select")
                        :namespace-path "src/cljs/manufaktura/ui/components/native_select.cljs"
                        :filename "native_select.cljs"}]))

(defstory
 ApiReference
 []
 (r/as-element
  (helpers/wrap-component
   [:div {:class "space-y-4 p-6 max-w-4xl"}
    [helpers/api-component-card
     {:component-name "native-select"
      :description
      "Native HTML select wrapped for styling with an aria-hidden chevron. Browser semantics, keyboard interaction, form submission, and option constraints remain native."
      :props
      [{:name ":size"
        :type ":default | :sm"
        :default ":default"
        :description "Controls select height and padding; consumed as a styling data attribute."}
       {:name ":class"
        :type "string"
        :default nil
        :description "Classes merged onto the select, not its wrapper."}
       {:name "select props"
        :type "map entries"
        :default nil
        :description
        "Normalized and forwarded to select, including :name, :value, :default-value, :on-change, :disabled, :required, and ARIA props."}]}]
    [helpers/api-component-card
     {:component-name "native-select-option / native-select-optgroup"
      :description
      "Styled native option and optgroup elements. Nest both beneath native-select; optgroup should contain options and receive a :label."
      :props
      [{:name ":class / native props"
        :type "string / map entries"
        :default nil
        :description
        "Classes are merged and remaining normalized props forwarded to option or optgroup."}]}]])))

(defstory NativeSelectDemo
          {:source-code (embed-source "manufaktura.stories.native-select.native-select-demo")}
          []
          (r/as-element (helpers/wrap-component [native-select-demo/example])))

(defstory NativeSelectSizes
          {:source-code (embed-source "manufaktura.stories.native-select.native-select-sizes")}
          []
          (r/as-element (helpers/wrap-component [native-select-sizes/example])))

(defstory NativeSelectInvalid
          "Native validation styling and message. Based on shadcn/ui Native Select - Invalid."
          {:source-code (embed-source "manufaktura.stories.native-select.native-select-invalid")}
          []
          (r/as-element (helpers/wrap-component [native-select-invalid/example])))

(defstory NativeSelectRtl
          "Right-to-left native select. Based on shadcn/ui Native Select - RTL."
          {:source-code (embed-source "manufaktura.stories.native-select.native-select-rtl")}
          []
          (r/as-element (helpers/wrap-component [native-select-rtl/example])))
