package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPorad extends JLayeredPane {

    JFrame ramkaGry;

    public PanelPorad(JFrame ramka) {

        this.ramkaGry = ramka;

        BudowaGui.ustawGifJakoTlo(ramka, "gifyTla/porady.gif", this);
        BudowaGui.stworzTextArea(ramka, Wprowadzenie(), 30, 130, 280, 70);
        BudowaGui.stworzTextArea(ramka, opisPostaci("Piotrek", "Łatwy", "Programista", 2000), 30, 185, 250, 100);
        BudowaGui.stworzTextArea(ramka, opisPostaci("Jan", "Normalny", "Urzędnik", 800), 30, 310, 250, 100);
        BudowaGui.stworzTextArea(ramka, opisPostaci("Seba", "Trudny", "Bezrobotny", 100), 30, 450, 250, 100);

        BudowaGui.stworzTextArea(ramka, opisAutomatu(), 340, 190, 153, 150);
        BudowaGui.stworzTextArea(ramka, opisWygranych(), 340, 350, 145, 200);


        BudowaGui.stworzTextArea(ramka, "Oto ochroniarz naszego wspaniałego kasyna - Borys.", 580, 200, 250, 100);
        BudowaGui.stworzTextArea(ramka, opisOszustw(), 580, 320, 350, 300);


        BudowaGui.stworzButton(ramka, "Wróć", 650, 500, 190,40, new AkcjaWybory());

    }




    @Override
    public Dimension getPreferredSize() {
        return new Dimension(945, 595);

    }

    private String Wprowadzenie() {
        return "Po wejściu do kasyna wskaż jedną z postaci: ";
    }

    private String opisPostaci (String imie, String poziom, String praca, int finanse) {
        return "- Imie: " + imie + "\n- Zawód: " + praca + "\n- Poziom trudnosci: " + poziom + "\n- Kasa: " + finanse;
    }


    private String opisAutomatu () {
        return "Zasady gry są bardzo proste! \nStojąc przy automacie, postaw kwotę pieniędzy ilość linii, które chcesz obstawić, pociągnij za dźwignię i gotwe!";
    }

    private String opisWygranych () {
        return "Kiedy gra się zacznie zostanie wylosowany układ znaków, w grze jest ich 6 rodzajów. Wygrywasz jeśli trzy takie same znajądą się w jednej linii. Najceniejsze są 7!";
    }

    private String opisOszustw () {
        return "Pamiętajcie, oszustwa są całkowicie dozwolne! Dopóki ochrona tego nie zauważy... \n \nTakże dopóki jesteście uważni i pomysłowi droga wolna, szczęściu należy pomagać. Ale w razie problemów, ja do niczego nie zachęcałem i w ogóle was nie znam.\nPowodzenia! ";
    }

    class AkcjaWybory implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {


        }
    }
}
