(ns simple-frame.views
  (:require [re-frame.core :as re-frame]
            [re-view.re-frame-simple :as db]))
        

(defn main-panel []
  (let [name (db/get :name)]
    [:div "Hello from " name]))
