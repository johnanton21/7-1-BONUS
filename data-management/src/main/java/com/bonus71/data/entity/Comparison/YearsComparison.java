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
