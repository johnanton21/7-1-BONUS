package com.bonus71.data;
public class Exoda2 {

    private int kodikos;
    private String tmima;
    private String taktikosProypologismos;
    private String proypologismosDimosionEpendyseon;
    private String synolo;

    public Exoda2(int kodikos,
                         String tmima,
                         String taktikosProypologismos,
                         String proypologismosDimosionEpendyseon,
                         String synolo) {
        this.kodikos = kodikos;
        this.tmima = tmima;
        this.taktikosProypologismos = taktikosProypologismos;
        this.proypologismosDimosionEpendyseon = proypologismosDimosionEpendyseon;
        this.synolo = synolo;
    }

    public int getKodikos() {
        return kodikos;
    }

    public String getTmima() {
        return tmima;
    }

    public String getTaktikosProypologismos() {
        return taktikosProypologismos;
    }

    public String getProypologismosDimosionEpendyseon() {
        return proypologismosDimosionEpendyseon;
    }

    public String getSynolo() {
        return synolo;
    }
}

