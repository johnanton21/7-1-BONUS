package bonus71;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        System.out.println("Welcome to the Menu!");
        Scanner choice = new Scanner(System.in);
        int selection;
        System.out.println("Please select an option:");
        do {
        System.out.println("1. Display of the current year's government budget data\n" + 
                           "2. Categorize expedetures and revenues by ministry or sector\n " + 
                           "3. Comparison of government budget data with other countries\n" +
                           "4. Apply changes\n" +
                           "5. Analyze statistical data using graphs\n" +
                           "6. Exit");
        selection = choice.nextInt();

        choice.close();
    } while (selection != 6);
    }
}
