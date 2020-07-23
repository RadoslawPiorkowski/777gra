package com.gui;

import com.muzyka.DzwiekOszustwa;
import com.muzyka.DzwiekWygranej;
import com.muzyka.MuzykaTla;

import javax.swing.*;
import javax.sound.sampled.*;

import java.awt.*;
import java.io.IOException;


public class RamkaGry extends JFrame {


    public Container kontener;

    static MuzykaTla muzykaTla;
    static DzwiekOszustwa dziwekiOszustwa;
    static DzwiekWygranej dzwiekWygranej;

    public RamkaGry() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        super("Kasyno 777");

        muzykaTla = new MuzykaTla();
        if (MuzykaTla.getCzyWlaczyony() != 1f)
            MuzykaTla.wycisz();

        dzwiekWygranej = new DzwiekWygranej();
        dziwekiOszustwa = new DzwiekOszustwa();

        if (DzwiekWygranej.getCzyWlaczyony() != 1f) {
            DzwiekWygranej.wycisz();
            DzwiekOszustwa.wycisz();
        }


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


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(941, 622);
    }


}
