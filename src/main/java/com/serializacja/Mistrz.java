package com.serializacja;

import java.io.Serializable;
import java.util.ArrayList;


public class Mistrz implements Serializable {

    String imie;
    int gotowka;

    public static ArrayList<Mistrz> listaMistrzow = new ArrayList<Mistrz>();

    static {
        try {
            listaMistrzow = Serializacja.odczytZPliku();
        } catch (NullPointerException ex) {
            System.out.println("Lista tymczasowo pusta");
        }

    }

    public Mistrz(String imie, int gotowka) {
        this.imie = imie;
        this.gotowka = gotowka;
    }

    public String getImie() {
        return imie;
    }


    public int getGotowka() {
        return gotowka;
    }


    @Override
    public String toString() {
        return  imie + " opuścił kasyno z " + gotowka + " złotymi w kieszeni!";
    }
}
