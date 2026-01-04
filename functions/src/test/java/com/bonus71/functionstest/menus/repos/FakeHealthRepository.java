package com.bonus71.functionstest.menus.repos;

import com.bonus71.data.entity.ministry.Health;
import com.bonus71.data.repository.HealthRepository;

import java.util.ArrayList;
import java.util.List;

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
