package com.bonus71.functionstest.menus.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bonus71.functionstest.main.functions.test.repos.FakeExpenditureRepository;
import com.bonus71.functionstest.main.functions.test.repos.FakeRevenueRepository;

import com.bonus71.data.entity.financial.Revenue;
import com.bonus71.functions.menus.RevenueMenu;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RevenueMenuTest {

  private FakeRevenueRepository repo;

  @BeforeEach
        void setup() {
    repo = new FakeRevenueRepository();
  }

  private String runMenuWithInput(String input) throws SQLException {

    System.setIn(new ByteArrayInputStream(input.getBytes()));


    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    Scanner testScanner = new Scanner(System.in);
    RevenueMenu.menu(repo);

    return outputStream.toString();
  }

  @Test
        void testView() throws SQLException {
    repo.insert(new Revenue(1, "Salary tax", "500000"));
    repo.insert(new Revenue(2, "VAT", "900000"));

    String out = runMenuWithInput("1\n");

    assertTrue(out.contains("1 | Salary tax | 500000"));
    assertTrue(out.contains("2 | VAT | 900000"));
  }

  @Test
        void testAdd() throws SQLException {
    runMenuWithInput(
                    "2\n"
                            + "10\n"
                            + "Income tax\n"
                            + "200000\n"
    );

    assertEquals(1, repo.findAll().size());
    Revenue r = repo.findAll().get(0);

    assertEquals(10, r.getCode());
    assertEquals("Income tax", r.getCategory());
    assertEquals("200000", r.getEuros());
  }

  @Test
        void testUpdate() throws SQLException {
    repo.insert(new Revenue(5, "OldCategory", "100"));

    runMenuWithInput(
                    "3\n"
                            +   "5\n"
                            + "NewCategory\n"
                            + "999\n"
    );

    Revenue updated = repo.findAll().get(0);
    assertEquals("NewCategory", updated.getCategory());
    assertEquals("999", updated.getEuros());
  }

  @Test
        void testDelete() throws SQLException {
    repo.insert(new Revenue(7, "Test", "111"));

    runMenuWithInput("4\n7\n");

    assertTrue(repo.findAll().isEmpty());
  }

  @Test
        void testInvalidChoice() throws SQLException {
    String out = runMenuWithInput("9\n");

    assertTrue(out.contains("Invalid choice!"));
  }
}
