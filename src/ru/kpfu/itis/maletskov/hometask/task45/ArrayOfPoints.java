package ru.kpfu.itis.maletskov.hometask.task45;

import ru.kpfu.itis.maletskov.hometask.task43.Point;

import java.util.Arrays;

/**
 * Created by User on 13.11.2017.
 */
public class ArrayOfPoints {
    protected int pointsCount;
    protected int capacity = 16;
    protected Point[] arr;
    protected Point[] otherArr;
    protected int index;


    public int add(Point p) {
        pointsCount++;
        capacity++;
        arr = new Point[pointsCount];
        for (int i = 0; i < pointsCount - 1; i++) {
            arr[i] = otherArr[i];
        }
        arr[pointsCount - 1] = p;
        otherArr = new Point[pointsCount];
        for (int i = 0; i < otherArr.length; i++) {
            otherArr[i] = arr[i];
        }
        return capacity - 1;
    }

    public boolean remove(int i) {
        if (i < 0 || i >= capacity - 1) {
            return false;
        } else {
            for (int j = i; j < arr.length - 1; j++) {
                otherArr[j] = arr[j + 1];
            }
            pointsCount--;
            return true;
        }
    }

    public Point get(int i) {
        return otherArr[i];
    }

    //searching point in a internal storage
    public int indexOf(Point p) {
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == p) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPointsCount() {
        return pointsCount;
    }

}
