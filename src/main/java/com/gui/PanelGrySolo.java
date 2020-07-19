package com.gui;

import com.draw.Gracz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelGrySolo extends JPanel {


    private static JTextField hajsWartosc;
    private static JTextField ostatniaWygranaWartos;
    private static JTextField zakladWartos;
    private static JTextField linieWartosc;

    private static int gra = 0;

    JFrame ramkaGry;
    JLabel tlo;

    JLabel hajs;
    JLabel ostatniaWygrana;
    JLabel zaklad;
    JLabel linie;


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


        zwiekszZaklad = BudowaGui.stworzButton(ramka, "", 550, 428, 25, 25, new ZwiekszZaklad());
        zwiekszZaklad.setBackground(new Color(102, 199, 91));
        zmniejszZaklad = BudowaGui.stworzButton(ramka, "", 590, 428, 25, 25, new ZmniejszZaklad());
        zmniejszZaklad.setBackground(new Color(212, 59, 59));

        linie = BudowaGui.stworzJLabel(ramka, "Linie:", 330, 480, 100, 40);
        linieWartosc = BudowaGui.stworzTextFieldBezEdycji(ramka, 410, 488, 120, 25);

        zwiekszIloscLini = BudowaGui.stworzButton(ramka, "", 550, 488, 25, 25, new DodajLinie());
        zwiekszIloscLini.setBackground(new Color(102, 199, 91));
        zmniejszIloscLini = BudowaGui.stworzButton(ramka, "", 590, 488, 25, 25, new OdejmijLinie());
        zmniejszIloscLini.setBackground(new Color(212, 59, 59));

        zakonczGre = BudowaGui.stworzButton(ramka, "Zakończ Gre", 730, 530, 150,30, new ZakonczGre());


        ustawPoczatkoweWartosci();

    }

    private void ustawPoczatkoweWartosci() {
        hajsWartosc.setText(Gracz.getGotowka() + "");
        if (gra == 0) {
            ostatniaWygranaWartos.setText("0");
            zakladWartos.setText("5");
            linieWartosc.setText("1");
            gra++;
        }
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

    class ZwiekszZaklad implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            int wartosc = Integer.parseInt(zakladWartos.getText());
            wartosc += 5;

            zakladWartos.setText(wartosc + "");
        }
    }

    class ZmniejszZaklad implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            int wartosc = Integer.parseInt(zakladWartos.getText());
            if (wartosc > 5) {
                wartosc -= 5;
                zakladWartos.setText(wartosc + "");
            }

        }
    }

    class DodajLinie implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            int ilosc = Integer.parseInt(linieWartosc.getText());
            if (ilosc < 5) {
                ilosc += 1;
                linieWartosc.setText(ilosc + "");
            }
        }
    }

    class OdejmijLinie implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            int ilosc = Integer.parseInt(linieWartosc.getText());
            if (ilosc > 1) {
                ilosc -= 1;
                linieWartosc.setText(ilosc + "");
            }
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
                gra = 0;
                invalidate();
                repaint();
            }

        }
    }



    public static JTextField getHajsWartosc() {
        return hajsWartosc;
    }

    public static JTextField getOstatniaWygranaWartos() {
        return ostatniaWygranaWartos;
    }

    public static JTextField getZakladWartos() {
        return zakladWartos;
    }

    public static JTextField getLinieWartosc() {
        return linieWartosc;
    }
}
