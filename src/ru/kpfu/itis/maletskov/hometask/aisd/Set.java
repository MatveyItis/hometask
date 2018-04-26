package ru.kpfu.itis.maletskov.hometask.aisd;

/**
 * Created by Maletskov on 26.02.2018.
 */
public class Set<T> {
    private T[] t;
    private int size;
    private int capacity = 16;
    private boolean rep;

    public Set() {
        t = (T[])(new Object[capacity]);
        size = 0;
    }

    public void insert(T t1) {
        if (size >= capacity) {
            T[] data1 = (T[])(new Object[t.length * 2]);
            System.arraycopy(t, 0, data1, 0, t.length);
            t = data1;
        }
        for (int i = 0; i < size; i++) {
            if (t1.equals(t[i])) {
                rep = true;
            }
        }
        if (!rep) {
            t[size] = t1;
            size++;
        }
        rep = false;
    }

    public void remove(T t1) {
        for (int i = 0; i < size; i++) {
            if (t1.equals(t[i])) {
                t[i] = null;
                for (int j = i; j < size; j++) {
                    t[j] = t[j + 1];
                }
                t[size - 1] = null;
                size--;
            }
        }
    }

    public boolean has(T t1) {
        for (int i = 0; i < size; i++) {
            if (t1.equals(t[i])) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }
}
