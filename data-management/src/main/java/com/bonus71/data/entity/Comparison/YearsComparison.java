package com.bonus71.data.entity.Comparison;

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

  public int getYear() {
    return year;
  }

  public String getNetRevenues() {
    return netRevenues;
  }

  public String getExpenses() {
    return expenses;
  }

  public String getBalance() {
    return balance;
  }
}

