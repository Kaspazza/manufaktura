(ns manufaktura.stories.all-components-stories
  "A single scrollable catalogue of every manufaktura component."
  (:require
   ["lucide-react"                                        :refer [ArrowRight Github]]
   [clojure.string                                        :as str]
   [manufaktura.stories.accordion-stories                 :as accordion]
   [manufaktura.stories.alert-dialog-stories              :as alert-dialog]
   [manufaktura.stories.alert-stories                     :as alert]
   [manufaktura.stories.aspect-ratio-stories              :as aspect-ratio]
   [manufaktura.stories.attachment-stories                :as attachment]
   [manufaktura.stories.avatar-stories                    :as avatar]
   [manufaktura.stories.badge-stories                     :as badge]
   [manufaktura.stories.breadcrumb-stories                :as breadcrumb]
   [manufaktura.stories.bubble-stories                    :as bubble]
   [manufaktura.stories.button-group-stories              :as button-group]
   [manufaktura.stories.button-stories                    :as button]
   [manufaktura.stories.calendar-stories                  :as calendar]
   [manufaktura.stories.card-stories                      :as card]
   [manufaktura.stories.carousel-stories                  :as carousel]
   [manufaktura.stories.chart-stories                     :as chart]
   [manufaktura.stories.chat-container-stories            :as chat-container]
   [manufaktura.stories.checkbox-stories                  :as checkbox]
   [manufaktura.stories.code-block-stories                :as code-block]
   [manufaktura.stories.collapsible-stories               :as collapsible]
   [manufaktura.stories.combobox-stories                  :as combobox]
   [manufaktura.stories.command-stories                   :as command]
   [manufaktura.stories.context-menu-stories              :as context-menu]
   [manufaktura.stories.data-table-stories                :as data-table]
   [manufaktura.stories.date-picker-stories               :as date-picker]
   [manufaktura.stories.dialog-stories                    :as dialog]
   [manufaktura.stories.direction-stories                 :as direction]
   [manufaktura.stories.drawer-stories                    :as drawer]
   [manufaktura.stories.dropdown-menu-stories             :as dropdown-menu]
   [manufaktura.stories.empty-stories                     :as empty]
   [manufaktura.stories.field-stories                     :as field]
   [manufaktura.stories.form-stories                      :as form]
   [manufaktura.stories.hover-card-stories                :as hover-card]
   [manufaktura.stories.input-group-stories               :as input-group]
   [manufaktura.stories.input-otp-stories                 :as input-otp]
   [manufaktura.stories.input-stories                     :as input]
   [manufaktura.stories.item-stories                      :as item]
   [manufaktura.stories.kbd-stories                       :as kbd]
   [manufaktura.stories.label-stories                     :as label]
   [manufaktura.stories.loader-stories                    :as loader]
   [manufaktura.stories.markdown-stories                  :as markdown]
   [manufaktura.stories.marker-stories                    :as marker]
   [manufaktura.stories.menubar-stories                   :as menubar]
   [manufaktura.stories.message-scroller-stories          :as message-scroller]
   [manufaktura.stories.message-stories                   :as message]
   [manufaktura.stories.native-select-stories             :as native-select]
   [manufaktura.stories.navigation-menu-stories           :as navigation-menu]
   [manufaktura.stories.notification-stories              :as notification]
   [manufaktura.stories.pagination-stories                :as pagination]
   [manufaktura.stories.popover-stories                   :as popover]
   [manufaktura.stories.progress-stories                  :as progress]
   [manufaktura.stories.prompt-input-stories              :as prompt-input]
   [manufaktura.stories.radio-group-stories               :as radio-group]
   [manufaktura.stories.resizable-stories                 :as resizable]
   [manufaktura.stories.scroll-area-stories               :as scroll-area]
   [manufaktura.stories.scroll-button-stories             :as scroll-button]
   [manufaktura.stories.select-stories                    :as select]
   [manufaktura.stories.separator-stories                 :as separator]
   [manufaktura.stories.sheet-stories                     :as sheet]
   [manufaktura.stories.sidebar-stories                   :as sidebar]
   [manufaktura.stories.skeleton-stories                  :as skeleton]
   [manufaktura.stories.slider-stories                    :as slider]
   [manufaktura.stories.speech-recognition-button-stories :as speech-recognition]
   [manufaktura.stories.spinner-stories                   :as spinner]
   [manufaktura.stories.stepper-stories                   :as stepper]
   [manufaktura.stories.switch-stories                    :as switch]
   [manufaktura.stories.system-message-stories            :as system-message]
   [manufaktura.stories.table-stories                     :as table]
   [manufaktura.stories.tabs-stories                      :as tabs]
   [manufaktura.stories.tag-combobox-stories              :as tag-combobox]
   [manufaktura.stories.textarea-stories                  :as textarea]
   [manufaktura.stories.theme-toggle-stories              :as theme-toggle]
   [manufaktura.stories.toggle-group-stories              :as toggle-group]
   [manufaktura.stories.toggle-stories                    :as toggle]
   [manufaktura.stories.tooltip-stories                   :as tooltip]
   [manufaktura.stories.typography-stories                :as typography]
   [manufaktura.ui.components.button                      :as ui-button]
   [manufaktura.ui.components.select                      :as ui-select]
   [reagent.core                                          :as r]))

(def ^:export default
  #js {:title "Home"
       :parameters #js {:layout "fullscreen"}})

(def components
  [{:name "Accordion"
    :preview accordion/AccordionBasic}
   {:name "Alert"
    :preview alert/Playground}
   {:name "Alert Dialog"
    :preview alert-dialog/AlertDialogBasic}
   {:name "Aspect Ratio"
    :preview aspect-ratio/Playground}
   {:name "Attachment"
    :preview attachment/Playground}
   {:name "Avatar"
    :preview avatar/Playground}
   {:name "Badge"
    :preview badge/BadgeVariants}
   {:name "Breadcrumb"
    :preview breadcrumb/BreadcrumbDemo}
   {:name "Bubble"
    :preview bubble/BubbleConversation}
   {:name "Button"
    :preview button/ButtonSize}
   {:name "Button Group"
    :preview button-group/Playground}
   {:name "Calendar"
    :preview calendar/SingleDate}
   {:name "Card"
    :preview card/Playground
    :preview-class "p-6"}
   {:name "Carousel"
    :preview carousel/CarouselDemo}
   {:name "Chart"
    :preview chart/BarChart}
   {:name "Chat Container"
    :preview chat-container/ChatContainerComposition}
   {:name "Checkbox"
    :preview checkbox/CheckboxDemo}
   {:name "Code Block"
    :preview code-block/CodeBlockWithHeader}
   {:name "Collapsible"
    :preview collapsible/CollapsibleBasic}
   {:name "Combobox"
    :preview combobox/Basic
    :preview-class "p-6"}
   {:name "Command"
    :preview command/CommandDemo}
   {:name "Context Menu"
    :preview context-menu/ContextMenuDemo}
   {:name "Data Table"
    :preview data-table/TableWithToolbar}
   {:name "Date Picker"
    :preview date-picker/DatePickerStates}
   {:name "Dialog"
    :preview dialog/DialogDemo}
   {:name "Direction"
    :preview direction/RightToLeft}
   {:name "Drawer"
    :preview drawer/BottomDrawer}
   {:name "Dropdown Menu"
    :preview dropdown-menu/DropdownMenuDemo}
   {:name "Empty"
    :docs-id "empty-state"
    :preview empty/Playground}
   {:name "Field"
    :preview field/FieldWithInput}
   {:name "Form"
    :preview form/Validation
    :preview-class "p-6"}
   {:name "Hover Card"
    :preview hover-card/HoverCardBasic}
   {:name "Input"
    :preview input/InputDemo}
   {:name "Input Group"
    :preview input-group/WithAddon}
   {:name "Input OTP"
    :preview input-otp/SixDigits
    :preview-class "p-6"}
   {:name "Item"
    :preview item/ItemVariants
    :preview-class "p-6"}
   {:name "Kbd"
    :preview kbd/KbdGroup
    :preview-class "p-6"}
   {:name "Label"
    :preview label/Playground}
   {:name "Loader"
    :preview loader/LoaderAllVariants}
   {:name "Markdown"
    :preview markdown/MarkdownCombined}
   {:name "Marker"
    :preview marker/MarkerVariants}
   {:name "Menubar"
    :preview menubar/MenubarDemo}
   {:name "Message"
    :preview message/MessageUserVsAssistant}
   {:name "Message Scroller"
    :preview message-scroller/MessageScrollerGroupChat}
   {:name "Native Select"
    :preview native-select/NativeSelectDemo}
   {:name "Navigation Menu"
    :preview navigation-menu/NavigationMenuIndicator}
   {:name "Notification"
    :preview notification/ToastWithDescription}
   {:name "Pagination"
    :preview pagination/PaginationDemo}
   {:name "Popover"
    :preview popover/PopoverDemo}
   {:name "Progress"
    :preview progress/ProgressBasic}
   {:name "Prompt Input"
    :preview prompt-input/PromptInputMultipleActions}
   {:name "Radio Group"
    :preview radio-group/FieldRadio}
   {:name "Resizable"
    :preview resizable/Horizontal}
   {:name "Scroll Area"
    :preview scroll-area/ScrollAreaBasic}
   {:name "Scroll Button"
    :preview scroll-button/ScrollButtonStandalone}
   {:name "Select"
    :preview select/SelectScrollable}
   {:name "Separator"
    :preview separator/SeparatorList}
   {:name "Sheet"
    :preview sheet/SheetDemo}
   {:name "Sidebar"
    :preview sidebar/SidebarDemo}
   {:name "Skeleton"
    :preview skeleton/SkeletonCard}
   {:name "Slider"
    :preview slider/SliderBasic}
   {:name "Speech Recognition Button"
    :preview speech-recognition/SpeechRecognitionStandalone}
   {:name "Spinner"
    :preview spinner/SpinnerDemo}
   {:name "Stepper"
    :preview stepper/StepperHorizontal}
   {:name "Switch"
    :preview switch/SwitchDemo}
   {:name "System Message"
    :preview system-message/Playground}
   {:name "Table"
    :preview table/TableDemo}
   {:name "Tabs"
    :preview tabs/TabsBasic}
   {:name "Tag Combobox"
    :preview tag-combobox/BasicTagSelection}
   {:name "Textarea"
    :preview textarea/TextareaDemo}
   {:name "Theme Toggle"
    :docs-id "themetoggle"
    :preview theme-toggle/ThemeToggleInHeader}
   {:name "Toggle"
    :preview toggle/ToggleBasic}
   {:name "Toggle Group"
    :preview toggle-group/ToggleGroupSingle}
   {:name "Tooltip"
    :preview tooltip/TooltipDemo}
   {:name "Typography"
    :preview typography/TypeScale}])

(def ^:private theme-responsive-components
  "Previews that make the theme configurator's tokens immediately visible."
  #{"Alert" "Badge" "Button" "Card" "Chart" "Checkbox" "Input" "Progress" "Radio Group" "Select"
    "Switch" "Tabs" "Textarea" "Toggle"})

(defn- theme-responsive-first
  [component]
  (not (contains? theme-responsive-components (:name component))))

(defn- component-id
  [name]
  (-> name
      str/lower-case
      (str/replace #"\s+" "-")))

(defn- component-card
  [{:keys [docs-id name preview preview-class]}]
  (let [id (component-id name)
        ^js story preview]
    [:section
     {:id id
      :class
      "mb-4 w-full break-inside-avoid scroll-mt-6 overflow-hidden rounded-lg border bg-card shadow-sm"}
     [:header {:class "border-b bg-muted/30 px-4 py-2.5"}
      [:h2 {:class "text-sm font-semibold tracking-tight"}
       [:a {:href (str "./?path=/docs/components-" (or docs-id id) "--docs")
            :target "_top"
            :class "underline-offset-4 hover:text-primary hover:underline"}
        name]]]
     [:div {:class (str "min-w-0 overflow-x-auto " preview-class)}
      (if-some [args (.-args story)]
        [:> story (js->clj args :keywordize-keys true)]
        [:> story])]]))

(def ^:private base-presets
  [{:id :neutral
    :label "Neutral"
    :swatch "oklch(0.556 0 0)"}
   {:id :stone
    :label "Stone"
    :swatch "oklch(0.553 0.013 58.071)"}
   {:id :zinc
    :label "Zinc"
    :swatch "oklch(0.552 0.016 285.938)"}
   {:id :mauve
    :label "Mauve"
    :swatch "oklch(0.542 0.034 322.5)"}
   {:id :olive
    :label "Olive"
    :swatch "oklch(0.58 0.031 107.3)"}
   {:id :mist
    :label "Mist"
    :swatch "oklch(0.56 0.021 213.5)"}
   {:id :taupe
    :label "Taupe"
    :swatch "oklch(0.547 0.021 43.1)"}])

(def ^:private theme-presets
  [{:id :amber
    :label "Amber"
    :swatch "oklch(0.769 0.188 70.08)"}
   {:id :blue
    :label "Blue"
    :swatch "oklch(0.623 0.214 259.815)"}
   {:id :cyan
    :label "Cyan"
    :swatch "oklch(0.715 0.143 215.221)"}
   {:id :emerald
    :label "Emerald"
    :swatch "oklch(0.696 0.17 162.48)"}
   {:id :fuchsia
    :label "Fuchsia"
    :swatch "oklch(0.667 0.295 322.15)"}
   {:id :green
    :label "Green"
    :swatch "oklch(0.723 0.192 149.579)"}
   {:id :indigo
    :label "Indigo"
    :swatch "oklch(0.585 0.233 277.117)"}
   {:id :lime
    :label "Lime"
    :swatch "oklch(0.768 0.233 130.85)"}
   {:id :orange
    :label "Orange"
    :swatch "oklch(0.705 0.213 47.604)"}
   {:id :pink
    :label "Pink"
    :swatch "oklch(0.656 0.241 354.308)"}
   {:id :purple
    :label "Purple"
    :swatch "oklch(0.627 0.265 303.9)"}
   {:id :red
    :label "Red"
    :swatch "oklch(0.637 0.237 25.331)"}
   {:id :rose
    :label "Rose"
    :swatch "oklch(0.645 0.246 16.439)"}
   {:id :sky
    :label "Sky"
    :swatch "oklch(0.685 0.169 237.323)"}
   {:id :teal
    :label "Teal"
    :swatch "oklch(0.704 0.14 182.503)"}
   {:id :violet
    :label "Violet"
    :swatch "oklch(0.606 0.25 292.717)"}
   {:id :yellow
    :label "Yellow"
    :swatch "oklch(0.795 0.184 86.047)"}])

(def ^:private radii
  [{:label "0"
    :value "0rem"}
   {:label "0.3"
    :value "0.3rem"}
   {:label "0.5"
    :value "0.5rem"}
   {:label "0.75"
    :value "0.75rem"}
   {:label "1.0"
    :value "1rem"}])

(def ^:private heading-fonts
  [{:id :figtree
    :label "Figtree"
    :family "'Figtree', sans-serif"}
   {:id :inter
    :label "Inter"
    :family "'Inter', sans-serif"}
   {:id :manrope
    :label "Manrope"
    :family "'Manrope', sans-serif"}
   {:id :playfair
    :label "Playfair Display"
    :family "'Playfair Display', serif"}])

(def ^:private body-fonts
  [{:id :inter
    :label "Inter"
    :family "'Inter', sans-serif"}
   {:id :figtree
    :label "Figtree"
    :family "'Figtree', sans-serif"}
   {:id :manrope
    :label "Manrope"
    :family "'Manrope', sans-serif"}
   {:id :source-serif
    :label "Source Serif 4"
    :family "'Source Serif 4', serif"}])

(defonce ^:private showcase-base
  (r/atom (or (some-> (.getAttribute js/document.documentElement "data-base")
                      keyword)
              :neutral)))

(defonce ^:private showcase-preset
  (r/atom (or (some-> (.getAttribute js/document.documentElement "data-theme")
                      keyword)
              :emerald)))

(defonce ^:private showcase-mode
  (r/atom (if (.contains (.-classList js/document.documentElement) "dark") :dark :light)))

(defonce ^:private showcase-radius (r/atom "0.75rem"))
(defonce ^:private showcase-chart-color (r/atom :blue))
(defonce ^:private showcase-heading-font (r/atom :figtree))
(defonce ^:private showcase-body-font (r/atom :inter))

(.setAttribute js/document.documentElement "data-base" (name @showcase-base))
(.setAttribute js/document.documentElement "data-theme" (name @showcase-preset))

(defn- select-showcase-base!
  [base]
  (.setAttribute js/document.documentElement "data-base" (name base))
  (reset! showcase-base base))

(defn- select-showcase-preset!
  [preset]
  (.setAttribute js/document.documentElement "data-theme" (name preset))
  (reset! showcase-preset preset))

(defn- select-showcase-chart-color! [color] (reset! showcase-chart-color color))

(defn- select-showcase-mode!
  [mode]
  (.toggle (.-classList js/document.documentElement) "dark" (= mode :dark))
  (reset! showcase-mode mode))

(defn- font-by-id [fonts id] (some #(when (= id (:id %)) %) fonts))

(defn- palette-by-id [presets id] (some #(when (= id (:id %)) %) presets))

(defn- shuffle-theme!
  []
  (let [base (:id (rand-nth base-presets))
        preset (:id (rand-nth theme-presets))
        mode (rand-nth [:light :dark])
        radius (:value (rand-nth radii))
        chart-color (:id (rand-nth theme-presets))
        heading-font (:id (rand-nth heading-fonts))
        body-font (:id (rand-nth body-fonts))]
    (select-showcase-base! base)
    (select-showcase-preset! preset)
    (select-showcase-mode! mode)
    (reset! showcase-radius radius)
    (select-showcase-chart-color! chart-color)
    (reset! showcase-heading-font heading-font)
    (reset! showcase-body-font body-font)))

(defn- reset-theme!
  []
  (select-showcase-base! :neutral)
  (select-showcase-preset! :emerald)
  (select-showcase-mode! :light)
  (reset! showcase-radius "0.75rem")
  (select-showcase-chart-color! :blue)
  (reset! showcase-heading-font :figtree)
  (reset! showcase-body-font :inter))

(defn- font-option
  [label fonts selected-font]
  (let [selected (font-by-id fonts @selected-font)]
    [:fieldset
     [:legend {:class "mb-2 text-xs font-medium uppercase tracking-wider text-muted-foreground"}
      label]
     [ui-select/select {:value (name @selected-font)
                        :on-value-change #(reset! selected-font (keyword %))}
      [ui-select/select-trigger
       {:aria-label (str "Select " (str/lower-case label) " font")
        :class
        "w-full border-input bg-background text-foreground shadow-none hover:bg-accent focus-visible:border-ring focus-visible:ring-ring"}
       [ui-select/select-value {}]
       [:span {:aria-hidden true
               :class "ml-auto text-xl leading-none text-muted-foreground"
               :style {:font-family (:family selected)}}
        "Aa"]]
      [ui-select/select-content {:align "start"
                                 :class "border-border bg-popover text-popover-foreground"}
       (for [{:keys [id label family]} fonts]
         ^{:key id}
         [ui-select/select-item {:value (name id)
                                 :class "focus:bg-accent focus:text-accent-foreground"}
          [:span {:style {:font-family family}}
           label]])]]]))

(defn- palette-option
  [label presets selected-preset on-value-change]
  [:fieldset
   [:legend {:class "mb-2 text-xs font-medium uppercase tracking-wider text-zinc-500"}
    label]
   [ui-select/select {:value (name @selected-preset)
                      :on-value-change #(on-value-change (keyword %))}
    [ui-select/select-trigger
     {:aria-label (str "Select " (str/lower-case label))
      :class
      "w-full border-input bg-background text-foreground shadow-none hover:bg-accent focus-visible:border-ring focus-visible:ring-ring"}
     [ui-select/select-value {}]]
    [ui-select/select-content {:align "start"
                               :class "border-border bg-popover text-popover-foreground"}
     (for [{:keys [id label swatch]} presets]
       ^{:key id}
       [ui-select/select-item {:value (name id)
                               :class "focus:bg-accent focus:text-accent-foreground"}
        [:span {:class "flex items-center gap-2"}
         [:span {:class "size-3 rounded-full ring-1 ring-border"
                 :style {:background swatch}}]
         label]])]]])

(defn- theme-configurator
  []
  (let [selected-mode @showcase-mode
        selected-radius @showcase-radius]
    [:aside
     {:class
      "overflow-hidden rounded-2xl border border-border bg-card text-card-foreground shadow-2xl lg:sticky lg:top-5"}
     [:div {:class "flex items-center justify-between border-b border-border px-4 py-4"}
      [:div
       [:p {:class "text-sm font-semibold"}
        "Customize"]
       [:p {:class "mt-0.5 text-xs text-muted-foreground"}
        "Design your component theme"]]]
     [:div {:class "max-h-[calc(100vh-13rem)] space-y-6 overflow-y-auto p-4"}
      [palette-option "Base color" base-presets showcase-base select-showcase-base!]
      [palette-option "Theme color" theme-presets showcase-preset select-showcase-preset!]
      [palette-option "Chart bars" theme-presets showcase-chart-color select-showcase-chart-color!]
      [:fieldset
       [:legend {:class "mb-2 text-xs font-medium uppercase tracking-wider text-muted-foreground"}
        "Appearance"]
       [:div {:class "grid grid-cols-2 gap-2"}
        (for [[mode icon label] [[:light "☀" "Light"] [:dark "◐" "Dark"]]]
          ^{:key mode}
          [:button
           {:type "button"
            :aria-pressed (= mode selected-mode)
            :on-click #(select-showcase-mode! mode)
            :class
            (str "rounded-lg border px-3 py-3 text-left text-sm transition-colors hover:bg-accent "
                 (if (= mode selected-mode)
                   "border-ring bg-accent text-accent-foreground"
                   "border-border"))}
           [:span {:class "mr-2 text-base"}
            icon]
           label])]]
      [:fieldset
       [:legend {:class "mb-2 text-xs font-medium uppercase tracking-wider text-muted-foreground"}
        "Radius"]
       [:div {:class "grid grid-cols-5 gap-1"}
        (for [{:keys [label value]} radii]
          ^{:key value}
          [:button {:type "button"
                    :aria-pressed (= value selected-radius)
                    :on-click #(reset! showcase-radius value)
                    :class (str "h-9 rounded-md border text-xs transition-colors hover:bg-accent "
                                (if (= value selected-radius)
                                  "border-ring bg-accent text-accent-foreground"
                                  "border-border text-muted-foreground"))}
           label])]]
      [font-option "Heading" heading-fonts showcase-heading-font]
      [font-option "Font" body-fonts showcase-body-font]]
     [:div {:class "grid grid-cols-2 gap-2 border-t border-border p-4"}
      [:button {:type "button"
                :on-click reset-theme!
                :class
                "rounded-md border border-border px-3 py-2 text-xs font-medium hover:bg-accent"}
       "Reset"]
      [:button
       {:type "button"
        :on-click shuffle-theme!
        :class
        "rounded-md bg-primary px-3 py-2 text-xs font-semibold text-primary-foreground hover:bg-primary/90"}
       "Shuffle ↻"]]]))

(defn- overview
  []
  (let [heading-font (font-by-id heading-fonts @showcase-heading-font)
        body-font (font-by-id body-fonts @showcase-body-font)
        chart-color (palette-by-id theme-presets @showcase-chart-color)]
    [:main {:data-base (name @showcase-base)
            :data-theme (name @showcase-preset)
            :style {"--radius" @showcase-radius
                    "--chart-1" (:swatch chart-color)
                    "--chart-2" (:swatch chart-color)
                    "--font-sans" (:family body-font)
                    "--showcase-heading-font" (:family heading-font)
                    "--showcase-body-font" (:family body-font)}
            :class (str
                    "showcase-fonts min-h-screen bg-background text-foreground transition-colors"
                    (when (= @showcase-mode :dark) " dark"))}
     [:div {:class "mx-auto max-w-[1800px] px-4 py-5 sm:px-6 lg:px-8"}
      [:header {:class
                "mb-6 flex flex-col justify-between gap-4 border-b pb-5 sm:flex-row sm:items-end"}
       [:div
        [:div {:class "mb-2 flex items-center gap-2"}
         [:span
          {:class
           "rounded-full bg-primary/10 px-2.5 py-1 text-[11px] font-semibold uppercase tracking-wider text-primary"}
          "Component showcase"]]
        [:h1 {:class "text-3xl font-bold tracking-tight"}
         "Manufaktura"]
        [:p {:class "mt-1.5 max-w-xl text-sm text-muted-foreground"}
         (str "Explore "
              (count components)
              " live ClojureScript components and tune their semantic theme in real time.")]]
       [:div {:class "flex flex-wrap items-center gap-2"}
        [ui-button/button {:as-child true
                           :variant :outline
                           :size :lg}
         [:a {:href "https://github.com/Kaspazza/manufaktura"
              :target "_blank"
              :rel "noopener noreferrer"}
          [:>
           Github
           {:aria-hidden true
            :data-icon "inline-start"}]
          "View source on GitHub"]]
        [ui-button/button {:as-child true
                           :variant :outline
                           :size :lg}
         [:a {:href "./?path=/story/docs-introduction--overview"
              :target "_top"}
          "Read the docs"
          [:>
           ArrowRight
           {:aria-hidden true
            :data-icon "inline-end"}]]]]]
      [:div {:class "grid items-start gap-5 lg:grid-cols-[17rem_minmax(0,1fr)]"}
       [theme-configurator]
       (into [:div {:class "min-w-0 columns-1 gap-4 md:columns-2 2xl:columns-3"}]
             (map (fn [{:keys [name]
                        :as component}]
                    ^{:key name} [component-card component])
                  (sort-by theme-responsive-first components)))]]]))

(defn ^:export Overview
  "Every available component rendered in one continuous, scannable page."
  []
  (r/as-element [overview]))
