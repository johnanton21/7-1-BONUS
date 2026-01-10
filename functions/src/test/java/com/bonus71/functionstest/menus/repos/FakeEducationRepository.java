package com.bonus71.functionstest.menus.repos;

import com.bonus71.data.entity.ministry.Education;
import com.bonus71.data.repository.EducationRepository;
import java.util.ArrayList;
import java.util.List;

/**
 * Fake repository implementation for {@link EducationRepository} used in unit tests.
 *
 * <p>This class provides an in-memory storage for {@link Education} objects,
 * allowing menu and service classes to be tested without requiring a real database.</p>
 *
 * <p>All CRUD operations (findAll, insert, update, delete) are overridden to
 * manipulate a simple {@link List} internally.</p>
 *
 * <p>Usage example:
 * <pre>{@code
 * FakeEducationRepository repo = new FakeEducationRepository();
 * repo.insert(new Education(1, "Math", "1000"));
 * List<Education> list = repo.findAll(); // returns the inserted object
 * }</pre>
 *
 * <p>This is intended only for testing purposes and should not be used in production.</p>
 */

public class FakeEducationRepository extends EducationRepository {

  private final List<Education> data = new ArrayList<>();

  @Override
    public List<Education> findAll() {
    return data;
  }

  @Override
    public void insert(Education e) {
    data.add(e);
  }

  @Override
    public void update(Education e) {
    delete(e.getMajorCategory());
    data.add(e);
  }

  @Override
    public void delete(int m) {
    data.removeIf(x -> x.getMajorCategory() == m);
  }
}
