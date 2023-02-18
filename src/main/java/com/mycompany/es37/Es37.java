/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.es37;

/**
 *
 * @author NICHOLASGHERBI
 */
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Es37 {
   
    
    
    public static boolean check_operatore(String operatore, String esame, Analisi[] analisi) throws IOException { 
        for (Analisi a : analisi) 
        {
            if (a.getNome().equals(esame)) 
            {
                for (int i=0; i<a.getStrumenti().size(); i++) 
                {
                    if (a.getStrumenti().get(i).getOperatoriAbilitati().contains(operatore)) 
                        return true;             
                }
            }
        }
        return false;
    }
   //fare chekc sulla data
   
    public static boolean check_data(String data_analisi, String data_prelievo, String esame, Analisi[] analisi) throws IOException, ParseException {
        LocalDate dA = LocalDate.parse(data_analisi);
        LocalDate dP = LocalDate.parse(data_prelievo);
        
        for (Analisi a : analisi) 
        {
            if (a.getNome().equals(esame)) 
            {
                long diff = ChronoUnit.DAYS.between(dP, dA);               
                if ((int) diff<a.getTempoDopoP())
                    return true;      
            }
        }
        return false;
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        ArrayList<String> lista_op = new ArrayList<String>();
        ArrayList<String> operatoreEsami = new ArrayList<String>();    
        ArrayList<Integer> strumenti = new ArrayList<Integer>();
        
        Gson g1 = new Gson();
        Gson g2 = new Gson();
        
        byte[] content = Files.readAllBytes(Paths.get("C:\\Users\\NICHOLASGHERBI\\Desktop\\5a\\TPSIT\\Es37\\src\\main\\java\\com\\mycompany\\es37\\esito.json"));
        String json1 = new String(content);
        Esito esito = g1.fromJson(json1, Esito.class);
        
        byte[] content2 = Files.readAllBytes(Paths.get("C:\\Users\\NICHOLASGHERBI\\Desktop\\5a\\TPSIT\\Es37\\src\\main\\java\\com\\mycompany\\es37\\analisi.json"));
        String json2 = new String(content2);
        Analisi[] analisi = g2.fromJson(json2, Analisi[].class);
  
        for (Analisi a : analisi) 
        {
            for (int i = 0; i < a.getStrumenti().size(); i++) 
            {
                lista_op.add(a.getStrumenti().get(i).getOperatoriAbilitati().get(i));
            }
        }
        System.out.println("PAZIENTE:");
        System.out.println("Nome: " + esito.getNome());
        System.out.println("Cognome: " + esito.getCognome());
        System.out.println("Codice Fiscale: " + esito.getCodice_fiscale());
        System.out.println("Sesso: " + esito.getSesso());
        System.out.println("Età: " + esito.getEta());
        System.out.println("Data del prelievo: " + esito.getDataPrelievo());
        System.out.println("Ora del prelievo: " + esito.getOraPrelievo());
        System.out.println("Luogo del prelievo: " + esito.getLuogoPrelievo());
        
        
        
        System.out.println("\nESAMI EFFETTUATI:");
        
        //
        //lista esami
        //
        for (int i = 0; i < esito.getEsami().size(); i++) 
        {
            
            System.out.println("Nome dell'esame: " + esito.getEsami().get(i).getDenominazione());
            System.out.println("Data: " + esito.getEsami().get(i).getData());
            System.out.println("Ora: " + esito.getEsami().get(i).getOra());
            
            boolean flag = check_data(esito.getEsami().get(i).getData(), esito.getDataPrelievo(), esito.getEsami().get(i).getDenominazione(), analisi);
            if (flag == true) 
                System.out.println("Analisi svolta in accordo coi tempi");
            else 
                System.out.println("Analisi svolta NON in accordo coi tempi");
            
            
            System.out.print("Codice dell'operatore: " + esito.getEsami().get(i).getCodiceOperatore());
         
            flag = check_operatore(esito.getEsami().get(i).getCodiceOperatore(), esito.getEsami().get(i).getDenominazione(), analisi);
            if (flag == true)
                System.out.print(" Stato: ABILITATO");
             else
                System.out.print(" Stato: NON ABILITATO");
            System.out.println("\n");
            
            operatoreEsami.add(esito.getEsami().get(i).getCodiceOperatore());
            

            for (int j=0; j<esito.getEsami().get(i).getStrumenti().size(); j++) 
            { 
                strumenti.add(esito.getEsami().get(i).getStrumenti().get(j));
            }
            
            
            System.out.println("\nValore degli esami: ");
            if (esito.getEsami().get(i).getValore() < esito.getEsami().get(i).getMax() && esito.getEsami().get(i).getValore() > esito.getEsami().get(i).getMin()) 
                System.out.println(esito.getEsami().get(i).getValore() + " \nStato: \nVALORE NELLA NORMA");
            else if (esito.getEsami().get(i).getValore() > esito.getEsami().get(i).getMax()) 
                System.out.println(esito.getEsami().get(i).getValore() + " \nStato: \nVALORE SUPERIORE ALLA NORMA"); 
            else 
                System.out.println(esito.getEsami().get(i).getValore() + " \nStato: \nVALORE INFERIORE ALLA NORMA");
            System.out.println("-------------------------------------------------------------------------------");
            
        }
    }
}
