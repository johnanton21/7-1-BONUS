import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

public class FakeYearsComparisonRepositoryTest {

    // Fake repository που δεν συνδέεται με βάση
    static class FakeYearsComparisonRepository extends YearsComparisonRepository {
        private final Map<Integer, YearsComparison> data = new HashMap<>();

        public void add(int year, YearsComparison yc) {
            data.put(year, yc);
        }

        @Override
        public YearsComparison findByYear(int year) {
            return data.get(year);  // Επιστρέφει μόνο από τη μνήμη
        }
    }

    @Test
    void testFindExistingYearReturnsCorrectData() {
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
    void testFindMissingYearReturnsNull() {
        FakeYearsComparisonRepository fakeRepo = new FakeYearsComparisonRepository();

        YearsComparison result = fakeRepo.findByYear(2023);

        assertNull(result);
    }
}