package com.bonus71.functionstest.main.functions.test;

import com.bonus71.functions.main.functions.DisplayMinistriesFunctionB;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DisplayMinistriesFunctionBTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    void testExitImmediately() throws Exception {
        String input = "0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        DisplayMinistriesFunctionB.showMinistriesData();

        String output = outContent.toString();
        assertTrue(output.contains("DISPLAY MINISTRIES DATA"));
        assertTrue(output.contains("exiting menu"));
    }

    @Test
    void testInvalidChoice() throws Exception {
        String input = "99\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        DisplayMinistriesFunctionB.showMinistriesData();

        String output = outContent.toString();
        assertTrue(output.contains("invalid selection"));
    }

    @Test
    void testMenuOptions() throws Exception {
        String input = "0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        DisplayMinistriesFunctionB.showMinistriesData();

        String output = outContent.toString();
        assertTrue(output.contains("MINISTRY OF EDUCATION"));
        assertTrue(output.contains("MINISTRY OF ENVIRONMENT"));
        assertTrue(output.contains("MINISTRY OF NATIONAL DEFENSE"));
        assertTrue(output.contains("MINISTRY OF FINANCE"));
        assertTrue(output.contains("MINISTRY OF HEALTH"));
    }

    @Test
    void testEducationOption() throws Exception {
        String input = "1\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        DisplayMinistriesFunctionB.showMinistriesData();

        String output = outContent.toString();
        assertTrue(output.contains("MINISTRY OF EDUCATION"));
    }

    @Test
    void testEnvironmentOption() throws Exception {
        String input = "2\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        DisplayMinistriesFunctionB.showMinistriesData();

        String output = outContent.toString();
        assertTrue(output.contains("MINISTRY OF ENVIRONMENT"));
    }

    @Test
    void testNationalDefenseOption() throws Exception {
        String input = "3\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        DisplayMinistriesFunctionB.showMinistriesData();

        String output = outContent.toString();
        assertTrue(output.contains("MINISTRY OF NATIONAL DEFENSE"));
    }

    @Test
    void testFinanceOption() throws Exception {
        String input = "4\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        DisplayMinistriesFunctionB.showMinistriesData();

        String output = outContent.toString();
        assertTrue(output.contains("MINISTRY OF FINANCE"));
    }

    @Test
    void testHealthOption() throws Exception {
        String input = "5\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        DisplayMinistriesFunctionB.showMinistriesData();

        String output = outContent.toString();
        assertTrue(output.contains("MINISTRY OF HEALTH"));
    }

    @Test
    void testMultipleChoices() throws Exception {
        String input = "1\n2\n3\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        DisplayMinistriesFunctionB.showMinistriesData();

        String output = outContent.toString();
        assertTrue(output.contains("MINISTRY OF EDUCATION"));
        assertTrue(output.contains("MINISTRY OF ENVIRONMENT"));
        assertTrue(output.contains("MINISTRY OF NATIONAL DEFENSE"));
    }
}
