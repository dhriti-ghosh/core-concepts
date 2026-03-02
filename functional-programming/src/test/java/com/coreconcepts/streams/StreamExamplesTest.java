package com.coreconcepts.streams;

import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;
import static org.assertj.core.api.Assertions.*;

class StreamExamplesTest {

    @Test
    void shouldFilterAndMapWords() {
        List<String> words = Arrays.asList("apple", "banana", "avocado", "cherry");
        List<String> result = words.stream()
                .filter(w -> w.startsWith("a"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        assertThat(result).containsExactly("APPLE", "AVOCADO");
    }

    @Test
    void shouldGroupByFirstChar() {
        List<String> words = Arrays.asList("apple", "avocado", "banana");
        Map<Character, List<String>> grouped = words.stream()
                .collect(Collectors.groupingBy(w -> w.charAt(0)));
        assertThat(grouped.get('a')).containsExactlyInAnyOrder("apple", "avocado");
        assertThat(grouped.get('b')).containsExactly("banana");
    }

    @Test
    void shouldReduceToSum() {
        int sum = IntStream.rangeClosed(1, 10).sum();
        assertThat(sum).isEqualTo(55);
    }

    @Test
    void shouldFlatMapNestedLists() {
        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4)
        );
        List<Integer> flat = nested.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        assertThat(flat).containsExactly(1, 2, 3, 4);
    }

    // TODO: write a test for partitioningBy
    // TODO: write a test for Collectors.joining
    // TODO: write a test for parallel stream
}
