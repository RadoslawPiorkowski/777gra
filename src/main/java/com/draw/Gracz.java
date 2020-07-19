package com.draw;

public class Gracz {

    public static int gotowka;
    public static int wynik;

    public static int getWynik() {
        return wynik;
    }

    public static void setWynik(int wynik) {
        Gracz.wynik = wynik;
    }

    public static int getGotowka() {
        return gotowka;
    }

    public static void setGotowka(int gotowka) {
        Gracz.gotowka = gotowka;
    }


    public static int zabieranieGotowki1Zaklad (int wysokoscZakladu) {
        if(gotowka-1*wysokoscZakladu <= 0)
            System.out.println("Brak gotówki");
        else
            setGotowka(gotowka-1*wysokoscZakladu);
        return 0;
    }

    public static int zabieranieGotowki2Zaklad (int wysokoscZakladu) {
        if(gotowka-2*wysokoscZakladu <= 0)
            System.out.println("Brak gotówki");
        else
            setGotowka(gotowka-2*wysokoscZakladu);
        return 0;
    }

    public static int zabieranieGotowki3Zaklad (int wysokoscZakladu) {
        if(gotowka-3*wysokoscZakladu <= 0)
            System.out.println("Brak gotówki");
        else
            setGotowka(gotowka-3*wysokoscZakladu);
        return 0;
    }

    public static int zabieranieGotowki4Zaklad (int wysokoscZakladu) {
        if(gotowka-4*wysokoscZakladu <= 0)
            System.out.println("Brak gotówki");
        else
            setGotowka(gotowka-4*wysokoscZakladu);
        return 0;
    }

    public static int zabieranieGotowki5Zaklad (int wysokoscZakladu) {
        if(gotowka-5*wysokoscZakladu <= 0)
            System.out.println("Brak gotówki");
        else
            setGotowka(gotowka-5*wysokoscZakladu);
        return 0;
    }
}
