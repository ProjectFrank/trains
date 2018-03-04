(ns trains.ex5-test
  (:require [trains.ex5 :as ex5]
            [trains.core :as core]
            [trains.fixtures :as fixtures]
            [clojure.test :refer :all]))

(deftest solution-test
  (is (= "NO SUCH ROUTE" (ex5/solution fixtures/adjacency-list))))
