/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.Date;

/**
 *
 * @author thiba
 */
public class Reservation {

    private double m_prix;
    private String m_nomAttraction;
    private String m_Login;
    private Date m_date;
    int m_nombre;

    public Reservation(String nomAtt, double prix, String Login, Date date, int nombre) {
        m_date = date;
        m_nomAttraction = nomAtt;
        m_prix = prix;
        m_Login = Login;
        m_nombre = nombre;
    }

    public Date getDate() {
        return m_date;
    }

    public int getNombre() {
        return m_nombre;
    }

    public double getPrix() {
        return m_prix;
    }

    public String getNom() {
        return m_nomAttraction;
    }

    public String getLogin() {
        return m_Login;
    }

    public String toString() {
        return m_date + m_nomAttraction + m_prix + m_Login + m_nombre;
    }

    public String DateToString() {
        String newDate = "";    //String we want
        String dayString = "";
        String MonthString = "";
        String YearString = "";
        int day, month, year;   //int buffer for the date

        day = m_date.getDate();

        if (day < 10) {
            dayString = "0" + Integer.toString(day);

        } else {
            dayString = Integer.toString(day);
        }

        month = m_date.getMonth() + 1;

        if (month < 10) {
            MonthString = "0" + Integer.toString(month);

        } else {
            MonthString = Integer.toString(month);
        }

        year = m_date.getYear() + 1900;

        YearString = Integer.toString(year);

        newDate = dayString + "/" + MonthString + "/" + YearString;
        return newDate;
    }
}
