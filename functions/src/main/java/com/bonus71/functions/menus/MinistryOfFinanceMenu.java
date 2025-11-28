package com.bonus71.functions.menus;

import com.bonus71.data.MainMenus;
import com.bonus71.data.entity.ministry.FinanceMinistry;
import com.bonus71.data.repository.FinanceMinistryRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class MinistryOfFinanceMenu {
    public static void menu(FinanceMinistryRepository repo) throws SQLException {
        Scanner scanner = MainMenus.getScanner();

        System.out.println("\n--- ΥΠΟΥΡΓΕΙΟ ΟΙΚΟΝΟΜΙΚΩΝ ---");
        System.out.println("1. Προβολή");
        System.out.println("2. Προσθήκη");
        System.out.println("3. Ενημέρωση");
        System.out.println("4. Διαγραφή");

        int ch = scanner.nextInt();
        scanner.nextLine();

        switch (ch) {
            case 1 -> repo.findAll().forEach(p ->
                    System.out.println(p.getMajorCategory() + " | " + p.getName() + " | " + p.getEuros()));
            case 2 -> {
                System.out.print("Μείζονα Κατηγορία: "); int m = scanner.nextInt(); scanner.nextLine();
                System.out.print("Ονομασία: "); String o = scanner.nextLine();
                System.out.print("Ευρώ: "); String e = scanner.nextLine();
                repo.insert(new FinanceMinistry(m, o, e));
            }
            case 3 -> {
                System.out.print("Μείζονα Κατηγορία: "); int m = scanner.nextInt(); scanner.nextLine();
                System.out.print("Νέα ονομασία: "); String o = scanner.nextLine();
                System.out.print("Νέο ευρώ: "); String e = scanner.nextLine();
                repo.update(new FinanceMinistry(m, o, e));
            }
            case 4 -> {
                System.out.print("Μείζονα Κατηγορία για διαγραφή: "); int m = scanner.nextInt();
                repo.delete(m);
            }
        }
    }
}

