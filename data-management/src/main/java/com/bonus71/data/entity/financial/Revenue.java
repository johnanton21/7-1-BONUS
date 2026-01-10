/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.data.entity.financial;

/**
 * Represents a financial revenue record.
 *
 * <p>This class models a revenue entry, identified by a unique code and
 * categorized according to its source. It stores the corresponding
 * monetary amount expressed in euros.</p>
 *
 * <p>Instances of this class are used to represent government or
 * organizational income data and are utilized by repository and service
 * layers for financial analysis, reporting, and comparison.</p>
 */

public class Revenue {

  private int code;
  private String category;
  private String euros;

  public Revenue(int code, String category, String euros) {
    this.code = code;
    this.category = category;
    this.euros = euros;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getEuros() {
    return euros;
  }

  public void setEuros(String euros) {
    this.euros = euros;
  }
}
