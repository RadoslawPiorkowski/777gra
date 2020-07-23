package com.draw;

import com.gui.PanelGrySolo;


public class Generowanie {

    public static Znaki losowanie[][] = new Znaki [3][3];

    public static void random () {
        for (int i = 0;i<3;i++) {
            for (int j = 0;j<3;j++) {
                double a = Math.random();
                    if (a < 0.19)
                        losowanie[i][j] = Znaki.pomarancza;
                    else if (a >=0.19 && a<0.38)
                        losowanie[i][j] = Znaki.jablko;
                    else if (a >=0.38 && a <0.53)
                        losowanie[i][j] = Znaki.wisnia;
                    else if (a >=0.53 && a< 0.71)
                        losowanie[i][j] = Znaki.dzwonek;
                    else if (a >=0.71 && a< 0.88)
                        losowanie[i][j] = Znaki.diament;
                    else if (a >=0.88)
                        losowanie[i][j] = Znaki.siedem;
            }
        }
    }


    public static void oszukuj () {
        double o = Math.random();
        if (o <0.5) {
            PanelGrySolo.zlapanoNaOszustwie = true;
        }
        else {
            for (int i = 0;i<3;i++) {
                for (int j = 0;j<3;j++) {
                    double a = Math.random();
                    if (a< 0.15)
                        losowanie[i][j] = Znaki.dzwonek;
                    else if (a >=0.15 && a< 0.60)
                        losowanie[i][j] = Znaki.diament;
                    else if (a >=0.60)
                        losowanie[i][j] = Znaki.siedem;
                }
            }
        }
    }
}


