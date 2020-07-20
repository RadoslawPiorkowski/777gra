package com.gui;

import com.draw.Generowanie;
import com.draw.Gracz;
import com.draw.Znaki;

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

    static int oszustwo = 0;


    JLabel s11;
    JLabel s12;
    JLabel s13;
    JLabel s21;
    JLabel s22;
    JLabel s23;
    JLabel s31;
    JLabel s32;
    JLabel s33;

    JLabel hajs;
    JLabel ostatniaWygrana;
    JLabel zaklad;
    JLabel linie;

    JButton oszukuj1,oszukuj2,oszukuj3,oszukuj4,oszukuj5;

    JButton zwiekszZaklad;
    JButton zmniejszZaklad;
    JButton zwiekszIloscLini;
    JButton zmniejszIloscLini;

    JButton dzwignia;
    JButton zakonczGre;

    Znaki[][] tabelaSymboloi = Generowanie.losowanie;



    public PanelGrySolo(JFrame ramka) {

        this.ramkaGry = ramka;



        if (gra == 0)
            Generowanie.random();



        tlo = BudowaGui.ustawGifJakoTlo(ramka, "gifyTla/automat.gif", this);

        //symbole
        s11 = BudowaGui.ustawSymbol(ramka, tabelaSymboloi[0][0].getGrafika(), this, 152, 62);
        s12 = BudowaGui.ustawSymbol(ramka, tabelaSymboloi[0][1].getGrafika(), this, 282, 62);
        s13 = BudowaGui.ustawSymbol(ramka, tabelaSymboloi[0][2].getGrafika(), this, 412, 62);

        s21 = BudowaGui.ustawSymbol(ramka, tabelaSymboloi[1][0].getGrafika(), this, 148, 172);
        s22 = BudowaGui.ustawSymbol(ramka, tabelaSymboloi[1][1].getGrafika(), this, 278, 172);
        s23 = BudowaGui.ustawSymbol(ramka, tabelaSymboloi[1][2].getGrafika(), this, 408, 172);

        s31 = BudowaGui.ustawSymbol(ramka, tabelaSymboloi[2][0].getGrafika(), this, 148, 282);
        s32 = BudowaGui.ustawSymbol(ramka, tabelaSymboloi[2][1].getGrafika(), this, 278, 282);
        s33 = BudowaGui.ustawSymbol(ramka, tabelaSymboloi[2][2].getGrafika(), this, 408, 282);


        oszukuj4 = BudowaGui.stworzUkrytyButton(true,ramka,"" , 95, 78, 30,30, new Oszukuj());
        oszukuj2 = BudowaGui.stworzUkrytyButton(true, ramka,"" , 95, 145, 30,30, new Oszukuj());
        oszukuj1 = BudowaGui.stworzUkrytyButton(true,ramka,"" , 95, 210, 30,30, new Oszukuj());
        oszukuj3 = BudowaGui.stworzUkrytyButton(true,ramka,"" , 93, 271, 30,30, new Oszukuj());
        oszukuj5 = BudowaGui.stworzUkrytyButton(true, ramka,"" , 95, 335, 30,30, new Oszukuj());


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

        ustawWartosci();
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

    public static void ustawWartosci () {
        if (gra > 0) {
            hajsWartosc.setText(LosowaniePanel.getHajsWartosc().getText());
            ostatniaWygranaWartos.setText(LosowaniePanel.getOstatniaWygranaWartos().getText());
            zakladWartos.setText(LosowaniePanel.getZakladWartos().getText());
            linieWartosc.setText(LosowaniePanel.getLinieWartosc().getText());
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

    class Oszukuj implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            Object o = actionEvent.getSource();

            if (o == oszukuj1 && oszustwo == 0)
                setOszustwo(1);
            else if (o == oszukuj2 && oszustwo == 1)
                setOszustwo(2);
            else if (o == oszukuj3 && oszustwo == 2)
                setOszustwo(3);
            else if (o == oszukuj4 && oszustwo == 3)
                setOszustwo(4);
            else if (o == oszukuj5 && oszustwo == 4)
                setOszustwo(5);

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

            Object[] opcje = {"Tak, wychodze!", "Nie, no zostane"};

            int decyzja = JOptionPane.showOptionDialog(null, "Czy napewno chcesz wyjść z gry?", "Wyjśćie", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcje, opcje[0]);
            if (decyzja == JOptionPane.YES_OPTION) {
                Container kontener = ramkaGry.getContentPane();
                tlo.setVisible(false);
                kontener.remove(dzwignia);
                kontener.remove(zakonczGre);
                usunElementy();
                kontener.add(new PanelStartowy(ramkaGry));
                PanelGrySolo.gra = 0;
                invalidate();
                repaint();
            }

        }
    }



    public void usunElementy() {
        ramkaGry.getContentPane().remove(zwiekszZaklad);
        ramkaGry.getContentPane().remove(zmniejszZaklad);
        ramkaGry.getContentPane().remove(zmniejszIloscLini);
        ramkaGry.getContentPane().remove(zwiekszIloscLini);
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

    public void setOszustwo(int oszustwo) {
        PanelGrySolo.oszustwo = oszustwo;
    }
}
