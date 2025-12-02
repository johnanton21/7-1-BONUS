package com.bonus71.functionstest.menus.tests;

import com.bonus71.data.entity.ministry.NationalDefense;
import com.bonus71.data.repository.NationalDefenseRepository;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NationalDefenseMenuTest {

    @Test
    void testFindAll() throws SQLException {
        NationalDefenseRepository repo = new NationalDefenseRepository();

        List<NationalDefense> results = repo.findAll();

        assertNotNull(results);
    }

    @Test
    void testInsert() throws SQLException {
        NationalDefenseRepository repo = new NationalDefenseRepository();

        NationalDefense nd = new NationalDefense(1001, "TestDefense", "800");
        repo.insert(nd);

        boolean exists = repo.findAll().stream()
                .anyMatch(x -> x.getMajorCategory() == 1001);

        assertTrue(exists);
    }

    @Test
    void testUpdate() throws SQLException {
        NationalDefenseRepository repo = new NationalDefenseRepository();

        NationalDefense nd = new NationalDefense(1002, "Old", "100");
        repo.insert(nd);

        NationalDefense updated = new NationalDefense(1002, "New", "999");
        repo.update(updated);

        NationalDefense result = repo.findAll().stream()
                .filter(x -> x.getMajorCategory() == 1002)
                .findFirst()
                .orElse(null);

        assertNotNull(result);
        assertEquals("New", result.getName());
        assertEquals("999", result.getEuros());
    }

    @Test
    void testDelete() throws SQLException {
        NationalDefenseRepository repo = new NationalDefenseRepository();

        NationalDefense nd = new NationalDefense(1003, "ToDelete", "70");
        repo.insert(nd);

        repo.delete(1003);

        boolean exists = repo.findAll().stream()
                .anyMatch(x -> x.getMajorCategory() == 1003);

        assertFalse(exists);
    }
}
