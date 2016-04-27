(ns proj2.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[proj2 started successfully]=-"))
   :middleware identity})
