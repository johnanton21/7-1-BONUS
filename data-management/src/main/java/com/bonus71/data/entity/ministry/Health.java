package com.bonus71.data.entity.ministry;

public class Health {

  private int majorCategory;
  private String name;
  private String euros;

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

  public String getEuros() {
    return euros;
  }

  public void setEuros(String euros) {
    this.euros = euros;
  }
}
