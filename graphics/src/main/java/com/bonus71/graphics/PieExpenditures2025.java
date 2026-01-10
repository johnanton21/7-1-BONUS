package com.bonus71.graphics;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;


/**
 * Pie chart visualizing the distribution of government expenditures for 2025 by category.
 *
 * <p>
 * Each slice represents a major category of government spending, such as Health, Education,
 * Defense, Welfare, and Infrastructure, with the corresponding percentage of the total budget.
 * The chart is created using JFreeChart and displayed in a Swing JFrame.
 * </p>
 *
 * <p>
 * Features:
 * <ul>
 *   <li>Displays the relative proportion of each spending category as a pie chart.</li>
 *   <li>Labels show the category name and its percentage.</li>
 *   <li>Circular pie chart with small interior gap for aesthetics.</li>
 *   <li>Font styling applied to labels for better readability.</li>
 * </ul>
 * </p>/**
 *  * Pie chart visualizing the distribution of government expenditures for 2025 by category.
 *  *
 *  * <p>
 *  * Each slice represents a major category of government spending, such as Health, Education,
 *  * Defense, Welfare, and Infrastructure, with the corresponding percentage of the total budget.
 *  * The chart is created using JFreeChart and displayed in a Swing JFrame.
 *  * </p>
 *  *
 *  * <p>
 *  * Features:
 *  * <ul>
 *  *   <li>Displays the relative proportion of each spending category as a pie chart.</li>
 *  *   <li>Labels show the category name and its percentage.</li>
 *  *   <li>Circular pie chart with small interior gap for aesthetics.</li>
 *  *   <li>Font styling applied to labels for better readability.</li>
 *  * </ul>
 *  * </p>
 *  *
 *  * <p>
 *  * Note: The data is currently hard-coded for demonstration purposes.
 *  * It can be extended to fetch actual expenditure data from the financial repositories.
 *  * </p>
 *  *
 *  * <p>
 *  * Usage:
 *  * <pre>{@code
 *  * PieExpenditures2025.showChart(); // Opens a JFrame displaying the pie chart
 *  * }</pre>
 *  * </p>
 *  */
public class PieExpenditures2025 {

  public static void showChart() {


    DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
    dataset.setValue("Υγεία", 30);
    dataset.setValue("Παιδεία", 25);
    dataset.setValue("Άμυνα", 20);
    dataset.setValue("Πρόνοια", 15);
    dataset.setValue("Υποδομές", 10);


    JFreeChart chart = ChartFactory.createPieChart(
                "Κρατικές Δαπάνες 2025",
                dataset,
                true,
                true,
                false
    );

    PiePlot plot = (PiePlot) chart.getPlot();


    plot.setLabelGenerator(
                new org.jfree.chart.labels.StandardPieSectionLabelGenerator("{0} ({2})")
    );
    plot.setSimpleLabels(false);


    plot.setCircular(true);
    plot.setLabelFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 13));
    plot.setInteriorGap(0.02);


    JFrame frame = new JFrame("Πίτα Δαπανών 2025");
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
