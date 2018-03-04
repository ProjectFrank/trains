(ns trains.core-test
  (:require [clojure.test :refer :all]
            [trains.core :as trains]))

(deftest edge-test
  (is (= {:head "B", :length 5, :tail "A"}
         (trains/edge "AB5"))))

(deftest parse-input-test
  (is (= {"A"
          {"B" {:head "B", :length 5, :tail "A"}
           "D" {:head "D", :length 5, :tail "A"}
           "E" {:head "E", :length 7, :tail "A"}}
          "B"
          {"C" {:head "C", :length 4, :tail "B"}}
          "C"
          {"D" {:head "D", :length 8, :tail "C"}
           "E" {:head "E", :length 2, :tail "C"}}
          "D"
          {"C" {:head "C", :length 8, :tail "D"}
           "E" {:head "E", :length 6, :tail "D"}}
          "E"
          {"B" {:head "B", :length 3, :tail "E"}}}
         (trains/parse-input "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7"))))
