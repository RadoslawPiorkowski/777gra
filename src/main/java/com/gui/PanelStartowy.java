package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelStartowy extends JPanel {

    JFrame ramkaGry;
    JButton start;
    JButton opcje;
    JButton porady;
    JButton wyjscie;

    JLabel tlo;

    public PanelStartowy(JFrame ramka) {

        this.ramkaGry = ramka;

        tlo = BudowaGui.ustawGifJakoTlo(ramka,"gifyTla/startTlo.gif", this);


        start = BudowaGui.stworzButton(ramka, "Start", 370,200,190,40, new Start());
        opcje = BudowaGui.stworzButton(ramka, "Opcje", 370,270,190,40, new WejdzWOpcje());
        porady = BudowaGui.stworzButton(ramka, "Porady", 370,340,190,40, new Porady());
        wyjscie = BudowaGui.stworzButton(ramka, "Wyjście", 370,410,190,40, new Wyjscie());


    }


    class Start implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            zmienPanel(new PanelWyboruGry(ramkaGry));
        }
    }


     class WejdzWOpcje implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            zmienPanel(new PanelOpcji(ramkaGry));

        }
    }


    class Porady implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            zmienPanel(new PanelPorad(ramkaGry));
        }
    }


    class Wyjscie implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            Object[] opcje = {"Tak", "Nie"};

            int decyzja = JOptionPane.showOptionDialog(null, "Czy napewno chcesz wyjść z gry?", "Wyjśćie", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcje, opcje[0]);
            if (decyzja == JOptionPane.YES_OPTION)
                ramkaGry.dispose();
        }
    }





    public void zmienPanel(JPanel panel) {
        Container kontener = ramkaGry.getContentPane();
        kontener.remove(Gra.panelGry);
        ramkaGry.add(panel);
        usunElementy();
        invalidate();
        repaint();
    }


    public  void usunElementy() {

        ramkaGry.getContentPane().remove(start);
        ramkaGry.getContentPane().remove(opcje);
        ramkaGry.getContentPane().remove(porady);
        ramkaGry.getContentPane().remove(wyjscie);
        tlo.setVisible(false);

    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(945, 595);

    }

}
