package com.bonus71.bootstrap;

import java.util.Scanner;

/**
 * Main class.
 *
 * @author jskarpetis
 * @version 1.0
 * Created on 19/11/25.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Menu!");

        Scanner choice = new Scanner(System.in);
        int selection;
        System.out.println("Please select an option:");

        do {
            System.out.println("""
                    1. Display of the current year's government budget data
                    2. Categorize expenditures and revenues by ministry or sector
                    3. Comparison of government budget data with other countries
                    4. Apply changes
                    5. Analyze statistical data using graphs
                    6. Exit""");

            selection = choice.nextInt();
            handleUserSelection(selection);
        } while (selection != 6);

        choice.close();
    }

    private static void handleUserSelection(int selection) {
        switch (selection) {
            case 1 -> {
                System.out.println("Case 1");
            }
            case 2 -> {
                System.out.println("Case 2");
            }
            case 3 -> {
                System.out.println("Case 3");
            }
            case 4 -> {
                System.out.println("Case 4");
            }
            case 5 -> {
                System.out.println("Case 5");
            }
            default -> {
            }
        }
    }
}
