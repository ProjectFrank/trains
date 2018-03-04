(ns trains.ex8-test
  (:require [trains.ex8 :as ex8]
            [trains.fixtures :as fixtures]
            [clojure.test :refer :all]))

(deftest solution-test
  (is (= 9 (ex8/solution fixtures/adjacency-list))))
