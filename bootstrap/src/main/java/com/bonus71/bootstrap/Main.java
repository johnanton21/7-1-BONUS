package com.bonus71.bootstrap;


import com.bonus71.data.entity.financial.Expenditure;
import com.bonus71.data.entity.financial.ExpenditureDetailed;
import com.bonus71.data.entity.financial.Revenue;
import com.bonus71.data.entity.ministry.Education;
import com.bonus71.data.entity.ministry.Environment;
import com.bonus71.data.entity.ministry.FinanceMinistry;
import com.bonus71.data.entity.ministry.Health;
import com.bonus71.data.entity.ministry.NationalDefense;
import com.bonus71.data.repository.EducationRepository;
import com.bonus71.data.repository.EnvironmentRepository;
import com.bonus71.data.repository.ExpenditureDetailedRepository;
import com.bonus71.data.repository.ExpenditureRepository;
import com.bonus71.data.repository.FinanceMinistryRepository;
import com.bonus71.data.repository.HealthRepository;
import com.bonus71.data.repository.NationalDefenseRepository;
import com.bonus71.data.repository.RevenueRepository;
import com.bonus71.functions.main.functions.FinancialService;
import com.bonus71.functions.menus.YearsComparisonMenu;
import com.bonus71.graphics.Comparison22_25;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;


public class Main extends JFrame {
  private final FinancialService financialService = new FinancialService();

  public Main() {
    setTitle("Budget Management System");
    setSize(700, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    initializeUi();
  }

  private void initializeUi() {
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout(10, 10));
    mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


    JLabel titleLabel = new JLabel("BUDGET MANAGEMENT SYSTEM", SwingConstants.CENTER);
    titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
    titleLabel.setForeground(new Color(0, 51, 102));
    mainPanel.add(titleLabel, BorderLayout.NORTH);


    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new GridLayout(7, 1, 10, 15));

    JButton btn1 = createMenuButton("1. Display Government Budget Data");
    JButton btn2 = createMenuButton("2. Display Fiscal Balance");
    JButton btn3 = createMenuButton("3. Categorize by Ministry");
    JButton btn4 = createMenuButton("4. Compare with Other Years");
    JButton btn5 = createMenuButton("5. Apply Changes (Edit Data)");
    JButton btn6 = createMenuButton("6. Analyze Statistical Data");
    JButton btn7 = createMenuButton("7. Exit");

    btn1.addActionListener(e -> displayBudgetData());
    btn2.addActionListener(e -> displayFiscalBalance());
    btn3.addActionListener(e -> categorizeByMinistry());
    btn4.addActionListener(e -> compareWithOtherYears());
    btn5.addActionListener(e -> applyChanges());
    btn6.addActionListener(e -> analyzeStatisticalData());
    btn7.addActionListener(e -> exitApplication());

    buttonsPanel.add(btn1);
    buttonsPanel.add(btn2);
    buttonsPanel.add(btn3);
    buttonsPanel.add(btn4);
    buttonsPanel.add(btn5);
    buttonsPanel.add(btn6);
    buttonsPanel.add(btn7);

    mainPanel.add(buttonsPanel, BorderLayout.CENTER);

    add(mainPanel);
  }

  private JButton createMenuButton(String text) {
    JButton button = new JButton(text);
    button.setFont(new Font("Arial", Font.PLAIN, 16));
    button.setFocusPainted(false);
    button.setBackground(new Color(240, 240, 240));
    button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 51, 102), 2),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
    ));
    return button;
  }

  // OPTION 1: Display Budget Data
  private void displayBudgetData() {
    try {
      StringBuilder sb = new StringBuilder();
      sb.append("=== EXPENDITURES ===\n\n");

      ExpenditureRepository exR = new ExpenditureRepository();
      for (Expenditure ex : exR.findAll()) {
        sb.append(ex.getCode()).append(" | ")
                  .append(ex.getCategory()).append(" | ")
                  .append(ex.getEuros()).append("\n");
      }

      sb.append("\n=== REVENUES ===\n\n");
      RevenueRepository esR = new RevenueRepository();
      for (Revenue es : esR.findAll()) {
        sb.append(es.getCode()).append(" | ")
                  .append(es.getCategory()).append(" | ")
                  .append(es.getEuros()).append("\n");
      }

      sb.append("\n=== DETAILED EXPENDITURES - ARTICLE 2 ===\n\n");
      ExpenditureDetailedRepository ex2R = new ExpenditureDetailedRepository();
      for (ExpenditureDetailed ex2 : ex2R.findAll()) {
        sb.append(ex2.getCode()).append(" | ")
                  .append(ex2.getDepartment()).append(" | ")
                  .append(ex2.getRegularBudget()).append(" | ")
                  .append(ex2.getPublicInvestmentBudget()).append(" | ")
                  .append(ex2.getTotal()).append("\n");
      }

      showTextDialog("Budget Data", sb.toString());
    } catch (SQLException e) {
      showError("Error loading budget data: " + e.getMessage());
    }
  }

  // OPTION 2: Display Fiscal Balance (using FinancialService)
  private void displayFiscalBalance() {
    try {
      double totalRevenue = financialService.calculateTotalRevenue();
      double totalExpenditure = financialService.calculateTotalExpenditure();
      double balance = financialService.calculateFiscalBalance();
      String status = financialService.getFiscalBalanceStatus();

      String message = String.format(
              """
                      FISCAL BALANCE REPORT
                      
                      Total Revenue:      %.2f EUR
                      Total Expenditure:  %.2f EUR
                      ─────────────────────────────────
                      Fiscal Balance:     %.2f EUR
                      
                      Status: %s""",
                totalRevenue, totalExpenditure, balance, status
      );

      JOptionPane.showMessageDialog(this, message, "Fiscal Balance",
                    JOptionPane.INFORMATION_MESSAGE);
    } catch (SQLException e) {
      showError("Error calculating fiscal balance: " + e.getMessage());
    }
  }

  // OPTION 3: Categorize by Ministry
  private void categorizeByMinistry() {
    String[] ministries = {
      "Ministry of Education, Religious Affairs and Sports",
      "Ministry of Environment",
      "Ministry of National Defense",
      "Ministry of Finance",
      "Ministry of Health"
    };

    String choice = (String) JOptionPane.showInputDialog(this,
                "Select Ministry:", "Categorize by Ministry",
                JOptionPane.QUESTION_MESSAGE, null, ministries, ministries[0]);

    if (choice != null) {
      try {
        StringBuilder sb = new StringBuilder();
        sb.append("=== ").append(choice.toUpperCase()).append(" ===\n\n");
        sb.append("MAJOR CATEGORY | NAME | EUROS\n");
        sb.append("─────────────────────────────────────────\n");

        if (choice.contains("Education, Religious Affairs and Sports")) {
          for (Education e : new EducationRepository().findAll()) {
            sb.append(e.getMajorCategory()).append(" | ")
                          .append(e.getName()).append(" | ")
                          .append(e.getEuros()).append("\n");
          }
        } else if (choice.contains("Environment")) {
          for (Environment e : new EnvironmentRepository().findAll()) {
            sb.append(e.getMajorCategory()).append(" | ")
                          .append(e.getName()).append(" | ")
                          .append(e.getEuros()).append("\n");
          }
        } else if (choice.contains("Defense")) {
          for (NationalDefense e : new NationalDefenseRepository().findAll()) {
            sb.append(e.getMajorCategory()).append(" | ")
                          .append(e.getName()).append(" | ")
                          .append(e.getEuros()).append("\n");
          }
        } else if (choice.contains("Finance")) {
          for (FinanceMinistry e : new FinanceMinistryRepository().findAll()) {
            sb.append(e.getMajorCategory()).append(" | ")
                          .append(e.getName()).append(" | ")
                          .append(e.getEuros()).append("\n");
          }
        } else if (choice.contains("Health")) {
          for (Health e : new HealthRepository().findAll()) {
            sb.append(e.getMajorCategory()).append(" | ")
                          .append(e.getName()).append(" | ")
                          .append(e.getEuros()).append("\n");
          }
        }

        showTextDialog(choice, sb.toString());
      } catch (SQLException e) {
        showError("Error loading ministry data: " + e.getMessage());
      }
    }
  }

  // OPTION 4: Compare with Other Years
  private final YearsComparisonMenu yearsComparisonMenu = new YearsComparisonMenu();

  private void compareWithOtherYears() {
    String[] options = {
      "Compare 2025 with 2022",
      "Compare 2025 with 2023",
      "Compare 2025 with 2024",
      "General Conclusions"
    };

    String choice = (String) JOptionPane.showInputDialog(
                this,
                "Select comparison:",
                "Years Comparison",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
    );

    if (choice == null) {
      return;
    }

    try {
      String result;

      switch (choice) {
        case "Compare 2025 with 2022" -> result =
                        yearsComparisonMenu.compare(2025, 2022);

        case "Compare 2025 with 2023" -> result =
                        yearsComparisonMenu.compare(2025, 2023);

        case "Compare 2025 with 2024" -> result =
                        yearsComparisonMenu.compare(2025, 2024);

        case "General Conclusions" -> result =
                        yearsComparisonMenu.generalConclusions();

        default -> result = "Invalid choice.";
      }

      showTextDialog("Year Comparison Result", result);

    } catch (SQLException e) {
      showError("Error loading comparison data: " + e.getMessage());
    }
  }


  // OPTION 5: Apply Changes (Edit Data)
  private void applyChanges() {
    String[] categories = {
      "Expenditures",
      "Revenues",
      "Ministry of Education, Religious Affairs and Sports",
      "Ministry of Environment",
      "Ministry of National Defense",
      "Ministry of Finance",
      "Ministry of Health"
    };

    String choice = (String) JOptionPane.showInputDialog(this,
                "Select category to edit:", "Edit Data",
                JOptionPane.QUESTION_MESSAGE, null, categories, categories[0]);

    if (choice != null) {
      try {
        switch (choice) {
          case "Expenditures" -> editExpenditures();
          case "Revenues" -> editRevenues();
          case "Ministry of Education, Religious Affairs and Sports" -> editEducation();
          case "Ministry of Environment" -> editEnvironment();
          case "Ministry of National Defense" -> editNationalDefense();
          case "Ministry of Finance" -> editFinanceMinistry();
          case "Ministry of Health" -> editHealth();
          default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
      } catch (SQLException e) {
        showError("Error editing data: " + e.getMessage());
      }
    }
  }

  private void editExpenditures() throws SQLException {
    String[] operations = {"View", "Add", "Update", "Delete"};
    String operation = (String) JOptionPane.showInputDialog(this,
                "Select operation:", "Edit Expenditures",
                JOptionPane.QUESTION_MESSAGE, null, operations, operations[0]);

    if (operation == null) {
      return;
    }

    ExpenditureRepository repo = new ExpenditureRepository();

    switch (operation) {
      case "View" -> {
        StringBuilder sb = new StringBuilder("EXPENDITURES\n\n");
        for (Expenditure e : repo.findAll()) {
          sb.append(e.getCode()).append(" | ")
                      .append(e.getCategory()).append(" | ")
                      .append(e.getEuros()).append("\n");
        }
                showTextDialog("Expenditures", sb.toString());
      }
      case "Add" -> {
                String code = JOptionPane.showInputDialog(this, "Enter Code:");
                if (code == null) return;
                String category = JOptionPane.showInputDialog(this, "Enter Category:");
                if (category == null) return;
                String euros = JOptionPane.showInputDialog(this, "Enter Euros:");
                if (euros == null) return;

                Integer codeInt = parseInteger(code, "Code");
                if (codeInt == null) return;

                repo.insert(new Expenditure(codeInt, category, euros));
                JOptionPane.showMessageDialog(this, "Expenditure added successfully!");
      }
      case "Update" -> {
                String code = JOptionPane.showInputDialog(this, "Enter Code to update:");
                if (code == null) return;
                String category = JOptionPane.showInputDialog(this, "Enter new Category:");
                if (category == null) return;
                String euros = JOptionPane.showInputDialog(this, "Enter new Euros:");
                if (euros == null) return;

                Integer codeInt = parseInteger(code, "Code");
                if (codeInt == null) return;

                repo.update(new Expenditure(codeInt, category, euros));
                JOptionPane.showMessageDialog(this, "Expenditure updated successfully!");
      }
      case "Delete" -> {
                String code = JOptionPane.showInputDialog(this, "Enter Code to delete:");
                if (code == null) return;

                Integer codeInt = parseInteger(code, "Code");
                if (codeInt == null) return;

                int confirm = JOptionPane.showConfirmDialog(this,
                        "Are you sure you want to delete this expenditure?",
                        "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    repo.delete(codeInt);
                    JOptionPane.showMessageDialog(this, "Expenditure deleted successfully!");
                }
      }
      default -> throw new IllegalStateException("Unexpected value: " + operation);
    }
  }

  private void editRevenues() throws SQLException {
    String[] operations = {"View", "Add", "Update", "Delete"};
    String operation = (String) JOptionPane.showInputDialog(this,
                "Select operation:", "Edit Revenues",
                JOptionPane.QUESTION_MESSAGE, null, operations, operations[0]);

    if (operation == null) {
      return;
    }

    RevenueRepository repo = new RevenueRepository();

    switch (operation) {
      case "View" -> {
        StringBuilder sb = new StringBuilder("REVENUES\n\n");
        for (Revenue e : repo.findAll()) {
          sb.append(e.getCode()).append(" | ")
                      .append(e.getCategory()).append(" | ")
                      .append(e.getEuros()).append("\n");
                }
                showTextDialog("Revenues", sb.toString());
            }
            case "Add" -> {
                String code = JOptionPane.showInputDialog(this, "Enter Code:");
                if (code == null) return;
                String category = JOptionPane.showInputDialog(this, "Enter Category:");
                if (category == null) return;
                String euros = JOptionPane.showInputDialog(this, "Enter Euros:");
                if (euros == null) return;

                Integer codeInt = parseInteger(code, "Code");
                if (codeInt == null) return;

                repo.insert(new Revenue(codeInt, category, euros));
                JOptionPane.showMessageDialog(this, "Revenue added successfully!");
            }
            case "Update" -> {
                String code = JOptionPane.showInputDialog(this, "Enter Code to update:");
                if (code == null) return;
                String category = JOptionPane.showInputDialog(this, "Enter new Category:");
                if (category == null) return;
                String euros = JOptionPane.showInputDialog(this, "Enter new Euros:");
                if (euros == null) return;

                Integer codeInt = parseInteger(code, "Code");
                if (codeInt == null) return;

                repo.update(new Revenue(codeInt, category, euros));
                JOptionPane.showMessageDialog(this, "Revenue updated successfully!");
            }
            case "Delete" -> {
                String code = JOptionPane.showInputDialog(this, "Enter Code to delete:");
                if (code == null) return;

                Integer codeInt = parseInteger(code, "Code");
                if (codeInt == null) return;

                int confirm = JOptionPane.showConfirmDialog(this,
                        "Are you sure you want to delete this revenue?",
                        "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    repo.delete(codeInt);
                    JOptionPane.showMessageDialog(this, "Revenue deleted successfully!");
                }
            }


      default -> throw new IllegalStateException("Unexpected value: " + operation);
    }
  }

  private void editEducation() throws SQLException {
    editMinistryGeneric("Education, Religious Affairs and Sports", new EducationRepository());
  }

  private void editEnvironment() throws SQLException {
    editMinistryGeneric("Environment", new EnvironmentRepository());
  }

  private void editNationalDefense() throws SQLException {
    editMinistryGeneric("National Defense", new NationalDefenseRepository());
  }

  private void editFinanceMinistry() throws SQLException {
    editMinistryGeneric("Finance", new FinanceMinistryRepository());
  }

  private void editHealth() throws SQLException {
    editMinistryGeneric("Health", new HealthRepository());
  }

  private <T> void editMinistryGeneric(String ministryName, Object repo) throws SQLException {
    String[] operations = {"View", "Add", "Update", "Delete"};
    String operation = (String) JOptionPane.showInputDialog(this,
                "Select operation:", "Edit " + ministryName,
                JOptionPane.QUESTION_MESSAGE, null, operations, operations[0]);

    if (operation == null) {
      return;
    }

    switch (operation) {
        case "View" -> {
            StringBuilder sb = new StringBuilder("MINISTRY OF " + ministryName.toUpperCase() + "\n\n");
            List<?> items = null;

            if (repo instanceof EducationRepository r) {
                items = r.findAll();
            } else {
                if (repo instanceof EnvironmentRepository r) items = r.findAll();
                else if (repo instanceof NationalDefenseRepository r) items = r.findAll();
                else if (repo instanceof FinanceMinistryRepository r) items = r.findAll();
                else if (repo instanceof HealthRepository r) items = r.findAll();
            }

            if (items != null) {
                for (Object item : items) {
                    if (item instanceof Education e) {
                        sb.append(e.getMajorCategory()).append(" | ")
                                .append(e.getName()).append(" | ")
                                .append(e.getEuros()).append("\n");
                    } else if (item instanceof Environment e) {
                        sb.append(e.getMajorCategory()).append(" | ")
                                .append(e.getName()).append(" | ")
                                .append(e.getEuros()).append("\n");
                    } else if (item instanceof NationalDefense e) {
                        sb.append(e.getMajorCategory()).append(" | ")
                                .append(e.getName()).append(" | ")
                                .append(e.getEuros()).append("\n");
                    } else if (item instanceof FinanceMinistry e) {
                        sb.append(e.getMajorCategory()).append(" | ")
                                .append(e.getName()).append(" | ")
                                .append(e.getEuros()).append("\n");
                    } else if (item instanceof Health e) {
                        sb.append(e.getMajorCategory()).append(" | ")
                                .append(e.getName()).append(" | ")
                                .append(e.getEuros()).append("\n");
                    }
                }
            }
            showTextDialog(ministryName, sb.toString());
        }
        case "Add" -> {
        String major = JOptionPane.showInputDialog(this, "Enter Major Category:");
        if (major == null) {
          return;
        }
        String name = JOptionPane.showInputDialog(this, "Enter Name:");
        if (name == null) {
          return;
        }
        String euros = JOptionPane.showInputDialog(this, "Enter Euros:");
        if (euros == null) {
          return;
        }

        int majorCat = Integer.parseInt(major);
        if (repo instanceof EducationRepository r) r.insert(new Education(majorCat, name, euros));
        else if (repo instanceof EnvironmentRepository r) r.insert(new Environment(majorCat, name, euros));
        else if (repo instanceof NationalDefenseRepository r) r.insert(new NationalDefense(majorCat, name, euros));
        else if (repo instanceof FinanceMinistryRepository r) r.insert(new FinanceMinistry(majorCat, name, euros));
        else if (repo instanceof HealthRepository r) r.insert(new Health(majorCat, name, euros));

        JOptionPane.showMessageDialog(this, ministryName + " entry added successfully!");
      }
      case "Update" -> {
            StringBuilder sb = new StringBuilder("MINISTRY OF " + ministryName.toUpperCase() + "\n\n");
        String major = JOptionPane.showInputDialog(this, "Enter Major Category to update:");
        if (major == null) {
          return;
        }
        String name = JOptionPane.showInputDialog(this, "Enter new Name:");
        if (name == null) {
          return;
        }
        String euros = JOptionPane.showInputDialog(this, "Enter new Euros:");
        if (euros == null) {
          return;
        }

                Integer majorCat = parseInteger(major, "Major Category");
                if (majorCat == null) return;

                int confirm = JOptionPane.showConfirmDialog(this,
                        "Are you sure you want to delete this entry?",
                        "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    if (repo instanceof EducationRepository r) r.delete(majorCat);
                    else if (repo instanceof EnvironmentRepository r) r.delete(majorCat);
                    else if (repo instanceof NationalDefenseRepository r) r.delete(majorCat);
                    else if (repo instanceof FinanceMinistryRepository r) r.delete(majorCat);
                    else if (repo instanceof HealthRepository r) r.delete(majorCat);

                    JOptionPane.showMessageDialog(this, ministryName + " entry deleted successfully!");
                }
            }


      default -> throw new IllegalStateException("Unexpected value: " + operation);
    }
  }

  // OPTION 6: Analyze Statistical Data
  private void analyzeStatisticalData() {
    Comparison22_25.showChart();
  }

  // OPTION 7: Exit
  private void exitApplication() {
    int result = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to exit?",
                "Exit Confirmation",
                JOptionPane.YES_NO_OPTION);
    if (result == JOptionPane.YES_OPTION) {
      System.exit(0);
    }
  }

  // Helper methods
  private void showTextDialog(String title, String content) {
    JTextArea textArea = new JTextArea(content);
    textArea.setEditable(false);
    textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

    JScrollPane scrollPane = new JScrollPane(textArea);
    scrollPane.setPreferredSize(new Dimension(600, 400));

    JOptionPane.showMessageDialog(this, scrollPane, title,
                JOptionPane.INFORMATION_MESSAGE);
  }

    /**
     * Safely parses a string to an integer with user-friendly error handling.
     * @param input the string to parse
     * @param fieldName the name of the field being parsed (for error messages)
     * @return the parsed integer, or null if parsing fails
     */
    private Integer parseInteger(String input, String fieldName) {
        if (input == null || input.trim().isEmpty()) {
            showError(fieldName + " cannot be empty!");
            return null;
        }

        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            showError("Invalid " + fieldName + ": Please enter a valid number.");
            return null;
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error",
                JOptionPane.ERROR_MESSAGE);
  }

  static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      Main frame = new Main();
      frame.setVisible(true);
    });
  }
}
