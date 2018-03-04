(ns trains.core
  (:gen-class)
  (:require [clojure.string :as string]))

(defn edge [str]
  (let [[tail head length] (string/split str #"")]
    {:head head
     :tail tail
     :length (Integer/parseInt length)}))

(defn adjacency-list [edges]
  (->> edges
       (group-by :tail)
       (map (fn [[k v]]
                [k (->> v
                        (map (juxt :head identity))
                        (into {}))]))
       (into {})))

(defn parse-input [input]
  (adjacency-list (map edge (string/split input #",\s?"))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
