/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project2;

import java.sql.*;
import net.proteanit.sql.DbUtils;
//import net.proteanit.sql.DbUtils;
//import net.proteanit.sql.*;

/**
 
 */
public class Result extends javax.swing.JFrame {

    /**
     * Creates new form Result
     */
    public Result() {
        initComponents();
        String gender = DBhandler.getStudentGenderByID(DBhandler.currentStudentID);
        String MrOrMs = "";
        if (gender.equalsIgnoreCase("Male")) {
            MrOrMs = "Mr.";
        } else {
            MrOrMs = "Ms.";
        }
//        resultTable = new JTable();
        resultText.setText("Hello again, " + MrOrMs + " " + DBhandler.currentStudentName + ". Here's your result:");
        updateTable();

        knowMoreLabel.setText("Don't know much about " + getTopRankCollegeName() + "?");
    }

    public int updateTable() {

        int count = 0;
        try {
            Connection conn = DBhandler.getConnection();
            Statement stmt = conn.createStatement();
            int x = DBhandler.getStudentIDByName(DBhandler.currentStudentName);;
            ResultSet rs = stmt.executeQuery("SELECT collegeName AS 'College', rank AS 'Rank' "
                    + "FROM `student_college` "
                    + "INNER JOIN `college`  ON student_college.collegeID = college.collegeID "
                    + "WHERE student_college.studentID =  '" + x + "'  ORDER BY rank DESC");
//            this.resultTable.setModel(DbUtils.resultSetToTableModel(rs));
            this.resultTable.setModel(DbUtils.resultSetToTableModel(rs));
            while (rs.next()) {
                count += 1;
                System.out.println(rs.getString("College"));
            }
            stmt.close();
            conn.close();

            return count;
        } catch (Exception e) {

            e.printStackTrace();
        }
        return count;
    }

    public String getTopRankCollegeName() {

        String s = "";
        try {
            Connection conn = DBhandler.getConnection();
            Statement stmt = conn.createStatement();
            int x = DBhandler.getStudentIDByName(DBhandler.currentStudentName);;
            ResultSet rs = stmt.executeQuery("SELECT collegeName "
                    + "FROM `student_college` "
                    + "INNER JOIN `college`  ON student_college.collegeID = college.collegeID "
                    + "WHERE student_college.studentID =  '" + x + "'  ORDER BY rank DESC");

            if (rs.next()) {
                s = rs.getString("collegeName");
                return s;

            }
            stmt.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
        return s;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        resultText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        clickHereMoreInfoButton = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        knowMoreLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 255));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 8));

        resultText.setFont(new java.awt.Font("Hacen Vanilla", 0, 18)); // NOI18N
        resultText.setForeground(new java.awt.Color(102, 102, 102));
        resultText.setText("jLabel1");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project2/Project2i/top.png"))); // NOI18N

        clickHereMoreInfoButton.setText("Click Here!");
        clickHereMoreInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickHereMoreInfoButtonActionPerformed(evt);
            }
        });

        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        knowMoreLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        knowMoreLabel.setForeground(new java.awt.Color(153, 0, 51));
        knowMoreLabel.setText("Don't know much about Math? ");

        resultTable.setAutoCreateRowSorter(true);
        resultTable.setBackground(new java.awt.Color(0, 0, 0));
        resultTable.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        resultTable.setForeground(new java.awt.Color(255, 255, 255));
        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        resultTable.setGridColor(new java.awt.Color(204, 204, 204));
        resultTable.setInheritsPopupMenu(true);
        resultTable.setIntercellSpacing(new java.awt.Dimension(6, 3));
        resultTable.setRowHeight(30);
        jScrollPane2.setViewportView(resultTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(resultText, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(knowMoreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(clickHereMoreInfoButton)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(resultText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(knowMoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clickHereMoreInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void clickHereMoreInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clickHereMoreInfoButtonActionPerformed

        try {
            Connection conn = DBhandler.getConnection();
            Statement stmt = conn.createStatement();
            int x = DBhandler.getStudentIDByName(DBhandler.currentStudentName);;
            ResultSet rs = stmt.executeQuery("SELECT * FROM college WHERE collegeName = '" + getTopRankCollegeName() + "'");

            if (rs.next()) {
                Info info = new Info();
                info.getAboutCollegeTitle().setText("About " + getTopRankCollegeName() + "..");
                info.getInfoTextPane().setText(rs.getString("collegeInfo"));
                info.setVisible(true);
            }
            stmt.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }


    }//GEN-LAST:event_clickHereMoreInfoButtonActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        dispose();
        System.exit(0);

    }//GEN-LAST:event_exitBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Result r = new Result();
                r.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clickHereMoreInfoButton;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel knowMoreLabel;
    private javax.swing.JTable resultTable;
    private javax.swing.JLabel resultText;
    // End of variables declaration//GEN-END:variables
}
