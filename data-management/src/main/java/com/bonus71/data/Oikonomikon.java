package com.bonus71.data;
public class Oikonomikon {

    private int meizona;
    private String onomasia;
    private String evro;

    public Oikonomikon(int meizona, String onomasia, String evro) {
        this.meizona = meizona;
        this.onomasia = onomasia;
        this.evro = evro;
    }

    public int getMeizona() {
        return meizona;
    }

    public String getOnomasia() {
        return onomasia;
    }

    public String getEvro() {
        return evro;
    }
}

