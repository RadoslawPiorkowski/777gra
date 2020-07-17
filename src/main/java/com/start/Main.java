package com.start;

import com.gui.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;


public class Main {

    public static void main(String[] args) throws IOException {

        RamkaGry ramkaGry = new RamkaGry();
        ramkaGry.add(new PanelOpcji(ramkaGry));


//        URL url = RamkaGry.class.getResource("aaa.png");
//        ramkaGry.setIconImage(Toolkit.getDefaultToolkit().getImage(url));

        ramkaGry.setVisible(true);
        ramkaGry.pack();



    }
}
