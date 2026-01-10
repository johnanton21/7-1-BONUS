/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.functionstest.menus.repos;

import com.bonus71.data.entity.ministry.FinanceMinistry;
import com.bonus71.data.repository.FinanceMinistryRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Fake repository implementation for {@link FinanceMinistryRepository} used in unit tests.
 *
 * <p>This class provides an in-memory storage for {@link FinanceMinistry} objects,
 * allowing menu and service classes to be tested without requiring a real database.</p>
 *
 * <p>All CRUD operations (findAll, insert, update, delete) are overridden to
 * manipulate a simple {@link List} internally.</p>
 *
 * <p>Usage example:
 * <pre>{@code
 * FakeFinanceMinistryRepository repo = new FakeFinanceMinistryRepository();
 * repo.insert(new FinanceMinistry(1, "Budget", "5000"));
 * List<FinanceMinistry> list = repo.findAll(); // returns the inserted object
 * }</pre>
 *
 * <p>This is intended only for testing purposes and should not be used in production.</p>
 */

public class FakeFinanceMinistryRepository extends FinanceMinistryRepository {

    private final List<FinanceMinistry> data = new ArrayList<>();

    @Override
    public List<FinanceMinistry> findAll() {
        return data;
    }

    @Override
    public void insert(FinanceMinistry e) {
        data.add(e);
    }

    @Override
    public void update(FinanceMinistry e) {
        delete(e.getMajorCategory());
        data.add(e);
    }

    @Override
    public void delete(int m) {
        data.removeIf(x -> x.getMajorCategory() == m);
    }
}
