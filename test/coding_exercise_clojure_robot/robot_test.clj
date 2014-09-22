(ns coding-exercise-clojure-robot.robot-test
  (:require [midje.sweet :refer :all]
            [coding-exercise-clojure-robot.robot :refer :all]))

(fact "Robots can be placed"

      (place 3 2 :NORTH) => { :x 3 :y 2 :f :NORTH }
      
      )

(fact "Robots can be moved"

      (->> (place 0 0 :NORTH) (move)) => { :x 0 :y 1 :f :NORTH }

      )

(fact "Robots can rotate left"

      (->> (place 0 0 :NORTH) (left)) => {:x 0 :y 0 :f :WEST}
      (->> (place 0 0 :EAST)  (left)) => {:x 0 :y 0 :f :NORTH}
      (->> (place 0 0 :SOUTH) (left)) => {:x 0 :y 0 :f :EAST}
      (->> (place 0 0 :WEST)  (left)) => {:x 0 :y 0 :f :SOUTH}

      )

(fact "Robots can rotate right"

      (->> (place 0 0 :NORTH) (right)) => {:x 0 :y 0 :f :EAST}
      (->> (place 0 0 :EAST)  (right)) => {:x 0 :y 0 :f :SOUTH}
      (->> (place 0 0 :SOUTH) (right)) => {:x 0 :y 0 :f :WEST}
      (->> (place 0 0 :WEST)  (right)) => {:x 0 :y 0 :f :NORTH}

      )

(fact "Clamp"
      (clamp 0 1 4) => 1
      (clamp 0 -1 4) => 0
      (clamp 0 5 4) => 4
      )

(fact "Robots can't be placed off the table"

      (place -1 -1 :NORTH) => {:x 0 :y 0 :f :NORTH}
      (place 55 55 :NORTH) => {:x 4 :y 4 :f :NORTH}

      )

(fact "Robots don't move off the table"

      (->> (place 0 0 :SOUTH) (move)) => {:x 0 :y 0 :f :SOUTH}
      (->> (place 4 4 :NORTH) (move)) => {:x 4 :y 4 :f :NORTH}
      
      )


