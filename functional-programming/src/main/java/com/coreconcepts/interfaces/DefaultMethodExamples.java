package com.coreconcepts.interfaces;

/**
 * Playground for Default & Static Interface Methods - Java 8
 *
 * Key concepts to explore:
 * - default methods (can be overridden)
 * - static methods on interfaces
 * - Resolving diamond problem with default methods
 */
public class DefaultMethodExamples {

    @FunctionalInterface
    interface Greeter {
        String greet(String name); // abstract

        default String greetLoudly(String name) {
            return greet(name).toUpperCase();
        }

        static Greeter formal() {
            return name -> "Good day, " + name + ".";
        }
    }

    interface Farewell {
        default String sayBye(String name) {
            return "Goodbye, " + name + "!";
        }
    }

    static class FriendlyGreeter implements Greeter, Farewell {
        @Override
        public String greet(String name) {
            return "Hey, " + name + "!";
        }
    }

    public static void main(String[] args) {
        Greeter lambda = name -> "Hello, " + name + "!";
        System.out.println(lambda.greet("World"));
        System.out.println(lambda.greetLoudly("World"));
        System.out.println(Greeter.formal().greet("Sir"));

        FriendlyGreeter fg = new FriendlyGreeter();
        System.out.println(fg.greet("Alice"));
        System.out.println(fg.sayBye("Alice"));

        // TODO: create your own @FunctionalInterface and use it as a lambda
        // TODO: explore what happens when two interfaces have the same default method
    }
}
