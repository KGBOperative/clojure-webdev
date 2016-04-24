(ns proj1.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [proj1.layout :refer [error-page]]
            [proj1.routes.home :refer [home-routes]]
            [compojure.route :as route]
            [proj1.middleware :as middleware]))

(def app-routes
  (routes
    (-> #'home-routes
        (wrap-routes middleware/wrap-csrf)
        (wrap-routes middleware/wrap-formats))
    (route/not-found
      (:body
        (error-page {:status 404
                     :title "page not found"})))))

(defn app [] (middleware/wrap-base #'app-routes))
