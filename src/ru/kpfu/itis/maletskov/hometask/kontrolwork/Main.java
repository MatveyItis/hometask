package ru.kpfu.itis.maletskov.hometask.kontrolwork;

/**
 * Created by Maletskov on 12.12.2017.
 */
public class Main {
    public static void main(String[] args) {
        Complex c = new Complex(22, 5);
        Complex d = c;
        System.out.println(c.equals(d));
        System.out.println(c.toString());
        System.out.println(c.add(d));
    }
}
