package com.gui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class RamkaGry extends JFrame {

    JPanel panel;

    public RamkaGry() throws IOException {
        super("Kasyno 777");
        setSize(925, 585);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        ImageIcon ikonaAplikacji = wczytajIkone("bbb.jpg");
        if (ikonaAplikacji != null)
            setIconImage(ikonaAplikacji.getImage());

//        this.setIconImage(ImageIO.read(new File("aaa.png")));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(941, 622);
    }

    private ImageIcon wczytajIkone(String grafika) {
        URL url = this.getClass().getResource(grafika);
        if (url != null)
            return new ImageIcon(url);
        else
            return null;
    }


}
