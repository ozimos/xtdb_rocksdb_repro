(ns ozimos.config
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]
            [aero.core :as aero]
            [mount.core :as mount :refer [defstate]]))


(set! *warn-on-reflection* true)
(defn load-config
  []
  (-> "config.edn"
      io/resource
      (aero/read-config (mount/args))))

(defstate config :start (load-config))

(comment
  
  (mount/start)
  )