(ns trains.core
  (:gen-class)
  (:require [clojure.string :as string]
            [trains.ex1 :as ex1]
            [trains.ex2 :as ex2]
            [trains.ex3 :as ex3]
            [trains.ex4 :as ex4]
            [trains.ex5 :as ex5]
            [trains.ex6 :as ex6]
            [trains.ex7 :as ex7]
            [trains.ex8 :as ex8]
            [trains.ex9 :as ex9]
            [trains.ex10 :as ex10]))

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

(defn parse-input [standardized-input]
  (adjacency-list (map edge (string/split standardized-input #",\s*"))))

(defn standardize-input [input]
  (string/join " " input))

(defn report [input]
  (let [graph (-> input
                  standardize-input
                  parse-input)
        solutions [(ex1/solution graph)
                   (ex2/solution graph)
                   (ex3/solution graph)
                   (ex4/solution graph)
                   (ex5/solution graph)
                   (ex6/solution graph)
                   (ex7/solution graph)
                   (ex8/solution graph)
                   (ex9/solution graph)
                   (ex10/solution graph)]]
    (->> solutions
         (map (fn [exercise-number solution]
                (format "Output #%s: %s"
                        exercise-number
                        solution))
              (rest (range)))
         (string/join "\n"))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (report args)))
