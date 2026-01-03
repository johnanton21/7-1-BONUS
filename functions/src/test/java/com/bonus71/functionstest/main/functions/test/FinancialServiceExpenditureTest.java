package com.bonus71.functionstest.main.functions.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bonus71.data.entity.financial.Expenditure;
import com.bonus71.functions.main.functions.FinancialService;
import com.bonus71.functionstest.main.functions.test.repos.FakeExpenditureRepository;
import java.sql.SQLException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FinancialServiceExpenditureTest {

    private FinancialService service;
    private FakeExpenditureRepository fakeRepo;

    @BeforeEach
    void setup() throws Exception {
        service = new FinancialService();
        fakeRepo = new FakeExpenditureRepository();

        var field = FinancialService.class.getDeclaredField("expenditureRepository");
        field.setAccessible(true);
        field.set(service, fakeRepo);

        fakeRepo.clear();
    }

    @Test
    void testAddExpenditure() throws SQLException {
        Expenditure exp = new Expenditure(1, "Rent", "50");
        service.addExpenditure(exp);

        assertEquals(1, fakeRepo.findAll().size());
        assertEquals("Rent", fakeRepo.findAll().get(0).getCategory());
        assertEquals("50", fakeRepo.findAll().get(0).getEuros());
    }

    @Test
    void testUpdateExpenditure() throws SQLException {
        Expenditure original = new Expenditure(2, "Supplies", "30");
        Expenditure updated  = new Expenditure(2, "Supplies", "80");

        service.addExpenditure(original);
        service.updateExpenditure(updated);

        assertEquals(1, fakeRepo.findAll().size());
        assertEquals("80", fakeRepo.findAll().get(0).getEuros());
    }

    @Test
    void testDeleteExpenditure() throws SQLException {
        Expenditure e1 = new Expenditure(1, "Rent", "50");
        Expenditure e2 = new Expenditure(2, "Books", "20");

        service.addExpenditure(e1);
        service.addExpenditure(e2);

        service.deleteExpenditure(1);

        assertEquals(1, fakeRepo.findAll().size());
        assertEquals(2, fakeRepo.findAll().get(0).getCode());
    }

    @Test
    void testCalculateTotalExpenditure() throws SQLException {
        service.addExpenditure(new Expenditure(1, "Rent", "50"));
        service.addExpenditure(new Expenditure(2, "Supplies", "25.5"));

        double total = service.calculateTotalExpenditure();

        assertEquals(75.5, total, 0.001);
    }
}
