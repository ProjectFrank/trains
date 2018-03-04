(ns trains.util
  (:require [clojure.string :as string]
            [clojure.set :as set]))

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

(defn trips-by-num-stops
  [adjacency-list start destination maximum-stops]
  (letfn [(helper [paths current-path]
            (let [last-node (last current-path)
                  num-stops (dec (count current-path))]
              (cond
                (and (= destination last-node)
                     (<= 1 num-stops))
                (conj paths current-path)
                
                (<= maximum-stops num-stops)
                #{}

                :else
                (let [next-nodes (keys (get adjacency-list last-node))]
                  (reduce set/union
                          (map (fn [next-node]
                                 (helper #{} (conj current-path next-node)))
                               next-nodes))))))]
    (helper #{} [start])))
