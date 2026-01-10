/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.functionstest.main.functions.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.bonus71.data.entity.financial.Revenue;
import com.bonus71.data.repository.RevenueRepository;
import com.bonus71.functions.main.functions.FinancialService;
import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test class for {@link FinancialService} focusing on revenue-related operations.
 *
 * <p>This class uses JUnit 5 and Mockito to test the revenue management functionality
 * of {@code FinancialService}. A mock {@link RevenueRepository} is injected to
 * verify that repository methods are called correctly.</p>
 *
 * <p>Tested operations include:
 * <ul>
 *   <li>Adding a revenue entry via {@link FinancialService#addRevenue(Revenue)}</li>
 *   <li>Updating a revenue entry via {@link FinancialService#updateRevenue(Revenue)}</li>
 *   <li>Deleting a revenue entry via {@link FinancialService#deleteRevenue(int)}</li>
 *   <li>Calculating total revenue when repository is empty via {@link FinancialService#calculateTotalRevenue()}</li>
 * </ul>
 *
 * <p>Setup uses reflection to inject the mock repository into the {@code FinancialService}
 * instance before each test.</p>
 */


public class FinancialServiceRevenueTest {

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
    void testAddRevenue() throws SQLException {
    Revenue rev = new Revenue(1, "Sales", "100");
    service.addRevenue(rev);
    verify(mockRepo, times(1)).insert(rev);
  }

  @Test
    void testUpdateRevenue() throws SQLException {
    Revenue rev = new Revenue(2, "Interest", "150");
    service.updateRevenue(rev);
    verify(mockRepo, times(1)).update(rev);
  }

  @Test
    void testDeleteRevenue() throws SQLException {
    service.deleteRevenue(1);
    verify(mockRepo, times(1)).delete(1);
  }

  @Test
    void testCalculateTotalRevenueEmpty() throws SQLException {
    when(mockRepo.findAll()).thenReturn(List.of());
    assertEquals(0.0, service.calculateTotalRevenue());
  }
}
