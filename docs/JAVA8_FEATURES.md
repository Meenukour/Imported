# Java 8 Features - Quick Reference Guide

## 📋 Overview

This guide covers the Java 8 features implemented in this repository, including lambda expressions, functional interfaces, and streams. These features enable functional programming patterns in Java.

## 🔧 Functional Interfaces

### 1. Predicate&lt;T&gt; - Boolean Testing
**File**: `PredicateFunctionalInterface.java`

```java
// Tests if input satisfies a condition
Predicate<String> isEmpty = String::isEmpty;
Predicate<Integer> isEven = x -> x % 2 == 0;

// Usage examples
boolean result = isEmpty.test(""); // true
boolean even = isEven.test(4);     // true

// Combining predicates
Predicate<String> isLong = s -> s.length() > 5;
Predicate<String> combined = isEmpty.or(isLong);
```

**Key Methods:**
- `test(T t)` - Evaluates predicate on input
- `and(Predicate<T> other)` - Logical AND
- `or(Predicate<T> other)` - Logical OR
- `negate()` - Logical NOT

### 2. Function&lt;T,R&gt; - Transformation
**File**: `FunctionFunctionalInterface.java`

```java
// Transforms input to different type/value
Function<String, Integer> stringLength = String::length;
Function<Integer, String> intToString = Object::toString;

// Usage examples
Integer length = stringLength.apply("Hello"); // 5
String str = intToString.apply(42);           // "42"

// Function composition
Function<String, String> lengthToString = stringLength.andThen(intToString);
String result = lengthToString.apply("Java"); // "4"
```

**Key Methods:**
- `apply(T t)` - Applies function to input
- `andThen(Function<R, V>)` - Compose functions (this then that)
- `compose(Function<V, T>)` - Compose functions (that then this)

### 3. Consumer&lt;T&gt; - Side Effects
**File**: `ConsumerFunctionalInterface.java`

```java
// Performs operation on input without returning value
Consumer<String> printer = System.out::println;
Consumer<List<String>> listClearer = List::clear;

// Usage examples
printer.accept("Hello World"); // Prints: Hello World
listClearer.accept(myList);    // Clears the list

// Chaining consumers
Consumer<String> logAndPrint = s -> System.err.println("LOG: " + s);
Consumer<String> combined = printer.andThen(logAndPrint);
```

**Key Methods:**
- `accept(T t)` - Performs operation on input
- `andThen(Consumer<T>)` - Chain operations

### 4. Supplier&lt;T&gt; - Value Generation
**File**: `SupplierFunctionalInterface.java`

```java
// Provides values without taking input
Supplier<Double> randomValue = Math::random;
Supplier<String> currentTime = () -> new Date().toString();
Supplier<List<String>> emptyList = ArrayList::new;

// Usage examples
Double random = randomValue.get();      // Random number
String time = currentTime.get();        // Current timestamp
List<String> list = emptyList.get();    // New empty list
```

**Key Methods:**
- `get()` - Returns supplied value

## 🌊 Streams API

### Stream Creation and Processing
**Files**: `StreamExample.java`, `StreamEvaluation.java`

```java
// Creating streams
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
Stream<String> stream = names.stream();

// Common operations
List<String> result = names.stream()
    .filter(name -> name.length() > 3)    // Filter by condition
    .map(String::toUpperCase)             // Transform elements
    .sorted()                             // Sort elements
    .collect(Collectors.toList());        // Collect to list

// Numeric operations
OptionalInt sum = IntStream.rangeClosed(1, 100)
    .filter(x -> x % 2 == 0)             // Even numbers only
    .sum();                               // Sum all elements
```

### Stream Evaluation Types

#### 1. **Intermediate Operations** (Lazy)
- `filter()` - Filters elements based on predicate
- `map()` - Transforms elements
- `sorted()` - Sorts elements
- `distinct()` - Removes duplicates
- `limit()` - Limits number of elements
- `skip()` - Skips first n elements

#### 2. **Terminal Operations** (Eager)
- `collect()` - Collects to collection
- `forEach()` - Performs action on each element
- `reduce()` - Reduces to single value
- `count()` - Counts elements
- `anyMatch()` - Tests if any match predicate
- `allMatch()` - Tests if all match predicate

## 🎯 Lambda Expression Syntax

### Basic Syntax
```java
// No parameters
Runnable r = () -> System.out.println("Hello");

// Single parameter (parentheses optional)
Consumer<String> c1 = s -> System.out.println(s);
Consumer<String> c2 = (s) -> System.out.println(s);

// Multiple parameters
BinaryOperator<Integer> add = (a, b) -> a + b;

// Block body
Function<String, String> processor = s -> {
    String trimmed = s.trim();
    return trimmed.toUpperCase();
};
```

### Method References
```java
// Static method reference
Function<String, Integer> parseInt = Integer::parseInt;

// Instance method reference
Consumer<String> println = System.out::println;

// Constructor reference
Supplier<ArrayList<String>> listSupplier = ArrayList::new;

// Instance method of arbitrary object
Function<String, String> toUpper = String::toUpperCase;
```

## 🏃‍♂️ Running the Examples

### Individual Functional Interface Examples:
```bash
# Predicate examples
mvn exec:java -Dexec.mainClass="org.java8.features.lambda.PredicateFunctionalInterface"

# Function examples
mvn exec:java -Dexec.mainClass="org.java8.features.lambda.FunctionFunctionalInterface"

# Consumer examples
mvn exec:java -Dexec.mainClass="org.java8.features.lambda.ConsumerFunctionalInterface"

# Supplier examples
mvn exec:java -Dexec.mainClass="org.java8.features.lambda.SupplierFunctionalInterface"
```

### Stream Examples:
```bash
# Stream processing examples
mvn exec:java -Dexec.mainClass="org.java8.features.streams.StreamExample"

# Stream evaluation demonstration
mvn exec:java -Dexec.mainClass="org.java8.features.StreamEvaluation"
```

## 🧪 Practice Exercises

### 1. **Predicate Combinations**
```java
// Create predicates for:
Predicate<Integer> isPositive = x -> x > 0;
Predicate<Integer> isEven = x -> x % 2 == 0;
Predicate<Integer> isPositiveEven = isPositive.and(isEven);

// Test with various numbers
```

### 2. **Function Chaining**
```java
// Chain multiple transformations:
Function<String, String> trim = String::trim;
Function<String, String> upper = String::toUpperCase;
Function<String, Integer> length = String::length;

Function<String, Integer> process = trim.andThen(upper).andThen(length);
```

### 3. **Stream Processing Pipeline**
```java
// Process a list of strings:
List<String> words = Arrays.asList("java", "stream", "lambda", "function");

// Find longest words, convert to uppercase, sort alphabetically
List<String> result = words.stream()
    .filter(word -> word.length() > 4)
    .map(String::toUpperCase)
    .sorted()
    .collect(Collectors.toList());
```

## 💡 Best Practices

### 1. **Prefer Method References**
```java
// Good
list.forEach(System.out::println);

// Less readable
list.forEach(item -> System.out.println(item));
```

### 2. **Keep Lambdas Simple**
```java
// Good
Function<String, String> simple = String::trim;

// Consider extracting to method if complex
Function<String, String> complex = s -> {
    // Many lines of complex logic
    return result;
};
```

### 3. **Use Appropriate Functional Interface**
- Use `Predicate<T>` for boolean tests
- Use `Function<T,R>` for transformations
- Use `Consumer<T>` for side effects
- Use `Supplier<T>` for value generation

### 4. **Avoid Side Effects in Streams**
```java
// Good - pure operations
List<String> result = list.stream()
    .filter(s -> s.length() > 3)
    .collect(Collectors.toList());

// Avoid - side effects
list.stream()
    .filter(s -> {
        System.out.println(s); // Side effect!
        return s.length() > 3;
    })
    .collect(Collectors.toList());
```

## 🔍 Performance Considerations

### 1. **Stream vs Loop Performance**
- Streams have overhead for simple operations
- Benefit increases with complex operations
- Parallel streams can improve performance for large datasets

### 2. **Lazy Evaluation**
- Intermediate operations are lazy (not executed until terminal operation)
- Allows for optimization opportunities
- Understanding evaluation helps with performance tuning

### 3. **Collection vs Stream**
```java
// For simple operations, traditional loops might be faster
for (String s : list) {
    if (s.length() > 3) {
        result.add(s.toUpperCase());
    }
}

// Streams excel with complex processing chains
list.stream()
    .filter(s -> s.length() > 3)
    .map(String::toUpperCase)
    .sorted()
    .limit(10)
    .collect(Collectors.toList());
```

---

These Java 8 features enable more expressive, functional programming patterns in Java, making code more readable and maintainable when used appropriately.