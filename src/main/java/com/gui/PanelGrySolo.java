package com.gui;

import javax.swing.*;
import java.awt.*;

public class PanelGrySolo extends JPanel {

    JFrame ramkaGry;
    JLabel tlo;

    public PanelGrySolo(JFrame ramka) {

        this.ramkaGry = ramka;

        tlo = BudowaGui.ustawGifJakoTlo(ramka, "gifyTla/losowanie.gif", this);
        
    }



}
