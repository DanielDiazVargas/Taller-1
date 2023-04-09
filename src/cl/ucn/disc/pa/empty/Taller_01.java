package cl.ucn.disc.pa.empty;

import edu.princeton.cs.stdlib.StdDraw;

import java.awt.*;

public class Taller_01 {
    public static void main(String[] args) {

        double max = 1.0;
        double min = -1.0;

        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);

        StdDraw.enableDoubleBuffering();


        /**
         * Aumento el valor minimo para evitar que las linia se salgan de la pantalla
         */
        min = -0.75;


        /**
         * Seleccion aleatoria de las variables y redondeo de las mismas para evitar un error que provocaba
         * que las linias no quedaran parlelas
         */
        double x1 = min + (max - min) * Math.random();
        double y1 = min + (max - min) * Math.random();
        x1 = Math.round(x1 * 1000) / 1000.0;
        y1 = Math.round(y1 * 1000) / 1000.0;

        double vx1 = 0.001 + (0.005 - 0.001) * Math.random();
        double vy1 = 0.001 + (0.005 - 0.001) * Math.random();
        vx1 = Math.round(vx1 * 1000) / 1000.0;
        vy1 = Math.round(vy1 * 1000) / 1000.0;

        double x2 = min + (max - min) * Math.random();
        double y2 = min + (max - min) * Math.random();
        x2 = Math.round(x2 * 1000) / 1000.0;
        y2 = Math.round(y2 * 1000) / 1000.0;

        double vx2 = 0.001 + (0.005 - 0.001) * Math.random();
        double vy2 = 0.001 + (0.005 - 0.001) * Math.random();
        vx2 = Math.round(vx2 * 1000) / 1000.0;
        vy2 = Math.round(vy2 * 1000) / 1000.0;

        /**
         * Creacion de arreglos para que las variables se puedan modificar sin necesidad de un "return;"
         */
        double[] linia01 = new double [8];
        double[] linia02 = new double [8];
        double[] linia03 = new double [8];
        double[] linia04 = new double [8];
        double[] linia05 = new double [8];
        double[] linia06 = new double [8];

        Arreglo (linia01, linia02, linia03, linia04, linia05, linia06, x1, y1, x2, y2, vx1, vy1, vx2,vy2);

        while (true) {
            StdDraw.clear();

            StdDraw.setPenColor(Color.BLACK);
            StdDraw.filledSquare(0, 0, 1);
            Linia1(linia01);
            Linia2(linia02);
            Linia3(linia03);
            Linia4(linia04);
            Linia5(linia05);
            Linia6(linia06);

            StdDraw.show();
        }
    }

    /**
     * Metodo para rellenar los arreglos y separar las linias entre si
     */
    public static void Arreglo (double[] linia01,double[] linia02,double[] linia03,double[] linia04,double[] linia05,double[] linia06, double x1, double y1, double x2, double y2, double vx1, double vy1, double vx2, double vy2) {

        linia01[0] = x1;
        linia02[0] = linia01[0] - 0.05;
        linia03[0] = linia02[0] - 0.05;
        linia04[0] = linia03[0] - 0.05;
        linia05[0] = linia04[0] - 0.05;
        linia06[0] = linia05[0] - 0.05;

        linia01[1] = y1;
        linia02[1] = linia01[1] - 0.05;
        linia03[1] = linia02[1] - 0.05;
        linia04[1] = linia03[1] - 0.05;
        linia05[1] = linia04[1] - 0.05;
        linia06[1] = linia05[1] - 0.05;

        linia01[2] = x2;
        linia02[2] = linia01[2] - 0.05;
        linia03[2] = linia02[2] - 0.05;
        linia04[2] = linia03[2] - 0.05;
        linia05[2] = linia04[2] - 0.05;
        linia06[2] = linia05[2] - 0.05;

        linia01[3] = y2;
        linia02[3] = linia01[3] - 0.05;
        linia03[3] = linia02[3] - 0.05;
        linia04[3] = linia03[3] - 0.05;
        linia05[3] = linia04[3] - 0.05;
        linia06[3] = linia05[3] - 0.05;

        linia01[4] = vx1;
        linia02[4] = vx1;
        linia03[4] = vx1;
        linia04[4] = vx1;
        linia05[4] = vx1;
        linia06[4] = vx1;

        linia01[5] = vy1;
        linia02[5] = vy1;
        linia03[5] = vy1;
        linia04[5] = vy1;
        linia05[5] = vy1;
        linia06[5] = vy1;

        linia01[6] = vx2;
        linia02[6] = vx2;
        linia03[6] = vx2;
        linia04[6] = vx2;
        linia05[6] = vx2;
        linia06[6] = vx2;

        linia01[7] = vy2;
        linia02[7] = vy2;
        linia03[7] = vy2;
        linia04[7] = vy2;
        linia05[7] = vy2;
        linia06[7] = vy2;
    }

    /**
     * Metodos que provocan el movimiento de cada linia individualmente
     */
    public static void Linia1 (double[] linia01) {
        if (Math.abs(linia01[0] + linia01[4]) > 1.0) {
            linia01[4] = -linia01[4];
        }
        if (Math.abs(linia01[1] + linia01[5]) > 1.0) {
            linia01[5] = -linia01[5];
        }
        if (Math.abs(linia01[2] + linia01[6]) > 1.0) {
            linia01[6] = -linia01[6];
        }
        if (Math.abs(linia01[3] + linia01[7]) > 1.0) {
            linia01[7] = -linia01[7];
        }

        linia01[0] += linia01[4];
        linia01[1] += linia01[5];
        linia01[2] += linia01[6];
        linia01[3] += linia01[7];


        StdDraw.setPenColor(255, 0 ,0);
        StdDraw.line(linia01[0], linia01[1], linia01[2], linia01[3]);
    }

    public static void Linia2 (double[] linia02) {
        if (Math.abs(linia02[0] + linia02[4]) > 1.0) {
            linia02[4] = -linia02[4];
        }
        if (Math.abs(linia02[1] + linia02[5]) > 1.0) {
            linia02[5] = -linia02[5];
        }
        if (Math.abs(linia02[2] + linia02[6]) > 1.0) {
            linia02[6] = -linia02[6];
        }
        if (Math.abs(linia02[3] + linia02[7]) > 1.0) {
            linia02[7] = -linia02[7];
        }

        linia02[0] += linia02[4];
        linia02[1] += linia02[5];
        linia02[2] += linia02[6];
        linia02[3] += linia02[7];


        StdDraw.setPenColor(0, 255, 0);
        StdDraw.line(linia02[0], linia02[1], linia02[2], linia02[3]);
    }

    public static void Linia3 (double[] linia03) {
        if (Math.abs(linia03[0] + linia03[4]) > 1.0) {
            linia03[4] = -linia03[4];
        }
        if (Math.abs(linia03[1] + linia03[5]) > 1.0) {
            linia03[5] = -linia03[5];
        }
        if (Math.abs(linia03[2] + linia03[6]) > 1.0) {
            linia03[6] = -linia03[6];
        }
        if (Math.abs(linia03[3] + linia03[7]) > 1.0) {
            linia03[7] = -linia03[7];
        }

        linia03[0] += linia03[4];
        linia03[1] += linia03[5];
        linia03[2] += linia03[6];
        linia03[3] += linia03[7];


        StdDraw.setPenColor(0, 0, 255);
        StdDraw.line(linia03[0], linia03[1], linia03[2], linia03[3]);
    }

    public static void Linia4 (double[] linia04) {
        if (Math.abs(linia04[0] + linia04[4]) > 1.0) {
            linia04[4] = -linia04[4];
        }
        if (Math.abs(linia04[1] + linia04[5]) > 1.0) {
            linia04[5] = -linia04[5];
        }
        if (Math.abs(linia04[2] + linia04[6]) > 1.0) {
            linia04[6] = -linia04[6];
        }
        if (Math.abs(linia04[3] + linia04[7]) > 1.0) {
            linia04[7] = -linia04[7];
        }

        linia04[0] += linia04[4];
        linia04[1] += linia04[5];
        linia04[2] += linia04[6];
        linia04[3] += linia04[7];


        StdDraw.setPenColor(255, 255, 0);
        StdDraw.line(linia04[0], linia04[1], linia04[2], linia04[3]);
    }

    public static void Linia5 (double[] linia05) {
        if (Math.abs(linia05[0] + linia05[4]) > 1.0) {
            linia05[4] = -linia05[4];
        }
        if (Math.abs(linia05[1] + linia05[5]) > 1.0) {
            linia05[5] = -linia05[5];
        }
        if (Math.abs(linia05[2] + linia05[6]) > 1.0) {
            linia05[6] = -linia05[6];
        }
        if (Math.abs(linia05[3] + linia05[7]) > 1.0) {
            linia05[7] = -linia05[7];
        }

        linia05[0] += linia05[4];
        linia05[1] += linia05[5];
        linia05[2] += linia05[6];
        linia05[3] += linia05[7];


        StdDraw.setPenColor(255,0,255);
        StdDraw.line(linia05[0], linia05[1], linia05[2], linia05[3]);
    }

    public static void Linia6 (double[] linia06) {
        if (Math.abs(linia06[0] + linia06[4]) > 1.0) {
            linia06[4] = -linia06[4];
        }
        if (Math.abs(linia06[1] + linia06[5]) > 1.0) {
            linia06[5] = -linia06[5];
        }
        if (Math.abs(linia06[2] + linia06[6]) > 1.0) {
            linia06[6] = -linia06[6];
        }
        if (Math.abs(linia06[3] + linia06[7]) > 1.0) {
            linia06[7] = -linia06[7];
        }

        linia06[0] += linia06[4];
        linia06[1] += linia06[5];
        linia06[2] += linia06[6];
        linia06[3] += linia06[7];


        StdDraw.setPenColor(0, 255, 255);
        StdDraw.line(linia06[0], linia06[1], linia06[2], linia06[3]);
    }
}