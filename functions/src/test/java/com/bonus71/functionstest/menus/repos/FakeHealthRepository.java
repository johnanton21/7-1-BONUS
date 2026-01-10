/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.functionstest.menus.repos;

import com.bonus71.data.entity.ministry.Health;
import com.bonus71.data.repository.HealthRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Fake repository implementation for {@link HealthRepository} used in unit tests.
 *
 * <p>This class provides an in-memory storage for {@link Health} objects,
 * allowing menu and service classes to be tested without requiring a real database.</p>
 *
 * <p>All CRUD operations (findAll, insert, update, delete) are overridden to
 * manipulate a simple {@link List} internally.</p>
 *
 * <p>Usage example:
 * <pre>{@code
 * FakeHealthRepository repo = new FakeHealthRepository();
 * repo.insert(new Health(1, "Hospitals", "1000"));
 * List<Health> list = repo.findAll(); // returns the inserted object
 * }</pre>
 *
 * <p>This is intended only for testing purposes and should not be used in production.</p>
 */

public class FakeHealthRepository extends HealthRepository {

    private final List<Health> data = new ArrayList<>();

    @Override
    public List<Health> findAll() {
        return data;
    }

    @Override
    public void insert(Health e) {
        data.add(e);
    }

    @Override
    public void update(Health e) {
        delete(e.getMajorCategory());
        data.add(e);
    }

    @Override
    public void delete(int m) {
        data.removeIf(x -> x.getMajorCategory() == m);
    }
}
