/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.functionstest.menus.repos;

import com.bonus71.data.entity.financial.Revenue;
import com.bonus71.data.repository.RevenueRepository;
import java.util.ArrayList;
import java.util.List;

public class FakeRevenueRepository extends RevenueRepository {

  private final List<Revenue> data = new ArrayList<>();

  @Override
    public List<Revenue> findAll() {
    return data;
  }

  @Override
    public void insert(Revenue r) {
    data.add(r);
  }

  @Override
    public void update(Revenue r) {
    delete(r.getCode());
    data.add(r);
  }

  @Override
    public void delete(int code) {
    data.removeIf(x -> x.getCode() == code);
  }
}

