/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import Modele.Main;
import Modele.ResaQuantite;
import Modele.Reservation;
import Modele.Ride;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Etienne
 */
public class MemberBook extends javax.swing.JFrame {

    private int m_quantity;
    private Date m_date;
    private Ride m_ride;

    public MemberBook(Ride ride) {
        m_ride = ride;
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

        LowPanel = new javax.swing.JPanel();
        ImageLabel = new javax.swing.JLabel();
        RideName = new javax.swing.JLabel();
        ReservationLabel = new javax.swing.JLabel();
        QuantityLabel = new javax.swing.JLabel();
        QuantitySpinner = new javax.swing.JSpinner();
        AddBasketButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jXDatePicker = new org.jdesktop.swingx.JXDatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        LowPanel.setBackground(new java.awt.Color(255, 255, 255));

        ImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/"+m_ride.getImage()+".jpg")));
        ImageLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ImageLabel.setPreferredSize(new java.awt.Dimension(2, 200));

        RideName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        RideName.setText(m_ride.getTitle());
        RideName.setToolTipText("");

        ReservationLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ReservationLabel.setText("Reservation date");

        QuantityLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        QuantityLabel.setText("Tickets quantity");

        QuantitySpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        QuantitySpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                QuantitySpinnerStateChanged(evt);
            }
        });

        AddBasketButton.setBackground(new java.awt.Color(105, 204, 255));
        AddBasketButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AddBasketButton.setForeground(new java.awt.Color(255, 255, 255));
        AddBasketButton.setText("Add to my basket");
        AddBasketButton.setPreferredSize(new java.awt.Dimension(155, 30));
        AddBasketButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBasketButtonActionPerformed(evt);
            }
        });

        jTextPane2.setEditable(false);
        jTextPane2.setText(m_ride.getDescription());
        jScrollPane1.setViewportView(jTextPane2);

        boolean success = true;
        m_date = jXDatePicker.getDate();
        System.out.println("Jdatepicker    "+m_date);
        m_quantity = (int) QuantitySpinner.getValue();
        Date m_date = jXDatePicker.getDate();

        String day = "";
        String month = "";
        String date = "";

        if (m_date != null) {
            if (m_date.getDate() < 10) {
                day = "0" + m_date.getDate();
            } else {
                day = "" + m_date.getDate();
            }

            if (m_date.getMonth() < 10) {
                month = "0" + (m_date.getMonth() + 1);
            } else {
                month = "" + (m_date.getMonth() + 1);
            }
            date = day + "/" + month + "/" + (1900 + m_date.getYear());

            System.out.println("DAte :" + date);
        }
        Connection com;

        try {

            com = DriverManager.getConnection(Main.url, Main.user, Main.password);

            Statement stmt = com.createStatement();

            String sqlStatement = "SELECT quantité FROM reservation WHERE attractionName ='" + m_ride.getTitle() + "' AND date ='" + date + "'";

            String sqlStatement2 = "SELECT quantité,date FROM reservation WHERE attractionName ='" + m_ride.getTitle() + "'";

            int res = 0;

            ArrayList<ResaQuantite> ResaQuantite = new ArrayList();

            ArrayList<String> date2 = new ArrayList();

            ArrayList<Integer> test = new ArrayList();

            ArrayList<Date> newDate = new ArrayList();

            ArrayList<Integer> quantiteTotaleJournaliere = new ArrayList();

            ResultSet rs = stmt.executeQuery(sqlStatement);

            while (rs.next()) {
                res += rs.getInt(1);

            }
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
                if (ResaQuantite.get(j).getQuantite() >= m_ride.getMax()) {
                    newDate.add(Register.toDate(ResaQuantite.get(j).getDate()));

                }

            }

            Date[] variable = new Date[newDate.size()];
            for (int i = 0; i < newDate.size(); i++) {
                Date date33 = newDate.get(i);
                variable[i] = date33;
            }
            jXDatePicker.getMonthView().setUnselectableDates(variable);

            /////////////////////////////////////////
            for (int i = 0; i < Main.AllResa.size(); i++) {

                if (Main.AllResa.get(i).getNom() == m_ride.getTitle() && Main.AllResa.get(i).DateToString() == date) {
                    res += Main.AllResa.get(i).getNombre();
                }
            }

            System.out.println("Num res :" + res);

            if ((res + m_quantity) <= m_ride.getMax()&&m_date!=null) {

                double price = m_quantity;
                price *= m_ride.getPrice();

                Reservation nv = new Reservation(m_ride.getTitle(), price, Main.connected.getMail(), m_date, m_quantity);
                JOptionPane.showMessageDialog(null, "ADDED TO BASKET");
                System.out.println(nv.toString());
                Main.AllResa.add(nv);
            }else if(m_date==null)
            {

            }
            else {

                JOptionPane.showMessageDialog(null, "NOT ENOUGH PLACES FOR THIS DATE\n" + (m_ride.getMax() - res) + " PLACES REMAINING");
            }

            com.close();
        } catch (SQLException e) {
            System.out.println("exception : " + e.getMessage());
        }

        javax.swing.GroupLayout LowPanelLayout = new javax.swing.GroupLayout(LowPanel);
        LowPanel.setLayout(LowPanelLayout);
        LowPanelLayout.setHorizontalGroup(
            LowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LowPanelLayout.createSequentialGroup()
                .addGroup(LowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LowPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(LowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(LowPanelLayout.createSequentialGroup()
                                .addGroup(LowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ReservationLabel)
                                    .addComponent(QuantityLabel))
                                .addGap(18, 18, 18)
                                .addGroup(LowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jXDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(QuantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(LowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(LowPanelLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LowPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AddBasketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(LowPanelLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(RideName)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LowPanelLayout.setVerticalGroup(
            LowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LowPanelLayout.createSequentialGroup()
                .addComponent(RideName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(ImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(LowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReservationLabel))
                .addGap(18, 18, 18)
                .addGroup(LowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(QuantityLabel)
                    .addComponent(QuantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddBasketButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LowPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LowPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void QuantitySpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_QuantitySpinnerStateChanged

    }//GEN-LAST:event_QuantitySpinnerStateChanged

    private void AddBasketButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBasketButtonActionPerformed

        boolean success = true;
        m_date = jXDatePicker.getDate();
        System.out.println("Jdatepicker    " + m_date);
        m_quantity = (int) QuantitySpinner.getValue();
        Date m_date = jXDatePicker.getDate();

        String day = "";
        String month = "";
        String date = "";

        if (m_date != null) {
            if (m_date.getDate() < 10) {
                day = "0" + m_date.getDate();
            } else {
                day = "" + m_date.getDate();
            }

            if (m_date.getMonth() < 10) {
                month = "0" + (m_date.getMonth() + 1);
            } else {
                month = "" + (m_date.getMonth() + 1);
            }
            date = day + "/" + month + "/" + (1900 + m_date.getYear());

            System.out.println("DAte :" + date);
        }
        Connection com;

        try {

            com = DriverManager.getConnection(Main.url, Main.user, Main.password);

            Statement stmt = com.createStatement();

            String sqlStatement = "SELECT quantité FROM reservation WHERE attractionName ='" + m_ride.getTitle() + "' AND date ='" + date + "'";

            String sqlStatement2 = "SELECT quantité,date FROM reservation WHERE attractionName ='" + m_ride.getTitle() + "'";

            int res = 0;

            ArrayList<ResaQuantite> ResaQuantite = new ArrayList();

            ArrayList<String> date2 = new ArrayList();

            ArrayList<Integer> test = new ArrayList();

            ArrayList<Date> newDate = new ArrayList();

            ArrayList<Integer> quantiteTotaleJournaliere = new ArrayList();

            ResultSet rs = stmt.executeQuery(sqlStatement);

            while (rs.next()) {
                res += rs.getInt(1);

            }
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
                if (ResaQuantite.get(j).getQuantite() >= m_ride.getMax()) {
                    newDate.add(Register.toDate(ResaQuantite.get(j).getDate()));

                }

            }

            Date[] variable = new Date[newDate.size()];
            for (int i = 0; i < newDate.size(); i++) {
                Date date33 = newDate.get(i);
                variable[i] = date33;
            }
            jXDatePicker.getMonthView().setUnselectableDates(variable);

/////////////////////////////////////////
            for (int i = 0; i < Main.AllResa.size(); i++) {

                if (Main.AllResa.get(i).getNom() == m_ride.getTitle() && Main.AllResa.get(i).DateToString() == date) {
                    res += Main.AllResa.get(i).getNombre();
                }
            }

            System.out.println("Num res :" + res);

            if ((res + m_quantity) <= m_ride.getMax() && m_date != null) {

                double price = m_quantity;
                price *= m_ride.getPrice();
                price -= m_ride.getPrice()*m_ride.getDiscount()/100;

                Reservation nv = new Reservation(m_ride.getTitle(), price, Main.connected.getMail(), m_date, m_quantity);
                JOptionPane.showMessageDialog(null, "ADDED TO BASKET");
                System.out.println(nv.toString());
                Main.AllResa.add(nv);
            } else if (m_date == null) {
                JOptionPane.showMessageDialog(null, "UNSELECTABLE DATE");

            } else {

                JOptionPane.showMessageDialog(null, "NOT ENOUGH PLACES FOR THIS DATE\n" + (m_ride.getMax() - res) + " PLACES REMAINING");
            }

            com.close();
        } catch (SQLException e) {
            System.out.println("exception : " + e.getMessage());
        }

    }//GEN-LAST:event_AddBasketButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        //</editor-fold>
        //</editor-fold>
        //Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemberBook(new Ride()).setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBasketButton;
    private javax.swing.JLabel ImageLabel;
    private javax.swing.JPanel LowPanel;
    private javax.swing.JLabel QuantityLabel;
    private javax.swing.JSpinner QuantitySpinner;
    private javax.swing.JLabel ReservationLabel;
    private javax.swing.JLabel RideName;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane2;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker;
    // End of variables declaration//GEN-END:variables
}