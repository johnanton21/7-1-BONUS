/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.data.entity.financial;
/**
 * Represents a detailed financial expenditure record.
 *
 * <p>This class models a detailed view of public expenditures by department.
 * It distinguishes between regular budget allocations and public investment
 * budget allocations, providing a comprehensive breakdown of financial spending.</p>
 *
 * <p>The {@code ExpenditureDetailed} entity is primarily used for in-depth
 * financial analysis, reporting, and visualization of government spending
 * across different administrative departments.</p>
 */

public class ExpenditureDetailed {
    /** Unique identifier code of the expenditure. */
    private int code;
    /** Department or administrative unit associated with the expenditure. */
    private String department;
    /** Amount allocated from the regular budget. */
    private String regularBudget;
    /** Amount allocated from the public investment budget. */
    private String publicInvestmentBudget;
    /** Total expenditure amount. */
    private String total;

    /**
     * Constructs an {@code ExpenditureDetailed} object with detailed
     * budget allocation data.
     *
     * @param code the unique identifier code of the expenditure
     * @param department the department or administrative unit associated
     *                   with the expenditure
     * @param regularBudget the amount allocated from the regular budget
     * @param publicInvestmentBudget the amount allocated from the public
     *                               investment budget
     * @param total the total expenditure amount
     */

  public ExpenditureDetailed(int code,
                               String department,
                               String regularBudget,
                               String publicInvestmentBudget,
                               String total) {
    this.code = code;
    this.department = department;
    this.regularBudget = regularBudget;
    this.publicInvestmentBudget = publicInvestmentBudget;
    this.total = total;
  }
    /** Returns the expenditure code. */
  public int getCode() {
    return code;
  }
    /** Sets the expenditure code. */
  public void setCode(int code) {
    this.code = code;
  }
    /** Returns the department associated with the expenditure. */
  public String getDepartment() {
    return department;
  }
    /** Sets the department associated with the expenditure. */
  public void setDepartment(String department) {
    this.department = department;
  }
    /** Returns the amount allocated from the regular budget. */
  public String getRegularBudget() {
    return regularBudget;
  }
    /** Sets the amount allocated from the regular budget. */
  public void setRegularBudget(String regularBudget) {
    this.regularBudget = regularBudget;
  }
/** Returns the amount allocated from the public investment budget.*/
  public String getPublicInvestmentBudget() {
    return publicInvestmentBudget;
  }

  /** Sets the amount allocated from the public investment budget. */
  public void setPublicInvestmentBudget(String publicInvestmentBudget) {
    this.publicInvestmentBudget = publicInvestmentBudget;
  }

    /** Returns the total expenditure amount. */
  public String getTotal() {
    return total;
  }
    /** Sets the total expenditure amount. */
  public void setTotal(String total) {
    this.total = total;
  }
}
