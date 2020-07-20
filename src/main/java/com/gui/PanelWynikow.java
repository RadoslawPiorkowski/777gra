package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelWynikow extends JPanel {

    JFrame ramkaGry;
    JButton wroc;
    JLabel tlo;

    public PanelWynikow(JFrame ramka) {
        this.ramkaGry = ramka;

        tlo = BudowaGui.ustawGifJakoTlo(ramka, "gifyTla/topLista.png", this);

        wroc = BudowaGui.stworzButton(ramka, "Wróć", 650, 500, 190,40, new Wroc());


    }



    class Wroc implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            usunElementy();

            ramkaGry.add(new PanelKasyna(ramkaGry));

            invalidate();
            repaint();

        }
    }

    public void usunElementy() {
        Container kontener = ramkaGry.getContentPane();

        kontener.remove(Gra.panelGry);
        kontener.remove(wroc);
        tlo.setVisible(false);

    }
}
