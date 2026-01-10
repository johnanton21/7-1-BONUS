/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.functionstest.menus.repos;

import com.bonus71.data.entity.ministry.NationalDefense;
import com.bonus71.data.repository.NationalDefenseRepository;

import java.util.ArrayList;
import java.util.List;

public class FakeNationalDefenseRepository extends NationalDefenseRepository {

    private final List<NationalDefense> data = new ArrayList<>();

    @Override
    public List<NationalDefense> findAll() {
        return data;
    }

    @Override
    public void insert(NationalDefense e) {
        data.add(e);
    }

    @Override
    public void update(NationalDefense e) {
        delete(e.getMajorCategory());
        data.add(e);
    }

    @Override
    public void delete(int m) {
        data.removeIf(x -> x.getMajorCategory() == m);
    }
}
