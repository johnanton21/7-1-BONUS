package com.bonus71.functionstest.main.functions.test.repos;

import com.bonus71.data.entity.financial.Revenue;
import com.bonus71.data.repository.RevenueRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FakeRevenueRepository extends RevenueRepository {

    private final List<Revenue> data = new ArrayList<>();

    @Override
    public List<Revenue> findAll() {
        return data;
    }

    @Override
    public void insert(Revenue revenue) throws SQLException {
        data.add(revenue);
    }

    @Override
    public void update(Revenue revenue) throws SQLException {
        delete(revenue.getCode());
        data.add(revenue);
    }

    @Override
    public void delete(int code) throws SQLException {
        data.removeIf(r -> r.getCode() == code);
    }

    public void add(Revenue revenue) {
        data.add(revenue);
    }

    public void clear() {
        data.clear();
    }
}
