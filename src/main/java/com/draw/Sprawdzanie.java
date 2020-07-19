package com.draw;

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

    public static int zakladJednaLinia (int wysokoscZakladu) {
        if (Gracz.gotowka - wysokoscZakladu <= 0) {
            System.out.println("Brak gotówki");
        } else {
            Gracz.setGotowka(Gracz.getGotowka() + Sprawdzanie.pierwszaLinia(wysokoscZakladu));
            Gracz.setWynik(Sprawdzanie.pierwszaLinia(wysokoscZakladu));
        }
        return 0;
    }

    public static int zakladDwieLinia (int wysokoscZakladu) {
        if (Gracz.gotowka - 2 * wysokoscZakladu <= 0) {
            System.out.println("Brak gotówki");
        } else {
            Gracz.setGotowka(Gracz.getGotowka() + Sprawdzanie.pierwszaLinia(wysokoscZakladu) + Sprawdzanie.drugaLinia(wysokoscZakladu));
            Gracz.setWynik(Sprawdzanie.pierwszaLinia(wysokoscZakladu) + Sprawdzanie.drugaLinia(wysokoscZakladu));
        }
        return 0;
    }

    public static int zakladTrzyLinia (int wysokoscZakladu) {
        if (Gracz.gotowka - 3 * wysokoscZakladu <= 0) {
            System.out.println("Brak gotówki");
        } else {
            Gracz.setGotowka(Gracz.getGotowka() + Sprawdzanie.pierwszaLinia(wysokoscZakladu) + Sprawdzanie.drugaLinia(wysokoscZakladu) + Sprawdzanie.trzeciaLinia(wysokoscZakladu));
            Gracz.setWynik(Sprawdzanie.pierwszaLinia(wysokoscZakladu) + Sprawdzanie.drugaLinia(wysokoscZakladu) + Sprawdzanie.trzeciaLinia(wysokoscZakladu));
        }
        return 0;
    }

    public static int zakladCzteryLinia (int wysokoscZakladu) {
        if (Gracz.gotowka - 3 * wysokoscZakladu <= 0) {
            System.out.println("Brak gotówki");
        } else {
            Gracz.setGotowka(Gracz.getGotowka() + Sprawdzanie.pierwszaLinia(wysokoscZakladu) + Sprawdzanie.drugaLinia(wysokoscZakladu) + Sprawdzanie.trzeciaLinia(wysokoscZakladu) +
                    Sprawdzanie.czwartaLinia(wysokoscZakladu));
            Gracz.setWynik(Sprawdzanie.pierwszaLinia(wysokoscZakladu) + Sprawdzanie.drugaLinia(wysokoscZakladu) + Sprawdzanie.trzeciaLinia(wysokoscZakladu) +
                    Sprawdzanie.czwartaLinia(wysokoscZakladu));
        }
        return 0;
    }

    public static int zakladPiecLinia (int wysokoscZakladu) {
        if (Gracz.gotowka - 3 * wysokoscZakladu <= 0) {
            System.out.println("Brak gotówki");
        } else {
            Gracz.setGotowka(Gracz.getGotowka() + Sprawdzanie.pierwszaLinia(wysokoscZakladu) + Sprawdzanie.drugaLinia(wysokoscZakladu) + Sprawdzanie.trzeciaLinia(wysokoscZakladu) +
                    Sprawdzanie.czwartaLinia(wysokoscZakladu) + Sprawdzanie.piataLinia(wysokoscZakladu));
            Gracz.setWynik(Sprawdzanie.pierwszaLinia(wysokoscZakladu) + Sprawdzanie.drugaLinia(wysokoscZakladu) + Sprawdzanie.trzeciaLinia(wysokoscZakladu) +
                    Sprawdzanie.czwartaLinia(wysokoscZakladu) + Sprawdzanie.piataLinia(wysokoscZakladu));
        }
        return 0;
    }
}
