package ru.kpfu.itis.maletskov.hometask.aisd;

import java.util.Arrays;

public class InsertionSort {
   public static void main(String[] args) {
      System.out.println(Arrays.toString(sort(new int[]{2, 3, 5, 1, 6, 4, 8, 7, 9})));
   }

   public static int[] sort(int[] a) {
      int t, j;
      for (int i = 0; i < a.length - 1; i++) {
         if (a[i] > a[i + 1]) {
            t = a[i + 1];
            a[i + 1] = a[i];
            j = i;
            while (j > 0 && t < a[j - 1]) {
               a[j] = a[j - 1];
               j--;
            }
            a[j] = t;
         }
      }
      return a;
   }
}
