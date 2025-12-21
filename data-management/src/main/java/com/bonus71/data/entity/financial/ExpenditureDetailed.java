package com.bonus71.data.entity.financial;

public class ExpenditureDetailed {

  private int code;
  private String department;
  private String regularBudget;
  private String publicInvestmentBudget;
  private String total;

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
