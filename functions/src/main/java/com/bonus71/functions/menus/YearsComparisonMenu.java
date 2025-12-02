package com.bonus71.functions.menus;
import com.bonus71.data.entity.Comparison.YearsComparison;
import com.bonus71.data.repository.YearsComparisonRepository;
import java.sql.SQLException;
import java.util.Scanner;

public class YearsComparisonMenu {

    private final YearsComparisonRepository repository = new YearsComparisonRepository();
    private final Scanner scanner = new Scanner(System.in);

    public void show() {
        while (true) {
            System.out.println("=== Budget Comparison Menu ===");
            System.out.println("1. Compare 2025 with 2022");
            System.out.println("2. Compare 2025 with 2023");
            System.out.println("3. Compare 2025 with 2024");
            System.out.println("4. General conclusions for the four-year period");
            System.out.println("0. Exit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> compareYears(2025, 2022);
                case "2" -> compareYears(2025, 2023);
                case "3" -> compareYears(2025, 2024);
                case "4" -> generalConclusions();
                case "0" -> {
                    System.out.println("Ok bye!");
                    return;
                }
                default -> System.out.println("Invalid choice.\n");
            }
        }
    }

    private void compareYears(int baseYear, int otherYear) {
        try {
            YearsComparison base = repository.findByYear(baseYear);
            YearsComparison other = repository.findByYear(otherYear);

            if (base == null || other == null) {
                System.out.println("Could not find data for years " + baseYear + " or " + otherYear);
                return;
            }

            System.out.println("\n=== Compare" + baseYear + " with " + otherYear + " ===");

            System.out.println("Net Revenues " + baseYear + ":  " + base.getNetRevenues());
            System.out.println("Net Revenues " + otherYear + ": " + other.getNetRevenues());

            System.out.println("Expenses " + baseYear + ":       " + base.getExpenses());
            System.out.println("Expenses " + otherYear + ":      " + other.getExpenses());

            System.out.println("Balance" + baseYear + ":      " + base.getBalance());
            System.out.println("Balance " + otherYear + ":     " + other.getBalance());

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    private void generalConclusions() {
        System.out.println("\n=== General Conclusions for the Four-Year Period ===\n");

        System.out.println(
                "Revenues: They continuously increase from 2022 → 2023 → 2024 "
                        + "(from ~59.6 to ~74.0 billion €). In 2025, the Jan–Oct period already shows ~61 billion €.\n"
                        + "Expenses: They peak in 2022 (~71.3 billion €), decrease slightly in 2023, "
                        + "increase again in 2024 (~73.7 billion €), and for Jan–Oct 2025 they stand at ~57.9 billion €.\n"
                        + "Balance:\n"
                        + "2022: large deficit (~–11.7 billion €)\n"
                        + "2023: much smaller deficit (~–4.0 billion €)\n"
                        + "2024: almost balanced / slight surplus (~+0.3 billion €)\n"
                        + "2025 (Jan–Oct): clear surplus of ~3.1 billion € in the ten-month period.\n"
        );
        System.out.println();
    }
}






