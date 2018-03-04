(ns trains.ex1-test
  (:require [clojure.test :refer :all]
            [trains.ex1 :as ex1]
            [trains.fixtures :as fixtures]))

(deftest ex1-test
  (is (= 9 (ex1/solution fixtures/adjacency-list))))
