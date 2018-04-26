package ru.kpfu.itis.maletskov.hometask.task45;

import ru.kpfu.itis.maletskov.hometask.task43.Point;
import ru.kpfu.itis.maletskov.hometask.task45.ArrayOfPoints;

import javax.swing.*;

/**
 * Created by User on 14.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        Point p1 = new Point();
        Point p2 = new Point();
        Point p3 = new Point();
        Point p4 = new Point();

        ArrayOfPoints a  = new ArrayOfPoints();
        a.add(p1);
        a.add(p2);
        a.add(p3);
        a.add(p4);

        for (int i = 0; i < a.arr.length; i++) {
            if (a.arr[i] != null) {
                System.out.println(a.arr[i]);
            }
        }
        a.remove(0);
        Point p5 = new Point();
        Point p6 = new Point();
        a.add(p5);
        a.add(p6);
        System.out.println();
        System.out.println(a.getPointsCount());
        for (int i = 0; i < a.arr.length; i++) {
            if (a.arr[i] != null) {
                System.out.println(a.arr[i]);
            }
        }
    }
}
