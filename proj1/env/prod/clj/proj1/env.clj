(ns proj1.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[proj1 started successfully]=-"))
   :middleware identity})
