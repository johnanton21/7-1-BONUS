package com.bonus71.functionstest.menus.tests;

import com.bonus71.data.entity.ministry.Environment;
import com.bonus71.functions.menus.MinistryOfTheEnvironmentMenu;
import com.bonus71.functionstest.menus.repos.FakeEnvironmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MinistryOfTheEnvironmentMenuTest {

    private FakeEnvironmentRepository repo;

    @BeforeEach
    void setup() {
        repo = new FakeEnvironmentRepository();
    }

    private String runMenu(String input) throws Exception {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Scanner testScanner = new Scanner(System.in);
        MinistryOfTheEnvironmentMenu.menu(repo);

        return out.toString();
    }

    @Test
    void testView() throws Exception {
        repo.insert(new Environment(1, "Climate Change", "50000"));
        repo.insert(new Environment(2, "Recycling", "25000"));

        String output = runMenu("1\n");

        assertTrue(output.contains("1 | Climate Change | 50000"));
        assertTrue(output.contains("2 | Recycling | 25000"));
    }

    @Test
    void testAdd() throws Exception {
        runMenu("2\n3\nWildlife Protection\n30000\n");

        assertEquals(1, repo.findAll().size());
        Environment e = repo.findAll().get(0);

        assertEquals(3, e.getMajorCategory());
        assertEquals("Wildlife Protection", e.getName());
        assertEquals("30000", e.getEuros());
    }

    @Test
    void testUpdate() throws Exception {
        repo.insert(new Environment(5, "Pollution Control", "15000"));

        runMenu("3\n5\nAir Quality\n20000\n");

        Environment e = repo.findAll().get(0);
        assertEquals("Air Quality", e.getName());
        assertEquals("20000", e.getEuros());
    }

    @Test
    void testDelete() throws Exception {
        repo.insert(new Environment(9, "Waste Management", "10000"));

        runMenu("4\n9\n");

        assertTrue(repo.findAll().isEmpty());
    }
}
