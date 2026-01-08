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

  private int code;
  private String department;
  private String regularBudget;
  private String publicInvestmentBudget;
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

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getRegularBudget() {
    return regularBudget;
  }

  public void setRegularBudget(String regularBudget) {
    this.regularBudget = regularBudget;
  }

  public String getPublicInvestmentBudget() {
    return publicInvestmentBudget;
  }

  public void setPublicInvestmentBudget(String publicInvestmentBudget) {
    this.publicInvestmentBudget = publicInvestmentBudget;
  }

  public String getTotal() {
    return total;
  }

  public void setTotal(String total) {
    this.total = total;
  }
}
