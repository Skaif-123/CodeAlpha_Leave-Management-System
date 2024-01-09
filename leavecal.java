package leavemanagement;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class leavecal extends javax.swing.JFrame {
    
    public leavecal() {
        initComponents();
        LoadEmpno();
        Loadleave();
        
    }
    
    Connection con;
    PreparedStatement pst;
    PreparedStatement pst1;
    PreparedStatement pst2;
    int casual = 0;
    int annual = 0;
    int medical = 0;
    
    public void Connection() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/leavemangement", "root", "");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void Loadleave() {
        
        Connection();
        
        String empno = txtNo.getSelectedItem().toString();
        try {
            pst = con.prepareStatement("select * from leaveinformation where emono = ?");
            pst.setString(1, empno);
            ResultSet rs2 = pst.executeQuery();
            
            if (rs2.next() == false) {
                JOptionPane.showMessageDialog(this, "Leave Information Error");
                
            } else {
                casual = rs2.getInt("casual");
                annual = rs2.getInt("annual");
                medical = rs2.getInt("medical");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void LoadEmpno() {
        Connection();
        try {
            pst = con.prepareStatement("select * from registration");
            ResultSet rs = pst.executeQuery();
//            txtNo.removeAllItems();

            while (rs.next()) {
                txtNo.addItem(rs.getString("emono"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtCategory = new javax.swing.JTextField();
        txtDays = new javax.swing.JSpinner();
        txtNo = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        rcasual = new javax.swing.JRadioButton();
        rannual = new javax.swing.JRadioButton();
        rmedical = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employee Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Employee No");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Category");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Days");

        txtName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        txtCategory.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        txtDays.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N

        txtNo.setBackground(new java.awt.Color(51, 255, 255));
        txtNo.setFont(new java.awt.Font("Georgia", 1, 15)); // NOI18N
        txtNo.setForeground(new java.awt.Color(255, 255, 0));
        txtNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNo, 0, 146, Short.MAX_VALUE)
                    .addComponent(txtName)
                    .addComponent(txtCategory)
                    .addComponent(txtDays, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Leave Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        rcasual.setBackground(new java.awt.Color(255, 255, 255));
        rcasual.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rcasual.setForeground(new java.awt.Color(255, 255, 255));
        rcasual.setText("Casual");
        rcasual.setContentAreaFilled(false);

        rannual.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rannual.setForeground(new java.awt.Color(255, 255, 255));
        rannual.setText("Annual");

        rmedical.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rmedical.setForeground(new java.awt.Color(255, 255, 255));
        rmedical.setText("Medical");
        rmedical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmedicalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rmedical)
                    .addComponent(rannual)
                    .addComponent(rcasual))
                .addGap(37, 37, 37))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(rcasual)
                .addGap(59, 59, 59)
                .addComponent(rannual)
                .addGap(68, 68, 68)
                .addComponent(rmedical)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("CANCEL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Loadleave();
        
        int bleave = 0;
        String empno = txtNo.getSelectedItem().toString();
        int days = Integer.parseInt(txtDays.getValue().toString());
        
        if (rcasual.isSelected() == true) {
            bleave = casual - days;
            
            if (bleave < 0) {
                JOptionPane.showMessageDialog(this, "You have casual leave: " + casual);
            } else {
                try {
                    pst = con.prepareStatement("update leaveinformation set casual= ? where emono=?");
                    pst.setInt(1, bleave);
                    pst.setString(2, empno);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Your Casual Leave Updated");
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (rannual.isSelected() == true) {
            bleave = annual - days;
            if (bleave < 0) {
                JOptionPane.showMessageDialog(this, "You have annual leave: " + annual);
            } else {
                try {
                    pst = con.prepareStatement("update leaveinformation set annual= ? where emono=?");
                    pst.setInt(1, bleave);
                    pst.setString(2, empno);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Your Annual Leave Updated");
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
        } else if (rmedical.isSelected() == true) {
            bleave = medical - days;
            if (bleave < 0) {
                JOptionPane.showMessageDialog(this, "You have medical leave: " + medical);
            } else {
                try {
                    pst = con.prepareStatement("update leaveinformation set medical= ? where emono=?");
                    pst.setInt(1, bleave);
                    pst.setString(2, empno);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Your Medical Leave Updated");
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
        }
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoActionPerformed
        String empno = txtNo.getSelectedItem().toString();
        Connection();
        try {
            pst = con.prepareStatement("select * from registration where emono=?");
            pst.setString(1, empno);
            ResultSet rs1 = pst.executeQuery();
            
            if (rs1.next() == false) {
                JOptionPane.showMessageDialog(this, "Emp no error");
            } else {
                String name = rs1.getString("empname");
                txtName.setText(name.trim());
                String category = rs1.getString("category");
                txtCategory.setText(category.trim());
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }//GEN-LAST:event_txtNoActionPerformed

    private void rmedicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmedicalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rmedicalActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        new FrontButton().setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(leavecal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(leavecal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(leavecal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(leavecal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              new leavecal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton rannual;
    private javax.swing.JRadioButton rcasual;
    private javax.swing.JRadioButton rmedical;
    private javax.swing.JTextField txtCategory;
    private javax.swing.JSpinner txtDays;
    private javax.swing.JTextField txtName;
    private javax.swing.JComboBox<String> txtNo;
    // End of variables declaration//GEN-END:variables
}