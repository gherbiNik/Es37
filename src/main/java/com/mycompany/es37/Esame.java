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
public class Esame {
    private String denominazione;
    private String data;
    private String ora;
    private String codiceOperatore;
    private ArrayList<Integer> strumenti;
    private float valore;
    private String unitaMisura;
    private int min;
    private int max;

    public Esame(String denominazione, String data, String ora, String codiceOperatore, ArrayList<Integer> strumenti, float valore, String unitaMisura, int min, int max) {
        this.denominazione = denominazione;
        this.data = data;
        this.ora = ora;
        this.codiceOperatore = codiceOperatore;
        this.strumenti = strumenti;
        this.valore = valore;
        this.unitaMisura = unitaMisura;
        this.min = min;
        this.max = max;
    }

    public String getDenominazione() {
        return denominazione;
    }
    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public String getOra() {
        return ora;
    }
    public void setOra(String ora) {
        this.ora = ora;
    }

    public String getCodiceOperatore() {
        return codiceOperatore;
    }
    public void setCodiceOperatore(String codiceOperatore) {
        this.codiceOperatore = codiceOperatore;
    }

    public ArrayList<Integer> getStrumenti() {
        return strumenti;
    }
    public void setStrumenti(ArrayList<Integer> strumenti) {
        this.strumenti = strumenti;
    }

    public float getValore() {
        return valore;
    }
    public void setValore(float valore) {
        this.valore = valore;
    }

    public String getUnitaMisura() {
        return unitaMisura;
    }
    public void setUnitaMisura(String unitaMisura) {
        this.unitaMisura = unitaMisura;
    }

    public int getMin() {
        return min;
    }
    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }
    public void setValore_massimo(int valoreMassimo) {
        this.max = valoreMassimo;
    }
}
