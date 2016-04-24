(ns proj1.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [proj1.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[proj1 started successfully using the development profile]=-"))
   :middleware wrap-dev})
