package com.bonus71.functionstest.menus.repos;

import com.bonus71.data.entity.financial.Revenue;
import com.bonus71.data.repository.RevenueRepository;
import java.util.ArrayList;
import java.util.List;

/**
 * Fake repository implementation for {@link RevenueRepository} used in unit tests.
 *
 * <p>This class provides an in-memory storage for {@link Revenue} objects,
 * allowing menu and service classes to be tested without a real database.</p>
 *
 * <p>All CRUD operations (findAll, insert, update, delete) are overridden to
 * manipulate a simple {@link List} internally.</p>
 *
 * <p>Usage example:
 * <pre>{@code
 * FakeRevenueRepository repo = new FakeRevenueRepository();
 * repo.insert(new Revenue(1, "Sales", "1000"));
 * List<Revenue> revenues = repo.findAll(); // returns the inserted object
 * }</pre>
 *
 * <p>This is intended only for testing purposes and should not be used in production.</p>
 */

public class FakeRevenueRepository extends RevenueRepository {

  private final List<Revenue> data = new ArrayList<>();

  @Override
    public List<Revenue> findAll() {
    return data;
  }

  @Override
    public void insert(Revenue r) {
    data.add(r);
  }

  @Override
    public void update(Revenue r) {
    delete(r.getCode());
    data.add(r);
  }

  @Override
    public void delete(int code) {
    data.removeIf(x -> x.getCode() == code);
  }
}

