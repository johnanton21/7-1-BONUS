package com.bonus71.functionstest.menus.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bonus71.data.entity.ministry.Environment;
import com.bonus71.data.repository.EnvironmentRepository;
import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.Test;




class MinistryOfEnvironmentMenuTest {

  @Test
    void testFindAll() throws SQLException {
    EnvironmentRepository repo = new EnvironmentRepository();

    List<Environment> results = repo.findAll();

    assertNotNull(results);
  }

  @Test
    void testInsert() throws SQLException {
    EnvironmentRepository repo = new EnvironmentRepository();

    Environment env = new Environment(901, "TestEnv", "300");
    repo.insert(env);

    boolean exists = repo.findAll().stream()
                .anyMatch(x -> x.getMajorCategory() == 901);

    assertTrue(exists);
  }

  @Test
    void testUpdate() throws SQLException {
    EnvironmentRepository repo = new EnvironmentRepository();

    Environment env = new Environment(902, "Old", "100");
    repo.insert(env);

    Environment updated = new Environment(902, "New", "999");
    repo.update(updated);

    Environment result = repo.findAll().stream()
                .filter(x -> x.getMajorCategory() == 902)
                .findFirst()
                .orElse(null);

    assertNotNull(result);
    assertEquals("New", result.getName());
    assertEquals("999", result.getEuros());
  }

  @Test
    void testDelete() throws SQLException {
    EnvironmentRepository repo = new EnvironmentRepository();

    Environment env = new Environment(903, "DeleteMe", "10");
    repo.insert(env);

    repo.delete(903);

    boolean exists = repo.findAll().stream()
                .anyMatch(x -> x.getMajorCategory() == 903);

    assertFalse(exists);
  }
}
