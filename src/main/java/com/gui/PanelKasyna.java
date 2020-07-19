package com.gui;

import com.draw.Gracz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelKasyna extends JPanel {

    JFrame ramkaGry;
    JButton zacznijLatwy;
    JButton zacznijSredni;
    JButton zacznijTrudny;
    JButton opcjeKasyna;
    JButton tanelaWynikow;
    JButton wyjscie;

    JLabel tlo;

    public PanelKasyna(JFrame ramka) {
        this.ramkaGry = ramka;


        tlo = BudowaGui.ustawGifJakoTlo(ramka, "gifyTla/kasyno.gif", this);

        zacznijLatwy = BudowaGui.stworzUkrytyButton(true, ramka, "", 365,220,50,50, new ZacznijLatwaGre());
        zacznijSredni = BudowaGui.stworzUkrytyButton(true, ramka, "", 278,365,50,50, new ZacznijSredniaGre());
        zacznijTrudny = BudowaGui.stworzUkrytyButton(true, ramka, "", 110,220,50,50, new ZacznijTrudnaGre());

        opcjeKasyna = BudowaGui.stworzUkrytyButton(true, ramka, "", 840,0,80,120, new Opcje());
        tanelaWynikow = BudowaGui.stworzUkrytyButton(true, ramka, "", 630,20,80,90, new TabelaWynikow());
        wyjscie = BudowaGui.stworzUkrytyButton(true, ramka, "", 570,545,90,45, new Wyjscie());


    }


     class ZacznijLatwaGre implements ActionListener {

         @Override
         public void actionPerformed(ActionEvent actionEvent) {
             Gracz.setGotowka(2000);
             zmienPanel(new PanelGrySolo(ramkaGry));

         }
     }

    class ZacznijSredniaGre implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Gracz.setGotowka(1000);
            zmienPanel(new PanelGrySolo(ramkaGry));


        }
    }

    class ZacznijTrudnaGre implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Gracz.setGotowka(200);
            zmienPanel(new PanelGrySolo(ramkaGry));


        }
    }

    class Opcje implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            zmienPanel(new PanelOpcjiWKasynie(ramkaGry));
        }
    }

    class TabelaWynikow implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            zmienPanel(new PanelGrySolo(ramkaGry));
        }
    }

    class Wyjscie implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            Object[] opcje = {"Tak", "Nie"};

            int decyzja = JOptionPane.showOptionDialog(null, "Czy napewno chcesz wyjść z Kasyna?", "Wyjśćie", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcje, opcje[0]);
            if (decyzja == JOptionPane.YES_OPTION) {
                tlo.setVisible(false);
                zmienPanel(new PanelStartowy(ramkaGry));
            }
        }
    }


    public void zmienPanel(JPanel panel) {
        Container kontener = ramkaGry.getContentPane();
        kontener.remove(Gra.panelGry);
        usunElementy();
        ramkaGry.add(panel);
        invalidate();
        repaint();
    }


    public  void usunElementy() {
        ramkaGry.getContentPane().remove(zacznijLatwy);
        ramkaGry.getContentPane().remove(zacznijSredni);
        ramkaGry.getContentPane().remove(zacznijTrudny);
        ramkaGry.getContentPane().remove(opcjeKasyna);
        ramkaGry.getContentPane().remove(tanelaWynikow);
        ramkaGry.getContentPane().remove(wyjscie);
        tlo.setVisible(false);

    }
}
