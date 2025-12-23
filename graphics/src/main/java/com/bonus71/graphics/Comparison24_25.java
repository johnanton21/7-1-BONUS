package com.bonus71.graphics;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;


public class Comparison24_25 {

  public static void showChart() {

    DefaultCategoryDataset dataset = new DefaultCategoryDataset();


    dataset.addValue(60_957_000_000L, "2025", "Net Revenues");
    dataset.addValue(74_041_000_000L, "2024", "Net Revenues");


    dataset.addValue(57_871_000_000L, "2025", "Expenses");
    dataset.addValue(73_741_000_000L, "2024", "Expenses");


    dataset.addValue(3_086_000_000L, "2025", "Balance");
    dataset.addValue(300_000_000L, "2024", "Balance");


    JFreeChart chart = ChartFactory.createBarChart(
                "Comparison 2025 vs 2024",
                "Category",
                "Amount (€)",
                dataset
    );


    JFrame frame = new JFrame("Bar Chart 2025 vs 2024");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.add(new ChartPanel(chart));
    frame.pack();
    frame.setVisible(true);
  }

  static void main(String[] args) {
    showChart();
  }
}
