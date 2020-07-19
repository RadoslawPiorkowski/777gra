package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LosowaniePanel extends JPanel {

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


        public LosowaniePanel(JFrame ramka) {

            this.ramkaGry = ramka;

            tlo = BudowaGui.ustawGifJakoTlo(ramka, "gifyTla/losowanie.gif", this);
            dzwignia = BudowaGui.stworzUkrytyButton(true,ramka, "", 587, 138, 50,150, new PrzerwanieLosowania());

            hajs = BudowaGui.stworzJLabel(ramka, "Gotówka:", 80, 420, 100, 40);
            hajsWartosc = BudowaGui.stworzTextFieldBezEdycji(ramka, 160, 428, 120, 25);

            ostatniaWygrana = BudowaGui.stworzJLabel(ramka, "Wygrana:", 80, 480, 100, 40);
            ostatniaWygranaWartos = BudowaGui.stworzTextFieldBezEdycji(ramka, 160, 488, 120, 25);

            zaklad = BudowaGui.stworzJLabel(ramka, "Zakład:", 330, 420, 100, 40);
            zakladWartos = BudowaGui.stworzTextFieldBezEdycji(ramka, 410, 428, 120, 25);


            zwiekszZaklad = BudowaGui.stworzButton(ramka, "", 550, 428, 25, 25, new PrzerwanieLosowania());
            zwiekszZaklad.setBackground(new Color(102, 199, 91));
            zmniejszZaklad = BudowaGui.stworzButton(ramka, "", 590, 428, 25, 25, new PrzerwanieLosowania());
            zmniejszZaklad.setBackground(new Color(212, 59, 59));

            linie = BudowaGui.stworzJLabel(ramka, "Linie:", 330, 480, 100, 40);
            linieWartosc = BudowaGui.stworzTextFieldBezEdycji(ramka, 410, 488, 120, 25);

            zwiekszIloscLini = BudowaGui.stworzButton(ramka, "", 550, 488, 25, 25, new PrzerwanieLosowania());
            zwiekszIloscLini.setBackground(new Color(102, 199, 91));
            zmniejszIloscLini = BudowaGui.stworzButton(ramka, "", 590, 488, 25, 25, new PrzerwanieLosowania());
            zmniejszIloscLini.setBackground(new Color(212, 59, 59));

            zakonczGre = BudowaGui.stworzButton(ramka, "Zakończ Gre", 730, 530, 150,30, new PrzerwanieLosowania());

            ustawWartosci();

        }

        public void ustawWartosci () {
            hajsWartosc.setText(PanelGrySolo.getHajsWartosc().getText());
            ostatniaWygranaWartos.setText(PanelGrySolo.getOstatniaWygranaWartos().getText());
            zakladWartos.setText(PanelGrySolo.getZakladWartos().getText());
            linieWartosc.setText(PanelGrySolo.getLinieWartosc().getText());
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

