/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.data.entity.ministry;
/**
 * Represents financial data related to the education sector.
 *
 * <p>This class models budgetary information associated with education,
 * including categorized expenditure or allocation data and the
 * corresponding monetary amount expressed in euros.</p>
 *
 * <p>Instances of this class are used to analyze and present financial
 * figures related to education policy and funding.</p>
 */

public class Education {

  private int majorCategory;
  private String name;
  private String euros;

  /**
     * Constructs an {@code Education} object with the specified attributes.
     *
     * @param majorCategory the major classification category of the
     *                      education-related financial entry
     * @param name the descriptive name of the education category
     * @param euros the monetary amount associated with the category in euros
     */

  public Education(int majorCategory, String name, String euros) {
    this.majorCategory = majorCategory;
    this.name = name;
    this.euros = euros;
  }

  public int getMajorCategory() {
    return majorCategory;
  }

  public void setMajorCategory(int majorCategory) {
    this.majorCategory = majorCategory;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEuros() {
    return euros;
  }

  public void setEuros(String euros) {
    this.euros = euros;
  }
}
