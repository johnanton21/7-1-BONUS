package com.bonus71.graphics;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;

public class PerMinistryPie2025 {

            public static void showChart() {

            // === 1. Dataset με πραγματικά ποσά ===
            DefaultPieDataset<String> dataset = new DefaultPieDataset<>();

            dataset.setValue("Βουλή των Ελλήνων", 171_950_000L);
            dataset.setValue("Προεδρία της Κυβέρνησης", 41_689_000L);
            dataset.setValue("Υπουργείο Εσωτερικών", 3_830_276_000L);
            dataset.setValue("Υπουργείο Εξωτερικών", 420_237_000L);
            dataset.setValue("Υπουργείο Εθνικής Άμυνας", 6_130_000_000L);
            dataset.setValue("Υπουργείο Υγείας", 7_177_424_000L);
            dataset.setValue("Υπουργείο Δικαιοσύνης", 650_803_000L);
            dataset.setValue("Υπουργείο Παιδείας, Θρησκευμάτων και Αθλητισμού", 1_012_000_000L);
            dataset.setValue("Υπουργείο Πολιτισμού", 575_419_000L);
            dataset.setValue("Υπουργείο Εθνικής Οικονομίας και Οικονομικών", 1_246_518_464_000L);
            dataset.setValue("Υπουργείο Αγροτικής Ανάπτυξης και Τροφίμων", 1_281_403_000L);
            dataset.setValue("Υπουργείο Περιβάλλοντος και Ενέργειας", 2_341_227_000L);
            dataset.setValue("Υπουργείο Εργασίας και Κοινωνικής Ασφάλισης", 18_678_084_000L);
            dataset.setValue("Υπουργείο Κοινωνικής Συνοχής και Οικογένειας", 3_989_553_000L);
            dataset.setValue("Υπουργείο Ανάπτυξης", 818_045_000L);
            dataset.setValue("Υπουργείο Υποδομών και Μεταφορών", 2_694_810_000L);
            dataset.setValue("Υπουργείο Ναυτιλίας και Νησιωτικής Πολιτικής", 651_864_000L);
            dataset.setValue("Υπουργείο Τουρισμού", 189_293_000L);
            dataset.setValue("Υπουργείο Ψηφιακής Διακυβέρνησης", 1_073_928_000L);
            dataset.setValue("Υπουργείο Μετανάστευσης και Ασύλου", 475_871_000L);
            dataset.setValue("Υπουργείο Προστασίας του Πολίτη", 2_285_820_000L);
            dataset.setValue("Υπουργείο Κλιματικής Κρίσης και Πολιτικής Προστασίας", 1_221_116_000L);
            dataset.setValue("Αποκεντρωμένες Διοικήσεις", 79_592_000L);

            // === 2. Chart ===
            JFreeChart chart = ChartFactory.createPieChart(
                    "Λεπτομερή Έξοδα 2025 (σε €)",
                    dataset,
                    true,  // Legend
                    true,
                    false
            );

            // === 3. Labels: όνομα + ποσό ===
            PiePlot plot = (PiePlot) chart.getPlot();
            plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {1} €"));
            plot.setSimpleLabels(false);
            plot.setCircular(true);
            plot.setLabelFont(new Font("SansSerif", Font.BOLD, 12));
            plot.setInteriorGap(0.04);

            // === 4. Window ===
            JFrame frame = new JFrame("Πίτα Λεπτομερή Έξοδα 2025");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setContentPane(new ChartPanel(chart));
            frame.setSize(1200, 800);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }

        public static void main(String[] args) {
            showChart();
        }
    }











