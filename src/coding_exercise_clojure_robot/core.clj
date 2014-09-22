(ns coding-exercise-clojure-robot.core
  (:gen-class))

(def heading {:NORTH { :dx  0  :dy  1  :right :EAST   :left :WEST }
              :EAST  { :dx  1  :dy  0  :right :SOUTH  :left :NORTH }
              :SOUTH { :dx  0  :dy -1  :right :WEST   :left :EAST }
              :WEST  { :dx -1  :dy  0  :right :NORTH  :left :SOUTH }})


(defn clamp
  "Ensures that value remains within the bounds of min and max"
  [min value max]
  (cond
   (< value min) min
   (> value max) max
   :else value))

(defn guard
  "Ensures that the robot does not fall off the grid"
  [{:keys [x y f]}]
  {:x (clamp 0 x 4)
   :y (clamp 0 y 4)
   :f f}
  )

(defn place
  "Places the robot on a 5x5 grid"
  [x y f]
  (guard  {:x x :y y :f f}))

(defn move
  "Moves the robot one cell in the direction it is currently facing"
  [{:keys [x y f]}]
  (guard  {:x (+ x (:dx (heading f)))
           :y (+ y (:dy (heading f)))
           :f f}))

(defn left
  "Rotate the robot to the left"
  [{:keys [x y f]}]
  {:x x
   :y y
   :f (:left (heading f))}
  )

(defn right
  "Rotate the robot to the right"
  [{:keys [x y f]}]
  {:x x
   :y y
   :f (:right (heading f))}
  )

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
