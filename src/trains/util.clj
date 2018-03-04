(ns trains.util
  (:require [clojure.string :as string]))

(defn route-edges [route-vec]
  (partition 2 1 route-vec))

(defn route-cost
  "Takes an adjacency-list and a route vector and returns the cost of
  traveling that route or :no-route if such a route cannot be traveled
  in the given graph."
  [adjacency-list route]
  (reduce (fn [cost [tail head :as edge]]
            (if (= cost :no-route)
              cost
              (let [edge-length (get-in adjacency-list
                                        [tail head :length]
                                        :no-route)]
                (if (= edge-length :no-route)
                  edge-length
                  (+ cost edge-length)))))
          0
          (route-edges route)))
