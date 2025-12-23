package com.bonus71.functionstest.menus.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bonus71.data.entity.ministry.Health;
import com.bonus71.data.repository.HealthRepository;
import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.Test;


class MinistryOfHealthMenuTest {

  @Test
    void testFindAll() throws SQLException {
    HealthRepository repo = new HealthRepository();

    List<Health> results = repo.findAll();

    assertNotNull(results);
  }

  @Test
    void testInsert() throws SQLException {
    HealthRepository repo = new HealthRepository();

    Health h = new Health(801, "TestHealth", "400");
    repo.insert(h);

    boolean exists = repo.findAll().stream()
                .anyMatch(x -> x.getMajorCategory() == 801);

    assertTrue(exists);
  }

  @Test
    void testUpdate() throws SQLException {
    HealthRepository repo = new HealthRepository();

    Health h = new Health(802, "OldHealth", "200");
    repo.insert(h);

    Health updated = new Health(802, "NewHealth", "600");
    repo.update(updated);

    Health result = repo.findAll().stream()
                .filter(x -> x.getMajorCategory() == 802)
                .findFirst()
                .orElse(null);

    assertNotNull(result);
    assertEquals("NewHealth", result.getName());
    assertEquals("600", result.getEuros());
  }

  @Test
    void testDelete() throws SQLException {
    HealthRepository repo = new HealthRepository();

    Health h = new Health(803, "TempHealth", "50");
    repo.insert(h);

    repo.delete(803);

    boolean exists = repo.findAll().stream()
                .anyMatch(x -> x.getMajorCategory() == 803);

    assertFalse(exists);
  }
}
