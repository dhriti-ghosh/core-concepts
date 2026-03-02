package com.coreconcepts.lambdas;

import org.junit.jupiter.api.Test;
import java.util.function.*;
import static org.assertj.core.api.Assertions.*;

class LambdaExamplesTest {

    @Test
    void predicateShouldIdentifyLongStrings() {
        assertThat(LambdaExamples.IS_LONG.test("hi")).isFalse();
        assertThat(LambdaExamples.IS_LONG.test("hello world")).isTrue();
    }

    @Test
    void functionShouldReturnStringLength() {
        assertThat(LambdaExamples.STRING_LENGTH.apply("Java")).isEqualTo(4);
    }

    @Test
    void predicateCompositionWithAnd() {
        Predicate<Integer> isEvenAndPositive = LambdaExamples.IS_EVEN.and(n -> n > 0);
        assertThat(isEvenAndPositive.test(4)).isTrue();
        assertThat(isEvenAndPositive.test(-4)).isFalse();
        assertThat(isEvenAndPositive.test(3)).isFalse();
    }

    @Test
    void functionCompositionWithAndThen() {
        // STRING_LENGTH then SQUARE
        Function<String, Integer> lengthSquared = LambdaExamples.STRING_LENGTH.andThen(LambdaExamples.SQUARE);
        assertThat(lengthSquared.apply("hi")).isEqualTo(4); // length 2, squared = 4
    }

    // TODO: add tests for Supplier, Consumer, BiFunction
}
