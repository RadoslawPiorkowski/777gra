package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;

public class BudowaGui {



    public static JLabel ustawGifJakoTlo(JFrame frame, String grafika, JPanel panel) {

        ClassLoader classLoader = panel.getClass().getClassLoader();
        URL grafikaGif = classLoader.getResource(grafika);

        ImageIcon obraz = new ImageIcon(grafikaGif);

        JLabel tlo = new JLabel();
        tlo.setIcon(obraz);
        obraz.setImageObserver(tlo);

        tlo.setBounds(0,0,925,585);
        frame.getContentPane().add(tlo, 3,0);
        return tlo;
    }

    public static JLabel ustawSymbol(JFrame frame, String grafika, JPanel panel, int x, int y) {

        ClassLoader classLoader = panel.getClass().getClassLoader();
        URL grafikaGif = classLoader.getResource(grafika);

        ImageIcon obraz = new ImageIcon(grafikaGif);

        JLabel symbol = new JLabel();
        symbol.setIcon(obraz);
        obraz.setImageObserver(symbol);

        symbol.setBounds(x,y,100,100);
        frame.getContentPane().add(symbol, 1,0);
        return symbol;
    }


    public static JButton stworzButton(JFrame frame, String nazwa, int x, int y, int szer, int wys, ActionListener actionListener) {
        JButton button = new JButton(nazwa);
        Font czcionka = new Font("Comic Sans MS", Font.BOLD, 14);
        button.setFont(czcionka);
        button.setBounds(x, y, szer, wys);
        button.addActionListener(actionListener);
        button.setForeground(Color.DARK_GRAY);
        button.setBackground(Color.LIGHT_GRAY);
        frame.getContentPane().add(button, 1, 0);
        return button;
    }

    public static JButton stworzUkrytyButton(boolean czyUkryty, JFrame frame, String nazwa, int x, int y, int szer, int wys, ActionListener actionListener) {
        JButton button = new JButton(nazwa);
        Font czcionka = new Font("Comic Sans MS", Font.BOLD, 14);
        button.setFont(czcionka);
        button.setBounds(x, y, szer, wys);
        button.addActionListener(actionListener);
        button.setForeground(Color.DARK_GRAY);
        button.setBackground(Color.LIGHT_GRAY);
        ukryjPrzycisk(button);
        frame.getContentPane().add(button, 1, 0);
        return button;
    }

    public static void ukryjPrzycisk(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
    }

    public static JLabel stworzJLabel (JFrame frame, String tekst, int x, int y, int szer, int wys) {
        JLabel napis = new JLabel(tekst);
        napis.setBounds(x, y, szer, wys);
        Font font = new Font("Times New Roman", Font.PLAIN, 14);
        napis.setFont(font);
        napis.setForeground(Color.WHITE);
        frame.add(napis, 1, 0);
        return napis;
    }

    public static JRadioButton JRadioButton (JFrame frame, String tekst, int x, int y, int szer, int wys, ButtonGroup buttonGroup) {
        JRadioButton radioButton = new JRadioButton(tekst);
        radioButton.setBounds(x, y, szer, wys);
        radioButton.setActionCommand(radioButton.getText());
        radioButton.setForeground(Color.WHITE);
        radioButton.setBackground(new Color(71,59,45));
        radioButton.setFocusPainted(false);

        buttonGroup.add(radioButton);
        frame.add(radioButton, 1, 0);
        return radioButton;
    }

    public static void stworzTextArea(JFrame frame, String tekst, int x, int y, int szer, int wys) {
        JTextArea textArea = new JTextArea();
        textArea.setBounds(x, y, szer, wys);
        Font font = new Font("Times New Roman", Font.PLAIN, 14);
        textArea.setFont(font);
        textArea.setForeground(Color.WHITE);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setText(tekst);
        frame.add(textArea,1,0);

    }

    public static JSlider stworzSlider (JFrame frame, int x, int y, int szer, int wys, int minTick, int maxTick) {
        JSlider jSlider = new JSlider(JSlider.HORIZONTAL, 0,100,10);
        jSlider.setMinorTickSpacing(minTick);
        jSlider.setMajorTickSpacing(maxTick);
        jSlider.setBackground(new Color(71,59,45));
        jSlider.setForeground(Color.CYAN);
        jSlider.setBounds(x, y, szer, wys);
        frame.add(jSlider, 1, 0);
        return jSlider;
    }

    public static JTextField stworzTextFieldBezEdycji(JFrame frame, int x, int y, int szer, int wys) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, szer, wys);
        frame.add(textField);
        Font czcionka = new Font("Time New Roman", Font.BOLD, 16);
        textField.setFont(czcionka);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);
        textField.setForeground(new Color(71,59,45));
        textField.setBackground(new Color(145, 185, 219));
        textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        frame.getContentPane().add(textField, 1, 0);
        return textField;
    }

    public static void stworzSeparatorPionowy(JFrame frame, int x, int y, int szer, int wys){
        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(x, y, szer, wys);
        frame.add(separator);
    }



    public static JTextField stworzTextField(JFrame frame, int x, int y, int szer, int wys) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, szer, wys);
        frame.add(textField);
        return textField;
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
