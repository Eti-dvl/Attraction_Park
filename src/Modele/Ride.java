/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author Etienne
 */
public class Ride {

    private String m_title;
    private String m_image;
    private String m_description;
    private Double m_price;
    private int m_max;
    private int m_discount;

    public Ride()
    {
        m_title ="Yes";
        m_image = "ride1";
        m_description = "..........";
        m_price = 0.0;
    }

    public Ride(String a, String b, String c,Double d)
    {
        m_title = a;
        m_image = b;
        m_description = c;
        m_price = d;
    }

    public Ride(String nom, int max, String feat, double prix, String image, int discount){
        m_title = nom;
        m_max = max;
        m_description = feat;
        m_price = prix;
        m_image = image;
        m_discount = discount;
        
    }

    public String getTitle(){return m_title;}
    public String getImage(){return m_image;}
    public String getDescription(){return m_description;}
    public Double getPrice(){return m_price;}
    public int getMax(){return m_max;}
    public int getDiscount(){return m_discount;}


}
