package com.bonus71.functionstest.menus.tests;

import com.bonus71.data.entity.ministry.FinanceMinistry;
import com.bonus71.functions.menus.MinistryOfFinanceMenu;
import com.bonus71.functionstest.menus.repos.FakeFinanceMinistryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MinistryOfFinanceMenuTest {

    private FakeFinanceMinistryRepository repo;

    @BeforeEach
    void setup() {
        repo = new FakeFinanceMinistryRepository();
    }

    private String runMenu(String input) throws Exception {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Scanner testScanner = new Scanner(System.in);
        MinistryOfFinanceMenu.menu(repo);

        return out.toString();
    }

    @Test
    void testView() throws Exception {
        repo.insert(new FinanceMinistry(1, "Tax Revenue", "100000"));
        repo.insert(new FinanceMinistry(2, "Budget Planning", "75000"));

        String output = runMenu("1\n");

        assertTrue(output.contains("1 | Tax Revenue | 100000"));
        assertTrue(output.contains("2 | Budget Planning | 75000"));
    }

    @Test
    void testAdd() throws Exception {
        runMenu("2\n3\nPublic Debt\n85000\n");

        assertEquals(1, repo.findAll().size());
        FinanceMinistry f = repo.findAll().get(0);

        assertEquals(3, f.getMajorCategory());
        assertEquals("Public Debt", f.getName());
        assertEquals("85000", f.getEuros());
    }

    @Test
    void testUpdate() throws Exception {
        repo.insert(new FinanceMinistry(5, "Treasury", "50000"));

        runMenu("3\n5\nState Treasury\n65000\n");

        FinanceMinistry f = repo.findAll().get(0);
        assertEquals("State Treasury", f.getName());
        assertEquals("65000", f.getEuros());
    }

    @Test
    void testDelete() throws Exception {
        repo.insert(new FinanceMinistry(9, "Old Budget", "20000"));

        runMenu("4\n9\n");

        assertTrue(repo.findAll().isEmpty());
    }
}
