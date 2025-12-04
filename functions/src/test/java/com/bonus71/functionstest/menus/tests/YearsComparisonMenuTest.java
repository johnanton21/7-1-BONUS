package com.bonus71.functionstest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

// === FAKE REPOSITORY ΓΙΑ TESTING ===
class FakeYearsComparisonRepository extends YearsComparisonRepository {
    private final Map<Integer, YearsComparison> data = new HashMap<>();

    public void add(int year, YearsComparison yc) {
        data.put(year, yc);
    }

    @Override
    public YearsComparison findByYear(int year) {
        return data.get(year);  // επιστρέφει μόνο από μνήμη
    }
}

public class YearsComparisonMenuTest {

    @Test
    void testCompare_ReturnsCorrectFormattedString() throws SQLException {
        // Arrange
        FakeYearsComparisonRepository fakeRepo = new FakeYearsComparisonRepository();

        fakeRepo.add(2025,
                new YearsComparison(2025, "61000000000", "57900000000", "3100000000"));
        fakeRepo.add(2022,
                new YearsComparison(2022, "59600000000", "71300000000", "-11700000000"));

        YearsComparisonMenu menu = new YearsComparisonMenu(fakeRepo);

        // Act
        String result = menu.compare(2025, 2022);

        // Assert
        assertTrue(result.contains("=== Comparison 2025 vs 2022 ==="));
        assertTrue(result.contains("Net Revenues 2025: 61000000000"));
        assertTrue(result.contains("Net Revenues 2022: 59600000000"));
        assertTrue(result.contains("Expenses 2025:    57900000000"));
        assertTrue(result.contains("Expenses 2022:    71300000000"));
        assertTrue(result.contains("Balance 2025:     3100000000"));
        assertTrue(result.contains("Balance 2022:     -11700000000"));
    }

    @Test
    void testCompare_WhenYearNotFound_ReturnsErrorMessage() throws SQLException {
        // Arrange
        FakeYearsComparisonRepository fakeRepo = new FakeYearsComparisonRepository();

        // μόνο το 2025 υπάρχει
        fakeRepo.add(2025,
                new YearsComparison(2025, "10", "5", "5"));

        YearsComparisonMenu menu = new YearsComparisonMenu(fakeRepo);

        // Act
        String result = menu.compare(2025, 2020);

        // Assert
        assertEquals("No data found for 2025 or 2020", result);
    }

    @Test
    void testGeneralConclusions_ReturnsCorrectText() {
        // Arrange
        YearsComparisonMenu menu = new YearsComparisonMenu(); // δεν χρειάζεται repo

        // Act
        String result = menu.generalConclusions();

        // Assert (ελέγχουμε βασικές φράσεις)
        assertTrue(result.contains("General Conclusions for the Four-Year Period"));
        assertTrue(result.contains("Revenues: Increase steadily from 2022"));
        assertTrue(result.contains("2024: +0.3B slight surplus"));
        assertTrue(result.contains("2025 (Jan–Oct): +3.1B surplus"));
    }
}