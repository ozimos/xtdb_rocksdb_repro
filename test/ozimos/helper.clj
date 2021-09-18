(ns ozimos.helper
  (:require [mount.core :as mount :refer [with-args]]))

(declare ^:dynamic *stub-server*)
(defn use-mock-api
  [server-fn port]
  (fn [test-fn]
    (binding [*stub-server* (server-fn port)]
      (try
        (-> (with-args {:profile :test}) (mount/start))
        (test-fn)
        (mount/stop)
        (finally
          (.close *stub-server*))))))
