(ns proj1.test.db.core
  (:require [proj1.db.core :refer [*db*] :as db]
            [luminus-migrations.core :as migrations]
            [clojure.test :refer :all]
            [clojure.java.jdbc :as jdbc]
            [proj1.config :refer [env]]
            [mount.core :as mount]))

(use-fixtures
  :once
  (fn [f]
    (mount/start
      #'proj1.config/env
      #'proj1.db.core/*db*)
    (migrations/migrate ["migrate"] (env :database-url))
    (f)))

(deftest test-messages
  (jdbc/with-db-transaction [t-conn *db*]
    (jdbc/db-set-rollback-only! t-conn)
    (let [timestamp (java.util.Date.)]
      (is (= 1 (db/save-message!
                 t-conn
                 {:name       "Bob"
                  :message    "Hello World"
                  :timestamp  timestamp}
                 {:connection t-conn})))
      (is (= {:name       "Bob"
              :message    "Hello World"
              :timestamp  timestamp}
             (-> (db/get-messages t-conn {})
                 (first)
                 (select-keys [:name :message :timestamp])))))))
