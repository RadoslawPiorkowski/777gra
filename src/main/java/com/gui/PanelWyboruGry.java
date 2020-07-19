package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PanelWyboruGry extends JPanel {

    JFrame ramkaGry;
    JButton wroc;
    JButton graSolo;
    JButton graWParze;

    JLabel tlo;

    public PanelWyboruGry(JFrame ramka) {

        this.ramkaGry = ramka;

        tlo = BudowaGui.ustawGifJakoTlo(ramka, "gifyTla/startTlo.gif", this);

        graSolo = BudowaGui.stworzButton(ramka, "Jeden Gracz", 370,230,190,40, new WejscieDoKasyna());
        graWParze = BudowaGui.stworzButton(ramka, "Dwóch Graczy", 370,320,190,40, new Wroc());
        wroc = BudowaGui.stworzButton(ramka, "Wróć", 370,410,190,40, new Wroc());

    }


    class WejscieDoKasyna implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            usunElementy();
            ramkaGry.add(new PanelKasyna(ramkaGry));
            invalidate();
            repaint();

        }
    }

    class Wroc implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            usunElementy();
            ramkaGry.add(new PanelStartowy(ramkaGry));

            invalidate();
            repaint();

        }
    }

    public void usunElementy() {
        Container kontener = ramkaGry.getContentPane();
        kontener.remove(Gra.panelGry);
        kontener.remove(wroc);
        kontener.remove(graSolo);
        kontener.remove(graWParze);
        tlo.setVisible(false);
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(945, 595);

    }
}
