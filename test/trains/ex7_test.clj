(ns trains.ex7-test
  (:require [trains.ex7 :as ex7]
            [trains.core :as core]
            [trains.fixtures :as fixtures]
            [clojure.test :refer :all]))

(deftest solution-test
  (is (= 3 (ex7/solution fixtures/adjacency-list))))
