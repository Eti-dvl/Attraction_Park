/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;


public class Employee {

    
    
    private String m_name;
    private String m_lastName;
    private String m_mail;
  
    public Employee()
    {
        m_name = "";
        m_lastName = "";
        m_mail = "";
    } 
    
    public Employee(String name, String lastName, String mail)
    {
        m_name = name;
        m_lastName = lastName;
        m_mail = mail;
    }
    
    
    //SETTERS
    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public void setM_lastName(String m_lastName) {
        this.m_lastName = m_lastName;
    }

    public void setM_mail(String m_mail) {
        this.m_mail = m_mail;
    }

    //GETTERS
    public String getM_name() {
        return m_name;
    }

    public String getM_lastName() {
        return m_lastName;
    }

    public String getM_mail() {
        return m_mail;
    }
    
}
