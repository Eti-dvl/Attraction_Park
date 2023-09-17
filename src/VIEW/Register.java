/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import Modele.Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author Etienne
 */
public class Register extends javax.swing.JFrame {

    String m_fName;
    String m_lName;
    String m_mail;
    Date m_born;
    String m_password1;
    String m_password2;
    double m_discount;

    public Register() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        FirstNameTextField = new javax.swing.JTextField();
        LastNameTextField = new javax.swing.JTextField();
        MailTextField = new javax.swing.JTextField();
        PasswordField = new javax.swing.JPasswordField();
        FirstNameLabel = new javax.swing.JLabel();
        LastNameLabel = new javax.swing.JLabel();
        MailLabel = new javax.swing.JLabel();
        DateOfBirthLabel = new javax.swing.JLabel();
        PasswordLabel = new javax.swing.JLabel();
        ConfirmPasswordField = new javax.swing.JPasswordField();
        ConfirmPasswordLabel = new javax.swing.JLabel();
        ConfirmButton = new javax.swing.JButton();
        DateOfBirth = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Panel.setBackground(new java.awt.Color(255, 255, 255));

        Title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Title.setText("Register");

        FirstNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstNameTextFieldActionPerformed(evt);
            }
        });
        FirstNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FirstNameTextFieldKeyPressed(evt);
            }
        });

        LastNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastNameTextFieldActionPerformed(evt);
            }
        });

        MailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MailTextFieldActionPerformed(evt);
            }
        });

        PasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFieldActionPerformed(evt);
            }
        });

        FirstNameLabel.setText("First Name");

        LastNameLabel.setText("Last Name");

        MailLabel.setText("Email Address");

        DateOfBirthLabel.setText("Date of Birth");

        PasswordLabel.setText("Password");

        ConfirmPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmPasswordFieldActionPerformed(evt);
            }
        });

        ConfirmPasswordLabel.setText("Confirm Password");

        ConfirmButton.setBackground(new java.awt.Color(102, 204, 255));
        ConfirmButton.setForeground(new java.awt.Color(255, 255, 255));
        ConfirmButton.setText("Confirm");
        ConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmButtonActionPerformed(evt);
            }
        });

        try {
            DateOfBirth.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        DateOfBirth.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DateOfBirth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateOfBirthActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(MailLabel)
                            .addComponent(DateOfBirthLabel)
                            .addComponent(DateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PasswordLabel)
                            .addComponent(ConfirmPasswordLabel)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Title)
                                    .addComponent(FirstNameLabel))
                                .addGap(18, 18, 18)
                                .addComponent(LastNameLabel))
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(FirstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(MailTextField)
                            .addComponent(PasswordField)
                            .addComponent(ConfirmPasswordField))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(ConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addComponent(Title)
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FirstNameLabel)
                    .addComponent(LastNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FirstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(DateOfBirthLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PasswordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ConfirmPasswordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ConfirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ConfirmButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FirstNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstNameTextFieldActionPerformed

    }//GEN-LAST:event_FirstNameTextFieldActionPerformed

    private void LastNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastNameTextFieldActionPerformed

    }//GEN-LAST:event_LastNameTextFieldActionPerformed

    private void MailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MailTextFieldActionPerformed

    }//GEN-LAST:event_MailTextFieldActionPerformed

    private void ConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmButtonActionPerformed
        boolean success = true;

        m_fName = FirstNameTextField.getText();
        System.out.println(m_fName);
        m_lName = LastNameTextField.getText();
        System.out.println(m_lName);
        String date = DateOfBirth.getText();   //String we want ton convert
        System.out.println(date);
        m_mail = MailTextField.getText();
        System.out.println(m_mail);
        m_password1 = PasswordField.getText();
        System.out.println(m_password1);
        m_password2 = ConfirmPasswordField.getText();
        System.out.println(m_password2);

        if (m_fName.equals("")) {
            success = false;
            JOptionPane.showMessageDialog(null, "Missing First name");
        } else if (m_lName.equals("")) {
            success = false;
            JOptionPane.showMessageDialog(null, "Missing Last name");
        } else if (date.equals("")) {
            success = false;
            JOptionPane.showMessageDialog(null, "Missing Date of Birth");
        } else if (m_mail.equals("")) {
            success = false;
            JOptionPane.showMessageDialog(null, "Missing Email address");
        } else if (m_password1.equals("")) {
            success = false;
            JOptionPane.showMessageDialog(null, "Missing Password");
        } else if (m_password2.equals("")) {
            success = false;
            JOptionPane.showMessageDialog(null, "Missing Confirmation Password");
        } else if (!m_password2.equals(m_password1)) {
            success = false;
            JOptionPane.showMessageDialog(null, "This is not the same Password");
        }

        if (success == true) {
            //Constructor
            
            m_born = toDate(date);
            System.out.println(m_born);

            Connection com;

            try {
                com = DriverManager.getConnection(Main.url, Main.user, Main.password);

                //String sqlStatement = "INSERT INTO member (name, lastname, email, birth, password) "
                //+ "VALUES(" + m_fName + "," + m_lName + ",20," + m_mail + "," + m_password1 + ")";
                String sqlStatement = "INSERT INTO member (name, lastname, email, birth, password) "
                        + "VALUES(?,?,?,?,?)";

                PreparedStatement pstmt = com.prepareStatement(sqlStatement);
                java.util.Date ajdh = java.util.Calendar.getInstance().getTime();
                System.out.println(ajdh);

                

                pstmt.setString(1, m_fName);
                pstmt.setString(2, m_lName);
                pstmt.setString(3, m_mail);
                pstmt.setString(4, date);
                pstmt.setString(5, m_password1);

                int rows = pstmt.executeUpdate();

                com.close();
                JOptionPane.showMessageDialog(null, "SUCCESS !\nWELCOME : " + m_fName + " " + m_lName);
                dispose();
            } catch (SQLException e) {
                System.out.println("exception : " + e.getMessage());
                JOptionPane.showMessageDialog(null, "EMAIL INVALID/ALREADY EXISTS");
            }

            
        }
    }//GEN-LAST:event_ConfirmButtonActionPerformed

    private void ConfirmPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmPasswordFieldActionPerformed

    }//GEN-LAST:event_ConfirmPasswordFieldActionPerformed

    //
    private void DateOfBirthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateOfBirthActionPerformed

    }//GEN-LAST:event_DateOfBirthActionPerformed

    private void FirstNameTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FirstNameTextFieldKeyPressed

    }//GEN-LAST:event_FirstNameTextFieldKeyPressed

    private void PasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFieldActionPerformed

    }//GEN-LAST:event_PasswordFieldActionPerformed

    public static Date toDate(String buff) {
        String res = "";    //Buffer to convert section of String in integer
        int day, month, year;   //int buffer for the date

        System.out.println(buff);

        res = buff.substring(0, 2);
        day = Integer.parseInt(res);

        res = buff.substring(3, 5);
        month = Integer.parseInt(res);

        res = buff.substring(6, 10);
        year = Integer.parseInt(res);

        return new Date(year - 1900, month - 1, day);  //Création de la date 
    }

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConfirmButton;
    private javax.swing.JPasswordField ConfirmPasswordField;
    private javax.swing.JLabel ConfirmPasswordLabel;
    private javax.swing.JFormattedTextField DateOfBirth;
    private javax.swing.JLabel DateOfBirthLabel;
    private javax.swing.JLabel FirstNameLabel;
    private javax.swing.JTextField FirstNameTextField;
    private javax.swing.JLabel LastNameLabel;
    private javax.swing.JTextField LastNameTextField;
    private javax.swing.JLabel MailLabel;
    private javax.swing.JTextField MailTextField;
    private javax.swing.JPanel Panel;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JLabel Title;
    // End of variables declaration//GEN-END:variables
}
