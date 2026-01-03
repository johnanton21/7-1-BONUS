package com.bonus71.functionstest.main.functions.test.repos;

import com.bonus71.data.entity.ministry.Education;
import com.bonus71.data.repository.EducationRepository;
import java.util.ArrayList;
import java.util.List;

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
