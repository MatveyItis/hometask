package ru.kpfu.itis.maletskov.hometask.aisd;

import java.util.Arrays;

public class BubbleSort {
   public static void main(String[] args) {
      System.out.println(Arrays.toString(sort(new int[]{2, 3, 5, 1, 6, 4, 8, 7, 9})));
   }

   public static int[] sort(int[] a) {
      int t;
      int count = 0;
      boolean isSorted = false;
      while (!isSorted) {
         for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
               count++;
               t = a[i];
               a[i] = a[i + 1];
               a[i + 1] = t;
            }
         }
         if (count == 0) {
            isSorted = true;
         }
         count = 0;
      }
      return a;
   }
}
