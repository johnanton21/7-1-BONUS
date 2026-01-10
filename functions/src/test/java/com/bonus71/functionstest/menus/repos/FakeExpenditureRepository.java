package com.bonus71.functionstest.menus.repos;

import com.bonus71.data.entity.financial.Expenditure;
import com.bonus71.data.repository.ExpenditureRepository;
import java.util.ArrayList;
import java.util.List;

/**
 * Fake repository implementation for {@link ExpenditureRepository} used in unit tests.
 *
 * <p>This class provides an in-memory storage for {@link Expenditure} objects,
 * allowing menu and service classes to be tested without requiring a real database.</p>
 *
 * <p>All CRUD operations (findAll, insert, update, delete) are overridden to
 * manipulate a simple {@link List} internally.</p>
 *
 * <p>Usage example:
 * <pre>{@code
 * FakeExpenditureRepository repo = new FakeExpenditureRepository();
 * repo.insert(new Expenditure(1, "Rent", "1000"));
 * List<Expenditure> list = repo.findAll(); // returns the inserted object
 * }</pre>
 *
 * <p>This is intended only for testing purposes and should not be used in production.</p>
 */

public class FakeExpenditureRepository extends ExpenditureRepository {

  private final List<Expenditure> data = new ArrayList<>();

  @Override
    public List<Expenditure> findAll() {
    return data;
  }

  @Override
    public void insert(Expenditure e) {
    data.add(e);
  }

  @Override
    public void update(Expenditure e) {
    delete(e.getCode());
    data.add(e);
  }

  @Override
    public void delete(int code) {
    data.removeIf(x -> x.getCode() == code);
  }
}
