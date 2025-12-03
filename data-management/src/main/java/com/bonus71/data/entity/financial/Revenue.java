package com.bonus71.data.entity.financial;

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
