package com.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelKasyna extends JLayeredPane {

    JFrame ramkaGry;

    public PanelKasyna(JFrame ramka) {
        this.ramkaGry = ramka;


        BudowaGui.ustawGifJakoTlo(ramka, "gifyTla/kasyno.gif", this);

        JButton button = new JButton();
        button.setBounds(100,150,100,100);
        BudowaGui.ukryjPrzycisk(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("elo");
            }
        });


        ramka.add(button, 1, 0);
    }

}
