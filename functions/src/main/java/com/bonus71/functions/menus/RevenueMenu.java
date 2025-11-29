package com.bonus71.functions.menus;

import com.bonus71.bootstrap.Main;
import com.bonus71.data.entity.financial.Revenue;
import com.bonus71.data.repository.RevenueRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class RevenueMenu {
    public static void menu(RevenueRepository repo) throws SQLException {
        Scanner scanner = Main.getScanner();

        System.out.println("\n--- REVENUE ---");
        System.out.println("1. View");
        System.out.println("2. Add");
        System.out.println("3. Update");
        System.out.println("4. Delete");

        int ch = scanner.nextInt();
        scanner.nextLine();

        switch (ch) {
            case 1 -> repo.findAll().forEach(e ->
                    System.out.println(e.getCode() + " | " + e.getCategory() + " | " + e.getEuros()));
            case 2 -> {
                System.out.print("Code: "); int k = scanner.nextInt(); scanner.nextLine();
                System.out.print("Category: "); String c = scanner.nextLine();
                System.out.print("Euros: "); String e = scanner.nextLine();
                repo.insert(new Revenue(k, c, e));
            }
            case 3 -> {
                System.out.print("Code: "); int k = scanner.nextInt(); scanner.nextLine();
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
