package com.bonus71.functionstest.main.functions.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bonus71.data.entity.financial.Expenditure;
import com.bonus71.data.entity.financial.Revenue;
import com.bonus71.functions.main.functions.FinancialService;
import com.bonus71.functionstest.main.functions.test.repos.FakeExpenditureRepository;
import com.bonus71.functionstest.main.functions.test.repos.FakeRevenueRepository;
import java.sql.SQLException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FinancialServiceFiscalTest {

    private FinancialService service;
    private FakeRevenueRepository fakeRevenue;
    private FakeExpenditureRepository fakeExpenditure;

    @BeforeEach
    void setup() throws Exception {
        service = new FinancialService();
        fakeRevenue = new FakeRevenueRepository();
        fakeExpenditure = new FakeExpenditureRepository();

        var fieldRev = FinancialService.class.getDeclaredField("revenueRepository");
        fieldRev.setAccessible(true);
        fieldRev.set(service, fakeRevenue);

        var fieldExp = FinancialService.class.getDeclaredField("expenditureRepository");
        fieldExp.setAccessible(true);
        fieldExp.set(service, fakeExpenditure);

        fakeRevenue.clear();
        fakeExpenditure.clear();
    }

    @Test
    void testFiscalBalanceSurplus() throws SQLException {
        fakeRevenue.add(new Revenue(1, "Sales", "200"));
        fakeExpenditure.add(new Expenditure(1, "Rent", "150"));

        assertEquals(50.0, service.calculateFiscalBalance(), 0.001);
        assertTrue(service.isSurplus());
        assertTrue(service.getFiscalBalanceStatus().contains("Surplus"));
    }

    @Test
    void testFiscalBalanceDeficit() throws SQLException {
        fakeRevenue.add(new Revenue(1, "Sales", "100"));
        fakeExpenditure.add(new Expenditure(1, "Rent", "150"));

        assertEquals(-50.0, service.calculateFiscalBalance(), 0.001);
        assertFalse(service.isSurplus());
        assertTrue(service.getFiscalBalanceStatus().contains("Deficit"));
    }

    @Test
    void testFiscalBalanceBalanced() throws SQLException {
        fakeRevenue.add(new Revenue(1, "Sales", "100"));
        fakeExpenditure.add(new Expenditure(1, "Rent", "100"));

        assertEquals(0.0, service.calculateFiscalBalance(), 0.001);
        assertTrue(service.isSurplus());
        assertTrue(service.getFiscalBalanceStatus().contains("Balanced"));
    }
}
