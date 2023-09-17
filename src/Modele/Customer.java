/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

public class Customer {

    protected boolean m_connected;
    protected String m_name = "NULL";
    protected String m_lastName = "NULL";
    protected String m_mail;
    

    public Customer() {

    }

    public Customer(String name, String lastname, String mail) {

        m_connected = false;
        m_name = name;
        m_lastName = lastname;
        m_mail = mail;
        System.out.println(this.m_lastName + "créé ");
    }

    public void setConnected() {
        m_connected = true;
    }

    public void setDisconnected() {
        m_connected = false;
    }

    public String getName(){return m_name;}
    public String getLastName(){return m_lastName;}
    public String getMail(){return m_mail;}
    
    public void setName(String a){m_name=a;}
    public void setLastName(String a){m_lastName=a;}
    public void setMail(String a){m_mail=a;}

    public String getRecord() {
        return "JAI PAS FAIT LE SOUSPROGRAMME";
    }

    public String getLogin() {
        return "loginpardéfaut";
    }

}
