(ns trains.ex2-test
  (:require [trains.ex2 :as ex2]
            [trains.core :as core]
            [trains.fixtures :as fixtures]
            [clojure.test :refer :all]))

(deftest solution-test
  (is (= 5 (ex2/solution fixtures/adjacency-list))))
