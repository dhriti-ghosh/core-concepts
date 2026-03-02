package com.coreconcepts.lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

/**
 * Playground for Lambda Expressions - Java 8
 *
 * Key concepts to explore:
 * - Functional interfaces (Function, Predicate, Consumer, Supplier, BiFunction, etc.)
 * - Method references (static, instance, constructor)
 * - Lambda syntax variations
 */
public class LambdaExamples {

    // --- Predicate: takes one arg, returns boolean ---
    public static final Predicate<String> IS_LONG = s -> s.length() > 5;
    public static final Predicate<Integer> IS_EVEN = n -> n % 2 == 0;

    // --- Function: takes one arg, returns a result ---
    public static final Function<String, Integer> STRING_LENGTH = String::length; // method reference
    public static final Function<Integer, Integer> SQUARE = n -> n * n;

    // --- Consumer: takes one arg, returns nothing ---
    public static final Consumer<String> PRINT = System.out::println;

    // --- Supplier: takes no args, returns a result ---
    public static final Supplier<List<String>> EMPTY_LIST = () -> Arrays.asList("default");

    // --- BiFunction: takes two args, returns a result ---
    public static final BiFunction<String, Integer, String> REPEAT = (s, n) -> s.repeat(n);

    // --- Comparator as lambda ---
    public static final Comparator<String> BY_LENGTH = Comparator.comparingInt(String::length);

    public static void main(String[] args) {
        // TODO: Try composing predicates with .and(), .or(), .negate()
        // TODO: Try composing functions with .andThen(), .compose()
        // TODO: Experiment with UnaryOperator, BinaryOperator

        System.out.println(IS_LONG.test("hello"));
        System.out.println(STRING_LENGTH.apply("Java 8"));
        PRINT.accept("Lambda works!");
    }
}
