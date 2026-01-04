package com.bonus71.functions.menus;

import com.bonus71.data.entity.ministry.Environment;
import com.bonus71.data.repository.EnvironmentRepository;
import java.sql.SQLException;
import java.util.Scanner;

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
