/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.functionstest.menus.tests;

import com.bonus71.data.entity.financial.Expenditure;
import com.bonus71.data.repository.ExpenditureRepository;
import com.bonus71.functions.menus.ExpensesMenu;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpensesMenuTest {

    static class FakeExpenditureRepo extends ExpenditureRepository {
        List<Expenditure> list = new ArrayList<>();

        @Override
        public List<Expenditure> findAll() {
            return list;
        }

        @Override
        public void insert(Expenditure e) {
            list.add(e);
        }

        @Override
        public void update(Expenditure e) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getCode() == e.getCode()) {
                    list.set(i, e);
                    return;
                }
            }
        }

        @Override
        public void delete(int code) {
            list.removeIf(e -> e.getCode() == code);
        }
    }

    private String runMenu(FakeExpenditureRepo repo, String input) throws SQLException {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        ExpensesMenu.menu(repo);

        return out.toString();
    }

    @Test
    void testView() throws SQLException {
        FakeExpenditureRepo repo = new FakeExpenditureRepo();
        repo.insert(new Expenditure(1, "Salaries", "100000"));
        repo.insert(new Expenditure(2, "Equipment", "50000"));

        String output = runMenu(repo, "1\n");

        assertTrue(output.contains("1 | Salaries | 100000"));
        assertTrue(output.contains("2 | Equipment | 50000"));
    }

    @Test
    void testAdd() throws SQLException {
        FakeExpenditureRepo repo = new FakeExpenditureRepo();

        runMenu(repo, "2\n10\nTravel\n5000\n");

        assertEquals(1, repo.list.size());
        assertEquals(10, repo.list.get(0).getCode());
        assertEquals("Travel", repo.list.get(0).getCategory());
        assertEquals("5000", repo.list.get(0).getEuros());
    }

    @Test
    void testUpdate() throws SQLException {
        FakeExpenditureRepo repo = new FakeExpenditureRepo();
        repo.insert(new Expenditure(5, "Utilities", "8000"));

        runMenu(repo, "3\n5\nUtilities Updated\n9000\n");

        assertEquals("Utilities Updated", repo.list.get(0).getCategory());
        assertEquals("9000", repo.list.get(0).getEuros());
    }

    @Test
    void testDelete() throws SQLException {
        FakeExpenditureRepo repo = new FakeExpenditureRepo();
        repo.insert(new Expenditure(7, "Maintenance", "3000"));

        runMenu(repo, "4\n7\n");

        assertTrue(repo.list.isEmpty());
    }

    @Test
    void testInvalidChoice() throws SQLException {
        FakeExpenditureRepo repo = new FakeExpenditureRepo();

        String output = runMenu(repo, "99\n");

        assertTrue(output.contains("Invalid choice"));
    }
}
