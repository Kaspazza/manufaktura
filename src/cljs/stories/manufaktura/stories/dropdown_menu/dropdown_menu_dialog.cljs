(ns manufaktura.stories.dropdown-menu.dropdown-menu-dialog
  (:require
   ["lucide-react"                          :refer [MoreHorizontal]]
   [manufaktura.ui.components.button        :as button]
   [manufaktura.ui.components.dialog        :as dialog]
   [manufaktura.ui.components.dropdown-menu :as dropdown-menu]
   [manufaktura.ui.components.field         :as field]
   [manufaktura.ui.components.input         :as input]
   [manufaktura.ui.components.label         :as label]
   [manufaktura.ui.components.textarea      :as textarea]
   [reagent.core                            :as r]))

(defn example
  []
  [(fn []
     (let [show-new? (r/atom false)
           show-share? (r/atom false)]
       (fn [] [:div {:class "p-6"}
               [dropdown-menu/dropdown-menu {:modal false}
                [dropdown-menu/dropdown-menu-trigger {:as-child true}
                 (button/button {:variant :outline
                                 :size :icon
                                 :aria-label "Open menu"}
                                [:> MoreHorizontal])]
                [dropdown-menu/dropdown-menu-content {:class "w-40"
                                                      :align "end"}
                 [dropdown-menu/dropdown-menu-label {}
                  "File Actions"]
                 [dropdown-menu/dropdown-menu-group {}
                  [dropdown-menu/dropdown-menu-item {:on-select (fn* [] (reset! show-new? true))}
                   "New File..."]
                  [dropdown-menu/dropdown-menu-item {:on-select (fn* [] (reset! show-share? true))}
                   "Share..."]
                  [dropdown-menu/dropdown-menu-item {:disabled true}
                   "Download"]]]]
               [dialog/dialog {:open @show-new?
                               :on-open-change (fn* [%1] (reset! show-new? %1))}
                [dialog/dialog-content {:class "sm:max-w-[425px]"}
                 [dialog/dialog-header {}
                  [dialog/dialog-title {}
                   "Create New File"]
                  [dialog/dialog-description {}
                   "Provide a name for your new file. Click create when you're done."]]
                 [field/field-group {:class "pb-3"}
                  [field/field {}
                   [field/field-label {:html-for "filename"}
                    "File Name"]
                   [input/input {:id "filename"
                                 :placeholder "document.txt"}]]]
                 [dialog/dialog-footer {}
                  [dialog/dialog-close {:as-child true}
                   (button/button {:variant :outline} "Cancel")]
                  (button/button {:type "submit"} "Create")]]]
               [dialog/dialog {:open @show-share?
                               :on-open-change (fn* [%1] (reset! show-share? %1))}
                [dialog/dialog-content {:class "sm:max-w-[425px]"}
                 [dialog/dialog-header {}
                  [dialog/dialog-title {}
                   "Share File"]
                  [dialog/dialog-description {}
                   "Anyone with the link will be able to view this file."]]
                 [field/field-group {:class "py-3"}
                  [field/field {}
                   [label/label {:html-for "share-email"}
                    "Email Address"]
                   [input/input {:id "share-email"
                                 :type "email"
                                 :placeholder "shadcn@vercel.com"}]]
                  [field/field {}
                   [field/field-label {:html-for "share-message"}
                    "Message (Optional)"]
                   [textarea/textarea {:id "share-message"
                                       :placeholder "Check out this file"}]]]
                 [dialog/dialog-footer {}
                  [dialog/dialog-close {:as-child true}
                   (button/button {:variant :outline} "Cancel")]
                  (button/button {:type "submit"} "Send Invite")]]]])))])
