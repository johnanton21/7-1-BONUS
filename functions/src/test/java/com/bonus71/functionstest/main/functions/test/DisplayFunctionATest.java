package com.bonus71.functionstest.main.functions.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bonus71.functions.main.functions.DisplayFunctionA;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class DisplayFunctionATest {
  private final PrintStream originalOut = System.out;
  private ByteArrayOutputStream outContent;

  @Before
    public void setUp() {
    outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
  }

  @After
    public void tearDown() {
    System.setOut(originalOut);
  }

  @Test
    public void testShowAllRunsAndPrintsHeaders() throws SQLException {


    DisplayFunctionA.showAll();


    String output = outContent.toString();


    assertTrue(output.contains("=== DISPLAY EXPENDITURES ==="));
    assertTrue(output.contains("=== DISPLAY REVENUES ==="));
    assertTrue(output.contains("=== DISPLAY ARTICLE 2 EXPENDITURES ==="));
  }
}

