package com.bonus71.graphics;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;

public class PieRevenues2025 {

    public static void showChart() {

        // === 1. Dataset ===
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        dataset.setValue("Κοινωνικές εισφορές", 60000000);
        dataset.setValue("Μεταβιβάσεις", 8131000000L);
        dataset.setValue("Πωλήσεις αγαθών και υπηρεσιών", 2405000000L);
        dataset.setValue("Λοιπά τρέχοντα έσοδα", 2775000000L);
        dataset.setValue("Πάγια Περιουσιακά Στοιχεία", 37000000);
        dataset.setValue("Χρεωστικοί τίτλοι", 11000000);
        dataset.setValue("Δάνεια (εισροές)", 20000000);
        dataset.setValue("Συμμετοχικοί τίτλοι & μερίδια", 467000000);
        dataset.setValue("Υποχρεώσεις από νόμισμα και καταθέσεις", 66000000);
        dataset.setValue("Χρεωστικοί τίτλοι (υποχρεώσεις)", 25973000000L);
        dataset.setValue("Δάνεια (υποχρεώσεις)", 1202027000000L);
        dataset.setValue("Χρηματοοικονομικά παράγωγα", 800000000);

        // === 2. Chart ===
        JFreeChart chart = ChartFactory.createPieChart(
                "Έσοδα & Υποχρεώσεις 2025", // Τίτλος
                dataset,
                true, // δείξε legend
                true,
                false
        );

        PiePlot plot = (PiePlot) chart.getPlot();

        // === 3. Labels: ΜΟΝΟ όνομα + αριθμός ===
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} ({1})"));
        plot.setSimpleLabels(false); // κρατάει τις γραμμές καθαρές

        // === 4. Εμφάνιση ===
        plot.setCircular(true);
        plot.setLabelFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 13));
        plot.setInteriorGap(0.02);

        // === 5. Window ===
        JFrame frame = new JFrame("Πίτα Εσόδων & Υποχρεώσεων 2025");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(new ChartPanel(chart));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        showChart();
    }
}



