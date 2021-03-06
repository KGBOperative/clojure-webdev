(ns proj2.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [proj2.layout :refer [error-page]]
            [proj2.routes.home :refer [home-routes]]
            [compojure.route :as route]
            [proj2.middleware :as middleware]))

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
