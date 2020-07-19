package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelOpcjiWKasynie extends JPanel {

    JFrame ramkaGry;

    JRadioButton muzykaON;
    JRadioButton muzykaOFF;
    JRadioButton efektyON;
    JRadioButton efektyOFF;

    ButtonGroup muzykaOnOff;
    ButtonGroup efektyOnOff;

    JSlider muzkaPoziom;
    JSlider efektyPoziom;

    JButton wroc;

    JLabel tlo;



    public PanelOpcjiWKasynie(JFrame ramkaGry) {
        this.ramkaGry = ramkaGry;

        tlo = BudowaGui.ustawGifJakoTlo(ramkaGry, "gifyTla/opcjeTlo.gif", this);

        BudowaGui.stworzJLabel(ramkaGry, "Muzyka:", 60, 190, 100,50);
        muzykaOnOff = new ButtonGroup();
        muzykaON = BudowaGui.JRadioButton(ramkaGry, "ON", 230, 200, 100, 35, muzykaOnOff);
        muzykaON.setSelected(true);
        muzykaOFF = BudowaGui.JRadioButton(ramkaGry, "OFF", 330, 200, 100, 35, muzykaOnOff);


        BudowaGui.stworzJLabel(ramkaGry, "Głośność Muzyki:", 60, 250, 150,50);
        muzkaPoziom = BudowaGui.stworzSlider(ramkaGry, 220, 250, 220, 50, 1, 100);


        BudowaGui.stworzJLabel(ramkaGry, "Efekty:", 60, 330, 100,50);

        efektyOnOff = new ButtonGroup();
        efektyON = BudowaGui.JRadioButton(ramkaGry, "ON", 230, 340, 100, 35, efektyOnOff);
        efektyON.setSelected(true);
        efektyOFF = BudowaGui.JRadioButton(ramkaGry, "OFF", 330, 340, 100, 35, efektyOnOff);

        BudowaGui.stworzJLabel(ramkaGry, "Głośność Efektów:", 60, 390, 150,50);
        efektyPoziom = BudowaGui.stworzSlider(ramkaGry, 220, 390, 220, 50, 1, 100);


        wroc = BudowaGui.stworzButton(ramkaGry, "Wróć", 370, 500, 190,40, new Wroc());

    }



    @Override
    public Dimension getPreferredSize() {
        return new Dimension(945, 595);

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
        kontener.remove(muzykaON);
        kontener.remove(muzykaOFF);
        kontener.remove(muzkaPoziom);
        kontener.remove(efektyON);
        kontener.remove(efektyOFF);
        kontener.remove(efektyPoziom);
        kontener.remove(wroc);
        kontener.remove(tlo);

    }
}
