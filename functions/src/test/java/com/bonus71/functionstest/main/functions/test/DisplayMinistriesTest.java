package com.bonus71.functionstest.main.functions.test;

import com.bonus71.functions.main.functions.DisplayMinistries;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test class for {@link DisplayMinistries}.
 *
 * <p>This class uses JUnit 5 to test the {@code showMinistriesData()} method.
 * It simulates user input via {@link System#in} and captures console output
 * via {@link System#out} to verify that menu options for all ministries
 * (Education, Environment, National Defense, Finance, Health) behave as expected.</p>
 *
 * <p>Test cases include:
 * <ul>
 *   <li>Exiting the menu immediately</li>
 *   <li>Handling invalid selections</li>
 *   <li>Displaying each ministry's data correctly</li>
 *   <li>Handling multiple selections in sequence</li>
 * </ul>
 *
 * <p>Setup and teardown methods redirect input and output streams for testing,
 * ensuring that standard console behavior is restored after each test.</p>
 */


public class DisplayMinistriesTest {

  private final InputStream originalIn = System.in;
  private final PrintStream originalOut = System.out;
  private ByteArrayOutputStream outContent;

  @BeforeEach
  void setUp() {
    outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
  }

  @AfterEach
  void tearDown() {
    System.setIn(originalIn);
    System.setOut(originalOut);
  }

  @Test
  void testExitImmediately() throws Exception {
    String input = "0\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));

    DisplayMinistries.showMinistriesData();

    String output = outContent.toString();
    assertTrue(output.contains("DISPLAY MINISTRIES DATA"));
    assertTrue(output.contains("exiting menu"));
  }

  @Test
  void testInvalidChoice() throws Exception {
    String input = "99\n0\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));

    DisplayMinistries.showMinistriesData();

    String output = outContent.toString();
    assertTrue(output.contains("invalid selection"));
  }

  @Test
  void testEducationOption() throws Exception {
    String input = "1\n0\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));

    DisplayMinistries.showMinistriesData();

    String output = outContent.toString();
    assertTrue(output.contains("MINISTRY OF EDUCATION"));
  }

  @Test
  void testEnvironmentOption() throws Exception {
    String input = "2\n0\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));

    DisplayMinistries.showMinistriesData();

    String output = outContent.toString();
    assertTrue(output.contains("MINISTRY OF ENVIRONMENT"));
  }

  @Test
  void testNationalDefenseOption() throws Exception {
    String input = "3\n0\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));

    DisplayMinistries.showMinistriesData();

    String output = outContent.toString();
    assertTrue(output.contains("MINISTRY OF NATIONAL DEFENSE"));
  }

  @Test
  void testFinanceOption() throws Exception {
    String input = "4\n0\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));

    DisplayMinistries.showMinistriesData();

    String output = outContent.toString();
    assertTrue(output.contains("MINISTRY OF FINANCE"));
  }

  @Test
  void testHealthOption() throws Exception {
    String input = "5\n0\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));

    DisplayMinistries.showMinistriesData();

    String output = outContent.toString();
    assertTrue(output.contains("MINISTRY OF HEALTH"));
  }

  @Test
  void testMultipleChoices() throws Exception {
    String input = "1\n2\n3\n0\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));

    DisplayMinistries.showMinistriesData();

    String output = outContent.toString();
    assertTrue(output.contains("MINISTRY OF EDUCATION"));
    assertTrue(output.contains("MINISTRY OF ENVIRONMENT"));
    assertTrue(output.contains("MINISTRY OF NATIONAL DEFENSE"));
  }
}
