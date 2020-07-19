package com.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Gra {

    static JFrame ekranGry;
    static JPanel panelGry;


    public static void rozpocznijGre() throws IOException {

        ekranGry = new RamkaGry();
//        panelGry = new PanelKasyna(ekranGry);
        panelGry = new PanelStartowy(ekranGry);
        ekranGry.getContentPane().add(panelGry);

        ekranGry.setVisible(true);
        ekranGry.pack();

    }

}
