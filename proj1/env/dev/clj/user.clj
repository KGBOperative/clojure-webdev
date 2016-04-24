(ns user
  (:require [mount.core :as mount]
            proj1.core))

(defn start []
  (mount/start-without #'proj1.core/repl-server))

(defn stop []
  (mount/stop-except #'proj1.core/repl-server))

(defn restart []
  (stop)
  (start))


