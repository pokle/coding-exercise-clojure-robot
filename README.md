# coding-exercise-clojure-robot

This is my solution to the robot simulation coding test in Clojure. See [PROBLEM.MD](PROBLEM.MD)

## Running

You'll need Java and Leiningen installed.

Run 'lein run' with the command file as an argument, like in these examples:

    > lein run test/sample-a.txt
    0,1,NORTH

    > lein run test/sample-b.txt
    0,0,WEST

    > lein run test/sample-c.txt
    3,3,NORTH

## Tests

[![Circle CI](https://circleci.com/gh/pokle/coding-exercise-clojure-robot.png?style=badge)](https://circleci.com/gh/pokle/coding-exercise-clojure-robot)

You can run the unit tests like so:

    > lein midje
    All checks (17) succeeded.


