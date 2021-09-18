(ns ozimos.xtdb-rocksdb-repro
  (:require [ozimos.xtdb :as xtdb]
            [xtdb.api :as xt]
            [hato.client :as hc]
            [crypticbutter.snoop :as snoop :refer [>defn =>]]
            [ozimos.client :refer [client]]))

(set! *warn-on-reflection* true)

(def SampleResponse [:map 
                     [:xt/id keyword?]
                     [:color string?]
                     [:name string?]
                     [:size int?]])
(>defn repro
       {::snoop/macro-config {:log-fn-sym 'taoensso.timbre/error}}
       [eid]
       [keyword? => SampleResponse]
       (let [res (:body (hc/get "http://localhost:7655/api" {:client client :as :json}))
             tx (xt/submit-tx xtdb/xtdb [[::xt/put (assoc res :xt/id eid)]])]
         (xt/await-tx xtdb/xtdb tx)
         (xt/entity (xt/db xtdb/xtdb) eid)))

(defn fetch-data []
   (:body (hc/get "http://localhost:7655/api" {:client client :as :json})))



