(ns ozimos.client
  (:require [hato.client :as hc]
            [ozimos.config :refer [config]]
            [mount.core :as mount :refer [defstate]]))

(defstate client :start (hc/build-http-client (:client config)))