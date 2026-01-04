package com.bonus71.graphics;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class Comparison23_25 extends JFrame {

  public Comparison23_25() {

    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    dataset.addValue(60957000000L, "Net Revenues", "2025");
    dataset.addValue(66776000000L, "Net Revenues", "2023");

    dataset.addValue(57871000000L, "Expenses", "2025");
    dataset.addValue(70765000000L, "Expenses", "2023");

    dataset.addValue(3086000000L, "Balance", "2025");
    dataset.addValue(-3989000000L, "Balance", "2023");


    JFreeChart barChart = ChartFactory.createBarChart(
                "Comparison 2025 vs 2023",
                "Category",
                "Amount (in €)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

    ChartPanel chartPanel = new ChartPanel(barChart);
    chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
    setContentPane(chartPanel);
  }


  public static void showChart() {
    Comparison23_25 chart = new Comparison23_25();
    chart.setSize(800, 600);
    chart.setLocationRelativeTo(null);
    chart.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    chart.setVisible(true);
  }

  public static void main(String[] args) {
    showChart();
  }
}
