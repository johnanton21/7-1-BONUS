/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.functionstest.menus.repos;

import com.bonus71.data.entity.ministry.NationalDefense;
import com.bonus71.data.repository.NationalDefenseRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Fake repository implementation for {@link NationalDefenseRepository} used in unit tests.
 *
 * <p>This class provides an in-memory storage for {@link NationalDefense} objects,
 * allowing menu and service classes to be tested without a real database.</p>
 *
 * <p>All CRUD operations (findAll, insert, update, delete) are overridden to
 * manipulate a simple {@link List} internally.</p>
 *
 * <p>Usage example:
 * <pre>{@code
 * FakeNationalDefenseRepository repo = new FakeNationalDefenseRepository();
 * repo.insert(new NationalDefense(1, "Army", "500"));
 * List<NationalDefense> list = repo.findAll(); // returns the inserted object
 * }</pre>
 *
 * <p>This is intended only for testing purposes and should not be used in production.</p>
 */

public class FakeNationalDefenseRepository extends NationalDefenseRepository {

    private final List<NationalDefense> data = new ArrayList<>();

    @Override
    public List<NationalDefense> findAll() {
        return data;
    }

    @Override
    public void insert(NationalDefense e) {
        data.add(e);
    }

    @Override
    public void update(NationalDefense e) {
        delete(e.getMajorCategory());
        data.add(e);
    }

    @Override
    public void delete(int m) {
        data.removeIf(x -> x.getMajorCategory() == m);
    }
}
