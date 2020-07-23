package com.gui;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

public class Gra {

    static JFrame ekranGry;
    static JPanel panelGry;


    public static void rozpocznijGre() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        ekranGry = new RamkaGry();
        panelGry = new PanelStartowy(ekranGry);
        ekranGry.getContentPane().add(panelGry);

        ekranGry.setVisible(true);
        ekranGry.pack();

    }

}
