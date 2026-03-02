package com.coreconcepts.optional;

import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.assertj.core.api.Assertions.*;

class OptionalExamplesTest {

    @Test
    void shouldReturnUserWhenFound() {
        Optional<String> user = OptionalExamples.findUserById(1);
        assertThat(user).isPresent().contains("Alice");
    }

    @Test
    void shouldReturnEmptyWhenNotFound() {
        Optional<String> user = OptionalExamples.findUserById(99);
        assertThat(user).isEmpty();
    }

    @Test
    void shouldChainFlatMap() {
        String email = OptionalExamples.findUserById(1)
                .flatMap(OptionalExamples::findEmailByName)
                .orElse("none");
        assertThat(email).isEqualTo("alice@example.com");
    }

    @Test
    void shouldMapValueInsideOptional() {
        Optional<Integer> nameLength = OptionalExamples.findUserById(1)
                .map(String::length);
        assertThat(nameLength).isPresent().contains(5);
    }

    // TODO: test Optional.ofNullable with null
    // TODO: test orElseGet with a Supplier
    // TODO: test orElseThrow
}
