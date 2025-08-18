# Examples Index

This document provides a quick reference to all examples in the repository with their expected outputs.

## Java 8+ Features Examples

### Lambda Expressions

| Example | Command | Expected Output |
|---------|---------|-----------------|
| Basic Lambda | `mvn exec:java -Dexec.mainClass="org.java8.features.Main"` | Shows traditional vs lambda implementation |
| Consumer Interface | `mvn exec:java -Dexec.mainClass="org.java8.features.lambda.ConsumerFunctionalInterface"` | "This is string as input HI MEENU" |

### Stream API Examples

| Example | Location | Description |
|---------|----------|-------------|
| Character Counting | `StreamEvaluation.java` line 22-25 | Count each character in a string |
| Word Reversal | `StreamEvaluation.java` line 38 | Reverse each word using streams |
| Age Calculation | `StreamEvaluation.java` line 45-47 | Calculate age using Period.between() |
| Duplicate Detection | `StreamEvaluation.java` line 55 | Find duplicates in a list |
| Even/Odd Separation | `StreamExample.java` line 215 | Partition numbers by even/odd |
| String Manipulation | `StreamExample.java` line 171 | Convert to uppercase using streams |

## Multithreading Examples

### Producer-Consumer Patterns

| Example | Command | Description | Notes |
|---------|---------|-------------|-------|
| BlockingQueue | `mvn exec:java -Dexec.mainClass="org.java.multithreading.BlockingQueueProcessor"` | Producer-consumer with BlockingQueue | Press Ctrl+C to stop |
| Priority Queue | `mvn exec:java -Dexec.mainClass="org.java.multithreading.PriorityQueueProcessor"` | Priority-based processing | |
| Delay Queue | `mvn exec:java -Dexec.mainClass="org.java.multithreading.DelayQueueProcessor"` | Delayed element processing | |

### Synchronization Examples

| Example | Command | Description |
|---------|---------|-------------|
| Semaphores | `mvn exec:java -Dexec.mainClass="org.java.multithreading.Threadmanipulation.Semaphores"` | Access control with semaphores |
| Cyclic Barrier | `mvn exec:java -Dexec.mainClass="org.java.multithreading.CyclicBarrierProcessor"` | Thread synchronization barriers |
| Wait/Notify | `mvn exec:java -Dexec.mainClass="org.java.multithreading.Threadmanipulation.WaitAndNotify"` | Classic wait/notify mechanism |

### Thread Pool Examples

| Example | Command | Description |
|---------|---------|-------------|
| Fixed Thread Pool | `mvn exec:java -Dexec.mainClass="org.java.multithreading.Threadmanipulation.FixedThreadExceutor"` | Fixed-size thread pool |
| Single Thread | `mvn exec:java -Dexec.mainClass="org.java.multithreading.Threadmanipulation.SingleThreadExceutor"` | Single thread executor |
| Scheduled Tasks | `mvn exec:java -Dexec.mainClass="org.java.multithreading.Threadmanipulation.ScheduledExceutor"` | Scheduled task execution |

### Classic Problems

| Problem | Command | Description |
|---------|---------|-------------|
| Dining Philosophers | `mvn exec:java -Dexec.mainClass="org.java.multithreading.diningPhilosphersProblem.Application"` | Classic deadlock prevention problem |
| Deadlock Demo | `mvn exec:java -Dexec.mainClass="org.java.multithreading.Threadmanipulation.Deadlock"` | Demonstrates deadlock conditions |

## Concurrent Collections

| Collection Type | Example Class | Use Case |
|----------------|---------------|----------|
| ConcurrentMap | `ConcurrentMapProcessor.java` | Thread-safe map operations |
| CopyOnWriteArray | `CopyOnWriteArrayProcessor.java` | Read-heavy, write-light scenarios |
| BlockingQueue | `BlockingQueueProcessor.java` | Producer-consumer patterns |

## Atomic Operations

| Type | Example | Description |
|------|---------|-------------|
| AtomicInteger | `AtomicIntegerExample.java` | Lock-free counter operations |
| Volatile | `VolatileProcessor.java` | Visibility guarantees |

## Quick Test Commands

### Verify All Examples Work
```bash
# Test Java 8 features
mvn exec:java -Dexec.mainClass="org.java8.features.Main"

# Test multithreading (with timeout to prevent hanging)
timeout 5s mvn exec:java -Dexec.mainClass="org.java.multithreading.BlockingQueueProcessor"

# Test dining philosophers (runs for specified time)
mvn exec:java -Dexec.mainClass="org.java.multithreading.diningPhilosphersProblem.Application"
```

### Build and Compile Check
```bash
mvn clean compile
mvn test
```

## Learning Path Recommendation

### Beginner (Start Here)
1. `org.java8.features.Main` - Basic lambda expressions
2. `org.java8.features.lambda.ConsumerFunctionalInterface` - Functional interfaces
3. `org.java8.features.streams.StreamExample` - Basic stream operations

### Intermediate
1. `org.java8.features.StreamEvaluation` - Advanced stream processing
2. `org.java.multithreading.BlockingQueueProcessor` - Basic concurrency
3. `org.java.multithreading.Threadmanipulation.FixedThreadExceutor` - Thread pools

### Advanced
1. `org.java.multithreading.diningPhilosphersProblem.Application` - Classic problems
2. `org.java.multithreading.CyclicBarrierProcessor` - Advanced synchronization
3. `org.java.multithreading.Threadmanipulation.AtomicIntegerExample` - Lock-free programming

## Troubleshooting Examples

### Common Issues and Solutions

| Issue | Likely Cause | Solution |
|-------|--------------|----------|
| ClassNotFoundException | Not compiled | Run `mvn clean compile` |
| Example hangs | Infinite loop/waiting | Use `timeout` command or Ctrl+C |
| Build fails | Java version | Ensure Java 11+ is installed |
| No output | Wrong main class | Check class name spelling |

### Debug Tips
- Add `-X` flag to Maven for debug output: `mvn -X exec:java ...`
- Use IDE debugger for step-through debugging
- Add print statements to understand execution flow
- Check thread states with JVisualVM for multithreading issues