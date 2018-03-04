(ns trains.util-test
  (:require [trains.util :as util]
            [trains.fixtures :as fixtures]
            [clojure.test :refer :all]))

(deftest trips-by-num-stops-test
  (is (= #{["C" "D" "C"]
           ["C" "E" "B" "C"]}
         (util/trips-by-num-stops fixtures/adjacency-list
                                  "C"
                                  "C"
                                  3)))
  (is (= #{["A" "B" "C" "D" "C"]
           ["A" "D" "C" "D" "C"]
           ["A" "D" "E" "B" "C"]}
         (util/trips-by-num-stops fixtures/adjacency-list
                                  "A"
                                  "C"
                                  4
                                  4))))
