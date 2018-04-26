package ru.kpfu.itis.maletskov.hometask.modifablecollection;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Maletskov on 25.02.2018.
 */
public class ModifableCollection<T> extends AbstractCollection<T> {
    private final static int DEFAULT_SIZE = 16;
    private T[] data;
    private int size;

    public ModifableCollection() {
        data = (T[])(new Object[DEFAULT_SIZE]);
        size = 0;
    }

    public ModifableCollection(Collection<T> coll) {
        data = (T[])(new Object[coll.size()]);
        size = 0;
        for (T t : coll) {
            data[size] = t;
            size++;
        }
    }

    public boolean add(T t) {
        if (size >= data.length) {
            T[] data1 = (T[])(new Object[data.length * 2]);
            System.arraycopy(data, 0, data1, 0, data.length);
            data = data1;
        }
        data[size] = t;
        size++;
        return true;
    }

    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(data[i])) {
                data[i] = null;
                for (int j = i; j < size; j++) {
                    data[j] = data[j + 1];
                }
                data[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    public boolean addAll(Collection<? extends T> coll) {
        int cSize = size;
        T[] data1;
        data1 = (T[])(new Object[size + coll.size()]);
        System.arraycopy(data, 0, data1, 0, size);
        data = data1;

        for (T t : coll) {
            data[cSize] = t;
            cSize++;
        }
        size = cSize;
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int i = 0; i < data.length; i++) {
            data[i] = null;
        }
        size = 0;
    }

    public boolean contains(Object o) {
        for (int i = 0; i < data.length; i++) {
            if (o.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    public Iterator<T> iterator() {
        return new ModifableCollectionIterator();
    }

    public Object[] toArray() {
        Object[] obj = new Object[size];
        for (int i = 0; i < size; i++) {
            obj[i] = data[i];
        }
        return obj;
    }

    public int size() {
        return data.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModifableCollection<?> that = (ModifableCollection<?>) o;

        if (size != that.size) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(data);
        result = 31 * result + size;
        return result;
    }

    private class ModifableCollectionIterator implements Iterator<T> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            if (data[current] == null) {
                current++;
                this.hasNext();
            }
            return current < size;
        }

        @Override
        public T next() {
            T value = data[current];
            current++;
            while (value != null && this.hasNext()) {
                value = data[current];
                current++;
            }
            return value;
        }

        //???
        @Override
        public void remove() {
            data[current] = null;
        }
    }
}