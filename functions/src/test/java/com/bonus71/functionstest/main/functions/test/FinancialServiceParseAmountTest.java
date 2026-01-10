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
import static org.mockito.Mockito.when;

import com.bonus71.data.entity.financial.Revenue;
import com.bonus71.data.repository.RevenueRepository;
import com.bonus71.functions.main.functions.FinancialService;
import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
