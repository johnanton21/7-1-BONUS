package com.bonus71.functionstest.main.functions.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bonus71.functions.main.functions.DisplayExpRev;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test class for {@link DisplayExpRev}.
 *
 * <p>This class uses JUnit 5 to test the output of the {@code showAll()} method
 * in DisplayExpRev. It captures the console output and verifies that all
 * expected headers and sections are printed correctly, ensuring that the
 * method displays expenditures, revenues, and detailed expenditures
 * as intended.</p>
 *
 * <p>Setup and teardown methods redirect {@link System#out} to a
 * {@link ByteArrayOutputStream} for capturing printed output, which is
 * then asserted in the test methods.</p>
 */


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

