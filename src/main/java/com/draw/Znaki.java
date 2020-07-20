package com.draw;

public enum Znaki {

    pomarancza(2, "symbole/pomarancz.png"),
    jablko(3, "symbole/jablko.png"),
    wisnia(4, "symbole/wisnia.png"),
    dzwonek(5, "symbole/dzwonek.png"),
    diament(6, "symbole/diament.png"),
    siedem(7, "symbole/siedem.png");

    public int wartosc;
    public String grafika;

    Znaki (int wartosc, String grafika) {
        this.wartosc = wartosc;
        this.grafika = grafika;
    }

    public String getGrafika() {
        return grafika;
    }

    public int getWartosc() {
        return wartosc;
    }

}
