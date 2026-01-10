/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.graphics;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;


/**
 * Pie chart visualizing government revenues and obligations for 2025.
 *
 * <p>
 * Each slice represents a major revenue source or obligation of the state, including:
 * social contributions, transfers, sales of goods and services, loans, financial instruments,
 * and other types of income or obligations. The chart helps illustrate the proportion of each
 * category in the overall financial picture for 2025.
 * </p>
 *
 * <p>
 * Features:
 * <ul>
 *   <li>Displays the relative proportion of each revenue/obligation category as a pie chart.</li>
 *   <li>Labels show both the category name and the corresponding absolute amount.</li>
 *   <li>Circular pie chart with a small interior gap for aesthetics.</li>
 *   <li>Labels use bold SansSerif font for readability.</li>
 *   <li>Lines are kept clean by disabling simple labels (using label generator with lines).</li>
 * </ul>
 * </p>
 *
 * <p>
 * Note: The data is currently hard-coded for demonstration purposes and can be
 * extended to fetch actual data from financial repositories or databases.
 * </p>
 *
 * <p>
 * Usage:
 * <pre>{@code
 * PieRevenues2025.showChart(); // Opens a JFrame displaying the pie chart
 * }</pre>
 * </p>
 */
public class PieRevenues2025 {
    /**
     * Creates and displays the pie chart of government revenues and obligations for 2025.
     */

  public static void showChart() {

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


    JFreeChart chart = ChartFactory.createPieChart(
                "Έσοδα & Υποχρεώσεις 2025",
                dataset,
                true,
                true,
                false
    );

    PiePlot plot = (PiePlot) chart.getPlot();


    plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} ({1})"));
    plot.setSimpleLabels(false); // κρατάει τις γραμμές καθαρές


    plot.setCircular(true);
    plot.setLabelFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 13));
    plot.setInteriorGap(0.02);


    JFrame frame = new JFrame("Πίτα Εσόδων & Υποχρεώσεων 2025");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setContentPane(new ChartPanel(chart));
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  static void main(String[] args) {
    showChart();
  }
}
