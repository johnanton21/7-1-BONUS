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

## EXECUTION
Navigate to the module `bootstrap` and run the main class:
```bash
cd bootstrap
java -jar target/bootstrap-1.0-SNAPSHOT.jar
