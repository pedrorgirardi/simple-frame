(ns simple-frame.views
  (:require [re-frame.core :as re-frame]
            [simple-frame.subs :as subs]
            ))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div "Hello from " @name]))
