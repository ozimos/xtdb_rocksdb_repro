(ns ozimos.mock
  (:require [stub-http.core :refer [start!]]
            [cheshire.core :as json]))

(defn mock [port]
  (start! {:port port} {"/api" {:status 200 :body (json/encode {:name "rand"
                                                                :color "blue"
                                                                :size 4})}}))