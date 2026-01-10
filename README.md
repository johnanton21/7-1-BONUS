# 7+1+BONUS - TECHNICAL REFERENCE/DOCUMENTATION

## BUDGET-HER0
"BUDGET-HERO" is an open-source state budget overview and processing system. The application displays current and historical state budget data, performs comparisons between different years, and visualizes them through various graphical elements. Additionally, it calculates and displays the fiscal balance and updates the data based on user modifications. Licensed under the MIT License.

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
├── checkstyle/                 # Configuration files (checkstyle)
├── data-management/        # Data processing module
├── functions/              # Core business logic module
├── graphics/               # Visualization and UI components module
├── .gitignore              # Files to be ignored by Git
├── LICENCE                 # Open Source License
├── README.md               # Project documentation
└── pom.xml                 # Parent Maven configuration
```

## UML
Detailed UML diagrams regarding the code architecture and system design.

## ALGORITHMS AND DATA STRUCTURES
- The **bootstrap** module is the module containing the main class, which in turn calls the individual classes of the respective modules.
- The **data-management** module handles access to a relational database (Railway), organized into tables such as Expenditure and Revenue. The connection is implemented using JDBC through the Connection, PreparedStatement, and ResultSet structures, while each database record is transformed into entity objects (Expenditure, Revenue) and temporarily stored in List/ArrayList collections. The core algorithms include serial retrieval and data conversion (row mapping) with linear complexity O(n), as well as CRUD operations via parameterized SQL commands.
- The **functions** module utilizes lists of revenue and expenditures to calculate total amounts via linear scanning, determine the fiscal balance as the difference between revenue and expenditures, and apply decision logic to characterize the budget as surplus, deficit, or balanced. Additionally, a value normalization algorithm is applied, converting financial values from strings into a numerical format suitable for calculations.There are also *test* files that support the application's verification using test data and fake repositories to validate the various algorithms.
- The **graphics** module handles data visualization, using aggregate numerical values and chart data structures derived from the linear processing of lists to create pie charts and comparative graphs.

## SUPPLEMENTARY TECHNICAL DOCUMENTATION
* **[Licence](https://github.com/johnanton21/7-1-BONUS/commit/2443d17b66ae411cbf5f662e955dbd4f854e80c1):** This project is licensed under the **MIT License**.
* **[Test Coverage(structure)](https://github.com/johnanton21/7-1-BONUS/blob/458793b6cb2a1ff60f4fd52053a33085ff9a41e1/docs/Jacoco):** Detailed unit testing structure using **JaCoCo**.
* **[Test Coverage report (zip)](https://drive.google.com/drive/folders/1LK6nllc56X1puiJcOABDAAZZtHUuqAR8?usp=drive_link):** Detailed reports on unit testing and code coverage using **JaCoCo**.
* **[Code Documentation](.):** Comprehensive **JavaDocs** for all core classes.
*  **AI** use in order to resolve some conflicts or problems that occured during the coding process: **[ChatGPT](https://chatgpt.com/)** and **[Chaton(Claude)](https://chaton.ai/claude/?utm_source=google&utm_medium=cpc&utm_campaign=GA%20|%20ChatOn%20|%20Web%20|%20T2%20|%20Search%20|%20Main%20|%20CPA%20|%2021.08.25&utm_content=785659180522&utm_term=claude%20ai%20free&campaign_id=22809916764&adset_id=186149762581&ad_id=785659180522&gad_source=1&gad_campaignid=22809916764&gbraid=0AAAAA9SXzF4VDuPf82AgGkUgHSj0LrI7R&gclid=CjwKCAiAjojLBhAlEiwAcjhrDmgdcHKCAHWDQW3WyDpyYr7uEPKXuz-h1t0JESNfhw0PtwSxKkG_GRoCLC4QAvD_BwE)**.
* <ins>Code Quality:</ins> Static code analysis using **Checkstyle** to ensure maintainability.
