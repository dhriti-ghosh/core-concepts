# Functional Programming – Java 8 Playground

A structured sandbox to explore Java 8's functional programming features.

## Structure

```
functional-programming/
├── pom.xml
└── src/
    ├── main/java/com/coreconcepts/
    │   ├── lambdas/          → Lambda expressions, functional interfaces
    │   ├── streams/          → Stream API (filter, map, reduce, collect, etc.)
    │   ├── optional/         → Optional type
    │   ├── datetime/         → New Date/Time API (java.time.*)
    │   └── interfaces/       → Default & static interface methods
    └── test/java/com/coreconcepts/
        ├── lambdas/
        ├── streams/
        └── optional/
```

## Topics Covered

| Package        | Java 8 Feature                              |
|----------------|---------------------------------------------|
| `lambdas`      | Lambdas, `Function`, `Predicate`, `Consumer`, `Supplier`, `BiFunction`, method references |
| `streams`      | `Stream` API — intermediate & terminal ops, `Collectors`, parallel streams |
| `optional`     | `Optional` — map, flatMap, filter, orElse   |
| `datetime`     | `LocalDate`, `LocalDateTime`, `ZonedDateTime`, `Duration`, `Period`, `Instant` |
| `interfaces`   | Default methods, static interface methods, `@FunctionalInterface` |

## Getting Started

```bash
cd functional-programming
mvn test          # run all tests
mvn compile       # compile only
```

## How to Use

Each class is a self-contained playground:
- `main()` methods you can run directly
- `// TODO` comments suggest things to try
- Matching test classes with starter assertions

The tests use **JUnit 5** + **AssertJ** for expressive, fluent assertions.
