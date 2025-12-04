package com.bonus71.functions.menus;

import com.bonus71.data.entity.Comparison.YearsComparison;
import com.bonus71.data.repository.YearsComparisonRepository;

import java.sql.SQLException;

public class YearsComparisonMenu {

    private final YearsComparisonRepository repo;
    //  1ος constructor – χρησιμοποιείται στο κανονικό πρόγραμμα
    public YearsComparisonMenu() {
        this.repo = new YearsComparisonRepository();
    }
    // 2ος constructor – χρησιμοποιείται στα tests με fake repo
    public YearsComparisonMenu(YearsComparisonRepository repo) {
        this.repo = repo;

    public YearsComparison getYear(int year) throws SQLException {
        return repo.findByYear(year);
    }

    public String compare(int baseYear, int otherYear) throws SQLException {
        YearsComparison base = repo.findByYear(baseYear);
        YearsComparison other = repo.findByYear(otherYear);

        if (base == null || other == null) {
            return "No data found for " + baseYear + " or " + otherYear;
        }

        return String.format("""
                === Comparison %d vs %d ===

                Net Revenues %d: %s
                Net Revenues %d: %s

                Expenses %d:    %s
                Expenses %d:    %s

                Balance %d:     %s
                Balance %d:     %s
                """,
                baseYear, otherYear,
                baseYear, base.getNetRevenues(),
                otherYear, other.getNetRevenues(),
                baseYear, base.getExpenses(),
                otherYear, other.getExpenses(),
                baseYear, base.getBalance(),
                otherYear, other.getBalance()
        );
    }

    public String generalConclusions() {
        return """
                === General Conclusions for the Four-Year Period ===

                Revenues: Increase steadily from 2022 → 2023 → 2024 (~59.6 → ~74.0 billion €).
                2025 Jan–Oct already shows ~61 billion €.

                Expenses: Peak in 2022 (~71.3 billion €), then decrease in 2023,
                rise again in 2024 (~73.7 billion €), and stand at ~57.9 billion € for Jan–Oct 2025.

                Balance:
                2022: –11.7B deficit
                2023: –4.0B deficit
                2024: +0.3B slight surplus
                2025 (Jan–Oct): +3.1B surplus

                """;
    }
}
