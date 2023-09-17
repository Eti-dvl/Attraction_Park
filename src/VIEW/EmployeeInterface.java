/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import Modele.Main;
import static Modele.Main.password;
import static Modele.Main.url;
import static Modele.Main.user;
import Modele.ResaQuantite;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Etienne
 */
public class EmployeeInterface extends javax.swing.JFrame {

    private DefaultTableModel memberModel = new DefaultTableModel();
    private DefaultTableModel reservationModel = new DefaultTableModel();
    private DefaultTableModel rideModel = new DefaultTableModel();
    private Object[][] members;
    private Object[][] reservations;
    private Object[][] ride;

    public EmployeeInterface() {
        initMemberTable();
        initReservationTable();
        initRideTable();
        initComponents();
    }

    private void initMemberTable() {

        String[] entetes = {"Name", "Last Name", "Email", "Birthday"};
        Connection com;

        try {

            com = DriverManager.getConnection(url, user, password);

            Statement stmt = com.createStatement();

            ResultSet resultat = stmt.executeQuery("SELECT name,lastname,email,birth FROM member");
            //on place le curseur sur le dernier tuple 
            resultat.last();
            //on récupère le numéro de la ligne 
            int i = resultat.getRow();
            System.out.println("nb " + i);

            members = new Object[i][4];

            i = 0;

            ResultSet rs = stmt.executeQuery("SELECT * FROM member");

            while (rs.next()) {

                members[i][0] = rs.getString("name");
                members[i][1] = rs.getString("lastname");
                members[i][2] = rs.getString("email");
                members[i][3] = rs.getString("birth");

                i++;
            }

            memberModel = new DefaultTableModel(members, entetes) {
                public boolean isCellEditable(int row, int column) {
                    return true;
                }
            };

            com.close();

        } catch (SQLException e) {
            System.out.println("exception : " + e.getMessage());
        }
    }

    private void initReservationTable() {

        Connection com;

        try {

            com = DriverManager.getConnection(url, user, password);

            Statement stmt = com.createStatement();

            //LOADING Reservation Table
            String[] entetes2 = {"Reservation ID" ,"Ride name", "Quantity", "Price", "Email", "Date"};
            ResultSet resultat2 = stmt.executeQuery("SELECT * FROM reservation");
            //on place le curseur sur le dernier tuple 
            resultat2.last();
            //on récupère le numéro de la ligne 
            int j = resultat2.getRow();
            System.out.println("nb " + j);

            reservations = new Object[j][6];

            j = 0;

            ResultSet rs2 = stmt.executeQuery("SELECT * FROM reservation");

            while (rs2.next()) {

                reservations[j][0] = rs2.getInt("reservationId");
                reservations[j][1] = rs2.getString("attractionName");
                reservations[j][2] = rs2.getInt("quantité");
                reservations[j][3] = rs2.getDouble("price");
                reservations[j][4] = rs2.getString("mail");
                reservations[j][5] = rs2.getString("date");

                j++;
            }

            reservationModel = new DefaultTableModel(reservations, entetes2) {
                public boolean isCellEditable(int row, int column) {
                    return true;
                }
            };

            com.close();
        } catch (SQLException e) {
            System.out.println("exception : " + e.getMessage());
        }
    }

    private void initRideTable() {

        Connection com;

        try {

            com = DriverManager.getConnection(url, user, password);

            Statement stmt = com.createStatement();

            //LOADING Reservation Table
            String[] entetes = {"Name", "Max places", "Description", "Price", "Image", "Discount"};
            ResultSet resultat = stmt.executeQuery("SELECT * FROM ride");
            //on place le curseur sur le dernier tuple 
            resultat.last();
            //on récupère le numéro de la ligne 
            int j = resultat.getRow();
            System.out.println("nb " + j);

            ride = new Object[j][6];

            j = 0;

            ResultSet rs = stmt.executeQuery("SELECT * FROM ride");

            while (rs.next()) {

                ride[j][0] = rs.getString("name");
                ride[j][1] = rs.getInt("availability");
                ride[j][2] = rs.getString("features");
                ride[j][3] = rs.getDouble("price");
                ride[j][4] = rs.getString("image");
                ride[j][5] = rs.getString("discount");

                j++;
            }

            rideModel = new DefaultTableModel(ride, entetes) {
                public boolean isCellEditable(int row, int column) {
                    return true;
                }
            };

            com.close();
        } catch (SQLException e) {
            System.out.println("exception : " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        memberTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        reservationTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        rideTable = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        discountTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        memberTable.setModel(memberModel);
        jScrollPane1.setViewportView(memberTable);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome, "+Main.employeeCo.getM_name());

        jButton3.setBackground(new java.awt.Color(255, 255, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Member Records");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Reservations");

        jButton1.setBackground(new java.awt.Color(0, 255, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Remove member");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        reservationTable.setModel(reservationModel);
        jScrollPane3.setViewportView(reservationTable);

        jButton2.setBackground(new java.awt.Color(0, 255, 255));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Remove reservation");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Rides");

        rideTable.setModel(rideModel);
        jScrollPane4.setViewportView(rideTable);

        jButton4.setBackground(new java.awt.Color(255, 51, 51));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Remove ride");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 255, 255));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Add ride");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(102, 255, 102));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Change ride discount");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        discountTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountTextFieldActionPerformed(evt);
            }
        });

        jLabel5.setText("%");

        jButton7.setText("Ask disponibilities");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Sort by popularity");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane4)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(jLabel4)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(discountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton7)
                            .addGap(26, 26, 26)))
                    .addComponent(jButton8))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(discountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addContainerGap(251, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (memberTable.getSelectedRow() != -1) {

            
            System.out.println("TEST : "+memberModel.getValueAt(memberTable.getSelectedRow(), 2));
            Connection com;
            
            try {
                com = DriverManager.getConnection(Main.url, Main.user, Main.password);

                Statement stmt = com.createStatement();

                String sqlStatement = "DELETE FROM member WHERE email = '"+ memberModel.getValueAt(memberTable.getSelectedRow(), 2)+"'";
                stmt.executeUpdate(sqlStatement);
                
                com.close();
            } catch (SQLException e) {
                System.out.println("exception : " + e.getMessage());
            }
            memberModel.removeRow(memberTable.getSelectedRow());

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (reservationTable.getSelectedRow() != -1) {
            Connection com;
            
            try {
                com = DriverManager.getConnection(Main.url, Main.user, Main.password);

                Statement stmt = com.createStatement();

                String sqlStatement = "DELETE FROM reservation WHERE reservationId = '"+ reservationModel.getValueAt(reservationTable.getSelectedRow(), 0)+"'";
                stmt.executeUpdate(sqlStatement);
                
                com.close();
            } catch (SQLException e) {
                System.out.println("exception : " + e.getMessage());
            }
            
            reservationModel.removeRow(reservationTable.getSelectedRow());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        EmployeeCustomer a = new EmployeeCustomer();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (rideTable.getSelectedRow() != -1) {
            
            Connection com;
            
            try {
                com = DriverManager.getConnection(Main.url, Main.user, Main.password);

                Statement stmt = com.createStatement();

                String sqlStatement = "DELETE FROM ride WHERE name = '"+ rideModel.getValueAt(rideTable.getSelectedRow(), 0)+"'";
                stmt.executeUpdate(sqlStatement);
                rideModel.removeRow(rideTable.getSelectedRow());
                com.close();
            } catch (SQLException e) {
                System.out.println("exception : " + e.getMessage());
            }
            
            
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        // TODO add your handling code here:
        EmployeeAddRide add = new EmployeeAddRide();
        add.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int test = 0;
        
        if(discountTextField.equals("")){
            test = 1;
        }
        
        if (rideTable.getSelectedRow()!= -1 && test!=1) {
            
            Integer discount = Integer.parseInt(discountTextField.getText());
            System.out.println("TEST :"+ discount);
            Connection com;
            
            try {
                com = DriverManager.getConnection(Main.url, Main.user, Main.password);

                Statement stmt = com.createStatement();
                

                String sqlStatement = "UPDATE ride SET discount ="+discount+"  WHERE name ='"+rideModel.getValueAt(rideTable.getSelectedRow(), 0)+"'";
                stmt.executeUpdate(sqlStatement);
                rideModel.setValueAt(discount, rideTable.getSelectedRow(), 5);
                
                com.close();
            } catch (SQLException e) {
                System.out.println("exception : " + e.getMessage());
            }
            
            
        }else
        {
            JOptionPane.showMessageDialog(null, "NO DISCOUNT ENTERED OR NO RIDE SELECTED");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void discountTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_discountTextFieldActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
         int test = 0;

        if (discountTextField.equals("")) {
            test = 1;
        }

        if (rideTable.getSelectedRow() != -1 && test != 1) {

            Connection com;

            try {
                com = DriverManager.getConnection(Main.url, Main.user, Main.password);

                Statement stmt = com.createStatement();

                String sqlStatement2 = "SELECT quantité,date FROM reservation WHERE attractionName ='" + rideModel.getValueAt(rideTable.getSelectedRow(), 0) + "'";

                ///////////////////////////::
                int res = 0;

                ArrayList<ResaQuantite> ResaQuantite = new ArrayList();

                ArrayList<String> date2 = new ArrayList();

                ArrayList<Date> newDate = new ArrayList();

                ArrayList<Integer> quantiteTotaleJournaliere = new ArrayList();

                ResultSet rs = stmt.executeQuery(sqlStatement2);

                ResultSet rs2 = stmt.executeQuery(sqlStatement2);
                String date3;
                int quantite3;

                while (rs2.next()) {

                    quantite3 = rs2.getInt(1);
                    date3 = rs2.getString(2);

                    ResaQuantite variable = new ResaQuantite(date3, quantite3);

                    boolean check = false;
                    for (int k = 0; k < ResaQuantite.size(); k++) {

                        if (date3.equals(ResaQuantite.get(k).getDate())) {
                            ResaQuantite.get(k).setQuantite(quantite3);
                            check = true;
                            System.out.println("TROU");
                        } else {
                        }
                    }

                    if (check == false) {
                        ResaQuantite.add(variable);
                    }

                }

                for (int j = 0; j < ResaQuantite.size(); j++) {

                    ResaQuantite.get(j).toString2();
                    System.out.println("Place 1 ?" + ResaQuantite.get(j).getQuantite());
                    int nombrePlace = (int) rideModel.getValueAt(rideTable.getSelectedRow(), 1);
                    System.out.println("Place 1 !!!!" + nombrePlace);

                    if (ResaQuantite.get(j).getQuantite() >= nombrePlace) {
                        newDate.add(Register.toDate(ResaQuantite.get(j).getDate()));
                    }
                    System.out.println("Nom ?" + rideModel.getValueAt(rideTable.getSelectedRow(), 0));
                    System.out.println("place2" + rideModel.getValueAt(rideTable.getSelectedRow(), 1));

                }

                Date[] variable = new Date[newDate.size()];
                for (int i = 0; i < newDate.size(); i++) {
                    Date date33 = newDate.get(i);
                    variable[i] = date33;
                }
                jXDatePicker1.getMonthView().setUnselectableDates(variable);

/////////////////////////////////////////
///////////////////////////:
                com.close();
            } catch (SQLException e) {
                System.out.println("exception : " + e.getMessage());
            }

        } else {

        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        Connection com;

        try {

            com = DriverManager.getConnection(Main.url, Main.user, Main.password);

            Statement stmt = com.createStatement();

            String sqlStatement = "SELECT quantité, attractionName FROM reservation";

            ArrayList<ResaQuantite> ResaQuantite = new ArrayList();

            ResultSet rs2 = stmt.executeQuery(sqlStatement);

            String ride3;
            int quantite3;

            while (rs2.next()) {

                quantite3 = rs2.getInt(1);
                ride3 = rs2.getString(2);

                ResaQuantite variable = new ResaQuantite(ride3, quantite3);

                boolean check = false;
                for (int k = 0; k < ResaQuantite.size(); k++) {

                    if (ride3.equals(ResaQuantite.get(k).getDate())) {
                        ResaQuantite.get(k).setQuantite(quantite3);
                        check = true;
                        System.out.println("TROU");
                    } else {
                    }
                }
                if (check == false) {
                    ResaQuantite.add(variable);
                }
            }
            for (int k = 0; k < ResaQuantite.size(); k++) {
                sqlStatement = "UPDATE ride SET popularity="+ResaQuantite.get(k).getQuantite()+ "  WHERE name ='" + ResaQuantite.get(k).getDate() + "'";
                    System.out.println("Quantité resa pour " + ResaQuantite.get(k).getDate() + " : " + ResaQuantite.get(k).getQuantite());
                    stmt.executeUpdate(sqlStatement);
                }
            
            String[] entetes = {"Name", "Max places", "Description", "Price", "Image", "Discount"};
            ResultSet resultat = stmt.executeQuery("SELECT * FROM ride");
            //on place le curseur sur le dernier tuple 
            resultat.last();
            //on récupère le numéro de la ligne 
            int j = resultat.getRow();
            System.out.println("nb " + j);

            ride = new Object[j][6];

            j = 0;

            ResultSet rs = stmt.executeQuery("SELECT * FROM ride ORDER BY popularity DESC");

            while (rs.next()) {

                ride[j][0] = rs.getString("name");
                ride[j][1] = rs.getInt("availability");
                ride[j][2] = rs.getString("features");
                ride[j][3] = rs.getDouble("price");
                ride[j][4] = rs.getString("image");
                ride[j][5] = rs.getString("discount");

                j++;
            }

            rideModel = new DefaultTableModel(ride, entetes) {
                public boolean isCellEditable(int row, int column) {
                    return true;
                }
            };
            com.close();
            
        } catch (SQLException e) {
            System.out.println("exception : " + e.getMessage());
        }
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeInterface.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeInterface.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeInterface.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeInterface.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField discountTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JTable memberTable;
    private javax.swing.JTable reservationTable;
    private javax.swing.JTable rideTable;
    // End of variables declaration//GEN-END:variables
}
