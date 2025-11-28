package com.bonus71.functions.main.functions;

import com.bonus71.data.entity.financial.Expenditure;
import com.bonus71.data.entity.financial.ExpenditureDetailed;
import com.bonus71.data.entity.financial.Revenue;
import com.bonus71.data.repository.ExpenditureDetailedRepository;
import com.bonus71.data.repository.ExpenditureRepository;
import com.bonus71.data.repository.RevenueRepository;
import java.sql.SQLException;

public class DisplayFunctionA {
    public static void main(String[] args) throws SQLException {

        // === ΕΜΦΑΝΙΣΗ ΕΞΟΔΩΝ ===
        System.out.println("=== ΕΜΦΑΝΙΣΗ ΕΞΟΔΩΝ ===");
        ExpenditureRepository exR = new ExpenditureRepository();
        for (Expenditure ex : exR.findAll())
            System.out.println(
                    ex.getCode() + " | " +
                            ex.getCategory() + " | " +
                            ex.getEuros()
            );

        // === ΕΜΦΑΝΙΣΗ ΕΣΟΔΩΝ ===
        System.out.println("\n=== ΕΜΦΑΝΙΣΗ ΕΣΟΔΩΝ ===");
        RevenueRepository esR = new RevenueRepository();
        for (Revenue es : esR.findAll()) {
            System.out.println(
                    es.getCode() + " | " +
                            es.getCategory() + " | " +
                            es.getEuros()
            );
        }
        // === ΕΜΦΑΝΙΣΗ ΕΞΟΔΩΝ ΑΡΘΡΟΥ 2 ===
        System.out.println("\n=== ΕΞΟΔΑ ΑΡΘΡΟΥ 2 ===");
        ExpenditureDetailedRepository ex2R = new ExpenditureDetailedRepository();
        System.out.println("\n ΚΩΔΙΚΟΣ | ΤΜΗΜΑ | ΤΑΚΤΙΚΟΣ ΠΡΟΥΠΟΛΟΓΙΣΜΟΣ | ΔΗΜΟΣΙΕΣ ΕΠΕΝΔΥΣΕΙΣ | ΣΥΝΟΛΟ");
        for (ExpenditureDetailed ex2 : ex2R.findAll()) {
            System.out.println(
                    ex2.getCode() + " | " +
                            ex2.getDepartment() + " | " +
                            ex2.getRegularBudget() + " | " +
                            ex2.getPublicInvestmentBudget() + " | " +
                            ex2.getTotal()
            );
        }
    }
}

