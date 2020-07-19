package com.draw;

public enum Znaki {

    pomarancza(2),
    jablko(3),
    wisnia(4),
    dzwonek(5),
    diament(6),
    siedem(7);

    public int wartosc;

    Znaki (int wartosc) {
        this.wartosc = wartosc;
    }

    public int getWartosc() {
        return wartosc;
    }

}
