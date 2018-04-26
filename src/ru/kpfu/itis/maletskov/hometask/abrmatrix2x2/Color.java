package ru.kpfu.itis.maletskov.hometask.abrmatrix2x2;

/**
 * Created by Maletskov on 03.01.2018.
 */
public enum Color {
    BLACK(0, 0, 0), WHITE(255, 255, 255);

    private int r, g, b;
    Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public String getRGBValues() {
        return "(" + r + ", " + g + ", " + b + ")";
    }
}
