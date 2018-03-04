(ns trains.ex9
  (:require [trains.dijkstra-shortest-path :as dsp]))

(defn solution [adjacency-list]
  (dsp/shortest-path-length adjacency-list "B" "B"))
