package com.muzyka;

import com.serializacja.Serializacja;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;


public class MuzykaTla {

    static float glosnosc;
    static float czyWlaczyony;


    static {
        if (Serializacja.odczytUstawienMuzyki() != null) {
            glosnosc = Objects.requireNonNull(Serializacja.odczytUstawienMuzyki())[0];
            czyWlaczyony = Objects.requireNonNull(Serializacja.odczytUstawienMuzyki())[2];
        }else
            glosnosc = 4;
    }

    static Clip klip;
    static AudioInputStream muzyka;
    static String sciezkaMuzykiTla = "src/main/resources/muzyka/muzykaTla.wav";

    public MuzykaTla() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        muzyka = AudioSystem.getAudioInputStream(new File(new File(sciezkaMuzykiTla).getAbsolutePath()).getAbsoluteFile());
        klip = AudioSystem.getClip();
        klip.open(muzyka);
        zmienGlosnosc(glosnosc);
        klip.loop(Clip.LOOP_CONTINUOUSLY);


    }


    public static void graj() {
        klip.start();
    }

    public static void wycisz() {
        klip.stop();
    }

    public static void zmienGlosnosc(Float poziomGlosnosci) {
        ((FloatControl) klip.getControl(FloatControl.Type.MASTER_GAIN)).setValue(poziomGlosnosci);
        glosnosc = poziomGlosnosci;
    }

    public static float getGlosnosc() {
        return glosnosc;
    }

    public static void setGlosnosc(float glosnosc) {
        MuzykaTla.glosnosc = glosnosc;
    }

    public static float getCzyWlaczyony() {
        return czyWlaczyony;
    }

    public static void setCzyWlaczyony(float czyWlaczyony) {
        MuzykaTla.czyWlaczyony = czyWlaczyony;
    }
}
