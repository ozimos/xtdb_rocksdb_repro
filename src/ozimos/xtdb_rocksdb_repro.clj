(ns ozimos.xtdb-rocksdb-repro
  (:require [ozimos.xtdb :as xtdb]
            [xtdb.api :as xt]
            [hato.client :as hc]
            [ozimos.client :refer [client]]
            [mount.core :as mount]))

(set! *warn-on-reflection* true)

(defn repro [eid] 
  (let [res (:body (hc/get "http://localhost:7655/api" {:client client :as :json}))
        tx (xt/submit-tx xtdb/xtdb [[::xt/put (assoc res :xt/id eid)]])]
    (xt/await-tx xtdb/xtdb tx)
    (xt/entity (xt/db xtdb/xtdb) eid)))

(defn fetch-data []
   (:body (hc/get "http://localhost:7655/api" {:client client :as :json})))



(comment
  (mount/start)
  (mount/stop)
  )
