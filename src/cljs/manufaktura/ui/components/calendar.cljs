(ns manufaktura.ui.components.calendar
  "Accessible calendar backed by react-day-picker. Dates remain JavaScript Date values at the boundary.

  Version: 1.0.0
  Last updated: 2026-11-03"
  (:require
   ["react-day-picker"       :refer [DayPicker getDefaultClassNames]]
   [manufaktura.utils.props  :refer [normalize-props]]
   [manufaktura.utils.styles :refer [merge-classes]]))

(defn calendar
  [raw-props]
  (let
    [{:keys [class class-names show-outside-days caption-layout]
      :or {show-outside-days true
           caption-layout :label}
      :as props}
     (normalize-props raw-props)
     defaults (js->clj (getDefaultClassNames) :keywordize-keys true)
     classes
     (merge
      defaults
      {:root "w-fit"
       :months "relative flex flex-col gap-4 md:flex-row"
       :month "flex w-full flex-col gap-4"
       :nav "pointer-events-none absolute inset-x-0 top-0 flex w-full items-center justify-between"
       :button_previous
       "pointer-events-auto flex size-8 items-center justify-center rounded-md p-0 hover:bg-accent aria-disabled:opacity-50"
       :button_next
       "pointer-events-auto flex size-8 items-center justify-center rounded-md p-0 hover:bg-accent aria-disabled:opacity-50"
       :month_caption "flex h-8 w-full items-center justify-center px-8"
       :dropdowns "flex h-8 w-full items-center justify-center gap-1.5 text-sm font-medium"
       :dropdown_root
       "relative rounded-md border border-input shadow-xs focus-within:border-ring focus-within:ring-2 focus-within:ring-ring/50"
       :dropdown
       "absolute inset-0 z-10 h-full w-full cursor-pointer bg-popover text-popover-foreground opacity-0 disabled:cursor-not-allowed"
       :caption_label
       (if (= "label" (name caption-layout))
         "select-none text-sm font-medium"
         "flex h-8 items-center gap-1 rounded-md pl-2 pr-1 text-sm font-medium select-none [&>svg]:size-3.5 [&>svg]:text-muted-foreground")
       :chevron "size-4 fill-current"
       :visually_hidden "sr-only"
       :month_grid "w-full border-collapse"
       :weekdays "flex"
       :weekday "flex-1 rounded-md text-[0.8rem] font-normal text-muted-foreground"
       :week "mt-2 flex w-full"
       :day "relative size-8 p-0 text-center"
       :day_button
       "size-8 rounded-md text-sm hover:bg-accent focus-visible:ring-2 focus-visible:ring-ring aria-selected:bg-primary aria-selected:text-primary-foreground"
       :range_start "rounded-l-md bg-accent"
       :range_middle "rounded-none bg-accent"
       :range_end "rounded-r-md bg-accent"
       :today "rounded-md bg-accent text-accent-foreground"
       :outside "text-muted-foreground opacity-50"
       :disabled "text-muted-foreground opacity-50"
       :hidden "invisible"}
      class-names)]
    [:>
     DayPicker
     (-> props
         (assoc :data-slot "calendar"
                :showOutsideDays show-outside-days
                :captionLayout (name caption-layout)
                :className
                (merge-classes
                 "group/calendar bg-background p-3 [--rdp-day-width:2rem] [--rdp-day-height:2rem]"
                 class)
                :classNames (clj->js classes))
         (dissoc :class :class-name :class-names :show-outside-days :caption-layout))]))
