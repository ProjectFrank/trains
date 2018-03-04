(ns trains.fixtures
  (:require [trains.core :as core]))

(def adjacency-list (core/parse-input "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7"))
