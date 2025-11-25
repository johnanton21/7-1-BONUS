package com.bonus71.data;

import java.util.Scanner;

public class EsodaMenu {
    public static void menu(EsodaRepository repo) {
        Scanner scanner = MainMenus.getScanner();

        System.out.println("\n--- ΕΣΟΔΑ ---");
        System.out.println("1. Προβολή");
        System.out.println("2. Προσθήκη");
        System.out.println("3. Ενημέρωση");
        System.out.println("4. Διαγραφή");

        int ch = scanner.nextInt();
        scanner.nextLine();

        switch (ch) {
            case 1 -> repo.findAll().forEach(e ->
                    System.out.println(e.getKodikos() + " | " + e.getKatigoria() + " | " + e.getEvro()));
            case 2 -> {
                System.out.print("Κωδικός: "); int k = scanner.nextInt(); scanner.nextLine();
                System.out.print("Κατηγορία: "); String c = scanner.nextLine();
                System.out.print("Ευρώ: "); String e = scanner.nextLine();
                repo.insert(new Esoda(k, c, e));
            }
            case 3 -> {
                System.out.print("Κωδικός: "); int k = scanner.nextInt(); scanner.nextLine();
                System.out.print("Νέα κατηγορία: "); String c = scanner.nextLine();
                System.out.print("Νέο ευρώ: "); String e = scanner.nextLine();
                repo.update(new Esoda(k, c, e));
            }
            case 4 -> {
                System.out.print("Κωδικός για διαγραφή: "); int k = scanner.nextInt();
                repo.delete(k);
            }
        }
    }
}

