/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import VIEW.BddConnection;
import java.util.ArrayList;

/**
 *
 * @author Etienne
 */
public class Main {

    /**
     * @param args the command line arguments
     * 
     */
    public static Member connected = new Member();
    public static Employee employeeCo;
    public static ArrayList<Reservation> AllResa = new ArrayList<>();
    public static final String url = "jdbc:mysql://localhost:3306/park?autoReconnect=true&useSSL=false";
    public static String user;
    public static String password;
    public static ArrayList<Ride> attractions = new ArrayList();
    
    
    
    public static void main(String[] args) {
        
        BddConnection bdd = new BddConnection();
        bdd.setVisible(true);                   
    }
    
}