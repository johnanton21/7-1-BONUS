/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.data.entity.financial;
/**
 * Represents a financial expenditure record.
 *
 * <p>This class models an expenditure entry, identified by a unique
 * code and categorized by its financial purpose. It also stores the
 * corresponding monetary amount expressed in euros.</p>
 *
 * <p>Instances of this class are used to store and transfer expenditure
 * data between the repository, service, and presentation layers of the
 * application.</p>
 */

public class Expenditure {
    /** Unique identifier code of the expenditure. */
    private int code;
    /** Category describing the type of expenditure. */
    private String category;
    /** Monetary amount of the expenditure in euros. */
    private String euros;

  /**
     * Constructs an {@code Expenditure} object with the specified attributes.
     *
     * @param code the unique identifier code of the expenditure
     * @param category the category describing the type of expenditure
     * @param euros the monetary amount of the expenditure in euros
     */

  public Expenditure(int code, String category, String euros) {
    this.code = code;
    this.category = category;
    this.euros = euros;
  }

    /**
     * Returns the expenditure code.
     *
     * @return the expenditure code
     */

    public int getCode() {
    return code;
  }

    /**
     * Sets the expenditure code.
     *
     * @param code the expenditure code to set
     */

    public void setCode(int code) {
    this.code = code;
  }
    /**
     * Returns the category of the expenditure.
     *
     * @return category as a string
     */
  public String getCategory() {
    return category;
  }
    /**
     * Sets the category of the expenditure.
     *
     * @param category the category to set
     */
  public void setCategory(String category) {
    this.category = category;
  }
    /**
     * Returns the monetary amount in euros.
     *
     * @return euros as a string
     */
  public String getEuros() {
    return euros;
  }
    /**
     * Sets the monetary amount in euros.
     *
     * @param euros the amount to set
     */
  public void setEuros(String euros) {
    this.euros = euros;
  }
}
