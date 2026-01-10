/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.data.entity.ministry;
/**
 * Represents a financial data entity associated with the health sector.
 * <p>
 * This class models budgetary information related to health services,
 * organizations, or programs. Each instance corresponds to a specific
 * entry classified under a major financial category and includes a
 * descriptive name along with the allocated or recorded amount in euros.
 * </p>
 *
 * <p>
 * The class is primarily used for data transfer, persistence, and reporting
 * purposes within the application's financial and statistical modules.
 * </p>
 */
public class Health {

  private int majorCategory;
  private String name;
  private String euros;

    /**
     * Constructs a {@code Health} object with the specified financial data.
     *
     * @param majorCategory the major financial category identifier
     * @param name          the name of the health-related entity or expense
     * @param euros         the amount expressed in euros
     */
  public Health(int majorCategory, String name, String euros) {
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

    /**
     * Returns the monetary amount of this record expressed in euros.
     *
     * @return the amount in euros
     */
  public String getEuros() {
    return euros;
  }

    /**
     * Sets the monetary amount of this record expressed in euros.
     *
     * @param euros the amount in euros to set
     */
  public void setEuros(String euros) {
    this.euros = euros;
  }
}
