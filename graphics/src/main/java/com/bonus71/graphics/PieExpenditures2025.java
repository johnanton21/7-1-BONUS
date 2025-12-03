package com.bonus71.graphics;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;

public class PieExpenditures2025 {

            public static void showChart() {

// === 1. Dataset ===
            DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
            dataset.setValue("Υγεία", 30);
            dataset.setValue("Παιδεία", 25);
            dataset.setValue("Άμυνα", 20);
            dataset.setValue("Πρόνοια", 15);
            dataset.setValue("Υποδομές", 10);

// === 2. Chart ===
            JFreeChart chart = ChartFactory.createPieChart(
                    "Κρατικές Δαπάνες 2025", // Τίτλος
                    dataset,
                    true, // δείξε legend
                    true,
                    false
            );

            PiePlot plot = (PiePlot) chart.getPlot();

// === 3. Labels ===
            plot.setLabelGenerator(
                    new org.jfree.chart.labels.StandardPieSectionLabelGenerator("{0} ({2})")
            );
            plot.setSimpleLabels(false); // κρατάει τις γραμμές καθαρές

// === 4. Εμφάνιση ===
            plot.setCircular(true);
            plot.setLabelFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 13));
            plot.setInteriorGap(0.02);

// === 5. Window ===
            JFrame frame = new JFrame("Πίτα Δαπανών 2025");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setContentPane(new ChartPanel(chart));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }





