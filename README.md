# 7+1+BONUS - TECHNICAL REFERENCE

## COMPILATION 

### Prerequisites
- Java JDK
- Apache Maven
- `JAVA_HOME` environment variable properly set

### Compilation

From the root directory of the project, where the parent `pom.xml` file is located, run:
```bash
mvn clean install
```

## EXECUTION
Navigate to the module `bootstrap` and run the main class:
```bash
cd bootstrap
java -jar target/bootstrap-1.0-SNAPSHOT.jar
```

## USAGE
> When the program starts, follow the on-screen instructions
1. Launch the application from the terminal
2. Provide the required input (1-7)
3. The program processes the input and displays the results in the console
4. When you press `7` the program will be terminated
