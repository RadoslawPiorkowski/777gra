package com.gui;

import com.draw.Generowanie;
import com.draw.Gracz;
import com.draw.Znaki;
import com.muzyka.DzwiekOszustwa;
import com.muzyka.DzwiekWygranej;
import com.serializacja.Mistrz;
import com.serializacja.Serializacja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelGrySolo extends JPanel {


    JFrame ramkaGry;
    JLabel tlo;
    public static int gra = 0;
    static int oszustwo = 0;
    public static boolean zlapanoNaOszustwie = false;


    private static JTextField hajsWartosc;
    private static JTextField ostatniaWygranaWartos;
    private static JTextField zakladWartos;
    private static JTextField linieWartosc;

    JLabel s11, s12, s13;
    JLabel s21, s22, s23;
    JLabel s31, s32, s33;

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
        s11 = BudowaGui.ustawSymbol(ramka, tabelaSymboloi[0][0].getGrafika(), this, 154, 62);
        s12 = BudowaGui.ustawSymbol(ramka, tabelaSymboloi[0][1].getGrafika(), this, 284, 62);
        s13 = BudowaGui.ustawSymbol(ramka, tabelaSymboloi[0][2].getGrafika(), this, 414, 62);

        s21 = BudowaGui.ustawSymbol(ramka, tabelaSymboloi[1][0].getGrafika(), this, 150, 172);
        s22 = BudowaGui.ustawSymbol(ramka, tabelaSymboloi[1][1].getGrafika(), this, 278, 172);
        s23 = BudowaGui.ustawSymbol(ramka, tabelaSymboloi[1][2].getGrafika(), this, 408, 172);

        s31 = BudowaGui.ustawSymbol(ramka, tabelaSymboloi[2][0].getGrafika(), this, 150, 282);
        s32 = BudowaGui.ustawSymbol(ramka, tabelaSymboloi[2][1].getGrafika(), this, 278, 282);
        s33 = BudowaGui.ustawSymbol(ramka, tabelaSymboloi[2][2].getGrafika(), this, 408, 282);


        //przyciski oszustwa
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

        zakonczGre = BudowaGui.stworzButton(ramka, "Zakończ Grę", 730, 530, 150,30, new ZakonczGre());


        if (zlapanoNaOszustwie) {
            try {
                puscDzwiekPrzylapania();
            } catch (Exception e) {
                e.printStackTrace();
            }
            przylapanoNaOszustiwe();
        }


        ustawWartosci();

        if (Integer.parseInt(ostatniaWygranaWartos.getText()) != 0 && Integer.parseInt(hajsWartosc.getText()) != 5) {
            try {
                puscDzwiekWygranej();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        czyMaszPieniadze();


    }

    private static void ustawPoczatkoweWartosci() {
        hajsWartosc.setText(Gracz.getGotowka() + "");
        if (gra == 0) {
            ostatniaWygranaWartos.setText("0");
            zakladWartos.setText("5");
            linieWartosc.setText("1");
            gra++;
        }
    }

    public static void ustawWartosci () {
        if (gra == 0)
            ustawPoczatkoweWartosci();
        else {
            hajsWartosc.setText(Gracz.getGotowka() + "");
            ostatniaWygranaWartos.setText(Gracz.getWynik() + "");
            zakladWartos.setText(LosowaniePanel.getZakladWartos().getText());
            linieWartosc.setText(LosowaniePanel.getLinieWartosc().getText());
        }
    }


    class Losowanie implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            if (sprawdzCzywystarczyGotowkiNaGre()) {

                odejmijPieniadzeZaZaklad();

                Container kontener = ramkaGry.getContentPane();
                tlo.setVisible(false);
                kontener.remove(dzwignia);
                kontener.add(new LosowaniePanel(ramkaGry));
                invalidate();
                repaint();

            } else
                brakFuduszyInfo();
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

        public static void przylapanoNaOszustiwe() {
        Gracz.setGotowka(5);
        JOptionPane.showMessageDialog(null, "Zostałeś złapany na oszustwie!\nWiększość Twoich pieniędzy została 'skonfiskowna na pokrycie strat kasyna'");
        zlapanoNaOszustwie = false;
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

            Object[] opcje = {"Tak, wychodzę!", "Nie, zostanę"};


            int decyzja = JOptionPane.showOptionDialog(null, "Czy napewno chcesz wyjść z gry?", "Wyjśćie", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcje, opcje[0]);
            if (decyzja == JOptionPane.YES_OPTION) {
                if (Integer.parseInt(hajsWartosc.getText()) > 200)
                    zapiszWynik();

                usunElementy();
                wrocNaStart();
            }
        }
    }

    public void czyMaszPieniadze() {
        if(Gracz.getGotowka() <= 0){
            JOptionPane.showMessageDialog(null, "Zbankrutowałeś!\nZostałeś wyrzucony z kasyna!\nZapraszamy ponownie po wypłacie");
            usunElementy();
            wrocNaStart();
        }
    }

    public boolean sprawdzCzywystarczyGotowkiNaGre() {
        int iloscPieniedzy = Integer.parseInt(hajsWartosc.getText());
        int zaklad = Integer.parseInt(zakladWartos.getText());
        int obstawianeLinie = Integer.parseInt(linieWartosc.getText());

        if (iloscPieniedzy < (zaklad * obstawianeLinie))
            return false;
        else
            return true;
    }

    public void odejmijPieniadzeZaZaklad() {
        int wczesnaIloscPieniedzy = Integer.parseInt(hajsWartosc.getText());
        int zaklad = Integer.parseInt(zakladWartos.getText());
        int obstawianeLinie = Integer.parseInt(linieWartosc.getText());

        int iloscPieniedzyPoZakladzie = wczesnaIloscPieniedzy - (zaklad * obstawianeLinie);

        Gracz.setGotowka(iloscPieniedzyPoZakladzie);
    }

    public void brakFuduszyInfo() {
        JOptionPane.showMessageDialog(null, "Brak gototówki na taki zakład");
    }


    public void usunElementy() {
        ramkaGry.getContentPane().remove(zwiekszZaklad);
        ramkaGry.getContentPane().remove(zmniejszZaklad);
        ramkaGry.getContentPane().remove(zmniejszIloscLini);
        ramkaGry.getContentPane().remove(zwiekszIloscLini);

        ramkaGry.getContentPane().remove(dzwignia);
        ramkaGry.getContentPane().remove(zakonczGre);

        ramkaGry.getContentPane().remove(oszukuj1);
        ramkaGry.getContentPane().remove(oszukuj2);
        ramkaGry.getContentPane().remove(oszukuj3);
        ramkaGry.getContentPane().remove(oszukuj4);
        ramkaGry.getContentPane().remove(oszukuj5);
    }

    public void wrocNaStart() {
        Container kontener = ramkaGry.getContentPane();
        tlo.setVisible(false);
        usunElementy();
        kontener.add(new PanelStartowy(ramkaGry));
        gra = 0;
        invalidate();
        repaint();
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

    public void zapiszWynik() {
        String imie = JOptionPane.showInputDialog("Podaj swoje imię, a może trafisz na listę mistrzów naszego kasyna!");
        try {
            if (imie.length() <= 15)
                dodajDoListyMistrzow(imie);
            else {
                JOptionPane.showMessageDialog(null,"Zbyt długie imie!\nMoże pseudonim?");
                zapiszWynik();
            }
        } catch (NullPointerException e) {
            e.getStackTrace();
        }
    }

    public void dodajDoListyMistrzow(String imie) {
        Mistrz.listaMistrzow.add(new Mistrz(imie, Integer.parseInt(hajsWartosc.getText())));
        Serializacja.zapisDoPliku(Mistrz.listaMistrzow);
    }

    private void puscDzwiekWygranej(){
            DzwiekWygranej.graj();
    }

    private void puscDzwiekPrzylapania(){
            DzwiekOszustwa.graj();
    }

}
