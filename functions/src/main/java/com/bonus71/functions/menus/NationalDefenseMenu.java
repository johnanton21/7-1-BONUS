/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.functions.menus;

import com.bonus71.data.entity.ministry.NationalDefense;
import com.bonus71.data.repository.NationalDefenseRepository;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Provides a console-based menu for managing data related to National Defense.
 *
 * <p>This class is part of the {@code functions.menus} package and offers a
 * command-line interface for interacting with National Defense budget records.
 * Users can view, add, update, and delete entries associated with national defense.</p>
 *
 * <p>The class acts as a controller between user input and the data access layer,
 * delegating all persistence operations to the {@link NationalDefenseRepository}.</p>
 *
 * <ul>
 *   <li>Displays national defense budget records</li>
 *   <li>Adds new entries</li>
 *   <li>Updates existing entries</li>
 *   <li>Deletes entries</li>
 * </ul>
 */

public class NationalDefenseMenu {
  @SuppressWarnings("checkstyle:OneStatementPerLine")
  public static void menu(NationalDefenseRepository repo) throws SQLException {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\n--- NATIONAL DEFENSE  ---");
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
        System.out.print("Code: ");
        int m = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: "); String o = scanner.nextLine();
        System.out.print("Euros: "); String e = scanner.nextLine();
        repo.insert(new NationalDefense(m, o, e));
      }
      case 3 -> {
        System.out.print("Code: ");
        int m = scanner.nextInt();
        scanner.nextLine();
        System.out.print("New name: "); String o = scanner.nextLine();
        System.out.print("Νew euros: "); String e = scanner.nextLine();
        repo.update(new NationalDefense(m, o, e));
      }
      case 4 -> {
        System.out.print("Code to delete: "); int m = scanner.nextInt();
        repo.delete(m);
      }
      default -> throw new IllegalStateException("Unexpected value: " + ch);
    }
  }
}
