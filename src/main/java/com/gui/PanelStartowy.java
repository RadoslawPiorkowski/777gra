package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelStartowy extends JLayeredPane {

    JFrame ramkaGry;

    public PanelStartowy(JFrame ramka) {

        this.ramkaGry = ramka;

        BudowaGui.ustawGifJakoTlo(ramka, "gifyTla/startTlo.gif", this);


        BudowaGui.stworzButton(ramka, "Start", 370,200,190,40, new Akcja());
        BudowaGui.stworzButton(ramka, "Opcje", 370,270,190,40, new Akcja());
        BudowaGui.stworzButton(ramka, "Porady", 370,340,190,40, new Akcja());
        BudowaGui.stworzButton(ramka, "Wyjście", 370,410,190,40, new Akcja());

    }



    @Override
    public Dimension getPreferredSize() {
        return new Dimension(945, 595);

    }

     class Akcja implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            ramkaGry.dispose();
        }
    }



}
