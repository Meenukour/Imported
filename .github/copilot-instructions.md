# Java Multithreading and Lambda Examples

Always reference these instructions first and fallback to search or bash commands only when you encounter unexpected information that does not match the info here.

This is a Java Maven educational repository containing practical examples of multithreading, concurrency, and Java 8 features. The codebase consists entirely of runnable demonstration programs designed for learning purposes.

## Working Effectively

### Prerequisites and Setup
- Ensure Java 11+ is installed (project runs on Java 17)
- Maven 3.6+ is required
- No additional dependencies or special setup needed

### Build Commands
Execute these commands in the repository root:

1. **Clean and compile**: `mvn clean compile`
   - **TIMING**: Takes ~30 seconds on first run with Maven dependency downloads. Set timeout to 120+ seconds.
   - **NEVER CANCEL**: Wait for completion even if it appears slow during dependency downloads
   - Subsequent runs take ~5 seconds

2. **Package JAR**: `mvn package` 
   - **TIMING**: Takes ~15 seconds. Set timeout to 60+ seconds.
   - **NEVER CANCEL**: Wait for completion
   - Creates `target/master-lambda-1.0-SNAPSHOT.jar`

3. **Run tests**: `mvn test`
   - **TIMING**: Takes ~20 seconds. Set timeout to 60+ seconds.
   - **NEVER CANCEL**: Wait for completion
   - **NOTE**: No actual tests exist - this validates Maven configuration only

### Running Applications
The repository contains multiple runnable main classes demonstrating different concepts:

#### Java 8 Features
- **Lambda expressions**: `mvn exec:java -Dexec.mainClass="org.java8.features.Main"`
- **Streams API**: `mvn exec:java -Dexec.mainClass="org.java8.features.streams.Main"`

#### Multithreading Examples  
- **Basic threading**: `mvn exec:java -Dexec.mainClass="org.java.multithreading.Threadmanipulation.App"`
- **Dining philosophers**: `mvn exec:java -Dexec.mainClass="org.java.multithreading.diningPhilosphersProblem.Application"`

#### Alternative Execution
After building with `mvn package`, run directly:
```bash
java -cp target/master-lambda-1.0-SNAPSHOT.jar org.java8.features.Main
```

## Validation Requirements

### Build Validation
- Always run `mvn clean compile` before making changes to ensure clean build state
- **NEVER CANCEL** build commands - they require full completion for proper validation
- Verify `target/classes` directory is populated after compilation

### Application Testing  
After making changes, validate functionality by running:

1. **Lambda example validation**:
   ```bash
   mvn exec:java -Dexec.mainClass="org.java8.features.Main"
   ```
   Expected output:
   ```
   This is implements Main Class
   This is lambda bird
   ```

2. **Streams example validation**:
   ```bash
   mvn exec:java -Dexec.mainClass="org.java8.features.streams.Main"  
   ```
   Expected output: Grouped Person objects by name

3. **Threading example validation**:
   ```bash
   mvn exec:java -Dexec.mainClass="org.java.multithreading.Threadmanipulation.App"
   ```
   Expected output: Interleaved "Runner1" and "Runner2" messages

4. **Dining philosophers validation**:
   ```bash
   mvn exec:java -Dexec.mainClass="org.java.multithreading.diningPhilosphersProblem.Application"
   ```
   **NOTE**: This demo intentionally throws `IllegalMonitorStateException` as part of demonstrating threading issues - this is EXPECTED behavior, not a bug.

### Complete Validation Scenario
Always execute this full validation sequence after changes:
1. `mvn clean compile` - ensure clean build
2. `mvn package` - create JAR  
3. Run at least 2 different main classes to verify functionality
4. Check that output matches expected patterns

## Project Structure and Key Locations

### Source Organization
```
src/main/java/org/
├── java/                          # Multithreading examples
│   └── multithreading/
│       ├── diningPhilosphersProblem/  # Classic concurrency problem
│       ├── Threadmanipulation/        # Basic threading examples  
│       └── synchronizedCollection/    # Thread-safe collections
└── java8/                         # Java 8 feature examples
    └── features/
        ├── lambda/                    # Lambda expression examples
        └── streams/                   # Stream API examples
```

### Key Files to Know
- `pom.xml` - Maven configuration (Java 11 target, no dependencies)
- `src/main/java/org/java8/features/Main.java` - Primary lambda demo
- `src/main/java/org/java8/features/streams/Main.java` - Streams demo  
- `src/main/java/org/java/multithreading/diningPhilosphersProblem/Application.java` - Concurrency demo

### Important Notes
- **No tests exist** - this is a demo/learning repository
- **No linting or formatting tools** configured
- **Runtime exceptions in threading demos are intentional** and demonstrate concurrency issues
- **All applications are educational examples** - not production code

## Common Reference Information

### Repository Root Listing
```
.
├── .git/
├── .gitignore
├── .idea/          # IntelliJ IDEA configuration
├── pom.xml         # Maven project file
└── src/main/java/  # All source code
```

### Maven pom.xml Key Details
- **Group ID**: org.example  
- **Artifact ID**: master-lambda
- **Version**: 1.0-SNAPSHOT
- **Java Version**: 11 (source/target)
- **No external dependencies**

### Expected Build Artifacts
After `mvn package`:
```
target/
├── classes/                           # Compiled .class files
├── master-lambda-1.0-SNAPSHOT.jar    # Packaged JAR (73KB)
└── maven-archiver/                    # Build metadata
```

## Troubleshooting

### Common Issues
1. **Build hangs during dependency download**: Wait - Maven downloads can take 5+ minutes on first run
2. **IllegalMonitorStateException in dining philosophers**: Expected behavior demonstrating threading issues
3. **No tests to run**: Expected - this repository contains only demo applications
4. **Java version warnings**: Safe to ignore - code runs on Java 17 despite Java 11 target

### When Things Go Wrong
- Always start with `mvn clean` to reset build state
- **NEVER interrupt long-running Maven commands**
- Verify Java version with `java -version` (should be 11+)
- Check Maven installation with `mvn --version`