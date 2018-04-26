package ru.kpfu.itis.maletskov.hometask.fantasyhome;

import java.util.ArrayList;

/**
 * Created by Maletskov on 19.02.2018.
 */
public class Journal<T, T1 extends Number> {
    private ArrayList<T> arr1;
    private ArrayList<T1> pointsArr;
    private ArrayList<ArrayList<T1>> arr2;
    private double average;
    private int count = 0, capacity = 0;

    public Journal() {
        arr1 = new ArrayList<>();
        arr2 = new ArrayList<>();
        pointsArr = new ArrayList<>();
    }

    public void add(T t, T1 t1) {
        arr1.add(t);
        pointsArr.add(capacity, t1);
        capacity++;
        arr2.add(capacity - 1, pointsArr);
    }

    public void addPoint(int i, T1 t1) {
        pointsArr.add(i, t1);
        arr2.add(i, pointsArr);
    }

    public double getAverageBall() {
        for (int i = 0; i < arr2.size(); i++) {
            for (int j = 0; j < pointsArr.size(); j++) {
                average = average + arr2.get(i).get(j).doubleValue();
                count++;
            }
        }
        if (count == 0) {
            return 0;
        } else {
            return average / count;
        }
    }
}
