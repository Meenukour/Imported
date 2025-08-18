# Java Learning Repository

A comprehensive collection of Java examples demonstrating modern Java features, multithreading concepts, and common programming patterns. This repository serves as a practical learning resource for developers looking to understand Java 8+ features and concurrent programming.

## 📋 Table of Contents

- [Overview](#overview)
- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Modules](#modules)
- [Running Examples](#running-examples)
- [Key Concepts Covered](#key-concepts-covered)
- [Documentation](#documentation)
- [Contributing](#contributing)

## 🎯 Overview

This project contains practical implementations and examples of:

- **Java 8+ Features**: Lambda expressions, Stream API, functional interfaces
- **Multithreading & Concurrency**: Thread manipulation, synchronization, concurrent collections
- **Design Patterns**: Classic concurrency problems and their solutions
- **Best Practices**: Modern Java programming techniques

## 🔧 Prerequisites

- **Java 11** or higher
- **Apache Maven 3.6+**
- Basic understanding of Java programming concepts

## 📁 Project Structure

```
src/main/java/
├── org/java8/features/          # Java 8+ features and functional programming
│   ├── lambda/                  # Lambda expressions and functional interfaces
│   ├── streams/                 # Stream API examples
│   ├── Main.java               # Main entry point for Java 8 features
│   └── StreamEvaluation.java   # Stream processing examples
└── org/java/multithreading/     # Concurrency and multithreading examples
    ├── Threadmanipulation/      # Thread management and control
    ├── diningPhilosphersProblem/ # Classic dining philosophers implementation
    ├── synchronizedCollection/  # Synchronized collection examples
    └── [Various concurrency classes]
```

## 🚀 Getting Started

1. **Clone the repository**
   ```bash
   git clone https://github.com/Meenukour/Imported.git
   cd Imported
   ```

2. **Build the project**
   ```bash
   mvn clean compile
   ```

3. **Run examples**
   ```bash
   # Run Java 8 features demo
   mvn exec:java -Dexec.mainClass="org.java8.features.Main"
   
   # Run specific examples (see Running Examples section)
   mvn exec:java -Dexec.mainClass="org.java.multithreading.BlockingQueueProcessor"
   ```

## 📚 Modules

### Java 8+ Features (`org.java8.features`)

#### Lambda Expressions & Functional Interfaces
- **`Bird.java`** - Functional interface example with default and static methods
- **`BirdImpl.java`** - Implementation examples
- **`ConsumerFunctionalInterface.java`** - Consumer interface examples
- **`FunctionFunctionalInterface.java`** - Function interface examples
- **`PredicateFunctionalInterface.java`** - Predicate interface examples
- **`SupplierFunctionalInterface.java`** - Supplier interface examples

#### Stream API
- **`StreamExample.java`** - Basic stream operations
- **`StreamEvaluation.java`** - Advanced stream processing with practical examples:
  - Character counting in strings
  - String manipulation with streams
  - Age calculation using LocalDate
  - Duplicate detection in collections

### Multithreading (`org.java.multithreading`)

#### Concurrent Collections
- **`BlockingQueueProcessor.java`** - Producer-consumer pattern with BlockingQueue
- **`ConcurrentMapProcessor.java`** - Thread-safe map operations
- **`CopyOnWriteArrayProcessor.java`** - Copy-on-write array operations
- **`PriorityQueueProcessor.java`** - Priority-based queue processing
- **`DelayQueueProcessor.java`** - Delayed element processing

#### Synchronization & Control
- **`CyclicBarrierProcessor.java`** - Barrier synchronization
- **`Semaphores.java`** - Semaphore-based access control
- **`WaitAndNotify.java`** - Classic wait/notify mechanisms
- **`VolatileProcessor.java`** - Volatile keyword usage

#### Thread Management
- **`ThreadProcess.java`** - Basic thread operations
- **`FixedThreadExceutor.java`** - Fixed thread pool executor
- **`SingleThreadExceutor.java`** - Single thread executor
- **`ScheduledExceutor.java`** - Scheduled task execution
- **`CallableProcessor.java`** - Callable and Future examples
- **`AtomicIntegerExample.java`** - Atomic operations

#### Classic Problems
- **Dining Philosophers Problem**
  - `Application.java` - Main application
  - `Philosopher.java` - Philosopher thread implementation
  - `ChopSticks.java` - Shared resource (chopsticks)
  - `State.java` - Philosopher states
  - `Constants.java` - Configuration constants

## 🏃‍♂️ Running Examples

### Java 8 Features
```bash
# Run main Java 8 features demo
mvn exec:java -Dexec.mainClass="org.java8.features.Main"

# Run stream evaluation examples
mvn exec:java -Dexec.mainClass="org.java8.features.StreamEvaluation"
```

### Multithreading Examples
```bash
# BlockingQueue producer-consumer example
mvn exec:java -Dexec.mainClass="org.java.multithreading.BlockingQueueProcessor"

# Dining philosophers problem
mvn exec:java -Dexec.mainClass="org.java.multithreading.diningPhilosphersProblem.Application"

# Thread executor examples
mvn exec:java -Dexec.mainClass="org.java.multithreading.Threadmanipulation.FixedThreadExceutor"

# Semaphore example
mvn exec:java -Dexec.mainClass="org.java.multithreading.Threadmanipulation.Semaphores"
```

## 🎓 Key Concepts Covered

### Functional Programming
- Lambda expressions and method references
- Built-in functional interfaces (Consumer, Function, Predicate, Supplier)
- Stream API operations (map, filter, collect, reduce)
- Optional handling

### Concurrency Patterns
- Producer-Consumer with BlockingQueue
- Thread pool management with Executors
- Synchronization primitives (monitors, semaphores, barriers)
- Atomic operations and volatile variables
- Lock-free data structures

### Best Practices
- Immutable object design
- Thread-safe collection usage
- Proper resource management
- Exception handling in concurrent code

## 📝 Example Code Snippets

### Lambda Expression Example
```java
// Traditional anonymous class
Bird bird = new Bird() {
    @Override
    public void canFly() {
        System.out.println("Traditional implementation");
    }
};

// Lambda expression
Bird lambdaBird = () -> {
    System.out.println("Lambda implementation");
};
```

### Stream API Example
```java
// Count characters in a string
String s = "string data to count each character";
s.chars()
    .mapToObj(c -> (char) c)
    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
    .entrySet()
    .forEach(System.out::println);
```

### BlockingQueue Example
```java
BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

// Producer
queue.put(value);

// Consumer  
Integer value = queue.take();
```

## 📚 Documentation

### Additional Resources
- **[Quick Start Guide](QUICKSTART.md)** - Get up and running in 5 minutes
- **[API Reference](docs/API_REFERENCE.md)** - Detailed class and method documentation  
- **[Examples Index](docs/EXAMPLES_INDEX.md)** - Complete list of examples with expected outputs
- **[Learning Path](docs/EXAMPLES_INDEX.md#learning-path-recommendation)** - Recommended order for studying the examples

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is for educational purposes. Feel free to use and modify the code for learning.

## 🔗 Additional Resources

- [Oracle Java Documentation](https://docs.oracle.com/en/java/)
- [Java Concurrency in Practice](https://jcip.net/)
- [Effective Java by Joshua Bloch](https://www.oreilly.com/library/view/effective-java/9780134686097/)