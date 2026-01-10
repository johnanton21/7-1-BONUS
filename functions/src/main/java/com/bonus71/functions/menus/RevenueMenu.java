package com.bonus71.functions.menus;

import com.bonus71.data.entity.financial.Revenue;
import com.bonus71.data.repository.RevenueRepository;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Provides a console-based menu for managing revenue data.
 *
 * <p>This class is part of the {@code functions.menus} package and offers a
 * command-line interface for interacting with revenue records. Users can view,
 * add, update, and delete revenue entries stored in the system.</p>
 *
 * <p>The class acts as a controller between user input and the data access layer,
 * delegating all operations to the {@link com.bonus71.data.repository.RevenueRepository}.</p>
 *
 * <ul>
 *   <li>Displays revenue records</li>
 *   <li>Adds new revenue entries</li>
 *   <li>Updates existing revenue entries</li>
 *   <li>Deletes revenue entries</li>
 * </ul>
 */


public class RevenueMenu {
  @SuppressWarnings("checkstyle:OneStatementPerLine")
  public static void menu(RevenueRepository repo) throws SQLException {
    Scanner scanner = new Scanner(System.in);

    System.out.println("\n--- REVENUE ---");
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
        int k = scanner.nextInt(); scanner.nextLine();
        System.out.print("Category: ");
        String c = scanner.nextLine();
        System.out.print("Euros: "); String e = scanner.nextLine();
        repo.insert(new Revenue(k, c, e));
      }
      case 3 -> {
        System.out.print("Code: ");
        int k = scanner.nextInt();
        scanner.nextLine();
        System.out.print("New category: "); String c = scanner.nextLine();
        System.out.print("New euros: "); String e = scanner.nextLine();
        repo.update(new Revenue(k, c, e));
      }
      case 4 -> {
        System.out.print("Code to delete: "); int k = scanner.nextInt();
        repo.delete(k);
      }
      default -> System.out.println("Invalid choice!");
    }
  }
}
