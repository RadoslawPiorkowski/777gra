package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;

public class BudowaGui {


    public static void ustawGifJakoTlo(JFrame frame, String grafika, JLayeredPane panel) {
        ClassLoader classLoader = panel.getClass().getClassLoader();
        URL grafikaGif = classLoader.getResource(grafika);
        ImageIcon obraz = new ImageIcon(grafikaGif);

        JLabel tlo = new JLabel();
        tlo.setIcon(obraz);
        obraz.setImageObserver(tlo);

        tlo.setBounds(0,0,925,585);
        frame.add(tlo, 3,0);
    }

    public static void stworzButton(JFrame frame, String nazwa, int x, int y, int szer, int wys, ActionListener actionListener) {
        JButton button = new JButton(nazwa);
        Font czcionka = new Font("Comic Sans MS", Font.BOLD, 14);
        button.setFont(czcionka);
        button.setBounds(x, y, szer, wys);
        button.addActionListener(actionListener);
        button.setForeground(Color.DARK_GRAY);
        button.setBackground(Color.LIGHT_GRAY);
        frame.add(button, 1, 0);
    }

    public static void stworzUkrytyButton(boolean czyUkryty, JFrame frame, String nazwa, int x, int y, int szer, int wys, ActionListener actionListener) {
        JButton button = new JButton(nazwa);
        Font czcionka = new Font("Comic Sans MS", Font.BOLD, 14);
        button.setFont(czcionka);
        button.setBounds(x, y, szer, wys);
        button.addActionListener(actionListener);
        button.setForeground(Color.DARK_GRAY);
        button.setBackground(Color.LIGHT_GRAY);
        ukryjPrzycisk(button);
        frame.add(button, 1, 0);
    }

    public static void ukryjPrzycisk(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
    }

    public static void stworzJLabel (JFrame frame, String tekst, int x, int y, int szer, int wys) {
        JLabel napis = new JLabel(tekst);
        napis.setBounds(x, y, szer, wys);
        frame.add(napis);
    }


    public static void stworzSeparatorPionowy(JFrame frame, int x, int y, int szer, int wys){
        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(x, y, szer, wys);
        frame.add(separator);
    }



    public static JButton stworzButton(JFrame frame, String nazwa, int x, int y, int szer, int wys, ActionListener actionListener, boolean czyPrzypisany) {
        JButton button = new JButton(nazwa);
        button.setBounds(x, y, szer, wys);
        button.addActionListener(actionListener);
        frame.add(button);
        return button;
    }

    public static JTextArea stworzTextArea(JFrame frame, int x, int y, int szer, int wys) {
        JTextArea textArea = new JTextArea();
        textArea.setBounds(x, y, szer, wys);
        textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        frame.add(textArea);
        return textArea;
    }

    public static JTextField stworzTextField(JFrame frame, int x, int y, int szer, int wys) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, szer, wys);
        frame.add(textField);
        return textField;
    }

    public static JTextField stworzTextFieldBezEdycji(JFrame frame, int x, int y, int szer, int wys) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, szer, wys);
        frame.add(textField);
        textField.setEditable(false);
        return textField;
    }

    public static void JRadioButton (JFrame frame, String tekst, int x, int y, int szer, int wys, ButtonGroup buttonGroup) {
        JRadioButton radioButton = new JRadioButton(tekst);
        radioButton.setBounds(x, y, szer, wys);
        radioButton.setActionCommand(radioButton.getText());
        buttonGroup.add(radioButton);
        frame.add(radioButton);
    }

    public static JSlider stworzSlider (JFrame frame, int x, int y, int szer, int wys, int minTick, int maxTick) {
        JSlider jSlider = new JSlider(JSlider.HORIZONTAL, 0,1000,1);
        jSlider.setMinorTickSpacing(minTick);
        jSlider.setMajorTickSpacing(maxTick);
        jSlider.setPaintLabels(true);
        jSlider.setPaintTicks(true);
        jSlider.setBounds(x, y, szer, wys);
        frame.add(jSlider);
        return jSlider;
    }

    public static JComboBox<String> stworzComboKolorow(JFrame frame, int x, int y, int szer, int wys) {

        JComboBox<String> comboBox = new JComboBox<String>();
//        comboBox.addItem("Zielony");
//        comboBox.addItem("Niebieski");
//        comboBox.addItem("Fioletowy");
//        comboBox.addItem("Czerwony");
        comboBox.setBounds(x, y, szer, wys);
        frame.add(comboBox);
        return comboBox;
    }

}