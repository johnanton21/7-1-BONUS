package com.bonus71.data;

public class DisplayMain {
    public static void main(String[] args) {

        // === ΕΜΦΑΝΙΣΗ ΕΞΟΔΩΝ ===
        System.out.println("=== ΕΜΦΑΝΙΣΗ ΕΞΟΔΩΝ ===");
        ExodaRepository exR = new ExodaRepository();
        for (Exodo ex : exR.findAll()) {
            System.out.println(
                    ex.getKodikos() + " | " +
                            ex.getKatigoria() + " | " +
                            ex.getEvro()
            );
        }

        // === ΕΜΦΑΝΙΣΗ ΕΣΟΔΩΝ ===
        System.out.println("\n=== ΕΜΦΑΝΙΣΗ ΕΣΟΔΩΝ ===");
        EsodaRepository esR = new EsodaRepository();
        for (Esoda es : esR.findAll()) {
            System.out.println(
                    es.getKodikos() + " | " +
                            es.getKatigoria() + " | " +
                            es.getEvro()
            );
        }
        // === ΕΜΦΑΝΙΣΗ ΕΞΟΔΩΝ ΑΡΘΡΟΥ 2 ===
        System.out.println("\n=== ΕΞΟΔΑ ΑΡΘΡΟΥ 2 ===");
        Exoda2Repository ex2R = new Exoda2Repository();
        System.out.println("\n ΚΩΔΙΚΟΣ | ΤΜΗΜΑ | ΤΑΚΤΙΚΟΣ ΠΡΟΥΠΟΛΟΓΙΣΜΟΣ | ΔΗΜΟΣΙΕΣ ΕΠΕΝΔΥΣΕΙΣ | ΣΥΝΟΛΟ");
        for (Exoda2 ex2 : ex2R.findAll()) {
            System.out.println(
                    ex2.getKodikos() + " | " +
                            ex2.getTmima() + " | " +
                            ex2.getTaktikosProypologismos() + " | " +
                            ex2.getProypologismosDimosionEpendyseon() + " | " +
                            ex2.getSynolo()
            );
        }
    }
}

