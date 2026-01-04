package com.bonus71.functionstest.main.functions.test;

import com.bonus71.functions.main.functions.EditFunctionC;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EditFunctionCTest {

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
    void testExitDirectly() throws SQLException {
        String input = "0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        EditFunctionC.editData();

        String output = outContent.toString();
        assertTrue(output.contains("Exit..."));
    }

    @Test
    void testInvalidChoice() throws SQLException {
        String input = "99\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        EditFunctionC.editData();

        String output = outContent.toString();
        assertTrue(output.contains("invalid choice!"));
        assertTrue(output.contains("Exit..."));
    }

    @Test
    void testMenuDisplay() throws SQLException {
        String input = "0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        EditFunctionC.editData();

        String output = outContent.toString();
        assertTrue(output.contains("DATA MANAGEMENT MENU"));
        assertTrue(output.contains("Expenditures"));
        assertTrue(output.contains("Revenues"));
    }
}
