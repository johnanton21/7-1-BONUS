/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.data.entity.Comparison;

/**
 * Represents a financial comparison for a specific fiscal year.
 *
 * <p>This class is a data entity that encapsulates summarized financial
 * information for a given year, including net revenues, total expenses,
 * and the resulting balance.</p>
 *
 * <p>Instances of this class are used to support comparative analysis
 * between different years, enabling the application to evaluate financial
 * performance trends and generate comparison reports.</p>
 */

public class YearsComparison {

  private int year;
  private String netRevenues;
  private String expenses;
  private String balance;

  public YearsComparison(int year, String netRevenues, String expenses, String balance) {
    this.year = year;
    this.netRevenues = netRevenues;
    this.expenses = expenses;
    this.balance = balance;
  }
  /**
   * Returns the fiscal year of this comparison.
   *
   * @return the fiscal year
   */

  public int getYear() {
    return year;
  }

  /**
   * Sets the fiscal year of this comparison.
   *
   * @param year the fiscal year to set
   */

  public void setYear(int year) {
    this.year = year;
  }

  public String getNetRevenues() {
    return netRevenues;
  }

  public void setNetRevenues(String netRevenues) {
    this.netRevenues = netRevenues;
  }

  public String getExpenses() {
    return expenses;
  }

  public void setExpenses(String expenses) {
    this.expenses = expenses;
  }

  public String getBalance() {
    return balance;
  }

  public void setBalance(String balance) {
    this.balance = balance;
  }
}
