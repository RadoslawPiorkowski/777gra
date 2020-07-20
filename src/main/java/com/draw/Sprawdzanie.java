package com.draw;
import com.gui.*;

public class Sprawdzanie {

    public static int wygrane (Znaki znaki) {
        if(znaki == Znaki.pomarancza)
            return 2;
        else if(znaki == Znaki.jablko)
            return 4;
        else if(znaki == Znaki.wisnia)
            return 6;
        else if(znaki == Znaki.dzwonek)
            return 8;
        else if (znaki == Znaki.diament)
            return 10;
        else
            return 15;
    }

    public static int pierwszaLinia (int wysokoscZakladu) {
        if (Generowanie.losowanie [1][0] == Generowanie.losowanie [1][1] & Generowanie.losowanie [1][2] == Generowanie.losowanie [1][0]) {
            return wysokoscZakladu * wygrane(Generowanie.losowanie[1][0]);
                }
        else
            return 0;
    }

    public static int drugaLinia (int wysokoscZakladu) {
        if (Generowanie.losowanie [0][0] == Generowanie.losowanie [0][1] & Generowanie.losowanie [0][2] == Generowanie.losowanie [0][0]) {
            return wysokoscZakladu * wygrane(Generowanie.losowanie[0][0]);
                }
        else
            return 0;
    }

    public static int trzeciaLinia (int wysokoscZakladu) {
        if (Generowanie.losowanie [2][0] == Generowanie.losowanie [2][1] & Generowanie.losowanie [2][2] == Generowanie.losowanie [2][0]) {
            return wysokoscZakladu * wygrane(Generowanie.losowanie[2][0]);
        }
        else
            return 0;
    }

    public static int czwartaLinia (int wysokoscZakladu) {
        if (Generowanie.losowanie [0][0] == Generowanie.losowanie [1][1] & Generowanie.losowanie [2][2] == Generowanie.losowanie [0][0]) {
            return wysokoscZakladu * wygrane(Generowanie.losowanie[0][0]);
        }
        else
            return 0;
    }

    public static int piataLinia (int wysokoscZakladu) {
        if (Generowanie.losowanie [2][0] == Generowanie.losowanie [1][1] & Generowanie.losowanie [0][2] == Generowanie.losowanie [2][0]) {
            return wysokoscZakladu * wygrane(Generowanie.losowanie[2][0]);
        }
        else
            return 0;
    }

    public static void zakladJednaLinia (int wysokoscZakladu) {
        Gracz.setGotowka(Gracz.getGotowka() + Sprawdzanie.pierwszaLinia(wysokoscZakladu));
        Gracz.setWynik(pierwszaLinia(wysokoscZakladu));
    }

    public static void zakladDwieLinia (int wysokoscZakladu) {
        Gracz.setGotowka(Gracz.getGotowka() + Sprawdzanie.pierwszaLinia(wysokoscZakladu) + Sprawdzanie.drugaLinia(wysokoscZakladu));
        Gracz.setWynik(Sprawdzanie.pierwszaLinia(wysokoscZakladu) + Sprawdzanie.drugaLinia(wysokoscZakladu));

    }

    public static void zakladTrzyLinia (int wysokoscZakladu) {
        Gracz.setGotowka(Gracz.getGotowka() + Sprawdzanie.pierwszaLinia(wysokoscZakladu) + Sprawdzanie.drugaLinia(wysokoscZakladu) + Sprawdzanie.trzeciaLinia(wysokoscZakladu));
        Gracz.setWynik(Sprawdzanie.pierwszaLinia(wysokoscZakladu) + Sprawdzanie.drugaLinia(wysokoscZakladu) + Sprawdzanie.trzeciaLinia(wysokoscZakladu));

    }

    public static void zakladCzteryLinia (int wysokoscZakladu) {
        Gracz.setGotowka(Gracz.getGotowka() + Sprawdzanie.pierwszaLinia(wysokoscZakladu) + Sprawdzanie.drugaLinia(wysokoscZakladu) + Sprawdzanie.trzeciaLinia(wysokoscZakladu) +
                Sprawdzanie.czwartaLinia(wysokoscZakladu));
        Gracz.setWynik(Sprawdzanie.pierwszaLinia(wysokoscZakladu) + Sprawdzanie.drugaLinia(wysokoscZakladu) + Sprawdzanie.trzeciaLinia(wysokoscZakladu) +
                Sprawdzanie.czwartaLinia(wysokoscZakladu));
    }

    public static void zakladPiecLinia (int wysokoscZakladu) {

        Gracz.setGotowka(Gracz.getGotowka() + Sprawdzanie.pierwszaLinia(wysokoscZakladu) + Sprawdzanie.drugaLinia(wysokoscZakladu) + Sprawdzanie.trzeciaLinia(wysokoscZakladu) +
                Sprawdzanie.czwartaLinia(wysokoscZakladu) + Sprawdzanie.piataLinia(wysokoscZakladu));
        Gracz.setWynik(Sprawdzanie.pierwszaLinia(wysokoscZakladu) + Sprawdzanie.drugaLinia(wysokoscZakladu) + Sprawdzanie.trzeciaLinia(wysokoscZakladu) +
                Sprawdzanie.czwartaLinia(wysokoscZakladu) + Sprawdzanie.piataLinia(wysokoscZakladu));
    }

    public static void zakladJednaLiniaMulti (int wysokoscZakladu) {
        GraczMulti.setGotowka(GraczMulti.getGotowka() + Sprawdzanie.pierwszaLinia(wysokoscZakladu));
        GraczMulti.setWynik(pierwszaLinia(wysokoscZakladu));
    }

    public static void zakladDwieLiniaMulti (int wysokoscZakladu) {
        GraczMulti.setGotowka(GraczMulti.getGotowka() + Sprawdzanie.pierwszaLinia(wysokoscZakladu) + Sprawdzanie.drugaLinia(wysokoscZakladu));
        GraczMulti.setWynik(Sprawdzanie.pierwszaLinia(wysokoscZakladu) + Sprawdzanie.drugaLinia(wysokoscZakladu));

    }

    public static void zakladTrzyLiniaMulti (int wysokoscZakladu) {
        GraczMulti.setGotowka(GraczMulti.getGotowka() + Sprawdzanie.pierwszaLinia(wysokoscZakladu) + Sprawdzanie.drugaLinia(wysokoscZakladu) + Sprawdzanie.trzeciaLinia(wysokoscZakladu));
        GraczMulti.setWynik(Sprawdzanie.pierwszaLinia(wysokoscZakladu) + Sprawdzanie.drugaLinia(wysokoscZakladu) + Sprawdzanie.trzeciaLinia(wysokoscZakladu));

    }

    public static void zakladCzteryLiniaMulti (int wysokoscZakladu) {
        GraczMulti.setGotowka(GraczMulti.getGotowka() + Sprawdzanie.pierwszaLinia(wysokoscZakladu) + Sprawdzanie.drugaLinia(wysokoscZakladu) + Sprawdzanie.trzeciaLinia(wysokoscZakladu) +
                Sprawdzanie.czwartaLinia(wysokoscZakladu));
        GraczMulti.setWynik(Sprawdzanie.pierwszaLinia(wysokoscZakladu) + Sprawdzanie.drugaLinia(wysokoscZakladu) + Sprawdzanie.trzeciaLinia(wysokoscZakladu) +
                Sprawdzanie.czwartaLinia(wysokoscZakladu));
    }

    public static void zakladPiecLiniaMulti (int wysokoscZakladu) {

        GraczMulti.setGotowka(GraczMulti.getGotowka() + Sprawdzanie.pierwszaLinia(wysokoscZakladu) + Sprawdzanie.drugaLinia(wysokoscZakladu) + Sprawdzanie.trzeciaLinia(wysokoscZakladu) +
                Sprawdzanie.czwartaLinia(wysokoscZakladu) + Sprawdzanie.piataLinia(wysokoscZakladu));
        GraczMulti.setWynik(Sprawdzanie.pierwszaLinia(wysokoscZakladu) + Sprawdzanie.drugaLinia(wysokoscZakladu) + Sprawdzanie.trzeciaLinia(wysokoscZakladu) +
                Sprawdzanie.czwartaLinia(wysokoscZakladu) + Sprawdzanie.piataLinia(wysokoscZakladu));
    }

}
