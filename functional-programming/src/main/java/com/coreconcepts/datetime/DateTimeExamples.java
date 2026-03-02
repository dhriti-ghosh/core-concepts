package com.coreconcepts.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Playground for the new Date/Time API - Java 8
 *
 * Key classes to explore:
 * - LocalDate, LocalTime, LocalDateTime  (no timezone)
 * - ZonedDateTime, ZoneId               (with timezone)
 * - Instant                             (machine time / epoch)
 * - Duration, Period                    (amounts of time)
 * - DateTimeFormatter                   (formatting / parsing)
 */
public class DateTimeExamples {

    public static void main(String[] args) {
        // --- LocalDate ---
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1995, Month.JUNE, 15);
        long age = ChronoUnit.YEARS.between(birthday, today);
        System.out.println("Age: " + age);

        // --- LocalDateTime ---
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Now: " + now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));

        // --- ZonedDateTime ---
        ZonedDateTime istNow = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("IST: " + istNow);

        // --- Duration ---
        LocalTime start = LocalTime.of(9, 0);
        LocalTime end = LocalTime.of(17, 30);
        Duration workday = Duration.between(start, end);
        System.out.println("Workday hours: " + workday.toHours());

        // TODO: try Period to find days/months between two LocalDates
        // TODO: try Instant.now() and convert to ZonedDateTime
        // TODO: try parsing a date string with DateTimeFormatter
    }
}
