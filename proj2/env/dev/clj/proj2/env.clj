(ns proj2.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [proj2.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[proj2 started successfully using the development profile]=-"))
   :middleware wrap-dev})
