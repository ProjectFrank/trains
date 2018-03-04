(ns trains.ex6
  (:require [trains.util :as util]))

(defn solution [adjacency-list]
  (count (util/trips-by-num-stops adjacency-list
                                  "C"
                                  "C"
                                  3)))
