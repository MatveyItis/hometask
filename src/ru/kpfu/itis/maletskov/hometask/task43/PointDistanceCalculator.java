package ru.kpfu.itis.maletskov.hometask.task43;

/**
 * Created by User on 11.11.2017.
 */
public class PointDistanceCalculator {
    public static double calculateDistance(Point p1, Point p2) {
        double d = Math.sqrt((p1.x - p2.x)*(p1.x - p2.x)
                + (p1.y - p2.y)*(p1.y - p2.y));
        return d;
    }
}
