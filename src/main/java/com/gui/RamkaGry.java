package com.gui;

import com.start.Main;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class RamkaGry extends JFrame {


    public RamkaGry() throws IOException {
        super("Kasyno 777");

        setSize(new Dimension(941,622));
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
//
//        URL url = RamkaGry.class.getResource("aaa.png");
//        setIconImage(Toolkit.getDefaultToolkit().getImage(url));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(941, 622);
    }




}
