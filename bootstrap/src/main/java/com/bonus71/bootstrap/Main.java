package com.bonus71.bootstrap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JFrame frame;
    private JCheckBox[] checkBoxes;

    static void main() {
        EventQueue.invokeLater(() -> {
            try {
                Main window = new Main();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Main() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Budget Management System");
        frame.setBounds(100, 100, 550, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("SELECTION MENU");
        lblTitle.setForeground(Color.BLUE);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(150, 20, 250, 25);
        frame.getContentPane().add(lblTitle);

        checkBoxes = new JCheckBox[7];

        checkBoxes[0] = new JCheckBox("1. Display of the current year's government budget data");
        checkBoxes[0].setBounds(20, 60, 500, 25);
        frame.getContentPane().add(checkBoxes[0]);

        checkBoxes[1] = new JCheckBox("2. Display fiscal balance");
        checkBoxes[1].setBounds(20, 90, 500, 25);
        frame.getContentPane().add(checkBoxes[1]);

        checkBoxes[2] = new JCheckBox("3. Categorize expenditures and revenues by ministry or sector");
        checkBoxes[2].setBounds(20, 120, 500, 25);
        frame.getContentPane().add(checkBoxes[2]);

        checkBoxes[3] = new JCheckBox("4. Comparison of government budget data with other countries");
        checkBoxes[3].setBounds(20, 150, 500, 25);
        frame.getContentPane().add(checkBoxes[3]);

        checkBoxes[4] = new JCheckBox("5. Apply changes");
        checkBoxes[4].setBounds(20, 180, 500, 25);
        frame.getContentPane().add(checkBoxes[4]);

        checkBoxes[5] = new JCheckBox("6. Analyze statistical data using graphs");
        checkBoxes[5].setBounds(20, 210, 500, 25);
        frame.getContentPane().add(checkBoxes[5]);

        checkBoxes[6] = new JCheckBox("7. Exit");
        checkBoxes[6].setBounds(20, 240, 500, 25);
        frame.getContentPane().add(checkBoxes[6]);

        JButton btnEnter = new JButton("ENTER");
        btnEnter.setBounds(220, 275, 100, 30);
        btnEnter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleUserSelection();
            }
        });
        frame.getContentPane().add(btnEnter);
    }

    private void handleUserSelection() {
        for (int i = 0; i < checkBoxes.length; i++) {
            if (checkBoxes[i].isSelected()) {
                int selection = i + 1;
                processSelection(selection);
                checkBoxes[i].setSelected(false);
            }
        }
    }

    private void processSelection(int selection) {
        switch (selection) {
            case 1 -> {
                JOptionPane.showMessageDialog(frame, "Case 1: Display budget data");
            }
            case 2 -> {
                JOptionPane.showMessageDialog(frame, "Case 2: Display fiscal balance");
            }
            case 3 -> {
                JOptionPane.showMessageDialog(frame, "Case 3: Categorize expenditures and revenues");
            }
            case 4 -> {
                JOptionPane.showMessageDialog(frame, "Case 4: Comparison with other countries");
            }
            case 5 -> {
                JOptionPane.showMessageDialog(frame, "Case 5: Apply changes");
            }
            case 6 -> {
                JOptionPane.showMessageDialog(frame, "Case 6: Analyze statistical data");
            }
            case 7 -> {
                int result = JOptionPane.showConfirmDialog(frame,
                    "Are you sure you want to exit?",
                    "Exit Confirmation",
                    JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
            default -> {
            }
        }
    }
}
