package com.bonus71.functionstest.menus.repos;

import com.bonus71.data.entity.financial.Expenditure;
import com.bonus71.data.repository.ExpenditureRepository;

import java.util.ArrayList;
import java.util.List;

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
