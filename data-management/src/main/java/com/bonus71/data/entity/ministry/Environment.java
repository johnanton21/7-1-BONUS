package com.bonus71.data.entity.ministry;

/**
 * Represents financial data related to the environmental sector.
 *
 * <p>This class models budgetary or expenditure information associated
 * with environmental policy and initiatives. It includes categorized
 * financial data and the corresponding monetary amount expressed in euros.</p>
 *
 * <p>Instances of this class are used for analysis and presentation of
 * environmental funding and expenditures within the application.</p>
 */


public class Environment {

  private int majorCategory;
  private String name;
  private String euros;

    /**
     * Constructs an {@code Environment} object with the specified attributes.
     *
     * @param majorCategory the major classification category of the
     *                      environment-related financial entry
     * @param name the descriptive name of the environmental category
     * @param euros the monetary amount associated with the category in euros
     */

  public Environment(int majorCategory, String name, String euros) {
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
