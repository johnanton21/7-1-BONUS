/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.functions.main.functions;

import com.bonus71.data.repository.EducationRepository;
import com.bonus71.data.repository.EnvironmentRepository;
import com.bonus71.data.repository.FinanceMinistryRepository;
import com.bonus71.data.repository.HealthRepository;
import com.bonus71.data.repository.NationalDefenseRepository;
import java.sql.SQLException;
import java.util.Scanner;
/**
 * Utility class responsible for displaying financial expenditure data
 * structured by governmental ministries.
 *
 * <p>This class retrieves ministry-related financial information from the
 * corresponding repository classes and prints the results directly to the
 * console. It provides an interactive textual menu that allows users to browse
 * and inspect data per ministry.</p>
 *
 * <p><b>Ministries handled:</b></p>
 * <ul>
 *     <li>Ministry of Education</li>
 *     <li>Ministry of Environment</li>
 *     <li>Ministry of National Defense</li>
 *     <li>Ministry of Finance</li>
 *     <li>Ministry of Health</li>
 * </ul>
 *
 * <p>This class is typically used for debugging, inspection, or console-based
 * demonstration scenarios, and may be triggered from menu-driven UI components
 * or service layers.</p>
 */

public class DisplayMinistries {
    /**
     * Displays expenditure information categorized by governmental ministries.
     *
     * <p>The method prints an interactive console menu that allows the user
     * to select a ministry. Upon selection, the method fetches data from the
     * appropriate repository and displays structured financial information
     * including major category, department name, and associated cost values.</p>
     *
     * <p>The user may continue selecting options until they choose to exit.</p>
     *
     * @throws SQLException if database access or retrieval fails
     */
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
