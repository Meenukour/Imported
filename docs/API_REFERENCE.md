# API Reference

This document provides detailed information about the key classes and interfaces in the Java Learning Repository.

## Java 8+ Features

### Functional Interfaces

#### `Bird` Interface
**Package:** `org.java8.features.lambda`

A functional interface demonstrating lambda expressions and default methods.

```java
@FunctionalInterface
public interface Bird {
    void canFly();                      // Abstract method
    static void staticMethod()          // Static method
    default int defaultMethod()         // Default method
    String toString();                  // Inherited from Object
}
```

**Usage Examples:**
```java
// Anonymous class implementation
Bird bird = new Bird() {
    @Override
    public void canFly() {
        System.out.println("Traditional implementation");
    }
};

// Lambda expression
Bird lambdaBird = () -> System.out.println("Lambda implementation");
```

#### Built-in Functional Interfaces

##### `Consumer<T>`
**Purpose:** Represents an operation that accepts a single input argument and returns no result.

```java
Consumer<String> stringConsumer = (String s) -> 
    System.out.println("Processing: " + s);
stringConsumer.accept("Hello World");
```

##### `Function<T, R>`
**Purpose:** Represents a function that accepts one argument and produces a result.

```java
Function<String, Integer> lengthFunction = str -> str.length();
int length = lengthFunction.apply("Hello");
```

##### `Predicate<T>`
**Purpose:** Represents a predicate (boolean-valued function) of one argument.

```java
Predicate<Integer> isEven = num -> num % 2 == 0;
boolean result = isEven.test(4); // true
```

##### `Supplier<T>`
**Purpose:** Represents a supplier of results (no input, produces output).

```java
Supplier<String> messageSupplier = () -> "Hello from Supplier";
String message = messageSupplier.get();
```

### Stream API

#### `StreamExample` Class
**Package:** `org.java8.features.streams`

Comprehensive examples of Stream API operations.

**Key Operations:**
- **Filter:** `stream.filter(predicate)`
- **Map:** `stream.map(function)`
- **Collect:** `stream.collect(collector)`
- **Reduce:** `stream.reduce(identity, accumulator)`

**Common Patterns:**
```java
// Filtering and counting
long count = list.stream()
    .filter(item -> item > threshold)
    .count();

// Transformation and collection
List<String> result = list.stream()
    .map(String::toUpperCase)
    .collect(Collectors.toList());

// Grouping
Map<Boolean, List<Integer>> partitioned = list.stream()
    .collect(Collectors.partitioningBy(i -> i % 2 == 0));
```

## Multithreading & Concurrency

### Producer-Consumer Pattern

#### `BlockingQueueProcessor` Class
**Package:** `org.java.multithreading`

Demonstrates the producer-consumer pattern using `BlockingQueue`.

**Key Components:**
- **FirstWorker:** Producer thread that adds elements to the queue
- **SecondWorker:** Consumer thread that removes elements from the queue
- **BlockingQueue:** Thread-safe queue with blocking operations

**Usage:**
```java
BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
FirstWorker producer = new FirstWorker(queue);
SecondWorker consumer = new SecondWorker(queue);

new Thread(producer).start();
new Thread(consumer).start();
```

### Thread Management

#### `FixedThreadExceutor` Class
**Package:** `org.java.multithreading.Threadmanipulation`

Demonstrates fixed thread pool executor usage.

```java
ExecutorService executor = Executors.newFixedThreadPool(5);
// Submit tasks
executor.submit(task);
// Shutdown when done
executor.shutdown();
```

#### `Semaphores` Class
**Package:** `org.java.multithreading.Threadmanipulation`

Shows semaphore-based access control.

```java
Semaphore semaphore = new Semaphore(3); // Allow 3 concurrent accesses
try {
    semaphore.acquire();
    // Critical section
} finally {
    semaphore.release();
}
```

### Classic Concurrency Problems

#### Dining Philosophers Problem
**Package:** `org.java.multithreading.diningPhilosphersProblem`

**Classes:**
- **Application:** Main entry point
- **Philosopher:** Thread representing a philosopher
- **ChopSticks:** Shared resource (chopsticks)
- **State:** Philosopher states (THINKING, EATING, HUNGRY)
- **Constants:** Configuration constants

**Problem Description:**
Five philosophers sit around a table with five chopsticks. Each philosopher needs two chopsticks to eat. The challenge is to prevent deadlock while allowing maximum concurrency.

## Synchronization Mechanisms

### `VolatileProcessor`
Demonstrates the `volatile` keyword for ensuring visibility across threads.

### `AtomicIntegerExample`
Shows atomic operations for lock-free programming.

### `WaitAndNotify`
Classic wait/notify mechanism for thread coordination.

### `CyclicBarrierProcessor`
Barrier synchronization allowing threads to wait for each other.

## Performance Considerations

### When to Use Each Approach

1. **Streams:** Use for data processing pipelines, filtering, and transformations
2. **BlockingQueue:** Ideal for producer-consumer scenarios
3. **Executors:** Better than manual thread management for task execution
4. **Atomic Classes:** Use for simple counters and flags without locks
5. **Volatile:** Use for simple flags visible across threads

### Best Practices

1. **Prefer higher-level constructs** (Executors, concurrent collections)
2. **Use immutable objects** when possible
3. **Minimize synchronization scope**
4. **Always close resources** (use try-with-resources)
5. **Handle InterruptedException** properly

## Code Examples Repository Structure

```
src/main/java/
├── org.java8.features/           # Modern Java features
│   ├── lambda/                   # Functional programming
│   ├── streams/                  # Stream API examples
│   └── *.java                   # Main classes
└── org.java.multithreading/     # Concurrency examples
    ├── Threadmanipulation/       # Thread management
    ├── diningPhilosphersProblem/ # Classic problem
    ├── synchronizedCollection/   # Thread-safe collections
    └── *.java                   # Concurrency utilities
```

This repository serves as a comprehensive reference for modern Java development practices, covering both functional programming paradigms and concurrent programming techniques.