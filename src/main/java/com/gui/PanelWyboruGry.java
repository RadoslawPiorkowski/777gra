package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelWyboruGry extends JLayeredPane {

    JFrame ramkaGry;

    public PanelWyboruGry(JFrame ramka) {

        this.ramkaGry = ramka;

        BudowaGui.ustawGifJakoTlo(ramka, "gifyTla/startTlo.gif", this);


//        JButton btnNewButton = new JButton("");
//        btnNewButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Info clicked");
//            }
//        });
//
//        String iconfilePath = this.getClass().getClassLoader().getResource("aaa.png").getFile();
//        btnNewButton.setIcon(new ImageIcon(iconfilePath));
//        btnNewButton.setBounds(450, 300, 190, 43);
//        btnNewButton.setBorder(BorderFactory.createEmptyBorder());
//        btnNewButton.setContentAreaFilled(false);
//        btnNewButton.setFocusable(false);
//        ramka.add(btnNewButton);

        BudowaGui.stworzButton(ramka, "Jeden Gracz", 370,230,190,40, new AkcjaWybory());
        BudowaGui.stworzButton(ramka, "Dwóch Graczy", 370,320,190,40, new AkcjaWybory());
        BudowaGui.stworzButton(ramka, "Wyjście", 370,410,190,40, new AkcjaWybory());

    }



    @Override
    public Dimension getPreferredSize() {
        return new Dimension(945, 595);

    }

    class AkcjaWybory implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {


        }
    }
}
