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
public class Analisi {
    private ArrayList<Strumenti> strumenti;
    private String nome;
    private int tempoDopoP;

    public Analisi(String nome, int tempoDopoP, ArrayList<Strumenti> strumenti) {
        this.nome = nome;
        this.tempoDopoP = tempoDopoP;
        this.strumenti = strumenti;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTempoDopoP() {
        return tempoDopoP;
    }

    public void setTempoDopoP(int tempoDopoP) {
        this.tempoDopoP = tempoDopoP;
    }
    public ArrayList<Strumenti> getStrumenti() {
        return strumenti;
    }
    public void setStrumenti(ArrayList<Strumenti> strumenti) {
        this.strumenti = strumenti;
    }
}
