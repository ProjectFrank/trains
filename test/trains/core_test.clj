(ns trains.core-test
  (:require [clojure.test :refer :all]
            [trains.core :as core]))

(deftest edge-test
  (is (= {:head "B", :length 5, :tail "A"}
         (core/edge "AB5"))))

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
         (core/parse-input "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7"))))

(deftest report-test
  (is (= "Output #1: 9\nOutput #2: 5\nOutput #3: 13\nOutput #4: 22\nOutput #5: NO SUCH ROUTE\nOutput #6: 2\nOutput #7: 3\nOutput #8: 9\nOutput #9: 9\nOutput #10: 7"
         (core/report (list "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7"))))
  (is (= "Output #1: 9\nOutput #2: 5\nOutput #3: 13\nOutput #4: 22\nOutput #5: NO SUCH ROUTE\nOutput #6: 2\nOutput #7: 3\nOutput #8: 9\nOutput #9: 9\nOutput #10: 7"
         (core/report (list "AB5," "BC4," "CD8," "DC8," "DE6," "AD5," "CE2," "EB3," "AE7")))))
