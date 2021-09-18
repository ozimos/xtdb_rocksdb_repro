(ns ozimos.xtdb-rocksdb-repro-test
  (:require [clojure.test :refer [testing deftest is use-fixtures]]
            [ozimos.mock :as m]
            [ozimos.xtdb-rocksdb-repro :as repro]
            [ozimos.helper :as helper]))

(use-fixtures :once (helper/use-mock-api m/mock 7655))
(deftest fetch-data
  (testing "fetch data"
    (is (= {:name "rand"
            :color "blue"
            :size 4} (repro/fetch-data)))))

(deftest store-data
  (testing "Store data in XTDB"
    (is (= {:xt/id :error-repro
            :name "rand"
            :color "blue"
            :size 4} (repro/repro :error-repro)))))
