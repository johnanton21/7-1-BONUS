/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.functionstest.main.functions.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.bonus71.data.entity.financial.Expenditure;
import com.bonus71.data.entity.financial.Revenue;
import com.bonus71.data.repository.ExpenditureRepository;
import com.bonus71.data.repository.RevenueRepository;
import com.bonus71.functions.main.functions.FinancialService;
import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test class for {@link FinancialService} focusing on fiscal/budget-related operations.
 *
 * <p>This class uses JUnit 5 and Mockito to test fiscal calculations, including
 * the computation of fiscal balance and status (Surplus, Deficit, Balanced),
 * as well as parsing of monetary amount strings in various formats.</p>
 *
 * <p>Tested operations include:
 * <ul>
 *   <li>Calculation of fiscal balance when revenues exceed expenditures (Surplus)</li>
 *   <li>Calculation of fiscal balance when expenditures exceed revenues (Deficit)</li>
 *   <li>Calculation of fiscal balance when revenues equal expenditures (Balanced)</li>
 *   <li>Parsing of amounts from strings with various formats, including currency symbols, commas, dots, null, empty, or invalid strings</li>
 * </ul>
 *
 * <p>Setup uses reflection to inject mock {@link RevenueRepository} and {@link ExpenditureRepository}
 * instances into the {@code FinancialService} before each test.</p>
 */


public class FinancialServiceFiscalTest {

  private FinancialService service;
  private RevenueRepository mockRevenue;
  private ExpenditureRepository mockExpenditure;

  @BeforeEach
    void setup() throws Exception {
    service = new FinancialService();
    mockRevenue = mock(RevenueRepository.class);
    mockExpenditure = mock(ExpenditureRepository.class);

    var fieldRev = FinancialService.class.getDeclaredField("revenueRepository");
    fieldRev.setAccessible(true);
    fieldRev.set(service, mockRevenue);

    var fieldExp = FinancialService.class.getDeclaredField("expenditureRepository");
    fieldExp.setAccessible(true);
    fieldExp.set(service, mockExpenditure);
  }

  @Test
    void testFiscalBalanceSurplus() throws SQLException {
    when(mockRevenue.findAll()).thenReturn(List.of(new Revenue(1, "Sales", "200")));
    when(mockExpenditure.findAll()).thenReturn(List.of(new Expenditure(1, "Rent", "150")));

    assertEquals(50.0, service.calculateFiscalBalance(), 0.001);
    assertTrue(service.isSurplus());
    assertTrue(service.getFiscalBalanceStatus().contains("Surplus"));
  }

  @Test
    void testFiscalBalanceDeficit() throws SQLException {
    when(mockRevenue.findAll()).thenReturn(List.of(new Revenue(1, "Sales", "100")));
    when(mockExpenditure.findAll()).thenReturn(List.of(new Expenditure(1, "Rent", "150")));
    assertEquals(-50.0, service.calculateFiscalBalance(), 0.001);
    assertFalse(service.isSurplus());
    assertTrue(service.getFiscalBalanceStatus().contains("Deficit"));
  }

  @Test
    void testFiscalBalanceBalanced() throws SQLException {
    when(mockRevenue.findAll()).thenReturn(List.of(new Revenue(1, "Sales", "100")));
    when(mockExpenditure.findAll()).thenReturn(List.of(new Expenditure(1, "Rent", "100")));

    assertEquals(0.0, service.calculateFiscalBalance(), 0.001);
    assertTrue(service.isSurplus());
    assertTrue(service.getFiscalBalanceStatus().contains("Balanced"));
  }

  @Test
    void testParseAmountVariousFormats() throws Exception {
    var method = FinancialService.class.getDeclaredMethod("parseAmount", String.class);
    method.setAccessible(true);

    // Βοηθητική κλήση της private μεθόδου
    double val1 = (double) method.invoke(service, "1.234,56€");
    double val2 = (double) method.invoke(service, "2,50");
    double val3 = (double) method.invoke(service, "1000");
    double val4 = (double) method.invoke(service, "€3.500");
    double val5 = (double) method.invoke(service, (Object) null);
    double val6 = (double) method.invoke(service, "");
    double val7 = (double) method.invoke(service, "abc");

    assertEquals(1234.56, val1, 0.001);
    assertEquals(2.50, val2, 0.001);
    assertEquals(1000.0, val3, 0.001);
    assertEquals(3500.0, val4, 0.001);
    assertEquals(0.0, val5, 0.001);
    assertEquals(0.0, val6, 0.001);
    assertEquals(0.0, val7, 0.001);
  }
}
