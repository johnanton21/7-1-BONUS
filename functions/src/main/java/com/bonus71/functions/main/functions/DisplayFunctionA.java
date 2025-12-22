package com.bonus71.functions.main.functions;

import com.bonus71.data.entity.financial.Expenditure;
import com.bonus71.data.entity.financial.ExpenditureDetailed;
import com.bonus71.data.entity.financial.Revenue;
import com.bonus71.data.repository.ExpenditureDetailedRepository;
import com.bonus71.data.repository.ExpenditureRepository;
import com.bonus71.data.repository.RevenueRepository;
import java.sql.SQLException;

public class DisplayFunctionA {
  public static void showAll() throws SQLException {


    System.out.println("\n === DISPLAY EXPENDITURES ===");
    ExpenditureRepository exR = new ExpenditureRepository();
    for (Expenditure ex : exR.findAll()) {
      System.out.println(
                  ex.getCode()
                          + " | " + ex.getCategory()
                          + " | " + ex.getEuros()
      );
    }

    System.out.println("\n === DISPLAY REVENUES ===");
    RevenueRepository esR = new RevenueRepository();
    for (Revenue es : esR.findAll()) {
      System.out.println(
                    es.getCode()
                            + " | " + es.getCategory()
                            + " | " + es.getEuros()
      );
    }

    System.out.println("\n === DISPLAY ARTICLE 2 EXPENDITURES ===");
    ExpenditureDetailedRepository ex2R = new ExpenditureDetailedRepository();
    System.out.println("\n CODE | DEPARTMENT | REGULAR BUDGET | PUBLIC INVESTMENTS | TOTAL");
    for (ExpenditureDetailed ex2 : ex2R.findAll()) {
      System.out.println(
                    ex2.getCode()
                            + " | " + ex2.getDepartment()
                            + " | " + ex2.getRegularBudget()
                            + " | " + ex2.getPublicInvestmentBudget()
                            + " | " + ex2.getTotal()
      );
    }
  }
}
