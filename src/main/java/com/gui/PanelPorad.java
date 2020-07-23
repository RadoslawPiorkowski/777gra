package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPorad extends JPanel {

    JFrame ramkaGry;
    JButton wroc;
    JLabel tlo;

    public PanelPorad(JFrame ramka) {

        this.ramkaGry = ramka;

        tlo = BudowaGui.ustawGifJakoTlo(ramka, "gifyTla/porady.gif", this);

        BudowaGui.stworzTextArea(ramka, Wprowadzenie(), 30, 130, 280, 70);
        BudowaGui.stworzTextArea(ramka, opisPostaci("Piotrek", "Łatwy", "Programista", 2000), 30, 185, 250, 100);
        BudowaGui.stworzTextArea(ramka, opisPostaci("Jan", "Normalny", "Urzędnik", 1000), 30, 310, 250, 100);
        BudowaGui.stworzTextArea(ramka, opisPostaci("Seba", "Trudny", "Bezrobotny", 200), 30, 450, 250, 100);

        BudowaGui.stworzTextArea(ramka, opisAutomatu(), 340, 190, 153, 150);
        BudowaGui.stworzTextArea(ramka, opisWygranych(), 340, 350, 145, 200);


        BudowaGui.stworzTextArea(ramka, "Oto ochroniarz naszego wspaniałego kasyna - Borys.", 580, 200, 210, 100);
        BudowaGui.stworzTextArea(ramka, opisOszustw(), 580, 320, 350, 300);


        wroc = BudowaGui.stworzButton(ramka, "Wróć", 650, 500, 190,40, new Wroc());

    }


    class Wroc implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            Container kontener = ramkaGry.getContentPane();
            kontener.remove(Gra.panelGry);
            kontener.remove(wroc);
            tlo.setVisible(false);

            ramkaGry.add(new PanelStartowy(ramkaGry));

            invalidate();
            repaint();

        }
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
        return "Zasady gry są proste:\n- Stań przy automacie\n- Postaw pieniędze\n- Wybierz ilość linii\n- Pociągnij za dźwignię\n- Cofnij dźwignię\n- Trzymaj kciuki!";
    }

    private String opisWygranych () {
        return "Automat wylosuje układ znaków, w grze jest ich 6 rodzajów.\n\nWygrywasz jeśli trzy jednakowe symbole znajądą się w jednej linii.";
    }

    private String opisOszustw () {
        return "Pamiętajcie, oszustwa są całkowicie dozwolne! Dopóki ochrona tego nie zauważy... \n \nTakże dopóki jesteście uważni i pomysłowi droga wolna, szczęściu należy pomagać. Ale w razie problemów, ja do niczego nie zachęcałem i w ogóle was nie znam.\nPowodzenia! ";
    }


}
