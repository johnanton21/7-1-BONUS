package com.bonus71.data.entity.ministry;
/**
 * Represents a financial data entity related to national defense.
 * <p>
 * This class models budgetary information associated with defense services,
 * military organizations, or defense-related programs. Each record is
 * classified under a major financial category and includes a descriptive
 * name along with the corresponding monetary amount expressed in euros.
 * </p>
 *
 * <p>
 * The class is intended for use in data transfer, persistence, and reporting
 * processes within the application's financial and statistical modules.
 * </p>
 */
public class NationalDefense {

  private int majorCategory;
  private String name;
  private String euros;
    /**
     * Constructs a {@code NationalDefense} object with the specified financial data.
     * <p>
     * Each instance represents a defense-related financial record classified
     * under a major category and includes a descriptive name along with the
     * corresponding amount expressed in euros.
     * </p>
     *
     * @param majorCategory the major financial category identifier under which
     *                      this record is classified
     * @param name          the name of the defense entity or expenditure
     * @param euros         the monetary amount expressed in euros
     */
  public NationalDefense(int majorCategory, String name, String euros) {
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
