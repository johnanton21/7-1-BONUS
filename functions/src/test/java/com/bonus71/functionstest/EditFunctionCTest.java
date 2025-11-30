package com.bonus71.functionstest;

import com.bonus71.functions.main.functions.EditFunctionC;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EditFunctionCTest {

    @Test
    void testExitDirectly() throws SQLException {
        // Προσομοίωση εισόδου: 0 για έξοδο
        String input = "0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Καταγραφή εξόδου
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        EditFunctionC.editData();

        String output = outputStream.toString();
        assertTrue(output.contains("Exit..."));
    }

    @Test
    void testInvalidChoice() throws SQLException {
        // Προσομοίωση εισόδου: 9 (invalid) και μετά 0 (exit)
        String input = "9\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Καταγραφή εξόδου
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        EditFunctionC.editData();

        String output = outputStream.toString();
        assertTrue(output.contains("invalid choice!"));
        assertTrue(output.contains("Exit..."));
    }

    @Test
    void testMultipleChoicesAndExit() throws SQLException {
        // Προσομοίωση εισόδου: επιλογές 1,2,3 και μετά 0 για έξοδο
        String input = "1\n2\n3\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        EditFunctionC.editData();

        String output = outputStream.toString();
        // Ελέγχουμε ότι εμφανίζεται τουλάχιστον
    }
}
