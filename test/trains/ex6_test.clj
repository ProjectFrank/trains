(ns trains.ex6-test
  (:require [trains.ex6 :as ex6]
            [trains.core :as core]
            [trains.fixtures :as fixtures]
            [clojure.test :refer :all]))

(deftest solution-test
  (is (= 2 (ex6/solution fixtures/adjacency-list))))
