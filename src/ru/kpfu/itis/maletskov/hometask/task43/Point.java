package ru.kpfu.itis.maletskov.hometask.task43;

import java.util.Scanner;

/**
 * Created by User on 11.11.2017.
 */
public class Point {
    protected final double x;
    protected final double y;

    public Point() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two coordinates x and y");
        this.x = sc.nextDouble();
        this.y = sc.nextDouble();
    }
    /*public void readFromFile() {
        try {
            sc = new Scanner(new File("src//ru//kpfu//" +
                    "itis//maletskov//hometask//task43//1.txt"));
            p1.x = sc.nextInt();
            p1.y = sc.nextInt();
            p2.x = sc.nextInt();
            p2.y = sc.nextInt();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }*/

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public String toString() {
        return "Point coordinates - x: " + x + ", y: " + y;
    }
}
