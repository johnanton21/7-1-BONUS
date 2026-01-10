/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.functionstest.menus.tests;

import com.bonus71.data.entity.ministry.Education;
import com.bonus71.functions.menus.MinistryOfEducationMenu;
import com.bonus71.functionstest.menus.repos.FakeEducationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MinistryOfEducationMenuTest {

    private FakeEducationRepository repo;

    @BeforeEach
    void setup() {
        repo = new FakeEducationRepository();
    }

    private String runMenu(String input) throws Exception {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Scanner testScanner = new Scanner(System.in);
        MinistryOfEducationMenu.menu(repo);

        return out.toString();
    }

    @Test
    void testView() throws Exception {
        repo.insert(new Education(1, "Schools", "15000"));
        repo.insert(new Education(2, "Universities", "90000"));

        String output = runMenu("1\n");

        assertTrue(output.contains("1 | Schools | 15000"));
        assertTrue(output.contains("2 | Universities | 90000"));
    }

    @Test
    void testAdd() throws Exception {
        runMenu("2\n3\nSpecial Education\n12000\n");

        assertEquals(1, repo.findAll().size());
        Education e = repo.findAll().get(0);

        assertEquals(3, e.getMajorCategory());
        assertEquals("Special Education", e.getName());
        assertEquals("12000", e.getEuros());
    }

    @Test
    void testUpdate() throws Exception {
        repo.insert(new Education(5, "Libraries", "3000"));

        runMenu("3\n5\nDigital Libraries\n9999\n");

        Education e = repo.findAll().get(0);
        assertEquals("Digital Libraries", e.getName());
        assertEquals("9999", e.getEuros());
    }

    @Test
    void testDelete() throws Exception {
        repo.insert(new Education(9, "Adult Education", "500"));

        runMenu("4\n9\n");

        assertTrue(repo.findAll().isEmpty());
    }
}
