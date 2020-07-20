package com.serializacja;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Mistrz implements Serializable {

    String imie;
    int gotowka;

    static List<Mistrz> listaMistrzow = new ArrayList<>();

    static {

    }

    public Mistrz(String imie, int gotowka) {
        this.imie = imie;
        this.gotowka = gotowka;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public int getGotowka() {
        return gotowka;
    }

    public void setGotowka(int gotowka) {
        this.gotowka = gotowka;
    }

    public static List<Mistrz> getListaMistrzow() {
        return listaMistrzow;
    }

    public static void setListaMistrzow(List<Mistrz> listaMistrzow) {
        Mistrz.listaMistrzow = listaMistrzow;
    }

    @Override
    public String toString() {
        return  imie + " opuścił kasyno z " + gotowka + " złotymi w kieszeni!";
    }
}
