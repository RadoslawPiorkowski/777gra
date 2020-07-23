package com.gui;

import com.draw.Generowanie;
import com.draw.Gracz;
import com.draw.GraczMulti;
import com.draw.Znaki;
import com.muzyka.DzwiekWygranej;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PanelGryMulti extends JPanel {

    DzwiekWygranej dzwiekWygranej;

    JFrame ramkaGry;
    JLabel tlo;
    public static int gra = 50;

    private static JTextField hajsWartosc1;
    private static JTextField ostatniaWygranaWartos1;
    private static JTextField zakladWartos1;
    private static JTextField linieWartosc1;

    private static JTextField hajsWartosc2;
    private static JTextField ostatniaWygranaWartos2;
    private static JTextField zakladWartos2;
    private static JTextField linieWartosc2;

    JLabel s11, s12, s13;
    JLabel s21, s22, s23;
    JLabel s31, s32, s33;

    JLabel hajs;
    JLabel ostatniaWygrana;
    JLabel zaklad;
    JLabel linie;


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

    Znaki[][] tabelaSymboloi = Generowanie.losowanie;


    public PanelGryMulti(JFrame ramka) {
        this.ramkaGry = ramka;

        if (gra == 50)
            Generowanie.random();

        tlo = BudowaGui.ustawGifJakoTlo(ramka, "gifyTla/automat.gif", this);

        //symbole
        s11 = BudowaGui.ustawSymbol(ramka, tabelaSymboloi[0][0].getGrafika(), this, 152, 62);
        s12 = BudowaGui.ustawSymbol(ramka, tabelaSymboloi[0][1].getGrafika(), this, 282, 62);
        s13 = BudowaGui.ustawSymbol(ramka, tabelaSymboloi[0][2].getGrafika(), this, 412, 62);

        s21 = BudowaGui.ustawSymbol(ramka, tabelaSymboloi[1][0].getGrafika(), this, 150, 172);
        s22 = BudowaGui.ustawSymbol(ramka, tabelaSymboloi[1][1].getGrafika(), this, 278, 172);
        s23 = BudowaGui.ustawSymbol(ramka, tabelaSymboloi[1][2].getGrafika(), this, 408, 172);

        s31 = BudowaGui.ustawSymbol(ramka, tabelaSymboloi[2][0].getGrafika(), this, 150, 282);
        s32 = BudowaGui.ustawSymbol(ramka, tabelaSymboloi[2][1].getGrafika(), this, 278, 282);
        s33 = BudowaGui.ustawSymbol(ramka, tabelaSymboloi[2][2].getGrafika(), this, 408, 282);


        dzwignia = BudowaGui.stworzUkrytyButton(true,ramka, "", 587, 138, 50,150, new Losowanie());

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


        zwiekszZaklad1 = BudowaGui.stworzButton(ramka, "", 430, 450, 25, 22, new ZwiekszZaklad());
        zwiekszZaklad1.setBackground(new Color(102, 199, 91));
        zmniejszZaklad1 = BudowaGui.stworzButton(ramka, "", 460, 450, 25, 22, new ZmniejszZaklad());
        zmniejszZaklad1.setBackground(new Color(212, 59, 59));

        zwiekszZaklad2 = BudowaGui.stworzButton(ramka, "", 430, 490, 25, 22, new ZwiekszZaklad());
        zwiekszZaklad2.setBackground(new Color(102, 199, 91));
        zmniejszZaklad2 = BudowaGui.stworzButton(ramka, "", 460, 490, 25, 22, new ZmniejszZaklad());
        zmniejszZaklad2.setBackground(new Color(212, 59, 59));


        linie = BudowaGui.stworzJLabel(ramka, "Linie:", 520, 415, 100, 25);
        linieWartosc1 = BudowaGui.stworzTextFieldBezEdycji(ramka, 500, 450, 80, 25);
        linieWartosc2 = BudowaGui.stworzTextFieldBezEdycji(ramka, 500, 490, 80, 25);

        zwiekszIloscLini1 = BudowaGui.stworzButton(ramka, "", 600, 450, 25, 25, new DodajLinie());
        zwiekszIloscLini1.setBackground(new Color(102, 199, 91));
        zmniejszIloscLini1 = BudowaGui.stworzButton(ramka, "", 630, 450, 25, 25, new OdejmijLinie());
        zmniejszIloscLini1.setBackground(new Color(212, 59, 59));

        zwiekszIloscLini2 = BudowaGui.stworzButton(ramka, "", 600, 490, 25, 25, new DodajLinie());
        zwiekszIloscLini2.setBackground(new Color(102, 199, 91));
        zmniejszIloscLini2 = BudowaGui.stworzButton(ramka, "", 630, 490, 25, 25, new OdejmijLinie());
        zmniejszIloscLini2.setBackground(new Color(212, 59, 59));


        zakonczGre = BudowaGui.stworzButton(ramka, "Zakończ Gre", 730, 530, 150,30, new ZakonczGre());

        ustawWartosci();

        if (Integer.parseInt(ostatniaWygranaWartos1.getText()) != 0 || Integer.parseInt(ostatniaWygranaWartos2.getText()) != 0) {
            try {
                puscDzwiekWygranej();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        czyGraczeMajaPieniadze();
        koniecGry();

    }


    private static void ustawPoczatkoweWartosci() {
        hajsWartosc1.setText(Gracz.getGotowka() + "");
        ostatniaWygranaWartos1.setText("0");
        zakladWartos1.setText("5");
        linieWartosc1.setText("1");

        hajsWartosc2.setText(GraczMulti.getGotowka() + "");
        ostatniaWygranaWartos2.setText("0");
        zakladWartos2.setText("5");
        linieWartosc2.setText("1");

    }


    public static void ustawWartosci () {
        if (gra == 50)
            ustawPoczatkoweWartosci();
        else {
            hajsWartosc1.setText(Gracz.getGotowka() + "");
            ostatniaWygranaWartos1.setText(Gracz.getWynik() + "");
            zakladWartos1.setText(LosowaniePanelMulti.getZakladWartos1().getText());
            linieWartosc1.setText(LosowaniePanelMulti.getLinieWartosc1().getText());

            hajsWartosc2.setText(GraczMulti.getGotowka() + "");
            ostatniaWygranaWartos2.setText(GraczMulti.getWynik() + "");
            zakladWartos2.setText(LosowaniePanelMulti.getZakladWartos2().getText());
            linieWartosc2.setText(LosowaniePanelMulti.getLinieWartosc2().getText());
        }

        gra--;
    }


    class Losowanie implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {


            if (sprawdzCzyWystarczyGotowkiNaGre()) {
               odejmijPieniadzeZaZaklad();


                Container kontener = ramkaGry.getContentPane();
                tlo.setVisible(false);
                kontener.remove(dzwignia);
                usunElementy();
                kontener.add(new LosowaniePanelMulti(ramkaGry));
                invalidate();
                repaint();

            } else
                brakFuduszyInfo();
        }
    }

    class ZwiekszZaklad implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            Object o = actionEvent.getSource();

            if (o == zwiekszZaklad1) {
                int wartosc = Integer.parseInt(zakladWartos1.getText());
                wartosc += 5;
                zakladWartos1.setText(wartosc + "");
            }else if (o == zwiekszZaklad2) {
                int wartosc = Integer.parseInt(zakladWartos2.getText());
                wartosc += 5;
                zakladWartos2.setText(wartosc + "");
            }
        }
    }



    class ZmniejszZaklad implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            Object o = actionEvent.getSource();

            if (o == zmniejszZaklad1) {
                int wartosc = Integer.parseInt(zakladWartos1.getText());
                if (wartosc > 5) {
                    wartosc -= 5;
                    zakladWartos1.setText(wartosc + "");
                }
            } else if (o == zmniejszZaklad2) {
                int wartosc = Integer.parseInt(zakladWartos2.getText());
                if (wartosc > 5) {
                    wartosc -= 5;
                    zakladWartos2.setText(wartosc + "");
                }
            }
        }
    }


    class DodajLinie implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            Object o = actionEvent.getSource();

            if (o == zwiekszIloscLini1) {
                int ilosc = Integer.parseInt(linieWartosc1.getText());
                if (ilosc < 5) {
                    ilosc += 1;
                    linieWartosc1.setText(ilosc + "");
                }
            } else if (o == zwiekszIloscLini2) {
                int ilosc = Integer.parseInt(linieWartosc2.getText());
                if (ilosc < 5) {
                    ilosc += 1;
                    linieWartosc2.setText(ilosc + "");
                }
            }
        }
    }



    class OdejmijLinie implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            Object o = actionEvent.getSource();

            if (o == zmniejszIloscLini1) {
                int ilosc = Integer.parseInt(linieWartosc1.getText());
                if (ilosc > 1) {
                    ilosc -= 1;
                    linieWartosc1.setText(ilosc + "");
                }
            } else if (o == zmniejszIloscLini2) {
                int ilosc = Integer.parseInt(linieWartosc2.getText());
                if (ilosc > 1) {
                    ilosc -= 1;
                    linieWartosc2.setText(ilosc + "");
                }
            }
        }
    }


    class ZakonczGre implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            UIManager belka = new UIManager();
            belka.put("OptionPane.background",
                    new ColorUIResource(148, 129, 65));
            belka.put("Panel.background",
                    new ColorUIResource(148, 129, 65));
            Object[] opcje = {"Tak, wychodzimy!", "Nie, dokończymy!"};

            int decyzja = JOptionPane.showOptionDialog(null, "Czy napewno chcecie przerwać gre przed końcem?", "Wyjśćie", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcje, opcje[0]);
            if (decyzja == JOptionPane.YES_OPTION) {
                usunElementy();
                wrocNaStart();
            }
        }
    }

    public void czyGraczeMajaPieniadze() {

        UIManager belka = new UIManager();
        belka.put("OptionPane.background",
                new ColorUIResource(148, 129, 65));
        belka.put("Panel.background",
                new ColorUIResource(148, 129, 65));
        if(Gracz.getGotowka() <= 0){
            JOptionPane.showMessageDialog(null, "Gracz 1 zbankrutował!\nGracz 2 wygrywa grę!");
            wrocNaStart();
        }

        if(GraczMulti.getGotowka() <= 0){
            JOptionPane.showMessageDialog(null, "Gracz 2 zbankrutował!\nGracz 1 wygrywa grę!");
            wrocNaStart();
        }
    }

    public void koniecGry() {
        int gracz1Gotowka = Gracz.getGotowka();
        int gracz2Gotowka = GraczMulti.getGotowka();

        UIManager belka = new UIManager();
        belka.put("OptionPane.background",
                new ColorUIResource(148, 129, 65));
        belka.put("Panel.background",
                new ColorUIResource(148, 129, 65));

        if (gra == 0) {
            if (gracz1Gotowka > gracz2Gotowka)
                JOptionPane.showMessageDialog(null, "Gracz 1 bardziej się dorobił i wygrywa grę!");
            else if (gracz2Gotowka > gracz1Gotowka)
                JOptionPane.showMessageDialog(null, "Gracz 2 bardziej się dorobił i wygrywa grę!");
            else
                JOptionPane.showMessageDialog(null, "Gra zakończona remisem!");

            wrocNaStart();
        }
    }

    public boolean sprawdzCzyWystarczyGotowkiNaGre() {
        int iloscPieniedzy1 = Integer.parseInt(hajsWartosc1.getText());
        int zaklad1 = Integer.parseInt(zakladWartos1.getText());
        int obstawianeLinie1 = Integer.parseInt(linieWartosc1.getText());

        int iloscPieniedzy2 = Integer.parseInt(hajsWartosc2.getText());
        int zaklad2 = Integer.parseInt(zakladWartos2.getText());
        int obstawianeLinie2 = Integer.parseInt(linieWartosc2.getText());


        return iloscPieniedzy1 >= (zaklad1 * obstawianeLinie1) && (iloscPieniedzy2 >= (zaklad2 * obstawianeLinie2));
    }

    public void odejmijPieniadzeZaZaklad() {
        int wczesnaIloscPieniedzy1 = Integer.parseInt(hajsWartosc1.getText());
        int zaklad1 = Integer.parseInt(zakladWartos1.getText());
        int obstawianeLinie1 = Integer.parseInt(linieWartosc1.getText());
        int iloscPieniedzyPoZakladzie1 = wczesnaIloscPieniedzy1- (zaklad1 * obstawianeLinie1);
        Gracz.setGotowka(iloscPieniedzyPoZakladzie1);

        int wczesnaIloscPieniedzy2 = Integer.parseInt(hajsWartosc2.getText());
        int zaklad2 = Integer.parseInt(zakladWartos2.getText());
        int obstawianeLinie2 = Integer.parseInt(linieWartosc2.getText());
        int iloscPieniedzyPoZakladzie2 = wczesnaIloscPieniedzy2- (zaklad2 * obstawianeLinie2);
        GraczMulti.setGotowka(iloscPieniedzyPoZakladzie2);
    }


    public void brakFuduszyInfo() {
        UIManager belka = new UIManager();
        belka.put("OptionPane.background",
                new ColorUIResource(148, 129, 65));
        belka.put("Panel.background",
                new ColorUIResource(148, 129, 65));
        JOptionPane.showMessageDialog(null, "Jedn z graczy próbuje postawić więcej niż posiada...");
    }


    public void usunElementy() {
        ramkaGry.getContentPane().remove(zwiekszZaklad1);
        ramkaGry.getContentPane().remove(zmniejszZaklad1);
        ramkaGry.getContentPane().remove(zmniejszIloscLini1);
        ramkaGry.getContentPane().remove(zwiekszIloscLini1);

        ramkaGry.getContentPane().remove(zwiekszZaklad2);
        ramkaGry.getContentPane().remove(zmniejszZaklad2);
        ramkaGry.getContentPane().remove(zmniejszIloscLini2);
        ramkaGry.getContentPane().remove(zwiekszIloscLini2);

        ramkaGry.getContentPane().remove(dzwignia);
        ramkaGry.getContentPane().remove(zakonczGre);
    }

    public void wrocNaStart() {
        Container kontener = ramkaGry.getContentPane();
        tlo.setVisible(false);
        usunElementy();
        kontener.add(new PanelStartowy(ramkaGry));
        gra = 25;
        invalidate();
        repaint();
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

    private void puscDzwiekWygranej() {

        dzwiekWygranej = new DzwiekWygranej();
        dzwiekWygranej.graj();
    }

}
