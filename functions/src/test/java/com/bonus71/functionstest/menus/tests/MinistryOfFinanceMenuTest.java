package com.bonus71.functionstest.menus.tests;

import com.bonus71.data.entity.ministry.FinanceMinistry;
import com.bonus71.data.repository.FinanceMinistryRepository;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinistryOfFinanceMenuTest {

    @Test
    void testFindAll() throws SQLException {
        FinanceMinistryRepository repo = new FinanceMinistryRepository();

        List<FinanceMinistry> results = repo.findAll();

        assertNotNull(results);
    }

    @Test
    void testInsert() throws SQLException {
        FinanceMinistryRepository repo = new FinanceMinistryRepository();

        FinanceMinistry fm = new FinanceMinistry(501, "FinanceTest", "1000");
        repo.insert(fm);

        boolean exists = repo.findAll().stream()
                .anyMatch(x -> x.getMajorCategory() == 501);

        assertTrue(exists);
    }

    @Test
    void testUpdate() throws SQLException {
        FinanceMinistryRepository repo = new FinanceMinistryRepository();

        FinanceMinistry fm = new FinanceMinistry(502, "OldFinance", "200");
        repo.insert(fm);

        FinanceMinistry updated = new FinanceMinistry(502, "NewFinance", "900");
        repo.update(updated);

        FinanceMinistry result = repo.findAll().stream()
                .filter(x -> x.getMajorCategory() == 502)
                .findFirst()
                .orElse(null);

        assertNotNull(result);
        assertEquals("NewFinance", result.getName());
        assertEquals("900", result.getEuros());
    }

    @Test
    void testDelete() throws SQLException {
        FinanceMinistryRepository repo = new FinanceMinistryRepository();

        FinanceMinistry fm = new FinanceMinistry(503, "TempFinance", "80");
        repo.insert(fm);

        repo.delete(503);

        boolean exists = repo.findAll().stream()
                .anyMatch(x -> x.getMajorCategory() == 503);

        assertFalse(exists);
    }
}
