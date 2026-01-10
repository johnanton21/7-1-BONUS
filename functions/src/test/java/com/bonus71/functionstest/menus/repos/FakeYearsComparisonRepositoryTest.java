package com.bonus71.functionstest.menus.repos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.bonus71.data.entity.Comparison.YearsComparison;
import com.bonus71.data.repository.YearsComparisonRepository;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for a fake {@link YearsComparisonRepository} used in testing.
 *
 * <p>This fake repository stores {@link YearsComparison} objects in-memory
 * keyed by year, allowing tests to simulate database queries without a real database.</p>
 */

public class FakeYearsComparisonRepositoryTest {


  static class FakeYearsComparisonRepository extends YearsComparisonRepository {

    private final Map<Integer, YearsComparison> data = new HashMap<>();

    public void add(int year, YearsComparison yc) {
            data.put(year, yc);
        }

    @Override
        public YearsComparison findByYear(int year) throws SQLException {
      return data.get(year);
    }
  }

  @Test
    void testFindExistingYearReturnsCorrectData() throws SQLException {
    FakeYearsComparisonRepository fakeRepo = new FakeYearsComparisonRepository();

    YearsComparison yc = new YearsComparison(
                2025, "61000000000", "57900000000", "3100000000"
    );

    fakeRepo.add(2025, yc);

    YearsComparison result = fakeRepo.findByYear(2025);

    assertNotNull(result);
    assertEquals("61000000000", result.getNetRevenues());
    assertEquals("57900000000", result.getExpenses());
    assertEquals("3100000000", result.getBalance());
  }

  @Test
    void testFindMissingYearReturnsNull() throws SQLException {
    FakeYearsComparisonRepository fakeRepo = new FakeYearsComparisonRepository();

    YearsComparison result = fakeRepo.findByYear(2023);

    assertNull(result);
  }
}
