package com.gui;

import com.serializacja.Mistrz;
import com.serializacja.MistrzComparatorGotowka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelWynikow extends JPanel {

    JFrame ramkaGry;
    JButton wroc;
    JLabel tlo;

    JLabel top;
    JTextArea opis;

    public PanelWynikow(JFrame ramka) {
        this.ramkaGry = ramka;

        tlo = BudowaGui.ustawGifJakoTlo(ramka, "gifyTla/topLista.png", this);

        wroc = BudowaGui.stworzButton(ramka, "Wróć", 650, 500, 190,40, new Wroc());

        top = BudowaGui.stworzJLabel(ramka, "TOP", 380,100,200,200);
        Font font = new Font("Times New Roman", Font.ITALIC + Font.BOLD, 80);
        top.setFont(font);
        top.setForeground(Color.RED);

        BudowaGui.stworzTextArea(ramka, tekstOpisu(), 360, 250, 400, 240);

        opis = BudowaGui.stworzTextArea(ramka, listaMistrzowKasyna(), 75, 185, 260, 500);
        Font font2 = new Font("Times New Roman", Font.ITALIC, 13);
        opis.setForeground(Color.black);
        opis.setFont(font2);


    }



    class Wroc implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            usunElementy();
            ramkaGry.add(new PanelKasyna(ramkaGry));

            invalidate();
            repaint();

        }
    }

    public void usunElementy() {
        Container kontener = ramkaGry.getContentPane();

        kontener.remove(Gra.panelGry);
        kontener.remove(wroc);
        tlo.setVisible(false);
    }

    public String tekstOpisu() {
        return "Oto lista dwudziesu największych zwycięzców w historii naszego kasyna!\n\nCzy masz odwagę, środki i odrobinę szczęścia żeby do nich dołączyć?\n\nPamiętaj, im wyższy zakład tym wyższa wygrana, więc nie obawiaj się porażki tylko zmierzaj ku zwycięstwu!\n\nTa lista jest najlepszym dodwodem na to, że sukces i bogactwo są na wyciągnięcie ręki!\n\nNie czekaj!\n\nZagraj i wzbogać się już dziś! ";
    }

    public String listaMistrzowKasyna() {

        if (!Mistrz.listaMistrzow.isEmpty()) {
            String tekst = "";
            Mistrz.listaMistrzow.sort(new MistrzComparatorGotowka());

            for (int i = 0; i < 20 && i < Mistrz.listaMistrzow.size(); i++)
                tekst += (i + 1) + "# " + Mistrz.listaMistrzow.get(i).getImie() + " opuścił kasyno z " + Mistrz.listaMistrzow.get(i).getGotowka() + " zł\n";

            return tekst;
        }
        return "Zostań pierwszym mistrzem kasyna!";
    }
}
