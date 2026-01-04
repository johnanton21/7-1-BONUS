package com.bonus71.functionstest.main.functions.test;

import com.bonus71.functions.main.functions.DisplayFunctionA;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DisplayFunctionATest {
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


        DisplayFunctionA.showAll();


        String output = outContent.toString();


        assertTrue(output.contains("=== DISPLAY EXPENDITURES ==="));
        assertTrue(output.contains("=== DISPLAY REVENUES ==="));
        assertTrue(output.contains("=== DISPLAY ARTICLE 2 EXPENDITURES ==="));
    }
}

