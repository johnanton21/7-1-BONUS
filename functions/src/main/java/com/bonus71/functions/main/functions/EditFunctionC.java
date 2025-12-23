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
import com.bonus71.functions.menus.MinistryOfHealthMenu;
import com.bonus71.functions.menus.MinistryOfEnvironmentMenu;
import com.bonus71.functions.menus.NationalDefenseMenu;
import com.bonus71.functions.menus.RevenueMenu;
import java.sql.SQLException;
import java.util.Scanner;

public class EditFunctionC {
  private static final Scanner scanner = new Scanner(System.in);

  public static void editData() throws SQLException {

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
                case 1 -> ExpensesMenu.menu(exodaRepo);
                case 2 -> RevenueMenu.menu(esodaRepo);
                case 3 -> MinistryOfEducationMenu.menu(paideiaRepo);
                case 4 -> MinistryOfTheEnvironmentMenu.menu(perivRepo);
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
        default -> System.out.println("invalid choice!");
      }
    }
  }
}
