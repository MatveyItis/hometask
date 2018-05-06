package ru.kpfu.itis.maletskov.hometask.aisd;

import java.util.Arrays;

public class SelectionSort {
   public static void main(String[] args) {
      System.out.println(Arrays.toString(sort(new int[]{2, 3, 5, 1, 6, 4, 8, 7, 9})));
   }

   public static int[] sort(int[] a) {
      for (int min = 0; min < a.length - 1; min++) {
         int least = min;
         for (int j = min + 1; j < a.length; j++) {
            if (a[j] < a[least]) {
               least = j;
            }
         }
         if (least != min) {
            int tmp = a[min];
            a[min] = a[least];
            a[least] = tmp;
         }
      }
      return a;
   }
}
