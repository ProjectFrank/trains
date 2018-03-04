(ns trains.ex4-test
  (:require [trains.ex4 :as ex4]
            [trains.core :as core]
            [trains.fixtures :as fixtures]
            [clojure.test :refer :all]))

(deftest solution-test
  (is (= 22 (ex4/solution fixtures/adjacency-list))))
