package ru.kpfu.itis.maletskov.hometask.modifablecollection;

import java.util.Arrays;

/**
 * Created by Maletskov on 25.02.2018.
 */
public class App {
    public static void main(String[] args) {
        ModifableCollection<String> c = new ModifableCollection<>();
        c.add("dsdfs");
        c.add("dsfsdfs");
        c.add("qwqwqw");
        c.add("qqqqqqqq");
        c.remove("dsdfs");
        System.out.println(Arrays.toString(c.toArray()));
    }
}
