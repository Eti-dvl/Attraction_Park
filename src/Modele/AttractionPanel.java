/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import VIEW.GuestBook;
import VIEW.MemberBook;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AttractionPanel {
       
    private JPanel attractionPanel;   
    private JButton bookButton;
    private JLabel description;
    private JLabel priceLabel;
    private JLabel attractionImage;
    private JLabel attractionTitle;
    private Ride m_ride;
    private JTextArea descriptiontxt;
    private JScrollPane jScrollPane1;
    
    
    public AttractionPanel(Ride ride)
    {
        m_ride = ride;
        build(ride);
    }    
    
    private void build(Ride ride)
    {
        m_ride=ride;
        
        bookButton = new JButton();
        attractionPanel = new JPanel();
        description = new JLabel();
        descriptiontxt = new JTextArea(8,20);
        priceLabel = new JLabel();
        attractionImage = new JLabel();
        attractionTitle = new JLabel(m_ride.getTitle());
        jScrollPane1 = new JScrollPane(descriptiontxt, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
        
        attractionPanel.setLayout(new GridBagLayout());
        
        attractionPanel.setBorder(BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200), 1));
        attractionPanel.setBackground(new java.awt.Color(255, 255, 255));
        
        //First add the title on the top
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.5;   
        gbc.anchor = GridBagConstraints.WEST;
        attractionTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        attractionPanel.add(attractionTitle, gbc);
        
        //add "description"
        description.setText("Description : ");
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        attractionPanel.add(description, gbc);
        
        //Add the description txt
        descriptiontxt.setWrapStyleWord(true);
        descriptiontxt.setLineWrap(true);
        descriptiontxt.setText(m_ride.getDescription());
        descriptiontxt.setEditable(false);
        jScrollPane1.setViewportView(descriptiontxt);
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        attractionPanel.add(jScrollPane1, gbc);
        
        
        //Add the price
        priceLabel.setText("Price : "+m_ride.getPrice()+" €");
        gbc.gridy =3;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        attractionPanel.add(priceLabel,gbc);
        
        //add the Image
        attractionImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/"+m_ride.getImage()+".jpg")));
        attractionImage.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight =3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.anchor = GridBagConstraints.LINE_END;
        attractionPanel.add(attractionImage, gbc);
        
        //Add the Button
        bookButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bookButton.setLabel("BOOK");
        bookButton.setBackground(new java.awt.Color(105, 204, 255));
        bookButton.setForeground(new java.awt.Color(255, 255, 255));
        bookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookButtonActionPerformed(evt);
            }
        });        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        attractionPanel.add(bookButton, gbc);        
    }
    
    private void BookButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        
        MemberBook a = new MemberBook(m_ride);
        GuestBook b = new GuestBook(m_ride);
        
        if(Main.connected.getOnline().getFlag() == true)
        {
            b.setVisible(false);
            a.setVisible(true);
        }
        else
        {
            a.setVisible(false);
            b.setVisible(true);            
        }
        
    }
    
    //GETTER
    public JPanel getPanel(){return attractionPanel;}
                
}
