(ns trains.ex4
  (:require [trains.util :as util]))

(defn solution [adjacency-list]
  (util/route-cost adjacency-list ["A" "E" "B" "C" "D"]))
