package com.bonus71.functionstest.menus.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bonus71.data.entity.financial.Expenditure;
import com.bonus71.functions.menus.ExpsensesMenu;
import com.bonus71.functionstest.menus.repos.FakeExpenditureRepository;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ExpensesMenuTest {

  private FakeExpenditureRepository repo;

  @BeforeEach
    void setup() {
    repo = new FakeExpenditureRepository();
  }

  private String runMenu(String input) throws Exception {
    System.setIn(new ByteArrayInputStream(input.getBytes()));

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    Scanner testScanner = new Scanner(System.in);

    ExpsensesMenu.menu(repo);

    return out.toString();
  }

  @Test
    void testView() throws Exception {
    repo.insert(new Expenditure(1, "Roads", "1000"));
    repo.insert(new Expenditure(2, "Hospitals", "2000"));

    String output = runMenu("1\n");

    assertTrue(output.contains("1 | Roads | 1000"));
    assertTrue(output.contains("2 | Hospitals | 2000"));
  }

  @Test
    void testAdd() throws Exception {
    runMenu("2\n5\nTransport\n3000\n");

    assertEquals(1, repo.findAll().size());
    Expenditure e = repo.findAll().get(0);

    assertEquals(5, e.getCode());
    assertEquals("Transport", e.getCategory());
    assertEquals("3000", e.getEuros());
  }

  @Test
    void testUpdate() throws Exception {
    repo.insert(new Expenditure(10, "Police", "500"));

    runMenu("3\n10\nSecurity\n9999\n");

    Expenditure e = repo.findAll().get(0);
    assertEquals("Security", e.getCategory());
    assertEquals("9999", e.getEuros());
  }

  @Test
    void testDelete() throws Exception {
    repo.insert(new Expenditure(7, "Fire Dept", "1200"));

    runMenu("4\n7\n");

    assertTrue(repo.findAll().isEmpty());
  }

  @Test
    void testInvalidChoice() throws Exception {
    String output = runMenu("9\n");
    assertTrue(output.contains("Invalid choice!"));
  }
}
