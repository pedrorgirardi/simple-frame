(ns simple-frame.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [simple-frame.events :as events]
            [simple-frame.views :as views]
            [simple-frame.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "DEV MODE")))


(defn clear-subscription-cache []
  (re-frame/clear-subscription-cache!))


(defn mount-root []
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))
