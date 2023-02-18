/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.es37;

import java.util.ArrayList;

/**
 *
 * @author NICHOLASGHERBI
 */
public class Strumenti {
    private int matricola;
    private ArrayList<String> operatoriAbilitati;

    public Strumenti(int matricola, ArrayList<String> operatoriAbilitati) {
        this.matricola = matricola;
        this.operatoriAbilitati = operatoriAbilitati;
    }

    public int getMatricola() {
        return matricola;
    }
    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public ArrayList<String> getOperatoriAbilitati() {
        return operatoriAbilitati;
    }
    public void setOperatoriAbilitati(ArrayList<String> operatoriAbilitati) {
        this.operatoriAbilitati = operatoriAbilitati;
    }
}