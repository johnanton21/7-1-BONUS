package com.bonus71.functionstest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.Scanner;

@Test
void testCompare2025With2022_ShowsCorrectOutput() {
    // Προσομοίωση εισόδου: επιλογή 1 (συγκρίνει 2025 με 2022), μετά έξοδος
    String input = "1\n0\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));

    // Καταγραφή εξόδου
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    // Fake repository με δεδομένα
    FakeYearsRepo fakeRepo = new FakeYearsRepo();
    fakeRepo.addData(2025, new YearsComparison(2025, "61000000000", "57900000000", "3100000000"));
    fakeRepo.addData(2022, new YearsComparison(2022, "59600000000", "71300000000", "-11700000000"));

    YearsComparisonMenu menu = new YearsComparisonMenu(fakeRepo, new Scanner(System.in));
    menu.show();

    String output = outputStream.toString();

    assertTrue(output.contains("Compare2025 with 2022"));
    assertTrue(output.contains("Net Revenues 2025:"));
    assertTrue(output.contains("Expenses 2022:"));
    assertTrue(output.contains("Balance2025:"));
}
