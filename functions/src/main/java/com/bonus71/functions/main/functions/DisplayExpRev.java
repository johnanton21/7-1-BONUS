/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.functions.main.functions;

import com.bonus71.data.entity.financial.Expenditure;
import com.bonus71.data.entity.financial.ExpenditureDetailed;
import com.bonus71.data.entity.financial.Revenue;
import com.bonus71.data.repository.ExpenditureDetailedRepository;
import com.bonus71.data.repository.ExpenditureRepository;
import com.bonus71.data.repository.RevenueRepository;
import java.sql.SQLException;
/**
 * Utility class responsible for displaying expenditure and revenue records.
 *
 * <p>This class outputs financial data retrieved from repository sources,
 * including:</p>
 * <ul>
 *     <li>General expenditure records</li>
 *     <li>Revenue records</li>
 *     <li>Article 2 detailed expenditure information</li>
 * </ul>
 *
 * <p>The retrieved information is printed directly to the standard output, in a
 * structured and readable format for debugging or inspection purposes.</p>
 *
 * <p><b>Usage:</b> This class is typically called from menu components or
 * service layers when detailed financial breakdowns are required.</p>
 */

public class DisplayExpRev {
  /**
   * Displays all expenditure, revenue, and detailed expenditure information.
   *
   * <p>This method fetches data from the corresponding repositories and prints
   * the results in categorized blocks:</p>
   * <ol>
   *     <li>"DISPLAY EXPENDITURES"</li>
   *     <li>"DISPLAY REVENUES"</li>
   *     <li>"DISPLAY ARTICLE 2 EXPENDITURES"</li>
   * </ol>
   *
   * @throws SQLException if a database access error occurs during retrieval
   */

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
