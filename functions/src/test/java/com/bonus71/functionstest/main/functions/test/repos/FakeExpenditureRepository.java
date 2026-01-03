package com.bonus71.functionstest.main.functions.test.repos;

import com.bonus71.data.entity.financial.Expenditure;
import com.bonus71.data.repository.ExpenditureRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FakeExpenditureRepository extends ExpenditureRepository {

    private final List<Expenditure> data = new ArrayList<>();

    @Override
    public List<Expenditure> findAll() throws SQLException {
        return new ArrayList<>(data);
    }

    @Override
    public void insert(Expenditure expenditure) throws SQLException {
        data.add(expenditure);
    }

    @Override
    public void update(Expenditure expenditure) throws SQLException {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getCode() == expenditure.getCode()) {
                data.set(i, expenditure);
                return;
            }
        }
    }

    @Override
    public void delete(int code) throws SQLException {
        data.removeIf(e -> e.getCode() == code);
    }

    // helpers για tests
    public void add(Expenditure expenditure) {
        data.add(expenditure);
    }

    public void clear() {
        data.clear();
    }
}
