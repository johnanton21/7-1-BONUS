package com.yourapp.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class FirstMenuGui {
        private JFrame frame;

        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        FirstMenuGui window = new FirstMenuGui();
                        window.frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        /**
         * Create the application.
         */
        public FirstMenuGui() {
            initialize();
        }

        /**
         * Initialize the contents of the frame.
         */
        private void initialize() {
            frame = new JFrame();
            frame.setBounds(100, 100, 450, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setLayout(null);

            JLabel lblNewLabel = new JLabel("ΜΕΝΟΥ ΕΠΙΛΟΓΗΣ");
            lblNewLabel.setForeground(Color.BLUE);
            lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
            lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel.setBackground(Color.WHITE);
            lblNewLabel.setBounds(140, 28, 130, 14);
            frame.getContentPane().add(lblNewLabel);

            JButton btnNewButton = new JButton("ENTER");
            btnNewButton.setBounds(160, 209, 85, 21);
            frame.getContentPane().add(btnNewButton);

            JCheckBox chckbxNewCheckBox = new JCheckBox("1. Εμφάνιση των στοιχείων του κρατικού προϋπολογισμού του τρέχοντος έτους");
            chckbxNewCheckBox.setBounds(6, 49, 424, 26);
            frame.getContentPane().add(chckbxNewCheckBox);

            JCheckBox chckbxNewCheckBox_1 = new JCheckBox("3. Κατηγοριοποίηση δαπανών και εσόδων ανά υπουργείο ή τομέα");
            chckbxNewCheckBox_1.setBounds(6, 100, 410, 21);
            frame.getContentPane().add(chckbxNewCheckBox_1);

            JCheckBox chckbxNewCheckBox_2 = new JCheckBox("4. Σύγκριση δεδομένων του κρατικού προϋπολογισμού με άλλες χώρες");
            chckbxNewCheckBox_2.setBounds(6, 124, 410, 21);
            frame.getContentPane().add(chckbxNewCheckBox_2);

            JCheckBox chckbxNewCheckBox_3 = new JCheckBox("5. Εφαρμoγή αλλαγών");
            chckbxNewCheckBox_3.setBounds(6, 147, 372, 21);
            frame.getContentPane().add(chckbxNewCheckBox_3);

            JCheckBox chckbxNewCheckBox_4 = new JCheckBox("6. Ανάλυση στατιστικών δεδομένων χρησιμοποιώντας γραφήματα");
            chckbxNewCheckBox_4.setBounds(6, 170, 393, 21);
            frame.getContentPane().add(chckbxNewCheckBox_4);

            JCheckBox chckbxNewCheckBox_5 = new JCheckBox("7. Έξοδος");
            chckbxNewCheckBox_5.setBounds(6, 193, 139, 21);
            frame.getContentPane().add(chckbxNewCheckBox_5);

            JCheckBox chckbxNewCheckBox_6 = new JCheckBox("2. Εμφάνιση δημοσιονομικού ισοζυγίου");
            chckbxNewCheckBox_6.setBounds(6, 77, 299, 21);
            frame.getContentPane().add(chckbxNewCheckBox_6);
        }
    }

