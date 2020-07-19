package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class PanelGrySolo extends JPanel {

    JFrame ramkaGry;
    JLabel tlo;

    JLabel hajs;
    JLabel ostatniaWygrana;
    JLabel zaklad;
    JLabel linie;

    JTextField hajsWartosc;
    JTextField ostatniaWygranaWartos;
    JTextField zakladWartos;
    JTextField linieWartosc;

    JButton zwiekszZaklad;
    JButton zmniejszZaklad;
    JButton zwiekszIloscLini;
    JButton zmniejszIloscLini;

    JButton dzwignia;
    JButton zakonczGre;

    public PanelGrySolo(JFrame ramka) {

        this.ramkaGry = ramka;

        tlo = BudowaGui.ustawGifJakoTlo(ramka, "gifyTla/automat.gif", this);
        dzwignia = BudowaGui.stworzUkrytyButton(true,ramka, "", 587, 138, 50,150, new Losowanie());

        hajs = BudowaGui.stworzJLabel(ramka, "Gotówka:", 80, 420, 100, 40);
        hajsWartosc = BudowaGui.stworzTextFieldBezEdycji(ramka, 160, 428, 120, 25);

        ostatniaWygrana = BudowaGui.stworzJLabel(ramka, "Wygrana:", 80, 480, 100, 40);
        ostatniaWygranaWartos = BudowaGui.stworzTextFieldBezEdycji(ramka, 160, 488, 120, 25);

        zaklad = BudowaGui.stworzJLabel(ramka, "Zakład:", 330, 420, 100, 40);
        zakladWartos = BudowaGui.stworzTextFieldBezEdycji(ramka, 410, 428, 120, 25);


        zwiekszZaklad = BudowaGui.stworzButton(ramka, "", 550, 428, 25, 25, new Losowanie());
        zwiekszZaklad.setBackground(new Color(102, 199, 91));
        zmniejszZaklad = BudowaGui.stworzButton(ramka, "", 590, 428, 25, 25, new Losowanie());
        zmniejszZaklad.setBackground(new Color(212, 59, 59));

        linie = BudowaGui.stworzJLabel(ramka, "Linie:", 330, 480, 100, 40);
        linieWartosc = BudowaGui.stworzTextFieldBezEdycji(ramka, 410, 488, 120, 25);

        zwiekszIloscLini = BudowaGui.stworzButton(ramka, "", 550, 488, 25, 25, new Losowanie());
        zwiekszIloscLini.setBackground(new Color(102, 199, 91));
        zmniejszIloscLini = BudowaGui.stworzButton(ramka, "", 590, 488, 25, 25, new Losowanie());
        zmniejszIloscLini.setBackground(new Color(212, 59, 59));

        zakonczGre = BudowaGui.stworzButton(ramka, "Zakończ Gre", 730, 530, 150,30, new ZakonczGre());

    }

    class Losowanie implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Container kontener = ramkaGry.getContentPane();

            tlo.setVisible(false);
            kontener.remove(dzwignia);
            kontener.add(new LosowaniePanel(ramkaGry));

            invalidate();
            repaint();
        }
    }

    class ZakonczGre implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            int decyzja = JOptionPane.showConfirmDialog(null, "Może jeszcze jedna gra?", "Zostań, jeszcze tylko jedna gra...", JOptionPane.YES_NO_OPTION);
            if (decyzja == JOptionPane.NO_OPTION) {
                Container kontener = ramkaGry.getContentPane();
                tlo.setVisible(false);
                kontener.remove(dzwignia);
                kontener.add(new PanelStartowy(ramkaGry));

                invalidate();
                repaint();
            }

        }
    }


    private class LosowaniePanel extends PanelGrySolo {

        JFrame ramkaGry;
        JLabel tlo;
        JButton dzwignia;


        public LosowaniePanel(JFrame ramka) {
            super(ramka);
            this.ramkaGry = ramka;

            tlo = BudowaGui.ustawGifJakoTlo(ramka, "gifyTla/losowanie.gif", this);
            dzwignia = BudowaGui.stworzUkrytyButton(true,ramka, "", 587, 138, 50,150, new PrzerwanieLosowania());

            hajs = BudowaGui.stworzJLabel(ramka, "Gotówka:", 80, 420, 100, 40);
            hajsWartosc = BudowaGui.stworzTextFieldBezEdycji(ramka, 160, 428, 120, 25);

            ostatniaWygrana = BudowaGui.stworzJLabel(ramka, "Wygrana:", 80, 480, 100, 40);
            ostatniaWygranaWartos = BudowaGui.stworzTextFieldBezEdycji(ramka, 160, 488, 120, 25);

            zaklad = BudowaGui.stworzJLabel(ramka, "Zakład:", 330, 420, 100, 40);
            zakladWartos = BudowaGui.stworzTextFieldBezEdycji(ramka, 410, 428, 120, 25);


            zwiekszZaklad = BudowaGui.stworzButton(ramka, "", 550, 428, 25, 25, new Losowanie());
            zwiekszZaklad.setBackground(new Color(102, 199, 91));
            zmniejszZaklad = BudowaGui.stworzButton(ramka, "", 590, 428, 25, 25, new Losowanie());
            zmniejszZaklad.setBackground(new Color(212, 59, 59));

            linie = BudowaGui.stworzJLabel(ramka, "Linie:", 330, 480, 100, 40);
            linieWartosc = BudowaGui.stworzTextFieldBezEdycji(ramka, 410, 488, 120, 25);

            zwiekszIloscLini = BudowaGui.stworzButton(ramka, "", 550, 488, 25, 25, new Losowanie());
            zwiekszIloscLini.setBackground(new Color(102, 199, 91));
            zmniejszIloscLini = BudowaGui.stworzButton(ramka, "", 590, 488, 25, 25, new Losowanie());
            zmniejszIloscLini.setBackground(new Color(212, 59, 59));

            zakonczGre = BudowaGui.stworzButton(ramka, "Zakończ Gre", 730, 530, 150,30, new Losowanie());

        }

        class PrzerwanieLosowania implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Container kontener = ramkaGry.getContentPane();

                tlo.setVisible(false);
                kontener.remove(dzwignia);
                kontener.add(new PanelGrySolo(ramkaGry));

                invalidate();
                repaint();
            }
        }
    }


}
