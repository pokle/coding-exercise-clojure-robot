(ns coding-exercise-clojure-robot.core
  (:use coding-exercise-clojure-robot.robot)
  (:gen-class))


(defn simul-line
  "Parses line by line, invoking commands on the robot"
  [lines robot]
  (let [line (first lines)]
    (if line
      (recur (next lines)
             (condp re-find line
               #"PLACE +(\d+),(\d+),([A-Z]+)" :>> (fn [[ m x y f]]
                                                    (place (Integer/parseInt  x)
                                                           (Integer/parseInt y)
                                                           (keyword f)))
               #"MOVE"   (move robot)
               #"RIGHT"  (right robot)
               #"LEFT"   (left robot)
               #"REPORT" (do (println robot) robot)
               robot ; ignore all else
               )))))


(defn simulate-from-file
  "Runs a robot simulation, taking commands from a file"
  [filename]
  (with-open [rdr (clojure.java.io/reader filename)]
    (simul-line (line-seq rdr) nil)))


(defn -main
  [filename]
  (simulate-from-file filename))
