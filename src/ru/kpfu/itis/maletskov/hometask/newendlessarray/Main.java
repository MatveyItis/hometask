package ru.kpfu.itis.maletskov.hometask.newendlessarray;

/**
 * Created by Maletskov on 13.02.2018.
 */
public class Main {
    public static void main(String[] args) {
        Box<Integer> box1 = new Box<>();
        box1.add(1);
        box1.add(2);
        Box<String> box2 = new Box<>();
        box2.add("fdfg");
        box2.remove(0);
        System.out.println(box2.get(0));
        System.out.println(box1.get(1));
    }
}
