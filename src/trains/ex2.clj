(ns trains.ex2
  (:require [trains.util :as util]))

(defn solution [adjacency-list]
  (util/route-cost adjacency-list ["A" "D"]))
