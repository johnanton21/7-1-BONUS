package com.bonus71.functions.main.functions;

import com.bonus71.data.repository.EducationRepository;
import com.bonus71.data.repository.EnvironmentRepository;
import com.bonus71.data.repository.FinanceMinistryRepository;
import com.bonus71.data.repository.HealthRepository;
import com.bonus71.data.repository.NationalDefenseRepository;
import java.sql.SQLException;
import java.util.Scanner;

public class DisplayMinistries {
  public static void showMinistriesData() throws SQLException {

    Scanner sc = new Scanner(System.in);
    int choice;

    do {
      System.out.println("\n===== DISPLAY MINISTRIES DATA =====");
      System.out.println("1 - MINISTRY OF EDUCATION");
      System.out.println("2 - MINISTRY OF ENVIRONMENT");
      System.out.println("3 - MINISTRY OF NATIONAL DEFENSE");
      System.out.println("4 - MINISTRY OF FINANCE");
      System.out.println("5 - MINISTRY OF HEALTH");
      System.out.println("0 - Exit");
      System.out.print("Select a ministry: ");


      choice = sc.nextInt();
      System.out.println();

      switch (choice) {

        case 1 -> {
          System.out.println("=== MINISTRY OF EDUCATION ===");
          EducationRepository repo = new EducationRepository();
          repo.findAll().forEach(p ->
                            System.out.println(p.getMajorCategory()
                                    + " | " + p.getName() + " | " + p.getEuros())
          );
        }

        case 2 -> {
          System.out.println("=== MINISTRY OF ENVIRONMENT ===");
          EnvironmentRepository repo = new EnvironmentRepository();
          repo.findAll().forEach(p ->
                            System.out.println(p.getMajorCategory()
                                    + " | " + p.getName() + " | " + p.getEuros())
          );
        }

        case 3 -> {
          System.out.println("=== MINISTRY OF NATIONAL DEFENSE ===");
          NationalDefenseRepository repo = new NationalDefenseRepository();
          repo.findAll().forEach(p ->
                            System.out.println(p.getMajorCategory()
                                    + " | " + p.getName() + " | " + p.getEuros())
          );
        }

        case 4 -> {
          System.out.println("=== MINISTRY OF FINANCE ===");
          FinanceMinistryRepository repo = new FinanceMinistryRepository();
          repo.findAll().forEach(p ->
                            System.out.println(p.getMajorCategory()
                                    + " | " + p.getName() + " | " + p.getEuros())
          );
        }

        case 5 -> {
          System.out.println("=== MINISTRY OF HEALTH===");
          HealthRepository repo = new HealthRepository();
          repo.findAll().forEach(p ->
                            System.out.println(p.getMajorCategory()
                                    + " | " + p.getName() + " | " + p.getEuros())
          );
        }

        case 0 -> System.out.println("exiting menu...");
        default -> System.out.println("invalid selection!");

      }

    } while (choice != 0);

    sc.close();
  }
}
