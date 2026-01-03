package com.bonus71.functionstest.main.functions.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bonus71.data.entity.financial.Revenue;
import com.bonus71.functions.main.functions.FinancialService;
import com.bonus71.functionstest.main.functions.test.repos.FakeRevenueRepository;
import java.sql.SQLException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FinancialServiceRevenueTest {

    private FinancialService service;
    private FakeRevenueRepository fakeRepo;

    @BeforeEach
    void setup() throws Exception {
        service = new FinancialService();
        fakeRepo = new FakeRevenueRepository();

        var field = FinancialService.class.getDeclaredField("revenueRepository");
        field.setAccessible(true);
        field.set(service, fakeRepo);

        fakeRepo.clear();
    }

    @Test
    void testAddRevenue() throws SQLException {
        Revenue rev = new Revenue(1, "Tax", "100.5");

        service.addRevenue(rev);

        assertEquals(1, fakeRepo.findAll().size());
        assertEquals("Tax", fakeRepo.findAll().get(0).getCategory());
        assertEquals("100.5", fakeRepo.findAll().get(0).getEuros());
    }

    @Test
    void testUpdateRevenue() throws SQLException {
        Revenue original = new Revenue(2, "VAT", "50");
        Revenue updated  = new Revenue(2, "VAT", "80");

        service.addRevenue(original);
        service.updateRevenue(updated);

        assertEquals(1, fakeRepo.findAll().size());
        assertEquals("80", fakeRepo.findAll().get(0).getEuros());
    }

    @Test
    void testDeleteRevenue() throws SQLException {
        Revenue r1 = new Revenue(1, "Tax", "100");
        Revenue r2 = new Revenue(2, "Fees", "20");

        service.addRevenue(r1);
        service.addRevenue(r2);

        service.deleteRevenue(1);

        assertEquals(1, fakeRepo.findAll().size());
        assertEquals(2, fakeRepo.findAll().get(0).getCode());
    }

    @Test
    void testCalculateTotalRevenue() throws SQLException {
        service.addRevenue(new Revenue(1, "Tax", "100"));
        // ΠΡΟΣΟΧΗ: με κόμμα, για να ταιριάζει με τη λογική της parseAmount
        service.addRevenue(new Revenue(2, "Fees", "20,5"));

        double total = service.calculateTotalRevenue();

        assertEquals(120.5, total, 0.001);
    }
}
