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
    /** Fiscal year for this comparison. */
    private int year;
    /** Total net revenues for the fiscal year. */
    private String netRevenues;
    /** Total expenses for the fiscal year. */
    private String expenses;
    /** Net balance (revenues - expenses) for the fiscal year. */
    private String balance;
    /**
     * Constructs a YearsComparison instance with all fields initialized.
     *
     * @param year the fiscal year
     * @param netRevenues total net revenues
     * @param expenses total expenses
     * @param balance net balance
     */
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
    /**
     * Returns the net revenues.
     *
     * @return net revenues as a string
     */
    public String getNetRevenues() {
        return netRevenues;
    }
    /**
     * Sets the net revenues.
     *
     * @param netRevenues the net revenues to set
     */
    public void setNetRevenues(String netRevenues) {
        this.netRevenues = netRevenues;
    }
    /**
     * Returns the total expenses.
     *
     * @return expenses as a string
     */
    public String getExpenses() {
        return expenses;
    }
    /**
     * Sets the total expenses.
     *
     * @param expenses the expenses to set
     */
    public void setExpenses(String expenses) {
        this.expenses = expenses;
    }
    /**
     * Returns the net balance (revenues - expenses).
     *
     * @return balance as a string
     */
    public String getBalance() {
        return balance;
    }
    /**
     * Sets the net balance.
     *
     * @param balance the balance to set
     */
    public void setBalance(String balance) {
        this.balance = balance;
    }
}
