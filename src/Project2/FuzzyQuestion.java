package Project2;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bdour
 */
public class FuzzyQuestion extends javax.swing.JFrame  {

    /**
     * Creates new form FuzzyQuestion
     */
    public FuzzyQuestion() {

//        fuzzyTextArea.setWrapStyleWord(true);
//        fuzzyTextArea.setLineWrap(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
        initComponents();
        pack();
//        fuzzyNextQuestionButton.requestFocus(true);

        if (DBhandler.currentFuzzyQuestionNumber < 2) {
            this.seeResult.setEnabled(false);
        }

        fuzzySlider.requestFocus();
        fuzzyIconLabel.setVisible(true);
//        fuzzySlider = new JSlider(JSlider.HORIZONTAL, -3, 3, 0);
        setLocationRelativeTo(null);
        fuzzySlider.setMinimum(-6);
        fuzzySlider.setMaximum(6);
        fuzzySlider.setValue(0);
        fuzzySlider.setMajorTickSpacing(2);
        fuzzySlider.setMinorTickSpacing(1);
        fuzzySlider.setPaintTicks(true);
        fuzzySlider.setPaintTrack(true);

        if ((int) ((DBhandler.randomNumber * 12) % 8) == 0) {
            if (fuzzySlider.getValue() == 0) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\justok.png"));
            } else if (fuzzySlider.getValue() == 2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\good.png"));
            } else if (fuzzySlider.getValue() == 4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\vgood.png"));
            } else if (fuzzySlider.getValue() == 6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\excellent.png"));
            } else if (fuzzySlider.getValue() == -2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\bad.png"));
            } else if (fuzzySlider.getValue() == -4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\vbad.png"));
            } else if (fuzzySlider.getValue() == -6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\terrible.png"));
            }

        } else if ((int) ((DBhandler.randomNumber * 12) % 8) == 1) {

            if (fuzzySlider.getValue() == 0) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\itsok.png"));
            } else if (fuzzySlider.getValue() == 2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\fairlywell.png"));
            } else if (fuzzySlider.getValue() == 4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\prettygood.png"));
            } else if (fuzzySlider.getValue() == 6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\greatly.png"));
            } else if (fuzzySlider.getValue() == -2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\notmuch.png"));
            } else if (fuzzySlider.getValue() == -4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\noway.png"));
            } else if (fuzzySlider.getValue() == -6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\miserable.png"));
            }
        } else if ((int) ((DBhandler.randomNumber * 12) % 8) == 2) {

            if (fuzzySlider.getValue() == 0) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arr0.png"));
            } else if (fuzzySlider.getValue() == 2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arr1.png"));
            } else if (fuzzySlider.getValue() == 4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arr2.png"));
            } else if (fuzzySlider.getValue() == 6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arr3.png"));
            } else if (fuzzySlider.getValue() == -2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arr-1.png"));
            } else if (fuzzySlider.getValue() == -4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arr-2.png"));
            } else if (fuzzySlider.getValue() == -6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arr-3.png"));

            }
        } else if ((int) ((DBhandler.randomNumber * 12) % 8) == 3) {
            if (fuzzySlider.getValue() == 0) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\dr0.png"));
            } else if (fuzzySlider.getValue() == 2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\dr1.png"));
            } else if (fuzzySlider.getValue() == 4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\dr2.png"));
            } else if (fuzzySlider.getValue() == 6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\dr3.png"));
            } else if (fuzzySlider.getValue() == -2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\dr-1.png"));
            } else if (fuzzySlider.getValue() == -4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\dr-2.png"));
            } else if (fuzzySlider.getValue() == -6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\dr-3.png"));
            }

        } else if ((int) ((DBhandler.randomNumber * 12) % 8) == 4) {
            if (fuzzySlider.getValue() == 0) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\fe0.png"));
            } else if (fuzzySlider.getValue() == 2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\fe1.png"));
            } else if (fuzzySlider.getValue() == 4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\fe2.png"));
            } else if (fuzzySlider.getValue() == 6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\fe3.png"));
            } else if (fuzzySlider.getValue() == -2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\fe-1.png"));
            } else if (fuzzySlider.getValue() == -4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\fe-2.png"));
            } else if (fuzzySlider.getValue() == -6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\fe-3.png"));
            }

        } else if ((int) ((DBhandler.randomNumber * 12) % 8) == 5) {

            if (fuzzySlider.getValue() == 0) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arrow0.png"));
            } else if (fuzzySlider.getValue() == 2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arrow1.png"));
            } else if (fuzzySlider.getValue() == 4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arrow2.png"));
            } else if (fuzzySlider.getValue() == 6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arrow3.png"));
            } else if (fuzzySlider.getValue() == -2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arrow-1.png"));
            } else if (fuzzySlider.getValue() == -4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arrow-2.png"));
            } else if (fuzzySlider.getValue() == -6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arrow-3.png"));
            }
        } else if ((int) ((DBhandler.randomNumber * 12) % 8) == 6) {

            if (fuzzySlider.getValue() == 0) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\gd3.png"));
            } else if (fuzzySlider.getValue() == 2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\gd4.png"));
            } else if (fuzzySlider.getValue() == 4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\gd5.png"));
            } else if (fuzzySlider.getValue() == 6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\gd6.png"));
            } else if (fuzzySlider.getValue() == -2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\gd2.png"));
            } else if (fuzzySlider.getValue() == -4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\gd1.png"));
            } else if (fuzzySlider.getValue() == -6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\gd0.png"));
            }
        } else if ((int) ((DBhandler.randomNumber * 12) % 8) == 7) {

            if (fuzzySlider.getValue() == 0) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\pie0.png"));
            } else if (fuzzySlider.getValue() == 2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\pie1.png"));
            } else if (fuzzySlider.getValue() == 4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\pie2.png"));
            } else if (fuzzySlider.getValue() == 6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\pie3.png"));
            } else if (fuzzySlider.getValue() == -2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\pie-1.png"));
            } else if (fuzzySlider.getValue() == -4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\pie-2.png"));
            } else if (fuzzySlider.getValue() == -6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\pie-3.png"));
            }
        }
//        fuzzySlider.setPaintLabels(true);
//        if (DBhandler.currentFuzzyQuestionNumber % 2 == 0) {
//            this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\justok.png"));
//
//        } else {
//            this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\itsok.png"));
//
//        }
        validate();
//        validateTree();

//        validate();
//        this.fuzzySlider.setMinimum(0);
//        this.fuzzySlider.setMaximum(10);
//        fuzzySlider.getValue();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        fuzzyTextArea = new javax.swing.JTextArea();
        fuzzySlider = new javax.swing.JSlider();
        fuzzyIconLabel = new javax.swing.JLabel();
        fuzzyNextQuestionButton = new javax.swing.JButton();
        fuzzyPercent = new javax.swing.JLabel();
        fuzzyOutOf = new javax.swing.JLabel();
        seeResult = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        jScrollPane1.setAlignmentX(2.0F);
        jScrollPane1.setAlignmentY(2.0F);
        jScrollPane1.setHorizontalScrollBar(null);

        fuzzyTextArea.setEditable(false);
        fuzzyTextArea.setBackground(new java.awt.Color(0, 153, 153));
        fuzzyTextArea.setColumns(20);
        fuzzyTextArea.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fuzzyTextArea.setForeground(new java.awt.Color(255, 255, 255));
        fuzzyTextArea.setLineWrap(true);
        fuzzyTextArea.setRows(5);
        fuzzyTextArea.setWrapStyleWord(true);
        fuzzyTextArea.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
        fuzzyTextArea.setAlignmentY(JTextArea.CENTER_ALIGNMENT);
        fuzzyTextArea.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 204, 204), new java.awt.Color(153, 153, 153)));
        jScrollPane1.setViewportView(fuzzyTextArea);

        fuzzySlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                fuzzySliderStateChanged(evt);
            }
        });
        fuzzySlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                fuzzySliderMouseDragged(evt);
            }
        });

        fuzzyNextQuestionButton.setText("Next Question!");
        fuzzyNextQuestionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fuzzyNextQuestionButtonActionPerformed(evt);
            }
        });

        fuzzyPercent.setFont(new java.awt.Font("Britannic Bold", 1, 36)); // NOI18N
        fuzzyPercent.setForeground(new java.awt.Color(255, 0, 153));

        fuzzyOutOf.setFont(new java.awt.Font("Verdana Ref", 0, 12)); // NOI18N
        fuzzyOutOf.setForeground(new java.awt.Color(102, 102, 102));
        fuzzyOutOf.setText("jLabel1");

        seeResult.setText("See Result!");
        seeResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seeResultActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fuzzyOutOf, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(fuzzyIconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(fuzzyPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fuzzySlider, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(fuzzyNextQuestionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                                .addComponent(seeResult)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fuzzyIconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(fuzzySlider, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fuzzyNextQuestionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seeResult, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(fuzzyOutOf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(fuzzyPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fuzzySliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_fuzzySliderStateChanged

        if ((int) ((DBhandler.randomNumber * 12) % 8) == 0) {
            System.out.println("");
            if (fuzzySlider.getValue() == 0) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\justok.png"));
            } else if (fuzzySlider.getValue() == 2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\good.png"));
            } else if (fuzzySlider.getValue() == 4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\vgood.png"));
            } else if (fuzzySlider.getValue() == 6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\excellent.png"));
            } else if (fuzzySlider.getValue() == -2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\bad.png"));
            } else if (fuzzySlider.getValue() == -4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\vbad.png"));
            } else if (fuzzySlider.getValue() == -6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\terrible.png"));
            }

        } else if ((int) ((DBhandler.randomNumber * 12) % 8) == 1) {

            if (fuzzySlider.getValue() == 0) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\itsok.png"));
            } else if (fuzzySlider.getValue() == 2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\fairlywell.png"));
            } else if (fuzzySlider.getValue() == 4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\prettygood.png"));
            } else if (fuzzySlider.getValue() == 6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\greatly.png"));
            } else if (fuzzySlider.getValue() == -2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\notmuch.png"));
            } else if (fuzzySlider.getValue() == -4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\noway.png"));
            } else if (fuzzySlider.getValue() == -6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\miserable.png"));
            }
        } else if ((int) ((DBhandler.randomNumber * 12) % 8) == 2) {

            if (fuzzySlider.getValue() == 0) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arr0.png"));
            } else if (fuzzySlider.getValue() == 2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arr1.png"));
            } else if (fuzzySlider.getValue() == 4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arr2.png"));
            } else if (fuzzySlider.getValue() == 6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arr3.png"));
            } else if (fuzzySlider.getValue() == -2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arr-1.png"));
            } else if (fuzzySlider.getValue() == -4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arr-2.png"));
            } else if (fuzzySlider.getValue() == -6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arr-3.png"));

            }
        } else if ((int) ((DBhandler.randomNumber * 12) % 8) == 3) {
            if (fuzzySlider.getValue() == 0) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\dr0.png"));
            } else if (fuzzySlider.getValue() == 2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\dr1.png"));
            } else if (fuzzySlider.getValue() == 4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\dr2.png"));
            } else if (fuzzySlider.getValue() == 6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\dr3.png"));
            } else if (fuzzySlider.getValue() == -2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\dr-1.png"));
            } else if (fuzzySlider.getValue() == -4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\dr-2.png"));
            } else if (fuzzySlider.getValue() == -6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\dr-3.png"));
            }

        } else if ((int) ((DBhandler.randomNumber * 12) % 8) == 4) {
            if (fuzzySlider.getValue() == 0) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\fe0.png"));
            } else if (fuzzySlider.getValue() == 2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\fe1.png"));
            } else if (fuzzySlider.getValue() == 4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\fe2.png"));
            } else if (fuzzySlider.getValue() == 6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\fe3.png"));
            } else if (fuzzySlider.getValue() == -2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\fe-1.png"));
            } else if (fuzzySlider.getValue() == -4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\fe-2.png"));
            } else if (fuzzySlider.getValue() == -6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\fe-3.png"));
            }

        } else if ((int) ((DBhandler.randomNumber * 12) % 8) == 5) {

            if (fuzzySlider.getValue() == 0) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arrow0.png"));
            } else if (fuzzySlider.getValue() == 2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arrow1.png"));
            } else if (fuzzySlider.getValue() == 4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arrow2.png"));
            } else if (fuzzySlider.getValue() == 6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arrow3.png"));
            } else if (fuzzySlider.getValue() == -2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arrow-1.png"));
            } else if (fuzzySlider.getValue() == -4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arrow-2.png"));
            } else if (fuzzySlider.getValue() == -6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arrow-3.png"));
            }
        } else if ((int) ((DBhandler.randomNumber * 12) % 8) == 6) {

            if (fuzzySlider.getValue() == 0) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\gd3.png"));
            } else if (fuzzySlider.getValue() == 2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\gd4.png"));
            } else if (fuzzySlider.getValue() == 4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\gd5.png"));
            } else if (fuzzySlider.getValue() == 6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\gd6.png"));
            } else if (fuzzySlider.getValue() == -2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\gd2.png"));
            } else if (fuzzySlider.getValue() == -4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\gd1.png"));
            } else if (fuzzySlider.getValue() == -6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\gd0.png"));
            }
        } else if ((int) ((DBhandler.randomNumber * 12) % 8) == 7) {

            if (fuzzySlider.getValue() == 0) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\pie0.png"));
            } else if (fuzzySlider.getValue() == 2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\pie1.png"));
            } else if (fuzzySlider.getValue() == 4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\pie2.png"));
            } else if (fuzzySlider.getValue() == 6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\pie3.png"));
            } else if (fuzzySlider.getValue() == -2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\pie-1.png"));
            } else if (fuzzySlider.getValue() == -4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\pie-2.png"));
            } else if (fuzzySlider.getValue() == -6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\pie-3.png"));
            }
        }

        validate();
        String s;
        validate();
        if (String.valueOf(((float) fuzzySlider.getValue() / 6) * 100).length() > 4) {
            s = String.valueOf(((float) fuzzySlider.getValue() / 6) * 100).substring(0, 4);
        } else {
            s = String.valueOf(((float) fuzzySlider.getValue() / 6) * 100);

        }
        fuzzyPercent.setText(s + "%");

    }//GEN-LAST:event_fuzzySliderStateChanged

    private void fuzzySliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fuzzySliderMouseDragged
//        fuzzyIconLabel.setText(String.valueOf(fuzzySlider.getValue()));
//        ImageIcon icon1 = new ImageIcon("inter2.png");
//        ImageIcon icon2 = new ImageIcon("interactive");
//        ImageIcon icon3 = new ImageIcon("Untitled-1");
//        int sliderValue = fuzzySlider.getValue();

        if ((int) ((DBhandler.randomNumber * 12) % 8) == 0) {
            System.out.println("");
            if (fuzzySlider.getValue() == 0) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\justok.png"));
            } else if (fuzzySlider.getValue() == 2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\good.png"));
            } else if (fuzzySlider.getValue() == 4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\vgood.png"));
            } else if (fuzzySlider.getValue() == 6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\excellent.png"));
            } else if (fuzzySlider.getValue() == -2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\bad.png"));
            } else if (fuzzySlider.getValue() == -4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\vbad.png"));
            } else if (fuzzySlider.getValue() == -6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\terrible.png"));
            }

        } else if ((int) ((DBhandler.randomNumber * 12) % 8) == 1) {

            if (fuzzySlider.getValue() == 0) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\itsok.png"));
            } else if (fuzzySlider.getValue() == 2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\fairlywell.png"));
            } else if (fuzzySlider.getValue() == 4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\prettygood.png"));
            } else if (fuzzySlider.getValue() == 6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\greatly.png"));
            } else if (fuzzySlider.getValue() == -2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\notmuch.png"));
            } else if (fuzzySlider.getValue() == -4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\noway.png"));
            } else if (fuzzySlider.getValue() == -6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\miserable.png"));
            }
        } else if ((int) ((DBhandler.randomNumber * 12) % 8) == 2) {

            if (fuzzySlider.getValue() == 0) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arr0.png"));
            } else if (fuzzySlider.getValue() == 2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arr1.png"));
            } else if (fuzzySlider.getValue() == 4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arr2.png"));
            } else if (fuzzySlider.getValue() == 6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arr3.png"));
            } else if (fuzzySlider.getValue() == -2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arr-1.png"));
            } else if (fuzzySlider.getValue() == -4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arr-2.png"));
            } else if (fuzzySlider.getValue() == -6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arr-3.png"));

            }
        } else if ((int) ((DBhandler.randomNumber * 12) % 8) == 3) {
            if (fuzzySlider.getValue() == 0) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\dr0.png"));
            } else if (fuzzySlider.getValue() == 2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\dr1.png"));
            } else if (fuzzySlider.getValue() == 4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\dr2.png"));
            } else if (fuzzySlider.getValue() == 6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\dr3.png"));
            } else if (fuzzySlider.getValue() == -2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\dr-1.png"));
            } else if (fuzzySlider.getValue() == -4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\dr-2.png"));
            } else if (fuzzySlider.getValue() == -6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\dr-3.png"));
            }

        } else if ((int) ((DBhandler.randomNumber * 12) % 8) == 4) {
            if (fuzzySlider.getValue() == 0) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\fe0.png"));
            } else if (fuzzySlider.getValue() == 2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\fe1.png"));
            } else if (fuzzySlider.getValue() == 4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\fe2.png"));
            } else if (fuzzySlider.getValue() == 6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\fe3.png"));
            } else if (fuzzySlider.getValue() == -2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\fe-1.png"));
            } else if (fuzzySlider.getValue() == -4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\fe-2.png"));
            } else if (fuzzySlider.getValue() == -6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\fe-3.png"));
            }

        } else if ((int) ((DBhandler.randomNumber * 12) % 8) == 5) {

            if (fuzzySlider.getValue() == 0) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arrow0.png"));
            } else if (fuzzySlider.getValue() == 2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arrow1.png"));
            } else if (fuzzySlider.getValue() == 4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arrow2.png"));
            } else if (fuzzySlider.getValue() == 6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arrow3.png"));
            } else if (fuzzySlider.getValue() == -2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arrow-1.png"));
            } else if (fuzzySlider.getValue() == -4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arrow-2.png"));
            } else if (fuzzySlider.getValue() == -6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\arrow-3.png"));
            }
        } else if ((int) ((DBhandler.randomNumber * 12) % 8) == 6) {

            if (fuzzySlider.getValue() == 0) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\gd3.png"));
            } else if (fuzzySlider.getValue() == 2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\gd4.png"));
            } else if (fuzzySlider.getValue() == 4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\gd5.png"));
            } else if (fuzzySlider.getValue() == 6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\gd6.png"));
            } else if (fuzzySlider.getValue() == -2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\gd2.png"));
            } else if (fuzzySlider.getValue() == -4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\gd1.png"));
            } else if (fuzzySlider.getValue() == -6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\gd0.png"));
            }
        } else if ((int) ((DBhandler.randomNumber * 12) % 8) == 7) {

            if (fuzzySlider.getValue() == 0) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\pie0.png"));
            } else if (fuzzySlider.getValue() == 2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\pie1.png"));
            } else if (fuzzySlider.getValue() == 4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\pie2.png"));
            } else if (fuzzySlider.getValue() == 6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\pie3.png"));
            } else if (fuzzySlider.getValue() == -2) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\pie-1.png"));
            } else if (fuzzySlider.getValue() == -4) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\pie-2.png"));
            } else if (fuzzySlider.getValue() == -6) {
                this.fuzzyIconLabel.setIcon(new ImageIcon("C:\\Users\\Bdour\\Documents\\NetBeansProjects\\Project2\\src\\Project2\\Project2i\\pie-3.png"));
            }
        }

        String s;

        validate();

        if (String.valueOf(((float) fuzzySlider.getValue()
                / 6) * 100).length() > 4) {
            s = String.valueOf(((float) fuzzySlider.getValue() / 6) * 100).substring(0, 4);
        } else {
            s = String.valueOf(((float) fuzzySlider.getValue() / 6) * 100);
        }

        fuzzyPercent.setText(s
                + "%");

//        if (fuzzySlider.getValue() == 0) {
//            fuzzyPercent.setText("0%");
//        } else if (fuzzySlider.getValue() == 2) {
//            fuzzyPercent.setText("%");
//        }

    }//GEN-LAST:event_fuzzySliderMouseDragged

    private void fuzzyNextQuestionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fuzzyNextQuestionButtonActionPerformed
        this.fuzzyNextQuestionButton.setEnabled(false);
        float rankUpdateValue = (float) this.fuzzySlider.getValue() / 5;
        DBhandler.studentCollegeRankExists_ThenUpdateRank_ElseInsert(DBhandler.currentStudentID, DBhandler.getCollegeIDByFuzzyQuestionID(DBhandler.fuzzyQuestions.get(DBhandler.currentFuzzyQuestionNumber)), rankUpdateValue);

        DBhandler.currentFuzzyQuestionNumber += 1;

        if (DBhandler.currentMChoiceQuestionNumber < DBhandler.multiChoiceQuestions.size()) {
            this.setVisible(false);
            DBhandler.randomNumber = Math.random() * DBhandler.currentMChoiceQuestionNumber + 17;
            MultiChoiceQuestion q1 = new MultiChoiceQuestion();
            q1.getmChoiceOutOf().setText("Multi-choice question " + (DBhandler.currentMChoiceQuestionNumber + 1) + "/" + DBhandler.multiChoiceQuestions.size() + ", " + DBhandler.getCollegeNameByMChoiceQuestionID(DBhandler.multiChoiceQuestions.get(DBhandler.currentMChoiceQuestionNumber)) + ":");
            q1.getQuestionTextArea().setLineWrap(true);
            q1.getQuestionTextArea().setWrapStyleWord(true);
            q1.getQuestionTextArea().setText(DBhandler.getMultiChoiceQuestionByID(DBhandler.multiChoiceQuestions.get(DBhandler.currentMChoiceQuestionNumber))[0]);
            q1.getOption1().setText(DBhandler.getMultiChoiceQuestionByID(DBhandler.multiChoiceQuestions.get(DBhandler.currentMChoiceQuestionNumber))[1]);
            q1.getOption2().setText(DBhandler.getMultiChoiceQuestionByID(DBhandler.multiChoiceQuestions.get(DBhandler.currentMChoiceQuestionNumber))[2]);
            q1.getOption3().setText(DBhandler.getMultiChoiceQuestionByID(DBhandler.multiChoiceQuestions.get(DBhandler.currentMChoiceQuestionNumber))[3]);
        } else {
            System.out.println("end of mchoice Qs!");
            if (DBhandler.currentFuzzyQuestionNumber < DBhandler.fuzzyQuestions.size()) {
                this.setVisible(false);
                DBhandler.randomNumber = Math.random() * DBhandler.currentFuzzyQuestionNumber + 3;
                FuzzyQuestion fq = new FuzzyQuestion();
                fq.getFuzzyTextArea().setLineWrap(true);
                fq.getFuzzyTextArea().setWrapStyleWord(true);
                fq.getFuzzyTextArea().setText(DBhandler.getFuzzyQuestionByID(DBhandler.fuzzyQuestions.get(DBhandler.currentFuzzyQuestionNumber))[0]);
                fq.getFuzzyOutOf().setText("Fuzzy question " + (DBhandler.currentFuzzyQuestionNumber + 1) + "/" + DBhandler.fuzzyQuestions.size() + ", " + DBhandler.getCollegeNameByFuzzyQuestionID(DBhandler.fuzzyQuestions.get(DBhandler.currentFuzzyQuestionNumber)) + ":");
            } else {
                this.setVisible(false);
                JOptionPane.showMessageDialog(rootPane, "End of questions! Now you'll see the result with some stats!");
                new Result().setVisible(true);

            }
        }

    }//GEN-LAST:event_fuzzyNextQuestionButtonActionPerformed

    private void seeResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seeResultActionPerformed

        this.setVisible(false);
        new Result().setVisible(true);

    }//GEN-LAST:event_seeResultActionPerformed

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
            java.util.logging.Logger.getLogger(FuzzyQuestion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FuzzyQuestion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FuzzyQuestion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FuzzyQuestion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FuzzyQuestion().setVisible(true);
            }
        });
    }

    public JLabel getFuzzyIconLabel() {
        return fuzzyIconLabel;
    }

    public JSlider getFuzzySlider() {
        return fuzzySlider;
    }

    public JTextArea getFuzzyTextArea() {
        return fuzzyTextArea;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JButton getFuzzyNextQuestionButton() {
        return fuzzyNextQuestionButton;
    }

    public JLabel getFuzzyOutOf() {
        return fuzzyOutOf;
    }

    public JLabel getFuzzyPercent() {
        return fuzzyPercent;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fuzzyIconLabel;
    private javax.swing.JButton fuzzyNextQuestionButton;
    private javax.swing.JLabel fuzzyOutOf;
    private javax.swing.JLabel fuzzyPercent;
    private javax.swing.JSlider fuzzySlider;
    private javax.swing.JTextArea fuzzyTextArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton seeResult;
    // End of variables declaration//GEN-END:variables
}
