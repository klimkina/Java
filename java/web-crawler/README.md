# Readme

usage:

    $ # compile the main files like this
    $ mvn compile
    $ # compile the main files and test files like this
    $ mvn test
    $ # then run the tests (after compiling the test files) like this
    $ mvn exec:java -Dexec.mainClass="com.company.already_passing.AlreadyPassingTests" -Dexec.classpathScope="test"
    $ # To run the first failing test, do:
    $ mvn exec:java -Dexec.mainClass="com.company.failing_tests.FailingTest1" -Dexec.classpathScope="test"
