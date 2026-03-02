package com.coreconcepts.streams;

import java.util.*;
import java.util.stream.*;

/**
 * Playground for Stream API - Java 8
 *
 * Key concepts to explore:
 * - Intermediate ops: filter, map, flatMap, distinct, sorted, peek, limit, skip
 * - Terminal ops:    collect, reduce, count, findFirst, anyMatch, allMatch, noneMatch, forEach
 * - Collectors:      toList, toSet, groupingBy, partitioningBy, joining, counting, summarizingInt
 * - Parallel streams
 * - Primitive streams: IntStream, LongStream, DoubleStream
 */
public class StreamExamples {

    static List<String> words = Arrays.asList("apple", "banana", "cherry", "avocado", "blueberry", "apricot");
    static List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public static void filterAndMap() {
        // TODO: filter words starting with 'a', uppercase them, sort, collect to list
        List<String> result = words.stream()
                .filter(w -> w.startsWith("a"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(result);
    }

    public static void groupingExample() {
        // TODO: group words by their first character
        Map<Character, List<String>> grouped = words.stream()
                .collect(Collectors.groupingBy(w -> w.charAt(0)));
        System.out.println(grouped);
    }

    public static void reduceExample() {
        // TODO: sum numbers using reduce, compare to IntStream.sum()
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);
    }

    public static void flatMapExample() {
        // TODO: flatten a list of lists
        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );
        List<Integer> flat = nested.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(flat);
    }

    public static void main(String[] args) {
        filterAndMap();
        groupingExample();
        reduceExample();
        flatMapExample();
    }
}
