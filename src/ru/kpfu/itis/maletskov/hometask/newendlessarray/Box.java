package ru.kpfu.itis.maletskov.hometask.newendlessarray;

/**
 * Created by Maletskov on 13.02.2018.
 */
public class Box<T> {
    protected int count;
    private int capacity = 16;
    private T[] t1;
    private T[] t2;

    public void add(T obj) {
        count++;
        capacity++;
        t1 = (T[])(new Object[count]);
        for (int i = 0; i < count - 1; i++) {
            t1[i] = t2[i];
        }
        t1[count - 1] = obj;
        t2 = (T[])(new Object[count]);
        for (int i = 0; i < t2.length; i++) {
            t2[i] = t1[i];
        }
    }

    public void remove(int j) {
        if (j < 0 || j >= capacity - 1) {

        } else {
            for (int i = j; i < t1.length - 1; i++) {
                t2[i] = t1[i + 1];
            }
            count--;
        }
    }

    public T get(int i) {
        if (i < 0 || i > t2.length - 1) {
            return null;
        }
        return t1[i];
    }

    public int getCount() {
        return count;
    }
}