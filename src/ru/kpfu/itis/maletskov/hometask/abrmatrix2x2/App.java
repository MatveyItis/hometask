package ru.kpfu.itis.maletskov.hometask.abrmatrix2x2;

import java.util.Random;

/**
 * Created by Maletskov on 22.12.2017.
 */
public class App {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(20);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
           System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println(binarySearch(3, arr, 0, arr.length - 1));
    }

    private static int binarySearch(int key, int[] arr, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }

        int mid = lo + (hi - lo) / 2;

        if (key < arr[mid]) {
            return binarySearch(key, arr, lo, mid - 1);
        } else if (key > arr[mid]) {
            return binarySearch(key, arr, mid + 1, hi);
        } else {
            return mid;
        }
    }

    public static void sort(int[] a) {
        int m, h;
        for (int i = 0; i < a.length - 1; i++) {
            m = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[m]) {
                    m = j;
                }
            }
            h = a[i];
            a[i] = a[m];
            a[m] = h;
        }
    }
}
