package com.bonus71.functionstest.menus.repos;

import com.bonus71.data.entity.ministry.Environment;
import com.bonus71.data.repository.EnvironmentRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Fake repository implementation for {@link EnvironmentRepository} used in unit tests.
 *
 * <p>This class provides an in-memory storage for {@link Environment} objects,
 * allowing menu and service classes to be tested without requiring a real database.</p>
 *
 * <p>All CRUD operations (findAll, insert, update, delete) are overridden to
 * manipulate a simple {@link List} internally.</p>
 *
 * <p>Usage example:
 * <pre>{@code
 * FakeEnvironmentRepository repo = new FakeEnvironmentRepository();
 * repo.insert(new Environment(1, "Forest Protection", "5000"));
 * List<Environment> list = repo.findAll(); // returns the inserted object
 * }</pre>
 *
 * <p>This is intended only for testing purposes and should not be used in production.</p>
 */

public class FakeEnvironmentRepository extends EnvironmentRepository {

    private final List<Environment> data = new ArrayList<>();

    @Override
    public List<Environment> findAll() {
        return data;
    }

    @Override
    public void insert(Environment e) {
        data.add(e);
    }

    @Override
    public void update(Environment e) {
        delete(e.getMajorCategory());
        data.add(e);
    }

    @Override
    public void delete(int m) {
        data.removeIf(x -> x.getMajorCategory() == m);
    }
}
