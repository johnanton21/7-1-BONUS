package com.bonus71.functions.menus;

import com.bonus71.data.entity.ministry.Environment;
import com.bonus71.data.repository.EnvironmentRepository;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Provides a console-based menu for managing data related to the Ministry of the Environment.
 *
 * <p>This class is part of the {@code functions.menus} package and offers a
 * command-line interface for interacting with budget data associated with the
 * Ministry of the Environment. It allows users to view, add, update, and delete
 * ministry-related records.</p>
 *
 * <p>The class acts as an intermediary between user input and the data access
 * layer, delegating all persistence operations to the {@link EnvironmentRepository}.</p>
 *
 * <ul>
 *   <li>Displays environmental budget records</li>
 *   <li>Adds new ministry entries</li>
 *   <li>Updates existing ministry data</li>
 *   <li>Deletes ministry records</li>
 * </ul>
 */


public class MinistryOfEnvironmentMenu {
  @SuppressWarnings("checkstyle:OneStatementPerLine")
  public static void menu(EnvironmentRepository repo) throws SQLException {
    Scanner scanner = new Scanner(System.in);

    System.out.println("\n--- MINISTRY OF THE ENVIRONMENT ---");
    System.out.println("1. View");
    System.out.println("2. Add");
    System.out.println("3. Update");
    System.out.println("4. Delete");

    int ch = scanner.nextInt();
    scanner.nextLine();

    switch (ch) {
      case 1 -> repo.findAll().forEach(p ->
                    System.out.println(p.getMajorCategory()
                            + " | " + p.getName() + " | " + p.getEuros()));
      case 2 -> {
        System.out.print("Code: "); int m = scanner.nextInt(); scanner.nextLine();
        System.out.print("Name: "); String o = scanner.nextLine();
        System.out.print("Euros: "); String e = scanner.nextLine();
        repo.insert(new Environment(m, o, e));
      }
      case 3 -> {
        System.out.print("Code: "); int m = scanner.nextInt(); scanner.nextLine();
        System.out.print("New name: "); String o = scanner.nextLine();
        System.out.print("New euro: "); String e = scanner.nextLine();
        repo.update(new Environment(m, o, e));
      }
      case 4 -> {
        System.out.print("Code to delete: "); int m = scanner.nextInt();
        repo.delete(m);
      }
      default -> throw new IllegalStateException("Unexpected value: " + ch);
    }
  }
}
