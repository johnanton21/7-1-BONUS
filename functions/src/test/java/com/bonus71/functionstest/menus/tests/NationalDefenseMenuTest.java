/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.functionstest.menus.tests;

import com.bonus71.data.entity.ministry.NationalDefense;
import com.bonus71.functions.menus.NationalDefenseMenu;
import com.bonus71.functionstest.menus.repos.FakeNationalDefenseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link NationalDefenseMenu}.
 *
 * <p>Tests all menu options: view, add, update, delete using a fake in-memory repository.</p>
 */

class NationalDefenseMenuTest {

    private FakeNationalDefenseRepository repo;

    @BeforeEach
    void setup() {
        repo = new FakeNationalDefenseRepository();
    }

    private String runMenu(String input) throws Exception {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Scanner testScanner = new Scanner(System.in);
        NationalDefenseMenu.menu(repo);

        return out.toString();
    }

    @Test
    void testView() throws Exception {
        repo.insert(new NationalDefense(1, "Army", "250000"));
        repo.insert(new NationalDefense(2, "Navy", "180000"));

        String output = runMenu("1\n");

        assertTrue(output.contains("1 | Army | 250000"));
        assertTrue(output.contains("2 | Navy | 180000"));
    }

    @Test
    void testAdd() throws Exception {
        runMenu("2\n3\nAir Force\n200000\n");

        assertEquals(1, repo.findAll().size());
        NationalDefense nd = repo.findAll().get(0);

        assertEquals(3, nd.getMajorCategory());
        assertEquals("Air Force", nd.getName());
        assertEquals("200000", nd.getEuros());
    }

    @Test
    void testUpdate() throws Exception {
        repo.insert(new NationalDefense(5, "Coast Guard", "60000"));

        runMenu("3\n5\nMaritime Defense\n75000\n");

        NationalDefense nd = repo.findAll().get(0);
        assertEquals("Maritime Defense", nd.getName());
        assertEquals("75000", nd.getEuros());
    }

    @Test
    void testDelete() throws Exception {
        repo.insert(new NationalDefense(9, "Old Equipment", "10000"));

        runMenu("4\n9\n");

        assertTrue(repo.findAll().isEmpty());
    }
}
