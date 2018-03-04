(ns trains.ex3-test
  (:require [trains.ex3 :as ex3]
            [trains.core :as core]
            [trains.fixtures :as fixtures]
            [clojure.test :refer :all]))

(deftest solution-test
  (is (= 13 (ex3/solution fixtures/adjacency-list))))
