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
 * Provides a console-based menu for managing expenditure data.
 *
 * <p>This class belongs to the {@code functions.menus} module and is responsible
 * for handling user interaction related to government expenditures. It presents
 * a simple text menu that allows the user to view, add, update, or delete
 * expenditure records.</p>
 *
 * <p>The class operates as a controller between user input and the data layer,
 * delegating all data access operations to the {@link ExpenditureRepository}.</p>
 *
 * <ul>
 *   <li>Displays expenditure records</li>
 *   <li>Inserts new expenditure entries</li>
 *   <li>Updates existing expenditure data</li>
 *   <li>Deletes expenditure records</li>
 * </ul>
 */

public class ExpenditureMenu {
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
                    System.out.println(e.getCode()
                            + " | " + e.getCategory() + " | " + e.getEuros()));
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
