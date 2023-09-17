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
public class ResaQuantite {

    String m_date;
    int m_quantite;

    public ResaQuantite(String date, int quantite) {
        m_date = date;
        m_quantite = quantite;
    }

    public void toString2() {
        System.out.println(m_date + "   " + m_quantite);
    }

    public void setQuantite(int quantite) {
        m_quantite += quantite;
    }

    public int getQuantite() {
        return m_quantite;
    }

    public String getDate() {
        return m_date;
    }
}