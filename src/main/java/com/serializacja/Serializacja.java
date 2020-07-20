//package com.serializacja;
//
//import javax.imageio.IIOException;
//import java.io.*;
//import java.util.ArrayList;
//
//public class Serializacja {
//
//    //serializacja
//    public static void zapisDoPliku(Mistrz mistrz) {
//
//        try {
//            ArrayList mistrzowie = odczytZPliku();
//            mistrzowie.add(mistrz);
//
//            FileOutputStream fos = new FileOutputStream("mistrzowie.777");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//
//            oos.writeObject(mistrzowie);
//            oos.close();
//            fos.close();
//
//        }catch(IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    //deserializacja
//    public static ArrayList odczytZPliku() {
//        try {
//
//            FileInputStream fis = new FileInputStream("mistrzowie.777");
//            ObjectInputStream ois = new ObjectInputStream(fis);
//
//            ArrayList<Mistrz> mistrz = (ArrayList<Mistrz>) ois.readObject();
//
//            ois.close();
//            fis.close();
//
//            return mistrz;
//
//        }	catch(IOException ex) {
//            ex.printStackTrace();
//        }
//
//        return null;
//    }
//}
