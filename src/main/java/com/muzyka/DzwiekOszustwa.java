package com.muzyka;

import com.serializacja.Serializacja;

import javax.sound.sampled.*;
import java.io.File;
import java.util.Objects;


public class DzwiekOszustwa{

    static float glosnosc;

    static {
        if (Serializacja.odczytUstawienMuzyki() != null)
            glosnosc = Objects.requireNonNull(Serializacja.odczytUstawienMuzyki())[1];
        else
            glosnosc = 4;
    }

    static Clip klip;
    static AudioInputStream muzyka;
    static String sciezkaDzwiekuOszustwa = "src/main/resources/muzyka/syreny.wav";


    public static void graj() {
        try {
            muzyka = AudioSystem.getAudioInputStream(new File(new File(sciezkaDzwiekuOszustwa).getAbsolutePath()).getAbsoluteFile());
            klip = AudioSystem.getClip();
            klip.open(muzyka);
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
        Serializacja.zapisUstawienMuzyki(new float[]{MuzykaTla.getGlosnosc(), glosnosc, MuzykaTla.getCzyWlaczyony(), DzwiekWygranej.getCzyWlaczyony()});
    }

    public static void zmienGlosnosc(Float poziomGlosnosci) {
        glosnosc = poziomGlosnosci;
    }
}