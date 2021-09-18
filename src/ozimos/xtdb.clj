(ns ozimos.xtdb
  (:require [xtdb.api :as xt]
            [ozimos.config :refer [config]]
            [mount.core :as mount :refer [defstate]]))

(defn start-xtdb
  []
  (-> config
      :xtdb
      xt/start-node))

(defstate xtdb :start (start-xtdb)
  :stop (when (not (keyword? xtdb)) (.close xtdb)))


