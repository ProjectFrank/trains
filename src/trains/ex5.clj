(ns trains.ex5
  (:require [trains.util :as util]))

(defn solution [adjacency-list]
  (let [result (util/route-cost adjacency-list ["A" "E" "D"])]
    (if (= result :no-route)
      "NO SUCH ROUTE"
      result)))
