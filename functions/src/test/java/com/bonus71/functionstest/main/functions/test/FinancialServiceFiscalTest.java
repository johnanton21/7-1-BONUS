package com.bonus71.functionstest.main.functions.test;

import com.bonus71.functions.main.functions.FinancialService;
import com.bonus71.data.entity.financial.Revenue;
import com.bonus71.data.entity.financial.Expenditure;
import com.bonus71.data.repository.RevenueRepository;
import com.bonus71.data.repository.ExpenditureRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

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
}
