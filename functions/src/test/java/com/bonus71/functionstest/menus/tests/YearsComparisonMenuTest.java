package com.bonus71.functionstest.menus.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bonus71.data.entity.Comparison.YearsComparison;
import com.bonus71.data.repository.YearsComparisonRepository;
import com.bonus71.functions.menus.YearsComparisonMenu;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

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

    FakeYearsComparisonRepository fakeRepo = new FakeYearsComparisonRepository();

    fakeRepo.add(2025,
                new YearsComparison(2025, "61000000000", "57900000000", "3100000000"));
    fakeRepo.add(2022,
                new YearsComparison(2022, "59600000000", "71300000000", "-11700000000"));

    YearsComparisonMenu menu = new YearsComparisonMenu(fakeRepo);


    String result = menu.compare(2025, 2022);


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

    FakeYearsComparisonRepository fakeRepo = new FakeYearsComparisonRepository();


    fakeRepo.add(2025,
                new YearsComparison(2025, "10", "5", "5"));

    YearsComparisonMenu menu = new YearsComparisonMenu(fakeRepo);


    String result = menu.compare(2025, 2020);


    assertEquals("No data found for 2025 or 2020", result);
  }

  @Test
    void testGeneralConclusions_ReturnsCorrectText() {

    YearsComparisonMenu menu = new YearsComparisonMenu(); // δεν χρειάζεται repo


    String result = menu.generalConclusions();


    assertTrue(result.contains("General Conclusions for the Four-Year Period"));
    assertTrue(result.contains("Revenues: Increase steadily from 2022"));
    assertTrue(result.contains("2024: +0.3B slight surplus"));
    assertTrue(result.contains("2025 (Jan–Oct): +3.1B surplus"));
  }
}