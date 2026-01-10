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

import com.bonus71.data.entity.financial.Expenditure;
import com.bonus71.data.repository.ExpenditureRepository;
import com.bonus71.functions.main.functions.FinancialService;
import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test class for {@link FinancialService} focusing on expenditure management.
 *
 * <p>This class uses JUnit 5 and Mockito to verify that {@link FinancialService} correctly
 * handles adding, updating, deleting, and summing expenditures.</p>
 *
 * <p>Tested scenarios include:
 * <ul>
 *   <li>Adding a new {@link Expenditure} to the repository</li>
 *   <li>Updating an existing {@link Expenditure}</li>
 *   <li>Deleting an {@link Expenditure} by code</li>
 *   <li>Calculating the total expenditure from multiple {@link Expenditure} objects</li>
 * </ul>
 *
 * <p>Setup uses reflection to inject a mock {@link ExpenditureRepository} into the {@code FinancialService}.</p>
 */


public class FinancialServiceExpenditureTest {

  private FinancialService service;
  private ExpenditureRepository mockRepo;

  @BeforeEach
    void setup() throws Exception {
    service = new FinancialService();
    mockRepo = mock(ExpenditureRepository.class);

    var field = FinancialService.class.getDeclaredField("expenditureRepository");
    field.setAccessible(true);
    field.set(service, mockRepo);
  }

  @Test
    void testAddExpenditure() throws SQLException {
    Expenditure exp = new Expenditure(1, "Rent", "50");
    service.addExpenditure(exp);
    verify(mockRepo, times(1)).insert(exp);
  }

  @Test
  void testUpdateExpenditure() throws SQLException {
    Expenditure exp = new Expenditure(2, "Supplies", "30");
    service.updateExpenditure(exp);
    verify(mockRepo, times(1)).update(exp);
  }

  @Test
    void testDeleteExpenditure() throws SQLException {
    service.deleteExpenditure(1);
    verify(mockRepo, times(1)).delete(1);
  }

  @Test
    void testCalculateTotalExpenditure() throws SQLException {
    when(mockRepo.findAll()).thenReturn(List.of(
                new Expenditure(1, "Rent", "50"),
                new Expenditure(2, "Supplies", "25.5")
    ));
    double total = service.calculateTotalExpenditure();
    assertEquals(75.5, total, 0.001);
  }
}
