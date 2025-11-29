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
            System.out.println("=== Σύγκριση Προϋπολογισμού 2025 ===");
            System.out.println("1. Σύγκριση 2025 με 2022");
            System.out.println("2. Σύγκριση 2025 με 2023");
            System.out.println("3. Σύγκριση 2025 με 2024");
            System.out.println("4. Γενικά συμπεράσματα τετραετίας");
            System.out.println("0. Έξοδος");
            System.out.print("Επιλογή: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> compareYears(2025, 2022);
                case "2" -> compareYears(2025, 2023);
                case "3" -> compareYears(2025, 2024);
                case "4" -> generalConclusions();
                case "0" -> {
                    System.out.println("Αντίο!");
                    return;
                }
                default -> System.out.println("Μη έγκυρη επιλογή.\n");
            }
        }
    }

    private void compareYears(int baseYear, int otherYear) {
        try {
            YearsComparison base = repository.findByYear(baseYear);
            YearsComparison other = repository.findByYear(otherYear);

            if (base == null || other == null) {
                System.out.println("Δεν βρέθηκαν δεδομένα για τα έτη " + baseYear + " ή " + otherYear);
                return;
            }

            System.out.println("\n=== Σύγκριση " + baseYear + " με " + otherYear + " ===");

            System.out.println("Καθαρά έσοδα " + baseYear + ":  " + base.getNetRevenues());
            System.out.println("Καθαρά έσοδα " + otherYear + ": " + other.getNetRevenues());

            System.out.println("Δαπάνες " + baseYear + ":       " + base.getExpenses());
            System.out.println("Δαπάνες " + otherYear + ":      " + other.getExpenses());

            System.out.println("Ισοζύγιο " + baseYear + ":      " + base.getBalance());
            System.out.println("Ισοζύγιο " + otherYear + ":     " + other.getBalance());

        } catch (SQLException e) {
            System.out.println("Σφάλμα κατά την ανάγνωση από τη βάση: " + e.getMessage());
        }
    }

    private void generalConclusions() {
        System.out.println("\n=== Γενικά συμπεράσματα τετραετίας ===\n");
        System.out.println(
                "Έσοδα: ανεβαίνουν συνεχώς 2022 → 2023 → 2024 (από ~59,6 σε ~74,0 δισ. €). " +
                        "Το 2025 στο 10μηνο έχει ήδη ~61 δισ. €.\n" +
                        "Δαπάνες: κορυφώνονται το 2022 (~71,3 δισ. €), πέφτουν ελαφρά το 2023, " +
                        "ξαναν ανεβαίνουν 2024 (~73,7 δισ. €), ενώ στο 10μηνο 2025 είναι ~57,9 δισ. €.\n" +
                        "Ισοζύγιο:\n" +
                        "2022: μεγάλο έλλειμμα (~–11,7 δισ. €)\n" +
                        "2023: πολύ μικρότερο έλλειμμα (~–4,0 δισ. €)\n" +
                        "2024: γυρνά σχεδόν σε ισοσκελισμό / μικρό πλεόνασμα (~+0,3 δισ. €)\n" +
                        "2025 (Ιαν–Οκτ): εμφανές πλεόνασμα ~3,1 δισ. € στο 10μηνο.\n"
        );
        System.out.println();
    }
}



