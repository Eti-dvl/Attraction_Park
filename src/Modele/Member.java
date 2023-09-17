/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.Date;


public class Member extends Customer {
    
    private double m_discount;
    private String m_password;
    private Date m_birthday;
    private BooleanChangeTest m_onLine;
    
    public Member() 
    {       
        super("","","");
        
        m_birthday = new Date(); 
        m_discount = 0.0;
        m_onLine = new BooleanChangeTest(false);
    }
    
    public Member(String name, String lastname, String mail, Date birthday, double discount) {
        
        super(name, lastname, mail);
        
        m_birthday = birthday; 
        m_discount = discount;
        //m_onLine = new BooleanChangeTest(false);

    }
    
    public Date getBirth(){return m_birthday;}
    public double getDiscount(){return m_discount;}
    public BooleanChangeTest getOnline(){return m_onLine;}
    
    public void setOnline(boolean a){m_onLine.setFlag(a);}
    public void setOnline2(BooleanChangeTest a){m_onLine = a;}
    public void setBirth(Date a){m_birthday =a;}
    public void setDiscount(double a){m_discount = a;}
}

