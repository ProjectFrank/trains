(ns trains.dijkstra-shortest-path
  "Variant on dijkstra's shortest path algorithm where we may also
  compute the shortest path from a node back to itself.")

(defn edges [adjacency-list]
  (mapcat vals
          (vals adjacency-list)))

(defn frontier
  "Returns a list of edges where the shortest-distance has been
  computed for the tail but not the head.

  Unlike the regular dijkstra's shortest path algorithm, an edge is
  considered to be a frontier edge if its head is the `from` node and
  the length of the shortest path for the `from` node back to itself
  has thus far been computed as 0."
  [shortest-distances from edges]
  (filter (fn [{:keys [tail head]}]
            (and (contains? shortest-distances tail)
                 (or (not (contains? shortest-distances head))
                     (and (= from head)
                          (zero? (get shortest-distances from))))))
          edges))

(defn greedy-score [shortest-distances {:keys [length tail] :as edge}]
  (let [shortest-path-distance-to-tail (get shortest-distances tail)]
    (+ shortest-path-distance-to-tail length)))

(defn edge-with-minimum-greedy-score
  "Returns a tuple of edge and greedy score."
  [shortest-distances frontier-edges]
  (let [edges->scores (zipmap frontier-edges
                              (map (partial greedy-score shortest-distances)
                                   frontier-edges))]
    (->> edges->scores
         (reduce (fn [[best-edge best-score :as best-entry]
                       [prospective-edge prospective-score :as prospective-entry]]
                   (if (< prospective-score best-score)
                     prospective-entry
                     best-entry))))))

(defn shortest-path-length [adjacency-list from destination]
  (let [edges (edges adjacency-list)]
    (loop [shortest-distances {from 0}]
      (let [frontier-edges (frontier shortest-distances from edges)]
        (if (or (and (contains? shortest-distances destination)
                     (not= 0 (get shortest-distances destination)))
                (empty? frontier-edges))
          (get shortest-distances destination)
          (let [[best-edge best-score] (edge-with-minimum-greedy-score shortest-distances
                                                                       frontier-edges)]
            (recur (assoc shortest-distances
                          (:head best-edge)
                          best-score))))))))
