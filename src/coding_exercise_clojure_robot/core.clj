(ns coding-exercise-clojure-robot.core
  (:gen-class))

(def heading {:NORTH { :dx  0  :dy  1  :right :EAST   :left :WEST }
              :EAST  { :dx  1  :dy  0  :right :SOUTH  :left :NORTH }
              :SOUTH { :dx  0  :dy -1  :right :WEST   :left :EAST }
              :WEST  { :dx -1  :dy  0  :right :NORTH  :left :SOUTH }})

(defn place
  "Places the robot on a 5x5 grid"
  [x y f]
  {:x x :y y :f f})

(defn move
  "Moves the robot one cell in the direction it is currently facing"
  [{:keys [x y f]}]
  {:x (+ x (:dx (heading f)))
   :y (+ y (:dy (heading f)))
   :f f})

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
