package ru.kpfu.itis.maletskov.hometask.abrmatrix2x2;

/**
 * Created by Maletskov on 22.12.2017.
 */
public class Matrix2x2 {
    private double[][] a;

    public Matrix2x2() {
       a = new double[2][2];
       a[0][0] = 0;
       a[0][1] = 0;
       a[1][0] = 0;
       a[1][1] = 0;
    }

    public Matrix2x2(double f) {
        a = new double[2][2];
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length; i++) {
                a[i][j] = f;
            }
        }
    }

    public Matrix2x2(double a1, double b1, double c1, double d1) {
        a = new double[2][2];
        a[0][0] = a1;
        a[0][1] = b1;
        a[1][0] = c1;
        a[1][1] = d1;
    }

    public Matrix2x2(double[][] b) {
        a = new double[2][2];
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length; i++) {
                a[i][j] = b[i][j];
            }
        }
    }

    public Matrix2x2 add(Matrix2x2 b) {
        double[][] d = new double[2][2];
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length; i++) {
                d[i][j] = a[i][j] + b.a[i][j];
            }
        }
        return new Matrix2x2(d);
    }
}
