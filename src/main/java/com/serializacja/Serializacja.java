package com.serializacja;

import java.io.*;
import java.util.ArrayList;

public class Serializacja {

    //serializacja
    public static void zapisDoPliku(ArrayList<Mistrz> mistrz) {

        try {

            FileOutputStream fos = new FileOutputStream("mistrzowie.777");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(mistrz);
            oos.close();
            fos.close();

        }catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void zapisUstawienMuzyki(float[] wartosci) {

        try {

            FileOutputStream fos = new FileOutputStream("audio.777");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(wartosci);
            oos.close();
            fos.close();

        }catch(IOException ex) {
            ex.printStackTrace();
        }
    }


//    deserializacja
    public static ArrayList<Mistrz> odczytZPliku() {
        try {

            FileInputStream fis = new FileInputStream("mistrzowie.777");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Mistrz> mistrz = (ArrayList<Mistrz>) ois.readObject();

            ois.close();
            fis.close();

            return mistrz;

        }	catch(IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public static float[] odczytUstawienMuzyki() {
        try {

            FileInputStream fis = new FileInputStream("audio.777");
            ObjectInputStream ois = new ObjectInputStream(fis);

            float[] wartosci = (float[]) ois.readObject();

            ois.close();
            fis.close();

            return wartosci;

        }	catch(IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
