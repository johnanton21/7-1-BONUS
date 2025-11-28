package com.bonus71.data;

import com.bonus71.data.repository.*;

import java.sql.SQLException;
import java.util.Scanner;

public class EditMain {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        ExpenditureRepository exodaRepo = new ExpenditureRepository();
        RevenueRepository esodaRepo = new RevenueRepository();
        EducationRepository paideiaRepo = new EducationRepository();
        EnvironmentRepository perivRepo = new EnvironmentRepository();
        NationalDefenseRepository amynaRepo = new NationalDefenseRepository();
        FinanceMinistryRepository oikRepo = new FinanceMinistryRepository();
        HealthRepository ygeiasRepo = new HealthRepository();

        while (true) {
            System.out.println("\n===== ΜΕΝΟΥ ΕΠΕΞΕΡΓΑΣΙΑΣ =====");
            System.out.println("1. Εξοδα");
            System.out.println("2. Εσοδα");
            System.out.println("3. Υπουργείο Παιδείας");
            System.out.println("4. Υπουργείο Περιβάλλοντος");
            System.out.println("5. Υπουργείο Εθνικής Άμυνας");
            System.out.println("6. Υπουργείο Οικονομικών");
            System.out.println("7. Υπουργείο Υγείας");
            System.out.println("0. Έξοδος");
            System.out.print("Επιλογή: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> ExodaMenu.menu(exodaRepo);
                case 2 -> EsodaMenu.menu(esodaRepo);
                case 3 -> PaideiasMenu.menu(paideiaRepo);
                case 4 -> PerivallontosMenu.menu(perivRepo);
                case 5 -> EthnikiAminaMenu.menu(amynaRepo);
                case 6 -> OikonomikonMenu.menu(oikRepo);
                case 7 -> YgeiaMenu.menu(ygeiasRepo);
                case 0 -> {
                    System.out.println("Έξοδος...");
                    return;
                }
                default -> System.out.println("Λάθος επιλογή!");
            }
        }
    }
}
