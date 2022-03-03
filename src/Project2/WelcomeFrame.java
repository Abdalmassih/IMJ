package Project2;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JWindow;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Abd Al-Massih
 */
public class WelcomeFrame extends javax.swing.JFrame {
    
    JTextField[] wfTextFields = new JTextField[9];
    static List<String> questionsNeeded = new ArrayList<String>();
    
    public WelcomeFrame() {

//        AWTUtilities.setWindowOpaque(this, false);
        setLocationRelativeTo(null);
        setTitle("Interactive Major Guide");
        initComponents();
        pack();
//        studentNameTexField.setCaretPosition(0);
        studentNameTexField.requestFocus();
//      studentNameTexField.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(scientificRadioButton);
        buttonGroup1.add(literaryRadioButton);
        scientificRadioButton.setSelected(true);
        
        genderCombo.removeAllItems();
        genderCombo.addItem((String) "Male");
        genderCombo.addItem((String) "Female");
        
        wfMofCombo.removeAllItems();
        List<Integer> sci = new ArrayList<Integer>();
        
        for (int year : DBhandler.getMofYears("sci_mof")) {
            sci.add(year);
        }
        for (Integer year : sci) {
            wfMofCombo.addItem((String) String.valueOf(year));
        }
        
        if (scientificRadioButton.isSelected()) {
            
            arabicMark.setEnabled(false);
            englishMark.setEnabled(false);
            historyMark.setEnabled(false);
            geographyMark.setEnabled(false);
        }

//        for (int i = 0; i < wfTextFields.length; i++) {
//            System.out.println(wfTextFields[i].getText());
//        }
    }
    
    public void getValuesToWfTextFieldsArray() {
        wfTextFields[0] = studentNameTexField;
        wfTextFields[1] = mathMark;
        wfTextFields[2] = physicsMark;
        wfTextFields[3] = chemistryMark;
        wfTextFields[4] = NaturalScienceMark;
        wfTextFields[5] = arabicMark;
        wfTextFields[6] = englishMark;
        wfTextFields[7] = historyMark;
        wfTextFields[8] = geographyMark;
    }
    
    public int calculateTotalMark() {
        getValuesToWfTextFieldsArray();
        int total = 0;
        if (getScientificRadioButton().isEnabled()) {
            for (int i = 1; i <= 4; i++) {
                total += Integer.parseInt(wfTextFields[i].getText());
            }
        } else if (getLiteraryRadioButton().isEnabled()) {
            
            for (int i = 5; i <= 8; i++) {
                total += Integer.parseInt(wfTextFields[i].getText());
                
            }
        }
        return total;
    }
    
    public boolean checkFields() {
        boolean allOK = true;
        if (scientificRadioButton.isSelected()) {
            if (studentNameTexField.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Please fill in your name.", "Blank Name", JOptionPane.ERROR_MESSAGE);
                allOK = false;
                return allOK;
            }
            if (!studentNameTexField.getText().matches("[a-zA-Z][a-zA-Z0-9_\\s.]*") && allOK) {
                JOptionPane.showMessageDialog(this, "Please enter a valid name!", "Wrong Input", JOptionPane.ERROR_MESSAGE);
                allOK = false;
                return allOK;
            }
            getValuesToWfTextFieldsArray();
            if (allOK) {
                
                for (int i = 1; i <= 4; i++) {
                    if (!wfTextFields[i].getText().matches("\\d+")) {
                        JOptionPane.showMessageDialog(rootPane, "You entered an INVALID value: (" + wfTextFields[i].getText() + ") for a mark.");
                        allOK = false;
                        break;
                    } else if (Integer.parseInt(wfTextFields[i].getText()) > Integer.parseInt(wfTextFields[i].getToolTipText().split(" ")[2])) {
                        JOptionPane.showMessageDialog(rootPane, "You entered an out-of-range value: (" + wfTextFields[i].getText() + ")");
                        allOK = false;
                        break;
                    }
                }
                
            }
            if (allOK) {
                if (calculateTotalMark() < 50) {
                    JOptionPane.showMessageDialog(rootPane, "You didn't pass with these marks. \nPlease enter a different student's marks or exit.");
                    allOK = false;
                    return false;
                }
            }
            return allOK;
            
        } else if (literaryRadioButton.isSelected()) {
            if (studentNameTexField.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Please fill in your name.", "Blank Name", JOptionPane.ERROR_MESSAGE);
                allOK = false;
                return allOK;
            }
            if (!studentNameTexField.getText().matches("[a-zA-Z][a-zA-Z0-9_\\s.]*") && allOK) {
                JOptionPane.showMessageDialog(this, "Please enter a valid name!", "Wrong Input", JOptionPane.ERROR_MESSAGE);
                allOK = false;
                return allOK;
            }
            getValuesToWfTextFieldsArray();
            if (allOK) {
                
                for (int i = 5; i <= 8; i++) {
                    if (!wfTextFields[i].getText().matches("\\d+")) {
                        JOptionPane.showMessageDialog(rootPane, "You entered an INVALID value / " + wfTextFields[i].getText() + " / for a mark.");
                        allOK = false;
                        break;
                    } else if (Integer.parseInt(wfTextFields[i].getText()) > Integer.parseInt(wfTextFields[i].getToolTipText().split(" ")[2])) {
                        JOptionPane.showMessageDialog(rootPane, "You entered an out-of-range value (" + wfTextFields[i].getText() + ")");
                        allOK = false;
                        break;
                    }
                }
            }
//            return allOK;//   JOptionPane.showMessageDialog(null, "Successfully inserted  "
            //          + studentNameTexField.getText().toUpperCase() + "'s information.", "Success!", JOptionPane.INFORMATION_MESSAGE);

        }
        if (allOK) {
            if (calculateTotalMark() < 40) {
                JOptionPane.showMessageDialog(rootPane, "You didn't pass with these marks. \nPlease enter a different student's marks or exit.");
                allOK = false;
                return false;
            }
        }
        
        return allOK;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        literaryRadioButton = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        physicsMark = new javax.swing.JTextField();
        mathMark = new javax.swing.JTextField();
        arabicMark = new javax.swing.JTextField();
        geographyMark = new javax.swing.JTextField();
        historyMark = new javax.swing.JTextField();
        englishMark = new javax.swing.JTextField();
        NaturalScienceMark = new javax.swing.JTextField();
        chemistryMark = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        scientificRadioButton = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        studentNameTexField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        genderCombo = new javax.swing.JComboBox();
        nextButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        wfMofCombo = new javax.swing.JComboBox();
        yesButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();
        aboutUsMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        setForeground(new java.awt.Color(153, 204, 255));
        setLocationByPlatform(true);
        setName("Interactive College Guide"); // NOI18N
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 1, true), "We'd like to know about your Majoring interests:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Hacen Samra Lt", 1, 18), new java.awt.Color(102, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(0, 204, 204));

        literaryRadioButton.setFont(new java.awt.Font("Gisha", 0, 14)); // NOI18N
        literaryRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        literaryRadioButton.setText("Literary");
        literaryRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                literaryRadioButtonActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "We would also like to know your detailed marks:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Hacen Samra Lt", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        physicsMark.setText("10");
        physicsMark.setToolTipText("Out of 40");
        physicsMark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                physicsMarkActionPerformed(evt);
            }
        });

        mathMark.setText("60");
        mathMark.setToolTipText("Out of 60");
        mathMark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mathMarkActionPerformed(evt);
            }
        });

        arabicMark.setText("38");
        arabicMark.setToolTipText("Out of 40");
        arabicMark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arabicMarkActionPerformed(evt);
            }
        });

        geographyMark.setText("6");
        geographyMark.setToolTipText("Out of 40");

        historyMark.setText("30");
        historyMark.setToolTipText("Out of 30");

        englishMark.setText("28");
        englishMark.setToolTipText("Out of 30");

        NaturalScienceMark.setText("30");
        NaturalScienceMark.setToolTipText("Out of 30");
        NaturalScienceMark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NaturalScienceMarkActionPerformed(evt);
            }
        });

        chemistryMark.setText("17");
        chemistryMark.setToolTipText("Out of 20");

        jLabel6.setFont(new java.awt.Font("Gisha", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Math:");

        jLabel7.setFont(new java.awt.Font("Gisha", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("English:");

        jLabel8.setFont(new java.awt.Font("Gisha", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Arabic:");

        jLabel9.setFont(new java.awt.Font("Gisha", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Physics:");

        jLabel10.setFont(new java.awt.Font("Gisha", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("History:");

        jLabel11.setFont(new java.awt.Font("Gisha", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Chemistry:");

        jLabel13.setFont(new java.awt.Font("Gisha", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Natural Science:");

        jLabel14.setFont(new java.awt.Font("Gisha", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Geography:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chemistryMark, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(physicsMark)
                    .addComponent(NaturalScienceMark)
                    .addComponent(mathMark))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(arabicMark)
                            .addComponent(englishMark)
                            .addComponent(historyMark, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(geographyMark, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(arabicMark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mathMark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(physicsMark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(englishMark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(historyMark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chemistryMark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NaturalScienceMark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(geographyMark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        scientificRadioButton.setFont(new java.awt.Font("Gisha", 0, 14)); // NOI18N
        scientificRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        scientificRadioButton.setText("Scientific");
        scientificRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scientificRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scientificRadioButton)
                    .addComponent(literaryRadioButton))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(scientificRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(literaryRadioButton)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel17.setBackground(new java.awt.Color(204, 204, 204));
        jLabel17.setFont(new java.awt.Font("SketchFlow Print", 3, 30)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setText("Let's Get Interactive!");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project2/Project2i/imgSMALL.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Who are you?", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Hacen Samra Lt", 1, 18), new java.awt.Color(255, 0, 102))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        studentNameTexField.setText("Abd");
        studentNameTexField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentNameTexFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Gisha", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Your Name:");

        jLabel4.setFont(new java.awt.Font("Gisha", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Your Gender:");

        genderCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        genderCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(genderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(studentNameTexField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 87, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(studentNameTexField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(genderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project2/Project2i/nxtbtn.png"))); // NOI18N
        nextButton.setMnemonic('m');
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0), 2), "Tell us about your Mofadala!", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Hacen Samra Lt", 1, 18), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(0, 153, 204));

        jLabel12.setFont(new java.awt.Font("Gisha", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("You can choose a previous Mofadala year:");

        jLabel1.setFont(new java.awt.Font("Gisha", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Or wanna fill in your own Mofadala? Here:");

        wfMofCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        wfMofCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wfMofComboMouseClicked(evt);
            }
        });
        wfMofCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wfMofComboActionPerformed(evt);
            }
        });

        yesButton.setText("Yes!");
        yesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(wfMofCombo, 0, 82, Short.MAX_VALUE)
                    .addComponent(yesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(wfMofCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(yesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(0, 153, 153));

        jMenu1.setText("File");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");
        jMenu2.setToolTipText("Know more about us");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        aboutMenuItem.setText("About this app");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(aboutMenuItem);

        aboutUsMenuItem.setText("About us");
        aboutUsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutUsMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(aboutUsMenuItem);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        JOptionPane.showMessageDialog(this, "Choose the number of variables "
                + "and constraints, then press Define the\n program button to define "
                + "your program's variables and constraints", "Help", JOptionPane.INFORMATION_MESSAGE);
        if (evt.getSource() == jMenu2) {
            JOptionPane.showMessageDialog(jMenu2, "go!");
        }       // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void aboutUsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutUsMenuItemActionPerformed
        JOptionPane.showMessageDialog(this, "This app was programmed by: \n \n Abd Al-Massih Yakeen \n Baker Damman \n Hamed Ali \n Ibraheem Shbat \n Ahmad Ajlani \n Delzan Hussein \n \n" + "  Thank you for using this program.", "Help!", JOptionPane.INFORMATION_MESSAGE);        // TODO add your handling code here:
    }//GEN-LAST:event_aboutUsMenuItemActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
        int yesExit = JOptionPane.showConfirmDialog(WelcomeFrame.this, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
        if (yesExit == JOptionPane.YES_OPTION) {
            System.exit(0);
        }// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        JOptionPane.showMessageDialog(WelcomeFrame.this, "After giving us some of your information, \n this app will ask you some questions upon which it will decide the best college for you.\n Enjoy!", "About App", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void yesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesButtonActionPerformed
        
        if (this.checkFields()) {
            DBhandler.currentStudentName = this.getStudentNameTexField().getText();
            Mofadala mof = new Mofadala(this, DBhandler.currentStudentName);
            mof.setDefaultCloseOperation(EXIT_ON_CLOSE);
            mof.pack();
            //            this.setEnabled(false);
        }

        //        this.setEnabled(true);
    }//GEN-LAST:event_yesButtonActionPerformed

    private void wfMofComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wfMofComboActionPerformed

    }//GEN-LAST:event_wfMofComboActionPerformed

    private void wfMofComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wfMofComboMouseClicked
        if (scientificRadioButton.isSelected()) {
            wfMofCombo.removeAllItems();
            List<Integer> sci = new ArrayList<Integer>();
            
            for (int year : DBhandler.getMofYears("sci_mof")) {
                sci.add(year);
            }
            for (Integer year : sci) {
                wfMofCombo.addItem(year);
            }
        } else if (literaryRadioButton.isSelected()) {
            wfMofCombo.removeAllItems();
            List<Integer> sci = new ArrayList<Integer>();
            
            for (int year : DBhandler.getMofYears("lit_mof")) {
                sci.add(year);
            }
            for (Integer year : sci) {
                wfMofCombo.addItem(year);
            }
        }
    }//GEN-LAST:event_wfMofComboMouseClicked

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        
        if (checkFields()) {

            //            yesButton.setEnabled(false);
            DBhandler.insertStudentInfo(this);
            List<String> candidateColleges = DBhandler.getCandidateColleges(Integer.parseInt(this.getWfMofCombo().getSelectedItem().toString()), this);
            DBhandler.fuzzyQuestions = DBhandler.getFuzzyQuestionsIDsArray(candidateColleges);
            DBhandler.multiChoiceQuestions = DBhandler.getMultiChoiceQuestionsIDsArray(candidateColleges);
            DBhandler.currentStudentName = this.getStudentNameTexField().getText();
//                        long seed = System.nanoTime();
//                        Collections.shuffle(DBhandler.fuzzyQuestions, new Random(seed));
//                        Collections.shuffle(DBhandler.multiChoiceQuestions, new Random(seed));

            if (candidateColleges.isEmpty()) {
                int ok = JOptionPane.showConfirmDialog(rootPane, "Sorry, you were not accepted in any college! \nWould you like to try again with different marks?", "Problem!", JOptionPane.YES_NO_OPTION);
                if (ok == 0) {
                    this.setVisible(false);
                    new WelcomeFrame().setVisible(true);
                } else {
                    System.exit(0);
                }
            } else {
                String s = new String();
                for (String string : candidateColleges) {
                    s += "\n";
                    s += "\t";                        
                    s += string;
                }
                
                JOptionPane.showMessageDialog(rootPane, "Colleges available for you:\n" + s.toUpperCase() + "\n \nClick OK to proceed to questions!", "Available Colleges", JOptionPane.INFORMATION_MESSAGE);
                
                int firstFuzzyQuestionID = DBhandler.getFuzzyQuestionsIDsArray(candidateColleges).get(0);
                String[] firstFuzzyQuestionDetails = new String[2];
                for (int i = 0; i < DBhandler.getFuzzyQuestionByID(firstFuzzyQuestionID).length; i++) {
                    firstFuzzyQuestionDetails[i] = DBhandler.getFuzzyQuestionByID(firstFuzzyQuestionID)[i];
                }
                this.setVisible(false);
                DBhandler.currentStudentID = DBhandler.getStudentIDByName(this.studentNameTexField.getText());
                FuzzyQuestion q = new FuzzyQuestion();
                q.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                q.getFuzzyTextArea().setLineWrap(true);
                q.getFuzzyOutOf().setText("Fuzzy question " + (DBhandler.currentFuzzyQuestionNumber + 1) + "/" + DBhandler.fuzzyQuestions.size() + ", " + DBhandler.getCollegeNameByFuzzyQuestionID(DBhandler.fuzzyQuestions.get(DBhandler.currentFuzzyQuestionNumber)) + ":");
                //            q.getNextQuestionButton().setEnabled(false);
                //            q.getStartButton().setEnabled(true);
                q.getFuzzyTextArea().setText(firstFuzzyQuestionDetails[0]);
                nextButton.setEnabled(false);
            }
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void genderComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderComboActionPerformed

    private void studentNameTexFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentNameTexFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentNameTexFieldActionPerformed

    private void scientificRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scientificRadioButtonActionPerformed
        
        mathMark.setEnabled(true);
        physicsMark.setEnabled(true);
        NaturalScienceMark.setEnabled(true);
        chemistryMark.setEnabled(true);
        
        arabicMark.setEnabled(false);
        englishMark.setEnabled(false);
        geographyMark.setEnabled(false);
        historyMark.setEnabled(false);
        
        wfMofCombo.removeAllItems();
        List<Integer> sci = new ArrayList<Integer>();
        
        for (int year : DBhandler.getMofYears("sci_mof")) {
            sci.add(year);
        }
        for (Integer year : sci) {
            wfMofCombo.addItem(year);
        }
    }//GEN-LAST:event_scientificRadioButtonActionPerformed

    private void NaturalScienceMarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NaturalScienceMarkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NaturalScienceMarkActionPerformed

    private void arabicMarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arabicMarkActionPerformed

    }//GEN-LAST:event_arabicMarkActionPerformed

    private void mathMarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mathMarkActionPerformed

    }//GEN-LAST:event_mathMarkActionPerformed

    private void physicsMarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_physicsMarkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_physicsMarkActionPerformed

    private void literaryRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_literaryRadioButtonActionPerformed
        
        mathMark.setEnabled(false);
        physicsMark.setEnabled(false);
        NaturalScienceMark.setEnabled(false);
        chemistryMark.setEnabled(false);
        
        arabicMark.setEnabled(true);
        englishMark.setEnabled(true);
        geographyMark.setEnabled(true);
        historyMark.setEnabled(true);
        wfMofCombo.removeAllItems();
        
        List<Integer> lit = new ArrayList<Integer>();
        
        for (int year : DBhandler.getMofYears("lit_mof")) {
            lit.add(year);
        }
        for (Integer year : lit) {
            wfMofCombo.addItem(year);
        }
    }//GEN-LAST:event_literaryRadioButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                    
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WelcomeFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WelcomeFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WelcomeFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WelcomeFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        WelcomeFrame wf = new WelcomeFrame();
        wf.setVisible(true);
//        WelcomeFrame wf = new WelcomeFrame();
//        wf.setVisible(true);
        //   System.out.println(wf.calculateTotalMark());
    }
    
    public JTextField[] getWfTextFields() {
        return wfTextFields;
    }
    
    public JTextField getNaturalScienceMark() {
        return NaturalScienceMark;
    }
    
    public JMenuItem getAboutMenuItem() {
        return aboutMenuItem;
    }
    
    public JMenuItem getAboutUsMenuItem() {
        return aboutUsMenuItem;
    }
    
    public JTextField getArabicMark() {
        return arabicMark;
    }
    
    public ButtonGroup getButtonGroup1() {
        return buttonGroup1;
    }
    
    public ButtonGroup getButtonGroup2() {
        return buttonGroup2;
    }
    
    public JTextField getChemistryMark() {
        return chemistryMark;
    }
    
    public JTextField getEnglishMark() {
        return englishMark;
    }
    
    public JTextField getGeographyMark() {
        return geographyMark;
    }
    
    public JTextField getHistoryMark() {
        return historyMark;
    }
    
    public JLabel getjLabel1() {
        return jLabel1;
    }
    
    public JLabel getjLabel10() {
        return jLabel10;
    }
    
    public JLabel getjLabel11() {
        return jLabel11;
    }
    
    public JLabel getjLabel13() {
        return jLabel13;
    }
    
    public JLabel getjLabel14() {
        return jLabel14;
    }
    
    public JLabel getjLabel17() {
        return jLabel17;
    }
    
    public JLabel getjLabel3() {
        return jLabel3;
    }
    
    public JLabel getjLabel6() {
        return jLabel6;
    }
    
    public JLabel getjLabel7() {
        return jLabel7;
    }
    
    public JLabel getjLabel8() {
        return jLabel8;
    }
    
    public JLabel getjLabel9() {
        return jLabel9;
    }
    
    public JMenu getjMenu1() {
        return jMenu1;
    }
    
    public JMenu getjMenu2() {
        return jMenu2;
    }
    
    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }
    
    public JMenuItem getjMenuItem2() {
        return jMenuItem2;
    }
    
    public JPanel getjPanel1() {
        return jPanel1;
    }
    
    public JPanel getjPanel2() {
        return jPanel2;
    }
    
    public JRadioButton getLiteraryRadioButton() {
        return literaryRadioButton;
    }
    
    public JTextField getMathMark() {
        return mathMark;
    }
    
    public JTextField getPhysicsMark() {
        return physicsMark;
    }
    
    public JRadioButton getScientificRadioButton() {
        return scientificRadioButton;
    }
    
    public JTextField getStudentNameTexField() {
        return studentNameTexField;
    }
    
    public JButton getYesButton() {
        return yesButton;
    }
    
    public static List<String> getQuestionsNeeded() {
        return questionsNeeded;
    }
    
    public JComboBox getGenderCombo() {
        return genderCombo;
    }
    
    public JLabel getjLabel12() {
        return jLabel12;
    }
    
    public JLabel getjLabel4() {
        return jLabel4;
    }
    
    public JComboBox getWfMofCombo() {
        return wfMofCombo;
    }
    
    public static int getEXIT_ON_CLOSE() {
        return EXIT_ON_CLOSE;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField NaturalScienceMark;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem aboutUsMenuItem;
    public static javax.swing.JTextField arabicMark;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    public javax.swing.JTextField chemistryMark;
    public static javax.swing.JTextField englishMark;
    private javax.swing.JComboBox genderCombo;
    public static javax.swing.JTextField geographyMark;
    public static javax.swing.JTextField historyMark;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    public javax.swing.JRadioButton literaryRadioButton;
    public static javax.swing.JTextField mathMark;
    protected static javax.swing.JButton nextButton;
    public static javax.swing.JTextField physicsMark;
    public javax.swing.JRadioButton scientificRadioButton;
    javax.swing.JTextField studentNameTexField;
    private javax.swing.JComboBox wfMofCombo;
    private javax.swing.JButton yesButton;
    // End of variables declaration//GEN-END:variables
}
