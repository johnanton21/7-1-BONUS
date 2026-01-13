# 7+1+BONUS - TECHNICAL REFERENCE/DOCUMENTATION

## BUDGET-HERO
"BUDGET-HERO" is an open-source state budget overview and processing system. The application displays current and historical state budget data, performs comparisons between different years, and visualizes them through various graphical elements. Additionally, it calculates and displays the fiscal balance and updates the data based on user modifications. Licensed under the MIT License.

## COMPILATION 
**Prerequisites**
- Java JDK
- Apache Maven
- `JAVA_HOME` environment variable properly set


**Step 1. Clone the repository** 
```bash
git clone https://github.com/johnanton21/7-1-BONUS.git
cd 7-1-BONUS
```

**2. Compile all modules**

From the root directory of the project, where the parent `pom.xml` file is located, run:
```bash
mvn clean compile
```

## EXECUTION
**Step 1: To launch the main menu of the application, run:**

```bash
mvn exec:java -pl bootstrap -Dexec.mainClass=com.bonus71.bootstrap.Main
```
After running this command, the main menu will appear in the terminal.

**Step 2: Using the Application**

Once the menu appears, follow the on-screen instructions to interact with the application.


## USAGE
1. Launch the application from the terminal
2. Provide the required input `(1-7)` when prompted
3. The program processes the input and displays the results in the console
4. To terminate the process: press `7`

## PROJECT STRUCTURE
This project is implemented as a **multi-module Maven project**.
```text
.
├── bootstrap/              # Main entry point & application startup module
├── checkstyle/             # Configuration files (checkstyle)
├── data-management/        # Data processing module
├── docs/                   # JaCoCo docs
├── functions/              # Core business logic module
├── graphics/               # Visualization and UI components module
├── .gitignore              # Files to be ignored by Git
├── LICENCE                 # Open Source License
├── README.md               # Project documentation
└── pom.xml                 # Parent Maven configuration
```

## UML
Detailed UML diagrams regarding the code architecture and system design.
* **[UML - part1](https://uml.planttext.com/plantuml/pdf/xLhBRjiu5DtxAuIk7DGnCAi1Z46GXrrCWIJesEqYguAHRbosCcMGbAUPGVvzI4cMABuSov6R39YD4TxB--0vfEXZdJEEACzNwM2mHl4Fj8GepbRZ-upaxFVVn6V66QTe7Vqx64JYBquHOz4DmaICHDNVQVI02I8nHka2w0R7C8a-Q2E3sljzCNrueWnWWhbmnV_0bu_3aqcqoN1Ic9_AQKM-yVZCY1fDefm16mY_So29xEFStr62E1h76Nd0otPFKs6uHmokjhQcko_pwqcqu1IJfJgwcCqjmvyk5ejwMEbn2Lo49X1pd17PPFEVsgfMXcowSHJjKk0v9SpbEwLu0_G64T4txRWwG3ZcZ-EhRBL65BECj1Vg3X1bBMFJ_AEmJGISN1aZmEUm0P83iomN_5m3OLRJFKe5s61RJAs6OPrtP4itChACzE0dRQHaV8cHsabXk6sYIxjMS-4ogtAvx9TbPiqiC7hQ1vrwnxN1AP8dM704Mi34MG8wC37YiCpeemsLd6RCjl1A_64TSsI46hKZdEZx805pTLbbgCEg1q4pjyfaNLscsFMIhD5ciafNgDBORgHzDdNRMBkXcm97E8La9uG9Y1t0LoAm1KGAopn5z39FHASM-pg_Jt7yaMo05I6SZZpZADt1Xct9AYlCwaRseaOxQXcrItX1Eath4bqiK3pCVgmnvsgBhh1j9-kgM8D_iYwKAul3sx_QrhoV9G2kDAMnZP5hfno-KQe3k9VphOeTphQEPzjANEN4XV5HEzgIN9ICjSl22dtFw5NTYdPhG2lOwy6qJJ4qmuvQqVputQYphK2sFSniLZ1kHG4kB0gRMk6hXvDiCCs8F3bw1BH94Y1zkJFLZcZvlGfk6cDFg6g90h9z8_ide9H_wm_GCdx0iMySRuk76qgdy22_NVO7g9Oe87lWupH8Q4522nAQkdU3X1Oaj22XcMm84beTCqXeGK8B4bgGqDImGK8B4bgGq8A45YIqW6EGqFvFoDeUf-yCR2ciCuQvQEfT1PrsCvhN3WgqxwDhGOK_QgSpARGb5wcuY4Vy6yt-Pj7Yh-lPpnZMjOvKpfErYjLZGFcmkNrjgVMisVbQL0vTPoUGWfWj06pJqptvIIwgUmMrtU5OnjQ-C98hjXBLWidcQ87ySuegXSHsBKuXKL2BYo9ZLT3JLC4cfuqOfwTdJQTMZq82RENtdK1xqBIvZ7c9shXrfAfoi-n4rgxpZqnNnmNwJHFMIf62iet5uUMXxO77gobGUVbhkdVaiKNBWsPiBqg_G2Y5tLA1E9JKjIwpSx4DTilq9dqROSsqjQGnqsoNiao_GfpwnJl4IyPYfvWUEsRrTk0tMP-vOGxUA2-mGLx_ndZcXeYTv_zhEEcjtD3uw_3oy7NRoa6yrVG57tSrrsxyrOMJBfUMWs8Sz-BYqudUykN5JHj9QytgyUxhE2vL5X-RIuzk9AuqeYxSxJBrk9Ir261lcQa64oH1oq7JrXSTDOt8nqlDjHj1TV6h2rCFYd5SolgqlhVCNJTj98argyUxBrfNF_xww5ovTAFnzeThMdxkmzukKuzpkRNz6lz6BxOc_fANrQZ5sXSFjRVRh7mytJOcOKctYxYONS-kFd-zlFjwDxkOAwkWlxGdwNlvMBpc9i6IxyyToeyckhSRWoWoj-KGQrwqit2bUiNEj5IlzVrQ7hdnatpIh1vl3x_-0m00):** The UML of bootstrap and data-management module.
* **[UML - part2](https://uml.planttext.com/plantuml/pdf/hPHFIyD04CNl-HHxRAa9MX6X1obKFGX2gISHaJMEwMAo6tOsrQBzxax-s6gwKninXxBTUMzcytj9ng2VYYmTevFMqIB8PVmY4n2noQ97emiyFOeIA_EvYb6y1u6WAqubefYOB9TMeT73uuVX2HL5SmrQfLv_Kw91JiLYOTIJmBbvdSnfC2V8fDAz6sULJkxkXRG9ri9LVOxs2SBmuqnSNLgPWRSUHLKPe1egHg90G5PPYQPIG_gRyXoUPP6wYNIG6BiybquYhFklWd4DEVWBvIdOQwKLEhkSAXWU_WJzdpGzatXWZBWXGLij23iyViwCcDRJrEpJjduE_Ya41HTlEJLGhh20NLC8kwJW6VKxMSR4PCUeVMmPAPCPVmnV57zCOWOBq4Nt53gz2wqn-oImPM3fRodzvBTaB7NVwEx4dmiTEsKqHXbrQy3Ns6z1Mjny-gwftg0FsxKPv0QLe--WiBIiH0DVWoOQVwsqZlZMZ5KauCgjtf9-Ha9frzzgqZZhxClxftteFLAWjr-c0s7S7EpwV_-d9m4DLgOJe-Eqm19OTIih5jVct9oYjFeOX-7P3hxhXs1FAnaiqAkflpqIdm00):** The UML of functions and graphics module.
* **[UML - part3](https://uml.planttext.com/plantuml/pdf/tLbTRzis57tNhn3wKWU5ZIPRCI0eWgHsWcrOkg3ksp0CZ4JRN2bI4AbqwPR_NegIB8gyLxBd59YN5mVakHyyznxwIhvKcXIwp7WK9Pme5I-OoZbvl2b5efaKL_7VKMp-NgcD_7p5-UJaF7wGB8sUMeFhlt8gKgRBWdwWkLHCo-AnsVj07wWemtN7Pa4rOPoc3YO4zTtXJg8eI7ywlK1I1A5XncCUeGE00Nt3A8ZbPX0DXi2IYA9BisJAUOdKzPO9fdJ1g6eFzCwjSBUz89e0nKxBX5HMOKd50okaoAZGmTvxQqBuWgweK64xt311H4ARu8_1_e-KSBrn2HuuZMK6I7FC1Cn_n0W_s8WXVk8Hmv0AhE3NfZDQstbROseM_Sg-ZBVkJBX3LFqVQOwNyQt9BxRRxe5KvL_PlOOEar0vAOpfENpWZgNUoH4N0I--UNk6NrTRgh1iGYfnPnytr24OymYLmFVfrG9nXLOCJx4j8kmGBV70cUko8mxzdl2wdTi3g0tBLTIN2Vvj4U926G2-04a0A50U8GwNIeZ5PHDYGmc1h7JwmTb0Tf7E7qI6RJrEoQXJfn67WtVzXL-njJD6-98M3ooXJITEOmgr47B7D2Q5tqt0VHBLZHx4dPmq6skgpOpMsAdgal_5dETjit3HGpd9T4XdiKKdX2UbKGpzA3LfVLS6gIplEGLHZXiSUSEK-VyTuLL10XXJoxB8UMbpkvUIKoAw_7ksIqrqZLkQRqonRc1bdfeeRS8DlrjMsol1nRffEoNi5QvlHz9qjm06kB_tb7BQdI2HgG4peI6Gwnm4JkES58fUPR8KUaBiHqjOn_rsqDjXSiVc0c1yZmAbm1Se28D3xZmy3mpWhR2ZJjdg4nE6A9BLuyELDWJTbvh-b4YnP5ze_Dg1f3cBJz-uAsf3KldPK1gl25VKTtSZXRPUJh-FefmadyYQnYyIcStkfIZL3wUpLNCVgLdrTQPUD5SAFiFiDSTKuAUgo61i8m4oAxP6GMo0KIU75HDfyu08NoKMnKpwXPuWBMyXjHO78NNFJxmM7pcP-H9X-d6sQdiCFPzpgkbMIywIoMvjBsZdkh4xj2oa2fPVcVjgRjnKpBYEx7hZoxkyskthog6tPq_PxuI1gUL_gOFXENgFMVeGFOHU1zNGmW4jj5ke4b308Jh86XAHOxaYoCYVifXlsxwd1a4okeyIRbrVa2JU6uVxoW5h27m43ulNmm8ptv4e8dpIylKm-hHrW2fGtqFQy8n2XNW0J2TZiETNYnVnI3NZjipmeoDUNi3kU3KKlbpmDOIzO3X0EhxB8SNKs50ezJgc3sJt-MLH1pfIDRZ51r-E18NgK4VSyjWxHB_p1zyZ7j3-eD_1YQep06QgRXETgWOWts2kwg8Tgox23XbuTmbMqyC3QcdPTSbT5oJVi4GPtXn2vp8pEc1AYhFl_ZXxutQAjzMy7RDR9f1cYIrfNFtUDT-Om1WW8qnCQa9--pqcnLgTDCJO3p-3wVIVY_Zd6wDD2kxFPdQRKXiqFe_BwjS936b1TqHGFePSq1Kf-VPHilfvHz6j_oVWuMvtbkzeqNR07QDdh_j4FoURG2ISC0JSC66MF186R62U4R3v_uxBNTpMVV1CHM3kwpsrRnMc-rG123NEB6A4r0v1GzmYKAHcU1fGAVvb9TgNwzzK2rwONIeG6A3i1qYO-G26iWw5XXZ_2W00):** The UML of data-management, functions and graphics module.

## ALGORITHMS AND DATA STRUCTURES
- The **bootstrap** module is the module containing the main class, which in turn calls the individual classes of the respective modules.
- The **data-management** module handles access to a relational database (Railway), organized into tables such as Expenditure and Revenue. The connection is implemented using JDBC through the Connection, PreparedStatement, and ResultSet structures, while each database record is transformed into entity objects (Expenditure, Revenue) and temporarily stored in List/ArrayList collections. The core algorithms include serial retrieval and data conversion (row mapping) with linear complexity O(n), as well as CRUD operations via parameterized SQL commands.
- The **functions** module utilizes lists of revenue and expenditures to calculate total amounts via linear scanning, determine the fiscal balance as the difference between revenue and expenditures, and apply decision logic to characterize the budget as surplus, deficit, or balanced. Additionally, a value normalization algorithm is applied, converting financial values from strings into a numerical format suitable for calculations.There are also *test* files that support the application's verification using test data and fake repositories to validate the various algorithms.
- The **graphics** module handles data visualization, using aggregate numerical values and chart data structures derived from the linear processing of lists to create pie charts and comparative graphs.

## SUPPLEMENTARY TECHNICAL DOCUMENTATION
* **[Licence](https://github.com/johnanton21/7-1-BONUS/commit/2443d17b66ae411cbf5f662e955dbd4f854e80c1):** This project is licensed under the **MIT License**.
* **[Test Coverage(structure)](https://github.com/johnanton21/7-1-BONUS/blob/458793b6cb2a1ff60f4fd52053a33085ff9a41e1/docs/Jacoco):** Detailed unit testing structure using **JaCoCo**.
* **[Test Coverage report (zip)](https://drive.google.com/drive/folders/1LK6nllc56X1puiJcOABDAAZZtHUuqAR8?usp=drive_link):** Detailed reports on unit testing and code coverage using **JaCoCo**.
* **[Code Documentation](https://johnanton21.github.io/7-1-BONUS/):** Comprehensive **JavaDocs** for all core classes.
*  **AI** use in order to resolve some conflicts or problems that occured during the coding process: **[ChatGPT](https://chatgpt.com/)** and **[Chaton(Claude)](https://chaton.ai/claude/?utm_source=google&utm_medium=cpc&utm_campaign=GA%20|%20ChatOn%20|%20Web%20|%20T2%20|%20Search%20|%20Main%20|%20CPA%20|%2021.08.25&utm_content=785659180522&utm_term=claude%20ai%20free&campaign_id=22809916764&adset_id=186149762581&ad_id=785659180522&gad_source=1&gad_campaignid=22809916764&gbraid=0AAAAA9SXzF4VDuPf82AgGkUgHSj0LrI7R&gclid=CjwKCAiAjojLBhAlEiwAcjhrDmgdcHKCAHWDQW3WyDpyYr7uEPKXuz-h1t0JESNfhw0PtwSxKkG_GRoCLC4QAvD_BwE)**.
* <ins>Code Quality:</ins> Static code analysis using **Checkstyle** to ensure maintainability.
