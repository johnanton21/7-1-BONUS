package com.bonus71.data;

import java.util.Scanner;
public class DisplayMinistriesMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== ΕΜΦΑΝΙΣΗ ΔΕΔΟΜΕΝΩΝ ΥΠΟΥΡΓΕΙΩΝ =====");
            System.out.println("1 - ΥΠΟΥΡΓΕΙΟ ΠΑΙΔΕΙΑΣ");
            System.out.println("2 - ΥΠΟΥΡΓΕΙΟ ΠΕΡΙΒΑΛΛΟΝΤΟΣ");
            System.out.println("3 - ΥΠΟΥΡΓΕΙΟ ΕΘΝΙΚΗΣ ΑΜΥΝΑΣ");
            System.out.println("4 - ΥΠΟΥΡΓΕΙΟ ΟΙΚΟΝΟΜΙΚΩΝ");
            System.out.println("5 - ΥΠΟΥΡΓΕΙΟ ΥΓΕΙΑΣ");
            System.out.println("0 - Έξοδος");
            System.out.print("Επιλέξτε υπουργείο: ");

            choice = sc.nextInt();
            System.out.println();

            switch (choice) {

                case 1 -> {
                    System.out.println("=== ΥΠΟΥΡΓΕΙΟ ΠΑΙΔΕΙΑΣ ===");
                    PaideiasRepository repo = new PaideiasRepository();
                    repo.findAll().forEach(p ->
                            System.out.println(p.getMeizona() + " | " + p.getOnomasia() + " | " + p.getEvro())
                    );
                }

                case 2 -> {
                    System.out.println("=== ΥΠΟΥΡΓΕΙΟ ΠΕΡΙΒΑΛΛΟΝΤΟΣ ===");
                    PerivallonRepository repo = new PerivallonRepository();
                    repo.findAll().forEach(p ->
                            System.out.println(p.getMeizona() + " | " + p.getOnomasia() + " | " + p.getEvro())
                    );
                }

                case 3 -> {
                    System.out.println("=== ΥΠΟΥΡΓΕΙΟ ΕΘΝΙΚΗΣ ΑΜΥΝΑΣ ===");
                    EthnikiAminaRepository repo = new EthnikiAminaRepository();
                    repo.findAll().forEach(p ->
                            System.out.println(p.getMeizona() + " | " + p.getOnomasia() + " | " + p.getEvro())
                    );
                }

                case 4 -> {
                    System.out.println("=== ΥΠΟΥΡΓΕΙΟ ΟΙΚΟΝΟΜΙΚΩΝ ===");
                    OikonomikonRepository repo = new OikonomikonRepository();
                    repo.findAll().forEach(p ->
                            System.out.println(p.getMeizona() + " | " + p.getOnomasia() + " | " + p.getEvro())
                    );
                }

                case 5 -> {
                    System.out.println("=== ΥΠΟΥΡΓΕΙΟ ΥΓΕΙΑΣ ===");
                    YgeiasRepository repo = new YgeiasRepository();
                    repo.findAll().forEach(p ->
                            System.out.println(p.getMeizona() + " | " + p.getOnomasia() + " | " + p.getEvro())
                    );
                }

                case 0 -> System.out.println("Έξοδος από το μενού...");
                default -> System.out.println("Μη έγκυρη επιλογή!");

            }

        } while (choice != 0);

        sc.close();
    }
}


