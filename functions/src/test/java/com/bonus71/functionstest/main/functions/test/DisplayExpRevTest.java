/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.functionstest.main.functions.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bonus71.functions.main.functions.DisplayExpRev;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class DisplayExpRevTest {
  private final PrintStream originalOut = System.out;
  private ByteArrayOutputStream outContent;

  @BeforeEach
    public void setUp() {
    outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
  }

  @AfterEach
    public void tearDown() {
    System.setOut(originalOut);
  }

  @Test
    public void testShowAllRunsAndPrintsHeaders() throws SQLException {


    DisplayExpRev.showAll();


    String output = outContent.toString();


    assertTrue(output.contains("=== DISPLAY EXPENDITURES ==="));
    assertTrue(output.contains("=== DISPLAY REVENUES ==="));
    assertTrue(output.contains("=== DISPLAY ARTICLE 2 EXPENDITURES ==="));
  }
}

