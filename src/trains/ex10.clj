(ns trains.ex10
  (:require [trains.util :as util]))

(defn solution [adjacency-list]
  (count (util/trips-by-max-length adjacency-list
                                   "C"
                                   "C"
                                   30)))
