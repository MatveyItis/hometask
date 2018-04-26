package ru.kpfu.itis.maletskov.hometask.abrfraction;

/**
 * Created by Maletskov on 21.12.2017.
 */
public class App {
    public static void main(String[] args) {
        RationalFraction r = new RationalFraction(-16, 8);
        RationalFraction m = new RationalFraction(23, 9);
        System.out.println(r.add(m));
    }
}
