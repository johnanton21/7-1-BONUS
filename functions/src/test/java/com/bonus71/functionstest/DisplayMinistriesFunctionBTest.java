package com.bonus71.functionstest;

import com.bonus71.data.entity.financial.Expenditure;
import com.bonus71.data.repository.ExpenditureRepository;
import com.bonus71.functions.menus.ExpsensesMenu;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisplayMinistriesFunctionBTest {


    static class FakeRepo extends ExpenditureRepository {
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

    @Test
    void testAddExpenditure() throws SQLException {
        FakeRepo repo = new FakeRepo();

        // Προσομοιώνουμε εισαγωγή χρήστη για επιλογή 2 (Add)
        Scanner scanner = new Scanner("2\n10\nBooks\n25\n");


        ExpsensesMenu.menu(repo);

        // Έλεγχος ότι το νέο expenditure προστέθηκε
        assertEquals(1, repo.list.size());
        assertEquals(10, repo.list.get(0).getCode());
        assertEquals("Books", repo.list.get(0).getCategory());
        assertEquals("25", repo.list.get(0).getEuros());
    }
}
