package com.bonus71.functionstest.main.functions.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.bonus71.data.entity.financial.Revenue;
import com.bonus71.data.repository.RevenueRepository;
import com.bonus71.functions.main.functions.FinancialService;
import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test class for {@link FinancialService} focusing on parsing monetary amount strings.
 *
 * <p>This class uses JUnit 5 and Mockito to verify that {@link FinancialService} correctly
 * parses various revenue string formats into numeric values and calculates total revenue.</p>
 *
 * <p>Tested scenarios include:
 * <ul>
 *   <li>Amounts with comma as decimal separator (e.g., "1,200")</li>
 *   <li>Amounts with currency symbols and spaces (e.g., " €500 ", "300€")</li>
 *   <li>Null or empty strings</li>
 * </ul>
 *
 * <p>The test ensures that the {@link FinancialService#calculateTotalRevenue()} method
 * correctly sums the parsed amounts into the total revenue.</p>
 *
 * <p>Setup uses reflection to inject a mock {@link RevenueRepository} into the {@code FinancialService}.</p>
 */


public class FinancialServiceParseAmountTest {

  private FinancialService service;
  private RevenueRepository mockRepo;

  @BeforeEach
    void setup() throws Exception {
    service = new FinancialService();
    mockRepo = mock(RevenueRepository.class);


    var field = FinancialService.class.getDeclaredField("revenueRepository");
    field.setAccessible(true);
    field.set(service, mockRepo);
  }

  @Test
    void testParseAmountThroughCalculateRevenue() throws SQLException {

    when(mockRepo.findAll()).thenReturn(List.of(
                new Revenue(1, "cat1", "1,200"),
                new Revenue(2, "cat2", " €500 "),
                new Revenue(3, "cat3", "300€"),
                new Revenue(4, "cat4", null),
                new Revenue(5, "cat5", "")
    ));

    double total = service.calculateTotalRevenue();

    assertEquals(2000.0, total);
  }
}
