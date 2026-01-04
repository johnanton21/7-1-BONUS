package com.bonus71.functionstest.menus.tests;

import com.bonus71.data.entity.ministry.Health;
import com.bonus71.functions.menus.MinistryOfHealthMenu;
import com.bonus71.functionstest.menus.repos.FakeHealthRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MinistryOfHealthMenuTest {

    private FakeHealthRepository repo;

    @BeforeEach
    void setup() {
        repo = new FakeHealthRepository();
    }

    private String runMenu(String input) throws Exception {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Scanner testScanner = new Scanner(System.in);
        MinistryOfHealthMenu.menu(repo);

        return out.toString();
    }

    @Test
    void testView() throws Exception {
        repo.insert(new Health(1, "Hospitals", "120000"));
        repo.insert(new Health(2, "Primary Care", "45000"));

        String output = runMenu("1\n");

        assertTrue(output.contains("1 | Hospitals | 120000"));
        assertTrue(output.contains("2 | Primary Care | 45000"));
    }

    @Test
    void testAdd() throws Exception {
        runMenu("2\n3\nMental Health\n35000\n");

        assertEquals(1, repo.findAll().size());
        Health h = repo.findAll().get(0);

        assertEquals(3, h.getMajorCategory());
        assertEquals("Mental Health", h.getName());
        assertEquals("35000", h.getEuros());
    }

    @Test
    void testUpdate() throws Exception {
        repo.insert(new Health(5, "Emergency Services", "25000"));

        runMenu("3\n5\nEmergency Care\n40000\n");

        Health h = repo.findAll().get(0);
        assertEquals("Emergency Care", h.getName());
        assertEquals("40000", h.getEuros());
    }

    @Test
    void testDelete() throws Exception {
        repo.insert(new Health(9, "Old Program", "5000"));

        runMenu("4\n9\n");

        assertTrue(repo.findAll().isEmpty());
    }
}
