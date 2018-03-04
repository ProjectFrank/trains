(ns trains.ex9-test
  (:require [trains.ex9 :as ex9]
            [trains.fixtures :as fixtures]
            [clojure.test :refer :all]))

(deftest solution-test
  (is (= 9 (ex9/solution fixtures/adjacency-list))))
