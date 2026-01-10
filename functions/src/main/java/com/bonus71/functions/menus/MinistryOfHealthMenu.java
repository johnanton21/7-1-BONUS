package com.bonus71.functions.menus;

import com.bonus71.data.entity.ministry.Health;
import com.bonus71.data.repository.HealthRepository;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Provides a console-based menu for managing data related to the Ministry of Health.
 *
 * <p>This class is part of the {@code functions.menus} package and offers a
 * command-line interface for interacting with health ministry budget records.
 * Users can view, add, update, and delete entries associated with the Ministry of Health.</p>
 *
 * <p>The class serves as a controller between user input and the data layer,
 * delegating all persistence operations to the {@link HealthRepository}.</p>
 *
 * <ul>
 *   <li>Displays health ministry budget records</li>
 *   <li>Adds new ministry entries</li>
 *   <li>Updates existing ministry data</li>
 *   <li>Deletes ministry records</li>
 * </ul>
 */


public class MinistryOfHealthMenu {
  public static void menu(HealthRepository repo) throws SQLException {
    Scanner scanner = new Scanner(System.in);

    System.out.println("\n--- MINISTRY OF HEALTH ---");
    System.out.println("1. View");
    System.out.println("2. Add");
    System.out.println("3. Update");
    System.out.println("4. Delete");

    int ch = scanner.nextInt();
    scanner.nextLine();

    switch (ch) {
      case 1 -> repo.findAll().forEach(p ->
                    System.out.println(p.getMajorCategory() + " | " + p.getName() + " | " + p.getEuros()));
      case 2 -> {
        System.out.print("Code: ");
        int m = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: ");
        String o = scanner.nextLine();
        System.out.print("Euros: ");
        String e = scanner.nextLine();
        repo.insert(new Health(m, o, e));
      }
      case 3 -> {
        System.out.print("Code: ");
        int m = scanner.nextInt();
        scanner.nextLine();
        System.out.print("New name: ");
        String o = scanner.nextLine();
        System.out.print("New euros: ");
        String e = scanner.nextLine();
        repo.update(new Health(m, o, e));
      }
      case 4 -> {
        System.out.print("Code to delete: ");
        int m = scanner.nextInt();
        repo.delete(m);
      }
      default -> throw new IllegalStateException("Unexpected value: " + ch);
    }
  }
}
