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
  ([adjacency-list start destination maximum-stops]
   (trips-by-num-stops adjacency-list
                       start
                       destination
                       1
                       maximum-stops))
  ([adjacency-list start destination minimum-stops maximum-stops]
   (letfn [(helper [paths current-path]
             (let [last-node (last current-path)
                   num-stops (dec (count current-path))]
               (cond
                 (and (= destination last-node)
                      (<= minimum-stops num-stops))
                 (conj paths current-path)
                 
                 (<= maximum-stops num-stops)
                 #{}

                 :else
                 (let [next-nodes (keys (get adjacency-list last-node))]
                   (reduce set/union
                           (map (fn [next-node]
                                  (helper #{} (conj current-path next-node)))
                                next-nodes))))))]
     (helper #{} [start]))))

(defn trips-by-max-length [adjacency-list start destination max-length]
  (letfn [(helper [paths current-path current-path-length]
            (let [last-node (last current-path)]
              (if (<= max-length current-path-length)
                #{}
                (let [next-nodes (keys (get adjacency-list last-node))
                      more-paths (reduce set/union
                                         (map (fn [next-node]
                                                (helper #{}
                                                        (conj current-path
                                                              next-node)
                                                        (+ current-path-length
                                                           (get-in adjacency-list
                                                                   [last-node
                                                                    next-node
                                                                    :length]))))
                                              next-nodes))]
                  (if (and (= destination last-node)
                           (not= 1 (count current-path))
                           (<= current-path-length max-length))
                    (conj more-paths current-path)
                    more-paths)))))]
    (helper #{} [start] 0)))
