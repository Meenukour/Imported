# Quick Start Guide

This guide helps you get started with the Java Learning Repository examples quickly.

## Prerequisites Check

Make sure you have the following installed:

```bash
# Check Java version (should be 11 or higher)
java -version

# Check Maven version (should be 3.6 or higher)
mvn -version
```

## Quick Setup

1. **Clone and Build**
   ```bash
   git clone https://github.com/Meenukour/Imported.git
   cd Imported
   mvn clean compile
   ```

2. **Verify Installation**
   ```bash
   mvn exec:java -Dexec.mainClass="org.java8.features.Main"
   ```

   Expected output:
   ```
   This is implements Main Class
   This is lambda bird
   ```

## Running Examples by Category

### Java 8+ Features

```bash
# Basic lambda expressions
mvn exec:java -Dexec.mainClass="org.java8.features.Main"

# Functional interfaces
mvn exec:java -Dexec.mainClass="org.java8.features.lambda.ConsumerFunctionalInterface"

# Stream operations
mvn exec:java -Dexec.mainClass="org.java8.features.StreamEvaluation"
```

### Multithreading Examples

```bash
# Producer-Consumer pattern (press Ctrl+C to stop)
mvn exec:java -Dexec.mainClass="org.java.multithreading.BlockingQueueProcessor"

# Dining Philosophers problem
mvn exec:java -Dexec.mainClass="org.java.multithreading.diningPhilosphersProblem.Application"

# Thread executors
mvn exec:java -Dexec.mainClass="org.java.multithreading.Threadmanipulation.FixedThreadExceutor"
```

## Common Issues

### Issue: "java.lang.ClassNotFoundException"
**Solution**: Make sure you've compiled the project:
```bash
mvn clean compile
```

### Issue: Java version incompatibility
**Solution**: Ensure you're using Java 11 or higher:
```bash
java -version
```

### Issue: Maven not found
**Solution**: Install Maven from [https://maven.apache.org/install.html](https://maven.apache.org/install.html)

## Next Steps

- Explore the code in your IDE (IntelliJ IDEA recommended)
- Read the main [README.md](README.md) for detailed explanations
- Try modifying the examples to experiment with different behaviors
- Check out the [API Documentation](docs/API_REFERENCE.md) for detailed method explanations

## Getting Help

If you encounter issues:
1. Check this quick start guide
2. Review the main README.md
3. Look at the inline code comments
4. Open an issue on the repository