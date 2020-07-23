package com.gui;

import com.muzyka.DzwiekOszustwa;
import com.muzyka.DzwiekWygranej;
import com.muzyka.MuzykaTla;
import com.serializacja.Serializacja;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public class PanelOpcji extends JPanel {

    JFrame ramkaGry;

    static JRadioButton muzykaON;
    static JRadioButton muzykaOFF;
    static JRadioButton efektyON;
    static JRadioButton efektyOFF;

    ButtonGroup muzykaOnOff;
    ButtonGroup efektyOnOff;

    JSlider muzkaPoziom;
    JSlider efektyPoziom;

    JButton wroc;

    JLabel tlo;

    public PanelOpcji(JFrame ramkaGry) {
        this.ramkaGry = ramkaGry;

        tlo = BudowaGui.ustawGifJakoTlo(ramkaGry, "gifyTla/opcjeTlo.gif", this);

        BudowaGui.stworzJLabel(ramkaGry, "Muzyka:", 60, 190, 100,50);
        muzykaOnOff = new ButtonGroup();
        muzykaON = BudowaGui.JRadioButton(ramkaGry, "ON", 230, 200, 100, 35, muzykaOnOff);
        muzykaOFF = BudowaGui.JRadioButton(ramkaGry, "OFF", 330, 200, 100, 35, muzykaOnOff);




        BudowaGui.stworzJLabel(ramkaGry, "Głośność Muzyki:", 60, 250, 150,50);
        muzkaPoziom = BudowaGui.stworzSlider(ramkaGry, 220, 250, 220, 50, 5, 100);
        muzkaPoziom.setValue((int) MuzykaTla.getGlosnosc() + 40);


        BudowaGui.stworzJLabel(ramkaGry, "Efekty:", 60, 330, 100,50);

        efektyOnOff = new ButtonGroup();
        efektyON = BudowaGui.JRadioButton(ramkaGry, "ON", 230, 340, 100, 35, efektyOnOff);
        efektyOFF = BudowaGui.JRadioButton(ramkaGry, "OFF", 330, 340, 100, 35, efektyOnOff);


        BudowaGui.stworzJLabel(ramkaGry, "Głośność Efektów:", 60, 390, 150,50);
        efektyPoziom = BudowaGui.stworzSlider(ramkaGry, 220, 390, 220, 50, 5, 100);
        efektyPoziom.setValue((int) DzwiekWygranej.getGlosnosc() + 40);

        wroc = BudowaGui.stworzButton(ramkaGry, "Wróć", 370, 500, 190,40, new Wroc());

        wybierzPrzyciskEfektow();
        wybierzPrzyciskMuzyki();

        muzykaOFF.addActionListener(new Wycisz());
        efektyOFF.addActionListener(new Wycisz());

        muzykaON.addActionListener(new Odcisz());
        efektyON.addActionListener(new Odcisz());

        muzkaPoziom.addChangeListener(new ZmienGlosnosc());
        efektyPoziom.addChangeListener(new ZmienGlosnosc());



    }

    class Wycisz implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            Object o = actionEvent.getSource();

            if (o == muzykaOFF)
                wyciszMuzyke();

            if (o == efektyOFF)
                wyciszEfekty();
        }
    }


    class Odcisz implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            Object o = actionEvent.getSource();

            if (o == muzykaON)
                odciszMuzyke();

            if (o == efektyON)
                odciszEfekty();
        }
    }

    class ZmienGlosnosc implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {

            float[] zapisGlosnosci = Objects.requireNonNull(Serializacja.odczytUstawienMuzyki());

            JSlider slider = (JSlider) e.getSource();
            float glosnosc = (float) slider.getValue() - 40;
            if (slider == muzkaPoziom) {
                MuzykaTla.zmienGlosnosc(glosnosc);
                zapisGlosnosci[0] = glosnosc;
            } else {
                DzwiekWygranej.zmienGlosnosc(glosnosc);
                DzwiekOszustwa.zmienGlosnosc(glosnosc);
                zapisGlosnosci[1] = glosnosc;
            }

            Serializacja.zapisUstawienMuzyki(zapisGlosnosci);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(945, 595);
    }

    class Wroc implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            usunElementy();

            ramkaGry.getContentPane().removeAll();
            ramkaGry.add(new PanelStartowy(ramkaGry));

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
        tlo.setVisible(false);
    }

    public static void wyciszMuzyke () {
        MuzykaTla.wycisz();
        zmienCzyMuzykaWlaczona(0f);

    }

    public static void odciszMuzyke() {
        MuzykaTla.graj();
        zmienCzyMuzykaWlaczona(1f);

    }

    public void wyciszEfekty() {
        DzwiekWygranej.wycisz();
        DzwiekOszustwa.wycisz();
        zmienCzyEfektyWlaczone(0f);

    }


    public static void odciszEfekty() {
        DzwiekOszustwa.odcisz();
        DzwiekWygranej.odcisz();
        zmienCzyEfektyWlaczone(1f);
    }

    private static void zmienCzyMuzykaWlaczona(float czyWlaczona) {
        float[] zapisGlosnosci = Objects.requireNonNull(Serializacja.odczytUstawienMuzyki());
        zapisGlosnosci[2] = czyWlaczona;
        Serializacja.zapisUstawienMuzyki(zapisGlosnosci);
    }

    private static void zmienCzyEfektyWlaczone(float czyWlaczona) {
        float[] zapisGlosnosci = Objects.requireNonNull(Serializacja.odczytUstawienMuzyki());
        zapisGlosnosci[3] = czyWlaczona;
        Serializacja.zapisUstawienMuzyki(zapisGlosnosci);
    }

    public void wybierzPrzyciskMuzyki() {
        if (MuzykaTla.getCzyWlaczyony() == 1f) {
            muzykaON.setSelected(true);
            odciszMuzyke();
        } else {
            muzykaOFF.setSelected(true);
            wyciszMuzyke();
        }
    }

    public void wybierzPrzyciskEfektow() {
        if (DzwiekWygranej.getCzyWlaczyony() == 1f) {
            efektyON.setSelected(true);
            odciszEfekty();
        } else {
            efektyOFF.setSelected(true);
            wyciszEfekty();
        }
    }

}
