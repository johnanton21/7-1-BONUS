/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.functions.menus;


import com.bonus71.data.entity.financial.Expenditure;
import com.bonus71.data.repository.ExpenditureRepository;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Provides a console-based menu for managing expense records.
 *
 * <p>This class is part of the {@code functions.menus} package and offers a
 * command-line interface for interacting with expenditure data. Through a
 * simple menu, users can view existing records, add new expenses, update
 * entries, or remove them from the system.</p>
 *
 * <p>The class acts as an intermediary between user input and the persistence
 * layer, delegating all data operations to the {@link ExpenditureRepository}.</p>
 *
 * <ul>
 *   <li>Displays all expense records</li>
 *   <li>Adds new expense entries</li>
 *   <li>Updates existing expenses</li>
 *   <li>Deletes expense records</li>
 * </ul>
 */

public class ExpensesMenu {
  public static void menu(ExpenditureRepository repo) throws SQLException {
    Scanner scanner = new Scanner(System.in);

    System.out.println("\n--- EXPENDITURES ---");
    System.out.println("1. View");
    System.out.println("2. Add");
    System.out.println("3. Update");
    System.out.println("4. Delete");

    int ch = scanner.nextInt();
    scanner.nextLine();

    switch (ch) {
      case 1 -> repo.findAll().forEach(e ->
                    System.out.println(e.getCode() + " | " + e.getCategory() + " | "
                            + e.getEuros()));
      case 2 -> {
        System.out.print("Code: ");
        int k = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Category: ");
        String c = scanner.nextLine();
        System.out.print("Euros: ");
        String e = scanner.nextLine();
        repo.insert(new Expenditure(k, c, e));
      }
      case 3 -> {
        System.out.print("Code: ");
        int k = scanner.nextInt();
        scanner.nextLine();
        System.out.print("New category: ");
        String c = scanner.nextLine();
        System.out.print("New euros: ");
        String e = scanner.nextLine();
        repo.update(new Expenditure(k, c, e));
      }
      case 4 -> {
        System.out.print("Code to delete: ");
        int k = scanner.nextInt();
        repo.delete(k);
      }
      default -> System.out.println("Invalid choice!");
    }
  }
}
