# coding-exercise-clojure-robot

This is my solution to the robot simulation coding test in Clojure. See [PROBLEM.MD](PROBLEM.MD)

## Running

You'll need Java and Leiningen installed.

Run 'lein run' with the command file as an argument, like in these examples:

    > lein run test/sample-a.txt
    {:x 0, :y 1, :f :NORTH}

    > lein run test/sample-b.txt
    {:x 0, :y 0, :f :WEST}

    > lein run test/sample-c.txt
    {:x 3, :y 3, :f :NORTH}

## Tests

[![Circle CI](https://circleci.com/gh/pokle/coding-exercise-clojure-robot.png?style=badge)](https://circleci.com/gh/pokle/coding-exercise-clojure-robot)

You can run the unit tests like so:

    > lein midje
    All checks (17) succeeded.


