package com.bonus71.functionstest.menus.repos;

import com.bonus71.data.entity.ministry.Environment;
import com.bonus71.data.repository.EnvironmentRepository;

import java.util.ArrayList;
import java.util.List;

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
