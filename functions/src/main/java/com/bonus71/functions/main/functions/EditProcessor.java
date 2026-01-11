/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.functions.main.functions;

import com.bonus71.data.repository.EducationRepository;
import com.bonus71.data.repository.EnvironmentRepository;
import com.bonus71.data.repository.ExpenditureRepository;
import com.bonus71.data.repository.FinanceMinistryRepository;
import com.bonus71.data.repository.HealthRepository;
import com.bonus71.data.repository.NationalDefenseRepository;
import com.bonus71.data.repository.RevenueRepository;
import com.bonus71.functions.menus.ExpenditureMenu;
import com.bonus71.functions.menus.MinistryOfEducationMenu;
import com.bonus71.functions.menus.MinistryOfFinanceMenu;
import com.bonus71.functions.menus.NationalDefenseMenu;
import com.bonus71.functions.menus.MinistryOfHealthMenu;
import com.bonus71.functions.menus.MinistryOfEnvironmentMenu;
import com.bonus71.functions.menus.RevenueMenu;
import java.sql.SQLException;
import java.util.Scanner;
/**
 * Processor class responsible for managing and editing financial application data.
 *
 * <p>This class provides an interactive console-based menu that allows the user to
 * modify expenditure, revenue, and ministry-related financial records. It delegates
 * modification operations to the appropriate menu components associated with each
 * repository type.</p>
 *
 * <p><b>Data categories handled:</b></p>
 * <ul>
 *     <li>General expenditures</li>
 *     <li>General revenues</li>
 *     <li>Ministry of Education</li>
 *     <li>Ministry of the Environment</li>
 *     <li>Ministry of National Defense</li>
 *     <li>Ministry of Finance</li>
 *     <li>Ministry of Health</li>
 * </ul>
 *
 * <p>The processor creates and holds repository instances for the duration of the
 * editing session, allowing repository-based operations such as creation, update,
 * and deletion of financial records.</p>
 *
 * <p>This utility is typically triggered from the main GUI or the bootstrap logic
 * when the user selects a data administration or editing mode.</p>
 */

public class EditProcessor {

  /**
   * Starts a continuous data management loop that allows the user to select
   * a financial data category and perform editing operations through menu components.
   *
   * <p>Repositories for each financial category are instantiated at the beginning,
   * making them available throughout the session. For each user selection, execution
   * is delegated to the corresponding menu-driven editor.</p>
   *
   * <p>The loop terminates only when the user selects the exit option.</p>
   *
   * @throws SQLException if a repository operation or database communication fails
   */

  public static void editData() throws SQLException {
    // Create scanner from current System.in (allows for testing)
    Scanner scanner = new Scanner(System.in);

    ExpenditureRepository exodaRepo = new ExpenditureRepository();
    RevenueRepository esodaRepo = new RevenueRepository();
    EducationRepository paideiaRepo = new EducationRepository();
    EnvironmentRepository perivRepo = new EnvironmentRepository();
    NationalDefenseRepository amynaRepo = new NationalDefenseRepository();
    FinanceMinistryRepository oikRepo = new FinanceMinistryRepository();
    HealthRepository ygeiasRepo = new HealthRepository();

    while (true) {
      System.out.println("\n===== DATA MANAGEMENT MENU =====");
      System.out.println("1. Expenditures");
      System.out.println("2. Revenues");
      System.out.println("3. Ministry of Education");
      System.out.println("4. Ministry of the Environment");
      System.out.println("5. Ministry of National Defense");
      System.out.println("6. Ministry of Finance");
      System.out.println("7. Ministry of Health");
      System.out.println("0. Exit");
      System.out.print("Your choice: ");

      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1 -> ExpenditureMenu.menu(exodaRepo);
        case 2 -> RevenueMenu.menu(esodaRepo);
        case 3 -> MinistryOfEducationMenu.menu(paideiaRepo);
        case 4 -> MinistryOfEnvironmentMenu.menu(perivRepo);
        case 5 -> NationalDefenseMenu.menu(amynaRepo);
        case 6 -> MinistryOfFinanceMenu.menu(oikRepo);
        case 7 -> MinistryOfHealthMenu.menu(ygeiasRepo);
        case 0 -> {
          System.out.println("Exit...");
          return;
        }
        default -> System.out.println("invalid choice!");
      }

    }
  }
}
