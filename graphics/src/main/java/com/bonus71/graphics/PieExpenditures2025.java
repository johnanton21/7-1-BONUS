package com.bonus71.graphics;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;



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
