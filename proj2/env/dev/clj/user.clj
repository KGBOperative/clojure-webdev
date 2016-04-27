(ns user
  (:require [mount.core :as mount]
            proj2.core))

(defn start []
  (mount/start-without #'proj2.core/repl-server))

(defn stop []
  (mount/stop-except #'proj2.core/repl-server))

(defn restart []
  (stop)
  (start))


