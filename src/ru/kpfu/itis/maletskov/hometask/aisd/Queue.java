package ru.kpfu.itis.maletskov.hometask.aisd;

/**
 * Created by Maletskov on 19.02.2018.
 */
public class Queue<T> extends Sequence<T> {
    private int start;
    private int top;

    @Override
    public void add(T t) {
        super.add(t);
        top++;
    }

    @Override
    public T pop() {
        if (top - start <= 0) {
            return null;
        } else {
            start++;
            return getCurrentElem(start - 1);
        }
    }

    @Override
    public int size() {
        return top - start;
    }
}
