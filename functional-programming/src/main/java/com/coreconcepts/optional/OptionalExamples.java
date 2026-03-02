package com.coreconcepts.optional;

import java.util.Optional;

/**
 * Playground for Optional - Java 8
 *
 * Key concepts to explore:
 * - Creating: Optional.of(), Optional.ofNullable(), Optional.empty()
 * - Consuming: get(), orElse(), orElseGet(), orElseThrow()
 * - Transforming: map(), flatMap(), filter()
 * - Checking: isPresent(), ifPresent()
 */
public class OptionalExamples {

    static Optional<String> findUserById(int id) {
        if (id == 1) return Optional.of("Alice");
        return Optional.empty();
    }

    static Optional<String> findEmailByName(String name) {
        if ("Alice".equals(name)) return Optional.of("alice@example.com");
        return Optional.empty();
    }

    public static void main(String[] args) {
        // Basic usage
        Optional<String> user = findUserById(1);
        System.out.println(user.orElse("Unknown"));

        // Chaining with flatMap
        String email = findUserById(1)
                .flatMap(OptionalExamples::findEmailByName)
                .orElse("no-email@example.com");
        System.out.println(email);

        // TODO: try .map() to transform the value inside Optional
        // TODO: try .filter() to conditionally keep the value
        // TODO: try Optional.ofNullable() with a null value
    }
}
