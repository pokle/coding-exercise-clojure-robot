(defproject coding-exercise-clojure-robot "0.1.0-SNAPSHOT"
  :description "A coding exercise to simulate a robot"
  :url "https://github.com/pokle/coding-exercise-clojure-robot"
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :main ^:skip-aot coding-exercise-clojure-robot.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
