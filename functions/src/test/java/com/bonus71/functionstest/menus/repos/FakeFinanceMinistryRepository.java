/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.functionstest.menus.repos;

import com.bonus71.data.entity.ministry.FinanceMinistry;
import com.bonus71.data.repository.FinanceMinistryRepository;

import java.util.ArrayList;
import java.util.List;

public class FakeFinanceMinistryRepository extends FinanceMinistryRepository {

    private final List<FinanceMinistry> data = new ArrayList<>();

    @Override
    public List<FinanceMinistry> findAll() {
        return data;
    }

    @Override
    public void insert(FinanceMinistry e) {
        data.add(e);
    }

    @Override
    public void update(FinanceMinistry e) {
        delete(e.getMajorCategory());
        data.add(e);
    }

    @Override
    public void delete(int m) {
        data.removeIf(x -> x.getMajorCategory() == m);
    }
}
