package com.bonus71.data.entity.ministry;
/**
 * Represents a financial record associated with a ministry entry.
 * <p>
 * This entity encapsulates budget-related information grouped by a major
 * financial category, including the ministry name and the corresponding
 * amount expressed in euros.
 * </p>
 *
 * <p>
 * It is primarily used as a data transfer and persistence object within
 * the finance and reporting modules of the application.
 * </p>
 */

public class FinanceMinistry {

  private int majorCategory;
  private String name;
  private String euros;

    /**
     * Constructs a {@code FinanceMinistry} object with the specified financial data.
     * <p>
     * Each instance represents a financial record associated with a ministry,
     * classified under a major financial category and including a descriptive
     * name along with the corresponding monetary amount expressed in euros.
     * </p>
     *
     * @param majorCategory the major financial category identifier under which
     *                      this ministry record is classified
     * @param name          the name of the ministry or financial entity
     * @param euros         the monetary amount associated with this record,
     *                      expressed in euros
     */
  public FinanceMinistry(int majorCategory, String name, String euros) {
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
