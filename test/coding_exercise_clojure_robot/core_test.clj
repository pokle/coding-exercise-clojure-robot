(ns coding-exercise-clojure-robot.core-test
  (:require [midje.sweet :refer :all]
            [coding-exercise-clojure-robot.core :refer :all]))


(fact "Robots can be placed"

      (place 3 2 :NORTH) => { :x 3 :y 2 :f :NORTH }
      
      )

(fact "Robots can be moved"

      (->> (place 0 0 :NORTH) (move)) => { :x 0 :y 1 :f :NORTH }

      )

(fact "Robots don't fall off the table")
