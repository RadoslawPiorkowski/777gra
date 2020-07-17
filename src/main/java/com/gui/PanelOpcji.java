package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelOpcji extends JLayeredPane {

    JFrame ramkaGry;

    ButtonGroup muzykaOnOff;
    ButtonGroup efektyOnOff;

    JSlider muzkaPoziom;
    JSlider efektyPoziom;

    public PanelOpcji(JFrame ramkaGry) {
        this.ramkaGry = ramkaGry;

        BudowaGui.ustawGifJakoTlo(ramkaGry, "gifyTla/opcjeTlo.gif", this);

        BudowaGui.stworzJLabel(ramkaGry, "Muzyka:", 60, 190, 100,50);
        muzykaOnOff = new ButtonGroup();
        BudowaGui.JRadioButton(ramkaGry, "ON", 230, 200, 100, 35, muzykaOnOff);
        BudowaGui.JRadioButton(ramkaGry, "OFF", 330, 200, 100, 35, muzykaOnOff);


        BudowaGui.stworzJLabel(ramkaGry, "Głośność Muzyki:", 60, 250, 150,50);
        muzkaPoziom = BudowaGui.stworzSlider(ramkaGry, 220, 250, 220, 50, 1, 100);


        BudowaGui.stworzJLabel(ramkaGry, "Efekty:", 60, 330, 100,50);

        efektyOnOff = new ButtonGroup();
        BudowaGui.JRadioButton(ramkaGry, "ON", 230, 340, 100, 35, muzykaOnOff);
        BudowaGui.JRadioButton(ramkaGry, "OFF", 330, 340, 100, 35, muzykaOnOff);

        BudowaGui.stworzJLabel(ramkaGry, "Głośność Efektów:", 60, 390, 150,50);
        efektyPoziom = BudowaGui.stworzSlider(ramkaGry, 220, 390, 220, 50, 1, 100);


        BudowaGui.stworzButton(ramkaGry, "Wróć", 370, 500, 190,40, new AkcjaWybory());


    }



    @Override
    public Dimension getPreferredSize() {
        return new Dimension(945, 595);

    }

    class AkcjaWybory implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {


        }
    }
}
