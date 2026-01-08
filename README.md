# 7+1+BONUS - TECHNICAL REFERENCE/DOCUMENTATION

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
├── bootstrap/              # Main entry point & application startup module
├── config/                 # Configuration files (checkstyle)
├── data-management/        # Data processing module
├── functions/              # Core business logic module
├── graphics/               # Visualization and UI components module
├── .gitignore              # Files to be ignored by Git
├── README.md               # Project documentation
└── pom.xml                 # Parent Maven configuration
```

## UML
Detailed UML diagrams regarding the code architecture and system design.

## ALGORITHMS AND DATA STRUCTURES
- The **bootstrap** module is the module containing the main class, which in turn calls the individual classes of the respective modules.
- The **data-management** module handles access to a relational database (Railway), organized into tables such as Expenditure and Revenue. The connection is implemented using JDBC through the Connection, PreparedStatement, and ResultSet structures, while each database record is transformed into entity objects (Expenditure, Revenue) and temporarily stored in List/ArrayList collections. The core algorithms include serial retrieval and data conversion (row mapping) with linear complexity O(n), as well as CRUD operations via parameterized SQL commands.
- The **functions** module utilizes lists of revenue and expenditures to calculate total amounts via linear scanning, determine the fiscal balance as the difference between revenue and expenditures, and apply decision logic to characterize the budget as surplus, deficit, or balanced. Additionally, a value normalization algorithm is applied, converting financial values from strings into a numerical format suitable for calculations.There are also *test* files that support the application's verification using test data and fake repositories to validate the various algorithms.
- The **graphics** module handles data visualization, using aggregate numerical values and chart data structures derived from the linear processing of lists to create pie charts and comparative graphs

## SUPPLEMENTARY TECHNICAL DOCUMENTATION
* **[Test Coverage(structure)](https://github.com/johnanton21/7-1-BONUS/blob/458793b6cb2a1ff60f4fd52053a33085ff9a41e1/docs/Jacoco):** Detailed unit testing structure using **JaCoCo**.
* **[Test Coverage report (zip)](https://drive.google.com/drive/folders/1LK6nllc56X1puiJcOABDAAZZtHUuqAR8?usp=drive_link):** Detailed reports on unit testing and code coverage using **JaCoCo**.
* **[Code Documentation](.):** Comprehensive **JavaDocs** for all core classes.
* <ins>Code Quality:</ins> Static code analysis using **Checkstyle** to ensure maintainability.
