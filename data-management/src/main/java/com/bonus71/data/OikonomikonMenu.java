package com.bonus71.data;

import java.util.Scanner;

public class OikonomikonMenu {

    public static void menu(OikonomikonRepository repo) {
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
                    System.out.println(p.getMeizona() + " | " + p.getOnomasia() + " | " + p.getEvro()));
            case 2 -> {
                System.out.print("Μείζονα Κατηγορία: "); int m = scanner.nextInt(); scanner.nextLine();
                System.out.print("Ονομασία: "); String o = scanner.nextLine();
                System.out.print("Ευρώ: "); String e = scanner.nextLine();
                repo.insert(new Oikonomikon(m, o, e));
            }
            case 3 -> {
                System.out.print("Μείζονα Κατηγορία: "); int m = scanner.nextInt(); scanner.nextLine();
                System.out.print("Νέα ονομασία: "); String o = scanner.nextLine();
                System.out.print("Νέο ευρώ: "); String e = scanner.nextLine();
                repo.update(new Oikonomikon(m, o, e));
            }
            case 4 -> {
                System.out.print("Μείζονα Κατηγορία για διαγραφή: "); int m = scanner.nextInt();
                repo.delete(m);
            }
        }
    }
}

