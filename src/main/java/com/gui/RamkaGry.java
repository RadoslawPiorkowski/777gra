package com.gui;

import javax.swing.*;
import java.awt.*;

import java.io.IOException;

public class RamkaGry extends JFrame {

    public Container kontener;
    public JPanel start, opcje;


    public RamkaGry() throws IOException {
        super("Kasyno 777");

        Dimension ekran = Toolkit.getDefaultToolkit().getScreenSize();
        int wysEkranu = ekran.height;
        int szerEkranu = ekran.width;
        this.setSize(szerEkranu/2, wysEkranu/2);

        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);


        ImageIcon ikon = new ImageIcon(this.getClass().getResource("/gifyTla/ikona.png"));
        this.setIconImage(ikon.getImage());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public void zmienNaOpcjie() {

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(941, 622);
    }



}
