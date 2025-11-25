import java.util.InputMismatchException;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MenuTest {
    @Test 
    public static void main(String[] args) {
        Scanner choice = new Scanner(System.in);
        int selection = -1;

        while (selection != 6) {

            System.out.println(" MENU ");
            System.out.println("1. Option 1");
            System.out.println("2. Option 2");
            System.out.println("3. Option 3");
            System.out.println("4. Option 4");
            System.out.println("5. Option 5");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");

            try {
                selection = choice.nextInt();

                if (selection < 1 || selection > 6) {
                    System.out.println("Error: Please enter a number between 1 and 6.");
                    continue;
                }

                switch (selection) {
                    case 1:
                        System.out.println("Option 1 selected.");
                        break;
                    case 2:
                        System.out.println("Option 2 selected.");
                        break;
                    case 3:
                        System.out.println("Option 3 selected.");
                        break;
                    case 4:
                        System.out.println("Option 4 selected.");
                        break;
                    case 5:
                        System.out.println("Option 5 selected.");
                        break;
                    case 6:
                        System.out.println("Exiting program...");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: You must enter a NUMBER.");
                choice.nextLine(); // καθαρισμός buffer
            }

            System.out.println();
        }

        choice.close();
    }
}
