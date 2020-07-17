package com.start;

import com.gui.PanelKasyna;
import com.gui.PanelPorad;
import com.gui.PanelWyboruGry;
import com.gui.RamkaGry;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;


public class Main {

    public static void main(String[] args) throws IOException {

        RamkaGry ramkaGry = new RamkaGry();
        ramkaGry.add(new PanelPorad(ramkaGry));


//        URL url = RamkaGry.class.getResource("aaa.png");
//        ramkaGry.setIconImage(Toolkit.getDefaultToolkit().getImage(url));

        ramkaGry.setVisible(true);
        ramkaGry.pack();



    }
}
