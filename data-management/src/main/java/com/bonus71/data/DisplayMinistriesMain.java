package com.bonus71.data;

import com.bonus71.data.entity.ministry.Environment;
import com.bonus71.data.repository.*;

import java.sql.SQLException;
import java.util.Scanner;
public class DisplayMinistriesMain {
    public static void main(String[] args) throws SQLException {

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
                    EducationRepository repo = new EducationRepository();
                    repo.findAll().forEach(p ->
                            System.out.println(p.getMajorCategory() + " | " + p.getName() + " | " + p.getEuros())
                    );
                }

                case 2 -> {
                    System.out.println("=== ΥΠΟΥΡΓΕΙΟ ΠΕΡΙΒΑΛΛΟΝΤΟΣ ===");
                    EnvironmentRepository repo = new EnvironmentRepository();
                    repo.findAll().forEach(p ->
                            System.out.println(p.getMajorCategory() + " | " + p.getName() + " | " + p.getEuros())
                    );
                }

                case 3 -> {
                    System.out.println("=== ΥΠΟΥΡΓΕΙΟ ΕΘΝΙΚΗΣ ΑΜΥΝΑΣ ===");
                    NationalDefenseRepository repo = new NationalDefenseRepository();
                    repo.findAll().forEach(p ->
                            System.out.println(p.getMajorCategory() + " | " + p.getName() + " | " + p.getEuros())
                    );
                }

                case 4 -> {
                    System.out.println("=== ΥΠΟΥΡΓΕΙΟ ΟΙΚΟΝΟΜΙΚΩΝ ===");
                    FinanceMinistryRepository repo = new FinanceMinistryRepository();
                    repo.findAll().forEach(p ->
                            System.out.println(p.getMajorCategory() + " | " + p.getName() + " | " + p.getEuros())
                    );
                }

                case 5 -> {
                    System.out.println("=== ΥΠΟΥΡΓΕΙΟ ΥΓΕΙΑΣ ===");
                    HealthRepository repo = new HealthRepository();
                    repo.findAll().forEach(p ->
                            System.out.println(p.getMajorCategory() + " | " + p.getName() + " | " + p.getEuros())
                    );
                }

                case 0 -> System.out.println("Έξοδος από το μενού...");
                default -> System.out.println("Μη έγκυρη επιλογή!");

            }

        } while (choice != 0);

        sc.close();
    }
}


