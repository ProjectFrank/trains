(ns trains.ex10-test
  (:require [trains.ex10 :as ex10]
            [trains.fixtures :as fixtures]
            [clojure.test :refer :all]))

(deftest solution-test
  (is (= 7 (ex10/solution fixtures/adjacency-list))))
