package com.bonus71.functions.main.functions;

import com.bonus71.data.entity.financial.Expenditure;
import com.bonus71.data.entity.financial.Revenue;
import com.bonus71.data.repository.ExpenditureRepository;
import com.bonus71.data.repository.RevenueRepository;
import java.sql.SQLException;
import java.util.List;
/**
 * Service layer providing high-level operations for financial data management.
 *
 * <p>This class acts as an abstraction over the underlying repository layer,
 * offering both data-retrieval and financial computation capabilities. It
 * supports CRUD operations for revenues and expenditures, as well as computing
 * aggregated financial metrics such as fiscal balance, total revenue, and
 * total expenditure.</p>
 *
 * <p><b>Responsibilities:</b></p>
 * <ul>
 *     <li>Fetching revenue and expenditure collections</li>
 *     <li>Performing fiscal calculations</li>
 *     <li>Providing balance/surplus-deficit interpretations</li>
 *     <li>Delegating persistence operations to repository classes</li>
 * </ul>
 *
 * <p>This service is typically used by controllers or menu layers that require
 * a structured business logic layer instead of direct repository access.</p>
 */
public class FinancialService {

  private final ExpenditureRepository expenditureRepository;
  private final RevenueRepository revenueRepository;

    /**
     * Constructs the service using new repository instances.
     *
     * <p>Repositories are created upon initialization and reused for all
     * operations performed by this service instance.</p>
     */

  public FinancialService() {
    this.expenditureRepository = new ExpenditureRepository();
    this.revenueRepository = new RevenueRepository();
  }

    /**
     * Retrieves all revenues from the database.
     *
     * @return a list of {@link Revenue} entities
     * @throws SQLException if a data-access error occurs
     */

  public List<Revenue> getAllRevenues() throws SQLException {
    return revenueRepository.findAll();
  }

    /**
     * Retrieves all expenditures from the database.
     *
     * @return a list of {@link Expenditure} entities
     * @throws SQLException if a data-access error occurs
     */

  public List<Expenditure> getAllExpenditures() throws SQLException {
    return expenditureRepository.findAll();
  }

    /**
     * Computes the sum of all revenue amounts.
     *
     * @return total revenue in euros as a double value
     * @throws SQLException if revenue retrieval fails
     */

  public double calculateTotalRevenue() throws SQLException {
    List<Revenue> revenues = revenueRepository.findAll();
    double total = 0.0;

    for (Revenue revenue : revenues) {
      total += parseAmount(revenue.getEuros());
    }

    return total;
  }
    /**
     * Computes the sum of all expenditure amounts.
     *
     * @return total expenditures in euros as a double value
     * @throws SQLException if expenditure retrieval fails
     */

  public double calculateTotalExpenditure() throws SQLException {
    List<Expenditure> expenditures = expenditureRepository.findAll();
    double total = 0.0;

    for (Expenditure expenditure : expenditures) {
      total += parseAmount(expenditure.getEuros());
    }

    return total;
  }
    /**
     * Calculates the fiscal balance as:
     * <pre>totalRevenue - totalExpenditure</pre>
     *
     * @return the fiscal balance (positive = surplus, negative = deficit)
     * @throws SQLException if retrieval or computation fails
     */

  public double calculateFiscalBalance() throws SQLException {
    double totalRevenue = calculateTotalRevenue();
    double totalExpenditure = calculateTotalExpenditure();
    return totalRevenue - totalExpenditure;
  }

    /**
     * Indicates whether the fiscal state reflects a surplus.
     *
     * @return {@code true} if revenues >= expenditures, otherwise {@code false}
     * @throws SQLException if balance calculation fails
     */

  public boolean isSurplus() throws SQLException {
    return calculateFiscalBalance() >= 0;
  }

    /**
     * Returns a formatted human-readable string describing the fiscal balance.
     *
     * @return status string in one of the formats: "Surplus: X euros", "Deficit: X euros", or "Balanced: 0.00 euros"
     * @throws SQLException if balance calculation fails
     */

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

    /**
     * Updates an existing revenue record.
     *
     * @param revenue the updated revenue entity
     * @throws SQLException if the update fails
     */

  public void updateRevenue(Revenue revenue) throws SQLException {
    revenueRepository.update(revenue);
  }

    /**
     * Updates an existing expenditure record.
     *
     * @param expenditure the updated expenditure entity
     * @throws SQLException if the update fails
     */

  public void updateExpenditure(Expenditure expenditure) throws SQLException {
    expenditureRepository.update(expenditure);
  }

    /**
     * Inserts a new revenue record.
     *
     * @param revenue the entity to insert
     * @throws SQLException if insertion fails
     */

  public void addRevenue(Revenue revenue) throws SQLException {
    revenueRepository.insert(revenue);
  }

    /**
     * Inserts a new expenditure record.
     *
     * @param expenditure the entity to insert
     * @throws SQLException if insertion fails
     */

  public void addExpenditure(Expenditure expenditure) throws SQLException {
    expenditureRepository.insert(expenditure);
  }

    /**
     * Deletes an expenditure record based on its identifier.
     *
     * @param code the expenditure identifier
     * @throws SQLException if deletion fails
     */

  public void deleteRevenue(int code) throws SQLException {
    revenueRepository.delete(code);
  }

    /**
     * Deletes an expenditure record based on its identifier.
     *
     * @param code the expenditure identifier
     * @throws SQLException if deletion fails
     */

  public void deleteExpenditure(int code) throws SQLException {
    expenditureRepository.delete(code);
  }

    /**
     * Parses a string representing a currency value and attempts to convert it to a double.
     *
     * <p>This helper method supports both European and US numeric formats and attempts
     * to normalize the value before parsing.</p>
     *
     * @param amount a formatted currency string (e.g. "1.234,56€" or "$1,234.56")
     * @return parsed numeric value or {@code 0.0} if parsing fails
     */

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

