(ns trains.ex7
  (:require [trains.util :as util]))

(defn solution [adjacency-list]
  (count (util/trips-by-num-stops adjacency-list
                                  "A"
                                  "C"
                                  4
                                  4)))
