package com.bonus71.functions.menus;


import com.bonus71.data.repository.NationalDefenseRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class NationalDefenseMenu {
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
                    System.out.println(p.getMajorCategory() + " | " + p.getName() + " | " + p.getEuros()));
            case 2 -> {
                System.out.print("Code: "); int m = scanner.nextInt(); scanner.nextLine();
                System.out.print("Name: "); String o = scanner.nextLine();
                System.out.print("Euros: "); String e = scanner.nextLine();
                repo.insert(new com.bonus71.data.entity.ministry.NationalDefense(m, o, e));
            }
            case 3 -> {
                System.out.print("Code: "); int m = scanner.nextInt(); scanner.nextLine();
                    System.out.print("New name: "); String o = scanner.nextLine();
                System.out.print("Νew euros: "); String e = scanner.nextLine();
                repo.update(new com.bonus71.data.entity.ministry.NationalDefense(m, o, e));
            }
            case 4 -> {
                System.out.print("Code to delete: "); int m = scanner.nextInt();
                repo.delete(m);
            }
        }
    }
}
