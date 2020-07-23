package com.muzyka;

import com.serializacja.Serializacja;

import javax.sound.sampled.*;
import java.io.File;
import java.util.Objects;


public class DzwiekWygranej{

    static float glosnosc;
    static float czyWlaczyony;


    static {
        if (Serializacja.odczytUstawienMuzyki() != null) {
            glosnosc = Objects.requireNonNull(Serializacja.odczytUstawienMuzyki())[1];
            czyWlaczyony = Objects.requireNonNull(Serializacja.odczytUstawienMuzyki())[3];
        }else
            glosnosc = 4;
    }


    static Clip klip;
    static AudioInputStream muzyka;
    static String sciezkaDzwiekuWygranej = "src/main/resources/muzyka/muzykaWygranej.wav";

    public static void graj() {
        try {
            muzyka = AudioSystem.getAudioInputStream(new File(new File(sciezkaDzwiekuWygranej).getAbsolutePath()).getAbsoluteFile());
            klip = AudioSystem.getClip();
            klip.open(muzyka);
            zmienGlosnosc(glosnosc);
        } catch (Exception e) {
            e.printStackTrace();
        }

        klip.start();
    }

    public static void odcisz() {
        glosnosc = Objects.requireNonNull(Serializacja.odczytUstawienMuzyki())[1];

    }

    public static void wycisz() {
        glosnosc = -80f;
        Serializacja.zapisUstawienMuzyki(new float[]{MuzykaTla.getGlosnosc(), glosnosc, MuzykaTla.getCzyWlaczyony(), getCzyWlaczyony()});
    }

    public static void zmienGlosnosc(Float poziomGlosnosci) {
        glosnosc = poziomGlosnosci;
    }

    public static float getGlosnosc() {
        return glosnosc;
    }


    public static float getCzyWlaczyony() {
        return czyWlaczyony;
    }

}
