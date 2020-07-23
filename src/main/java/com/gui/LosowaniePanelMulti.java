package com.gui;

import com.draw.Generowanie;
import com.draw.Gracz;
import com.draw.GraczMulti;
import com.draw.Sprawdzanie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LosowaniePanelMulti extends JPanel {

    JFrame ramkaGry;
    JLabel tlo;

    JLabel hajs;
    JLabel ostatniaWygrana;
    JLabel zaklad;
    JLabel linie;

    private static JTextField hajsWartosc1;
    private static JTextField ostatniaWygranaWartos1;
    private static JTextField zakladWartos1;
    private static JTextField linieWartosc1;

    private static JTextField hajsWartosc2;
    private static JTextField ostatniaWygranaWartos2;
    private static JTextField zakladWartos2;
    private static JTextField linieWartosc2;

    JButton zwiekszZaklad1;
    JButton zmniejszZaklad1;
    JButton zwiekszIloscLini1;
    JButton zmniejszIloscLini1;

    JButton zwiekszZaklad2;
    JButton zmniejszZaklad2;
    JButton zwiekszIloscLini2;
    JButton zmniejszIloscLini2;

    JButton dzwignia;
    JButton zakonczGre;

    public LosowaniePanelMulti(JFrame ramka) {
        this.ramkaGry = ramka;


        tlo = BudowaGui.ustawGifJakoTlo(ramka, "gifyTla/losowanie.gif", this);
        dzwignia = BudowaGui.stworzUkrytyButton(true,ramka, "", 587, 138, 50,300, new PrzerwanieLosowania());

        BudowaGui.stworzJLabel(ramka, "Gracz 1", 80, 450,100,25);
        BudowaGui.stworzJLabel(ramka, "Gracz 2", 80, 490,100,25);


        hajs = BudowaGui.stworzJLabel(ramka, "Gotówka:", 160, 415, 100, 25);
        hajsWartosc1 = BudowaGui.stworzTextFieldBezEdycji(ramka, 140, 450, 80, 25);
        hajsWartosc2 = BudowaGui.stworzTextFieldBezEdycji(ramka, 140, 490, 80, 25);


        ostatniaWygrana = BudowaGui.stworzJLabel(ramka, "Wygrana:", 250, 415, 100, 25);
        ostatniaWygranaWartos1 = BudowaGui.stworzTextFieldBezEdycji(ramka, 240, 450, 80, 25);
        ostatniaWygranaWartos2 = BudowaGui.stworzTextFieldBezEdycji(ramka, 240, 490, 80, 25);

        zaklad = BudowaGui.stworzJLabel(ramka, "Zakład:", 360, 415, 100, 25);
        zakladWartos1 = BudowaGui.stworzTextFieldBezEdycji(ramka, 340, 450, 80, 25);
        zakladWartos2 = BudowaGui.stworzTextFieldBezEdycji(ramka, 340, 490, 80, 25);


        zwiekszZaklad1 = BudowaGui.stworzButton(ramka, "", 430, 450, 25, 22, new NicNieRob());
        zwiekszZaklad1.setBackground(new Color(102, 199, 91));
        zmniejszZaklad1 = BudowaGui.stworzButton(ramka, "", 460, 450, 25, 22, new NicNieRob());
        zmniejszZaklad1.setBackground(new Color(212, 59, 59));

        zwiekszZaklad2 = BudowaGui.stworzButton(ramka, "", 430, 490, 25, 22, new NicNieRob());
        zwiekszZaklad2.setBackground(new Color(102, 199, 91));
        zmniejszZaklad2 = BudowaGui.stworzButton(ramka, "", 460, 490, 25, 22, new NicNieRob());
        zmniejszZaklad2.setBackground(new Color(212, 59, 59));


        linie = BudowaGui.stworzJLabel(ramka, "Linie:", 520, 415, 100, 25);
        linieWartosc1 = BudowaGui.stworzTextFieldBezEdycji(ramka, 500, 450, 80, 25);
        linieWartosc2 = BudowaGui.stworzTextFieldBezEdycji(ramka, 500, 490, 80, 25);

        zwiekszIloscLini1 = BudowaGui.stworzButton(ramka, "", 600, 450, 25, 25, new NicNieRob());
        zwiekszIloscLini1.setBackground(new Color(102, 199, 91));
        zmniejszIloscLini1 = BudowaGui.stworzButton(ramka, "", 630, 450, 25, 25, new NicNieRob());
        zmniejszIloscLini1.setBackground(new Color(212, 59, 59));

        zwiekszIloscLini2 = BudowaGui.stworzButton(ramka, "", 600, 490, 25, 25, new NicNieRob());
        zwiekszIloscLini2.setBackground(new Color(102, 199, 91));
        zmniejszIloscLini2 = BudowaGui.stworzButton(ramka, "", 630, 490, 25, 25, new NicNieRob());
        zmniejszIloscLini2.setBackground(new Color(212, 59, 59));


        zakonczGre = BudowaGui.stworzButton(ramka, "Zakończ", 730, 530, 150,30, new PrzerwanieLosowania());

        ustawWartosci();
    }

    public static void ustawWartosci () {
        hajsWartosc1.setText(Gracz.getGotowka() + "");
        ostatniaWygranaWartos1.setText(Gracz.getWynik() + "");
        zakladWartos1.setText(PanelGryMulti.getZakladWartos1().getText());
        linieWartosc1.setText(PanelGryMulti.getLinieWartosc1().getText());

        hajsWartosc2.setText(GraczMulti.getGotowka() + "");
        ostatniaWygranaWartos2.setText(GraczMulti.getWynik() + "");
        zakladWartos2.setText(PanelGryMulti.getZakladWartos2().getText());
        linieWartosc2.setText(PanelGryMulti.getLinieWartosc2().getText());
    }

    class PrzerwanieLosowania implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            Generowanie.random();

            sprawdzWygrana1();
            sprawdzWygrana2();
            usunElementy();
            ramkaGry.getContentPane().removeAll();
            ramkaGry.getContentPane().add(new PanelGryMulti(ramkaGry));
            invalidate();
            repaint();
        }
    }


    class NicNieRob implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
        }
    }


    public void usunElementy() {
        Container kontener = ramkaGry.getContentPane();
        tlo.setVisible(false);
        kontener.remove(dzwignia);

        ramkaGry.getContentPane().remove(zwiekszZaklad1);
        ramkaGry.getContentPane().remove(zmniejszZaklad1);
        ramkaGry.getContentPane().remove(zmniejszIloscLini1);
        ramkaGry.getContentPane().remove(zwiekszIloscLini1);

        ramkaGry.getContentPane().remove(zwiekszZaklad2);
        ramkaGry.getContentPane().remove(zmniejszZaklad2);
        ramkaGry.getContentPane().remove(zmniejszIloscLini2);
        ramkaGry.getContentPane().remove(zwiekszIloscLini2);

    }

    public static void sprawdzWygrana1() {

        int zaklad = Integer.parseInt(zakladWartos1.getText());
        int obstawianeLinie = Integer.parseInt(linieWartosc2.getText());
        int wartoscZakladu = zaklad * obstawianeLinie;

        if (obstawianeLinie == 1)
            Sprawdzanie.zakladJednaLinia(wartoscZakladu);
        else if (obstawianeLinie == 2)
            Sprawdzanie.zakladDwieLinia(wartoscZakladu);
        else if (obstawianeLinie == 3)
            Sprawdzanie.zakladTrzyLinia(wartoscZakladu);
        else if (obstawianeLinie == 4)
            Sprawdzanie.zakladCzteryLinia(wartoscZakladu);
        else
            Sprawdzanie.zakladPiecLinia(wartoscZakladu);

    }

    public static void sprawdzWygrana2() {

        int zaklad = Integer.parseInt(zakladWartos2.getText());
        int obstawianeLinie = Integer.parseInt(linieWartosc2.getText());
        int wartoscZakladu = zaklad * obstawianeLinie;

        if (obstawianeLinie == 1)
            Sprawdzanie.zakladJednaLiniaMulti(wartoscZakladu);
        else if (obstawianeLinie == 2)
            Sprawdzanie.zakladDwieLiniaMulti(wartoscZakladu);
        else if (obstawianeLinie == 3)
            Sprawdzanie.zakladTrzyLiniaMulti(wartoscZakladu);
        else if (obstawianeLinie == 4)
            Sprawdzanie.zakladCzteryLiniaMulti(wartoscZakladu);
        else
            Sprawdzanie.zakladPiecLiniaMulti(wartoscZakladu);

    }


    public static JTextField getZakladWartos1() {
        return zakladWartos1;
    }

    public static JTextField getLinieWartosc1() {
        return linieWartosc1;
    }

    public static JTextField getZakladWartos2() {
        return zakladWartos2;
    }

    public static JTextField getLinieWartosc2() {
        return linieWartosc2;
    }
}
