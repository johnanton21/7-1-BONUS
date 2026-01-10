package com.bonus71.functionstest.main.functions.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bonus71.functions.main.functions.EditProcessor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test class for {@link EditProcessor}.
 *
 * <p>This class uses JUnit 5 to test the {@code editData()} method.
 * It simulates user input via {@link System#in} and captures console output
 * via {@link System#out} to verify the behavior of the data editing menu.</p>
 *
 * <p>Test cases include:
 * <ul>
 *   <li>Exiting the menu immediately (input "0")</li>
 *   <li>Handling invalid menu selections</li>
 *   <li>Displaying the main data management menu with all options</li>
 * </ul>
 *
 * <p>Setup and teardown methods restore the original input and output streams
 * to ensure standard console behavior after each test.</p>
 */


public class EditProcessorTest {

  private final InputStream originalIn = System.in;
  private final PrintStream originalOut = System.out;

  @BeforeEach
  void setUp() {
    // Tests will set their own System.in/out
  }

  @AfterEach
  void tearDown() {
    // Restore original streams after each test
    System.setIn(originalIn);
    System.setOut(originalOut);
  }

  @Test
  void testExitDirectly() throws SQLException {
    // Προσομοίωση εισόδου: 0 για έξοδο
    String input = "0\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));


    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    EditProcessor.editData();

    String output = outputStream.toString();
    assertTrue(output.contains("Exit..."));
  }

  @Test
  void testInvalidChoice() throws SQLException {
    // Προσομοίωση εισόδου: 99 (invalid) και μετά 0 (exit)
    String input = "99\n0\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));


    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    EditProcessor.editData();

    String output = outputStream.toString();
    assertTrue(output.contains("invalid choice!"));
    assertTrue(output.contains("Exit..."));
  }

  @Test
  void testMenuDisplay() throws SQLException {
    // Test that menu displays and exits cleanly
    String input = "0\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    EditProcessor.editData();

    String output = outputStream.toString();
    assertTrue(output.contains("DATA MANAGEMENT MENU"));
    assertTrue(output.contains("Expenditures"));
    assertTrue(output.contains("Revenues"));
    assertTrue(output.contains("Exit..."));
  }
}
