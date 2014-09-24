(ns coding-exercise-clojure-robot.core
  (:use coding-exercise-clojure-robot.robot))

(defn convert-and-place
  "Calls robot/place after converting the string arguments to the right types"
  [[_ x y f]]
  (place (Integer/parseInt x) (Integer/parseInt y) (keyword f)))

(defn report [robot]
  "Where's that pesky robot now?"
  (printf "%d,%d,%s\n" (:x robot) (:y robot) (name (:f robot)))
  robot)

(defn simul-line
  "Parses line by line, invoking commands on the robot"
  [lines robot]
  (let [line (first lines)]
    (when line
      (recur (next lines)
             (condp re-find line
               #"PLACE +(\d+) *, *(\d+) *, *([A-Z]+)" :>> convert-and-place
               #"MOVE"   (when robot (move robot))
               #"RIGHT"  (when robot (right robot))
               #"LEFT"   (when robot (left robot))
               #"REPORT" (when robot (report robot))
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


