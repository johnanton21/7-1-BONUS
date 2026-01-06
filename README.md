# 7+1+BONUS - TECHNICAL REFERENCE

## BUDGET-HER0
"BUDGET-HERO" is a state budget overview and processing system. The application displays current and historical state budget data, performs comparisons between different years, and visualizes them through various graphical elements. Additionally, it calculates and displays the fiscal balance and updates the data based on user modifications.

## COMPILATION 
**Prerequisites**
- Java JDK
- Apache Maven
- `JAVA_HOME` environment variable properly set

**Compilation**

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
1. Launch the application from the terminal
2. Provide the required input `(1-7)`
3. The program processes the input and displays the results in the console
4. To terminate the process: press `7`

## PROJECT STRUCTURE
```text
.
├── bootstrap/              # Main entry point & application startup
├── config/                 # Configuration files (checkstyle, etc.)
├── data-management/        # Data processing and storage logic
├── functions/              # Core business logic
├── graphics/               # Visualization and UI components
├── .gitignore              # Files to be ignored by Git
├── JACOCO_INSTRUCTIONS.md  # Instructions for test coverage
├── pom.xml                 # Parent Maven configuration
└── README.md               # Project documentation
```

## UML

## ALGORITHMS AND DATA STRUCTURES

## SUPPLEMENTARY TECHNICAL DOCUMENTATION
