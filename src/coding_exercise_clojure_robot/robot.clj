(ns coding-exercise-clojure-robot.robot)

(def move-delta
  "Table of delta moves based on heading"
  {:NORTH { :dx  0  :dy  1 }
   :EAST  { :dx  1  :dy  0 }
   :SOUTH { :dx  0  :dy -1 }
   :WEST  { :dx -1  :dy  0 }})

(def right-of
  "Answer's the question: what's to the right of"
  {:NORTH :EAST
   :EAST  :SOUTH
   :SOUTH :WEST
   :WEST  :NORTH})

(def left-of
  "Answers the question: what's the left of"
  {:NORTH :WEST
   :EAST  :NORTH
   :SOUTH :EAST
   :WEST  :SOUTH})

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
   :f f})

(defn place
  "Places the robot on a 5x5 grid"
  [x y f]
  (guard  {:x x :y y :f f}))

(defn move
  "Moves the robot one cell in the direction it is currently facing"
  [robot]
  (guard  (assoc robot
            :x (+ (:x robot) (:dx (move-delta (:f robot))))
            :y (+ (:y robot) (:dy (move-delta (:f robot)))))))

(defn left
  "Rotate the robot to the left"
  [robot]
  (assoc robot :f (left-of (:f robot))))

(defn right
  "Rotate the robot to the right"
  [robot]
  (assoc robot :f (right-of (:f robot))))

