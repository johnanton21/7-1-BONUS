package com.bonus71.functions.main.functions;

import com.bonus71.data.entity.financial.Expenditure;
import com.bonus71.data.entity.financial.Revenue;
import com.bonus71.data.repository.ExpenditureRepository;
import com.bonus71.data.repository.RevenueRepository;
import java.sql.SQLException;
import java.util.List;

public class FinancialService {

  private final ExpenditureRepository expenditureRepository;
  private final RevenueRepository revenueRepository;

  public FinancialService() {
    this.expenditureRepository = new ExpenditureRepository();
    this.revenueRepository = new RevenueRepository();
  }


  public List<Revenue> getAllRevenues() throws SQLException {
    return revenueRepository.findAll();
  }

  public List<Expenditure> getAllExpenditures() throws SQLException {
    return expenditureRepository.findAll();
  }


  public double calculateTotalRevenue() throws SQLException {
    List<Revenue> revenues = revenueRepository.findAll();
    double total = 0.0;

    for (Revenue revenue : revenues) {
      total += parseAmount(revenue.getEuros());
    }

    return total;
  }

  public double calculateTotalExpenditure() throws SQLException {
    List<Expenditure> expenditures = expenditureRepository.findAll();
    double total = 0.0;

    for (Expenditure expenditure : expenditures) {
      total += parseAmount(expenditure.getEuros());
    }

    return total;
  }

  public double calculateFiscalBalance() throws SQLException {
    double totalRevenue = calculateTotalRevenue();
    double totalExpenditure = calculateTotalExpenditure();
    return totalRevenue - totalExpenditure;
  }

  public boolean isSurplus() throws SQLException {
    return calculateFiscalBalance() >= 0;
  }

  public String getFiscalBalanceStatus() throws SQLException {
    double balance = calculateFiscalBalance();

    if (balance > 0) {
      return "Surplus: " + String.format("%.2f", balance) + " euros";
    } else if (balance < 0) {
      return "Deficit: " + String.format("%.2f", Math.abs(balance)) + " euros";
    } else {
      return "Balanced: 0.00 euros";
    }
  }


  public void updateRevenue(Revenue revenue) throws SQLException {
    revenueRepository.update(revenue);
  }

  public void updateExpenditure(Expenditure expenditure) throws SQLException {
    expenditureRepository.update(expenditure);
  }

  public void addRevenue(Revenue revenue) throws SQLException {
    revenueRepository.insert(revenue);
  }

  public void addExpenditure(Expenditure expenditure) throws SQLException {
    expenditureRepository.insert(expenditure);
  }

  public void deleteRevenue(int code) throws SQLException {
    revenueRepository.delete(code);
  }

  public void deleteExpenditure(int code) throws SQLException {
    expenditureRepository.delete(code);
  }


  private double parseAmount(String amount) {
    if (amount == null || amount.trim().isEmpty()) {
      return 0.0;
    }

    try {
      // Remove currency symbols and whitespace, keep only digits, dots, and commas
      String cleaned = amount.replaceAll("[^0-9.,-]", "").trim();

      // Handle European format (1.234,56) vs US format (1,234.56)
      // If both comma and dot exist, determine which is the decimal separator
      if (cleaned.contains(",") && cleaned.contains(".")) {
        int lastComma = cleaned.lastIndexOf(',');
        int lastDot = cleaned.lastIndexOf('.');

        if (lastComma > lastDot) {
          // European format: 1.234,56 -> remove dots, replace comma with dot
          cleaned = cleaned.replace(".", "").replace(",", ".");
        } else {
          // US format: 1,234.56 -> just remove commas
          cleaned = cleaned.replace(",", "");
        }
      } else if (cleaned.contains(",")) {
        // Only comma exists - could be decimal (2,50) or thousands (1,200)
        // Assume decimal if only one comma and it's near the end (2-3 digits after)
        int commaPos = cleaned.lastIndexOf(',');
        int digitsAfterComma = cleaned.length() - commaPos - 1;

        if (digitsAfterComma <= 2 && cleaned.indexOf(',') == commaPos) {
          // Likely decimal separator: 2,50
          cleaned = cleaned.replace(",", ".");
        } else {
          // Likely thousands separator: 1,200
          cleaned = cleaned.replace(",", "");
        }
      } else if (cleaned.contains(".")) {
        // Only dot exists - could be decimal (25.5) or thousands (3.500)
        // If dot has exactly 3 digits after it, it's likely thousands separator (European)
        int dotPos = cleaned.lastIndexOf('.');
        int digitsAfterDot = cleaned.length() - dotPos - 1;

        if (digitsAfterDot == 3 && cleaned.indexOf('.') == dotPos) {
          // Likely thousands separator: 3.500
          cleaned = cleaned.replace(".", "");
        }
        // Otherwise assume decimal separator (US format): 25.5
      }

      return Double.parseDouble(cleaned);
    } catch (NumberFormatException e) {
      System.err.println("Warning: Could not parse amount '" + amount + "', treating as 0.0");
      return 0.0;
    }
  }
}

