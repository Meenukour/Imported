# Java Multithreading and Java 8 Features Learning Repository

A comprehensive collection of Java examples demonstrating **multithreading concepts** and **Java 8 features**. This repository serves as a practical learning resource for understanding concurrent programming and modern Java features.

## 🎯 Purpose

This repository provides hands-on examples for:
- **Multithreading**: From basic thread creation to advanced concurrent programming concepts
- **Java 8 Features**: Lambda expressions, functional interfaces, and streams
- **Concurrent Collections**: Thread-safe data structures and their usage patterns
- **Classic Concurrency Problems**: Including the famous Dining Philosophers problem

## 📋 Prerequisites

- **Java**: JDK 11 or higher (tested with Java 17)
- **Maven**: 3.6+ for building and dependency management
- **IDE**: Any Java IDE (IntelliJ IDEA, Eclipse, VS Code)

## 🚀 Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/Meenukour/Imported.git
cd Imported
```

### 2. Build the Project
```bash
mvn clean compile
```

### 3. Run Examples
Navigate to specific example files and run them directly from your IDE, or use Maven to run specific classes:

#### 🧵 Multithreading Examples:
```bash
# Basic threading with priorities
mvn exec:java -Dexec.mainClass="org.java.multithreading.Threadmanipulation.App"

# Dining Philosophers Problem (runs for 5 seconds)
mvn exec:java -Dexec.mainClass="org.java.multithreading.diningPhilosphersProblem.Application"

# BlockingQueue producer-consumer pattern
mvn exec:java -Dexec.mainClass="org.java.multithreading.BlockingQueueProcessor"

# Semaphore usage example
mvn exec:java -Dexec.mainClass="org.java.multithreading.Threadmanipulation.Semaphores"
```

#### ☕ Java 8 Features Examples:
```bash
# Lambda expressions and functional interfaces
mvn exec:java -Dexec.mainClass="org.java8.features.Main"

# Stream processing examples
mvn exec:java -Dexec.mainClass="org.java8.features.streams.Main"
```

## 📚 What You'll Learn

> 📖 **Detailed Documentation Available**: 
> - [Dining Philosophers Problem Guide](docs/DINING_PHILOSOPHERS.md) - In-depth explanation of the classic concurrency problem
> - [Java 8 Features Reference](docs/JAVA8_FEATURES.md) - Comprehensive guide to lambda expressions, functional interfaces, and streams

### 🧵 Multithreading Concepts

#### Basic Threading
- **Thread Creation**: Different ways to create and start threads
- **Thread Priorities**: Managing thread execution priority
- **Runnable Interface**: Implementing thread behavior

| File | Concept | Description |
|------|---------|-------------|
| `App.java` | Basic Threading | Thread creation with priorities |
| `ThreadProcess.java` | Thread Management | Thread lifecycle and management |
| `Processor.java` | Runnable Implementation | Custom thread behavior |

#### Thread Executors
- **Fixed Thread Pool**: Managing a fixed number of worker threads
- **Single Thread Executor**: Sequential task execution
- **Scheduled Executor**: Time-based task scheduling

| File | Concept | Description |
|------|---------|-------------|
| `FixedThreadExceutor.java` | Thread Pool | Fixed-size thread pool management |
| `SingleThreadExceutor.java` | Sequential Execution | Single-threaded task processing |
| `ScheduledExceutor.java` | Task Scheduling | Time-based task execution |

#### Synchronization & Thread Safety
- **Volatile Variables**: Memory visibility guarantees
- **Atomic Operations**: Lock-free thread-safe operations
- **Semaphores**: Controlling access to resources
- **Wait and Notify**: Thread coordination mechanisms
- **Deadlock**: Understanding and avoiding deadlocks

| File | Concept | Description |
|------|---------|-------------|
| `VolatileProcessor.java` | Memory Visibility | Volatile keyword usage |
| `AtomicIntegerExample.java` | Atomic Operations | Lock-free thread safety |
| `Semaphores.java` | Resource Control | Limiting concurrent access |
| `WaitAndNotify.java` | Thread Coordination | Inter-thread communication |
| `Deadlock.java` | Deadlock Scenarios | Understanding deadlock conditions |

#### Concurrent Collections
- **BlockingQueue**: Producer-consumer pattern implementation
- **CopyOnWriteArrayList**: Thread-safe list for read-heavy scenarios
- **DelayQueue**: Time-based element retrieval
- **PriorityQueue**: Thread-safe priority-based processing
- **ConcurrentMap**: Thread-safe map operations
- **CyclicBarrier**: Synchronizing multiple threads at a barrier point

| File | Concept | Description |
|------|---------|-------------|
| `BlockingQueueProcessor.java` | Producer-Consumer | Thread-safe queue operations |
| `CopyOnWriteArrayProcessor.java` | Read-Heavy Collections | Copy-on-write pattern |
| `DelayQueueProcessor.java` | Delayed Processing | Time-based element access |
| `PriorityQueueProcessor.java` | Priority Processing | Thread-safe priority queue |
| `ConcurrentMapProcessor.java` | Concurrent Maps | Thread-safe map operations |
| `CyclicBarrierProcessor.java` | Thread Synchronization | Barrier-based coordination |

#### Classic Concurrency Problems

##### 🍽️ Dining Philosophers Problem
A complete implementation of the classic concurrency problem demonstrating:
- **Resource Contention**: Multiple threads competing for shared resources
- **Deadlock Prevention**: Strategies to avoid circular waiting
- **Thread Coordination**: Complex multi-thread synchronization

**Files:**
- `Application.java` - Main simulation runner
- `Philosopher.java` - Individual philosopher thread
- `ChopSticks.java` - Shared resource (chopsticks)
- `Constants.java` - Configuration parameters
- `State.java` - Philosopher states (thinking, hungry, eating)

### ☕ Java 8 Features

#### Lambda Expressions & Functional Interfaces
Modern Java programming with functional programming concepts:

| File | Interface Type | Description |
|------|----------------|-------------|
| `PredicateFunctionalInterface.java` | Predicate&lt;T&gt; | Boolean-valued functions |
| `FunctionFunctionalInterface.java` | Function&lt;T,R&gt; | Input transformation functions |
| `ConsumerFunctionalInterface.java` | Consumer&lt;T&gt; | Operations on input without return |
| `SupplierFunctionalInterface.java` | Supplier&lt;T&gt; | No-argument result suppliers |

#### Streams API
- **Stream Processing**: Data processing with functional operations
- **Stream Evaluation**: Lazy evaluation and performance considerations

| File | Concept | Description |
|------|---------|-------------|
| `StreamExample.java` | Stream Operations | Filtering, mapping, reducing data |
| `StreamEvaluation.java` | Performance | Stream evaluation strategies |

## 📁 Project Structure

```
src/main/java/org/
├── java/multithreading/
│   ├── diningPhilosphersProblem/     # Complete dining philosophers implementation
│   ├── Threadmanipulation/          # Basic threading concepts
│   ├── synchronizedCollection/      # Synchronized collection examples
│   └── [Concurrent Collections]     # Various concurrent collection examples
└── java8/features/
    ├── lambda/                      # Functional interfaces and lambda expressions
    └── streams/                     # Stream API examples
```

## 🎓 Recommended Learning Path

### For Beginners:
1. **Start with Basic Threading** (`Threadmanipulation/App.java`)
2. **Understand Thread Safety** (`VolatileProcessor.java`, `AtomicIntegerExample.java`)
3. **Learn Synchronization** (`Semaphores.java`, `WaitAndNotify.java`)
4. **Explore Executors** (`FixedThreadExceutor.java`)

### For Intermediate Learners:
1. **Concurrent Collections** (BlockingQueue, ConcurrentMap examples)
2. **Advanced Synchronization** (`CyclicBarrierProcessor.java`)
3. **Dining Philosophers Problem** (complete implementation)

### For Advanced Learners:
1. **Performance Considerations** (Compare different concurrent collections)
2. **Custom Synchronization Mechanisms**
3. **Java 8 Functional Programming** (Lambda expressions, Streams)

## 🔧 Key Concepts Demonstrated

- **Thread Creation and Management**
- **Synchronization Primitives**
- **Lock-free Programming**
- **Producer-Consumer Patterns**
- **Resource Management**
- **Deadlock Prevention**
- **Functional Programming in Java**
- **Stream Processing**

## 💡 Tips for Learning

1. **Run Examples**: Execute each example to see threading behavior in action
2. **Modify Parameters**: Change thread counts, delays, and other parameters to observe different behaviors
3. **Add Logging**: Insert print statements to trace thread execution
4. **Experiment**: Combine concepts from different examples
5. **Profile Performance**: Use profiling tools to understand performance characteristics

## 🤝 Contributing

Feel free to contribute additional examples, improvements, or documentation:

1. Fork the repository
2. Create a feature branch
3. Add your examples or improvements
4. Submit a pull request

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

## 🎉 Acknowledgments

This repository serves as an educational resource for learning Java concurrency and modern Java features. Perfect for:
- Computer Science students learning concurrent programming
- Java developers transitioning to multithreaded applications
- Anyone interested in understanding Java 8+ features

---

**Happy Learning! 🚀**

Start with the examples that match your current knowledge level and gradually work your way up to more complex concurrency patterns.