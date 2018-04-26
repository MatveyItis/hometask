package ru.kpfu.itis.maletskov.hometask.aisd;

import java.util.Arrays;

/**
 * Created by Maletskov on 19.02.2018.
 */
public class Map<K, V> {
    private K[] k;
    private V[] v;
    private K key;
    private V value;
    private int capacity = 16;
    private int count = 0;

    public Map() {
        k = (K[])(new Object[capacity]);
        v = (V[])(new Object[capacity]);
    }

    public void put(K key, V value) {
        if (count > capacity) {
            System.out.println("Map is full! You cannot add items.");
        } else {
            if (hasKey(key) == -1) {
                k[count] = key;
                v[count] = value;
                count++;
            } else {
                v[hasKey(key)] = value;
            }
        }
    }

    public void remove(K k1) {
        if (hasKey(k1) != -1) {
            k[hasKey(k1)] = null;
            v[hasKey(k1)] = null;
            for (int i = hasKey(k1); i < count - 1; i++) {
                k[i] = k[i + 1];
            }
            k[count] = null;
            count--;
        }
    }

    public K getKey(K key) {
        if (hasKey(key) != -1) {
            return k[hasKey(key)];
        } else {
            return null;
        }
    }
    
    public boolean containsValue(V v1) {
        for (int i = 0; i < count; i++) {
            if (v1.equals(v[i])) {
                return true;
            }
        }
        return false;
    }

    protected int hasKey(K k1) {
        for (int i = 0; i < k.length; i++) {
            if (k[i].equals(k1)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Map<?, ?> map = (Map<?, ?>) o;

        if (capacity != map.capacity) return false;
        if (count != map.count) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(k, map.k)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(v, map.v)) return false;
        if (key != null ? !key.equals(map.key) : map.key != null) return false;
        return value != null ? value.equals(map.value) : map.value == null;
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(k);
        result = 31 * result + Arrays.hashCode(v);
        result = 31 * result + (key != null ? key.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + capacity;
        result = 31 * result + count;
        return result;
    }
}
