package com.start;

import com.gui.PanelKasyna;
import com.gui.RamkaGry;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        RamkaGry ramkaGry = new RamkaGry();
        ramkaGry.add(new PanelKasyna(ramkaGry));
        ramkaGry.setVisible(true);
        ramkaGry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ramkaGry.pack();

    }
}
