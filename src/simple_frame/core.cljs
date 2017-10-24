(ns simple-frame.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [re-view.re-frame-simple :as db]
            [simple-frame.views :as views]
            [simple-frame.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "DEV MODE")))


(defn clear-subscription-cache []
  (re-frame/clear-subscription-cache!))


(defn mount-root []
  (reagent/render [views/main-panel] (.getElementById js/document "app")))

(defn ^:export init []
  (db/assoc! :name "shadow-cljs, re-frame and re-frame-simple")
  (dev-setup)
  (mount-root))
