package ru.kpfu.itis.maletskov.hometask.aisd;

import java.util.Arrays;

/**
 * Created by Maletskov on 22.04.2018.
 */
public class MergeSort {
   public static void main(String[] args) {
      System.out.println(Arrays.toString(sortMerge(new int[]{1, 5, 6, 3, 11, 111, 987, 543, 12, 13, 15, 14})));
   }

   private static int[] sortMerge(int[] arr) {
      int len = arr.length;
      if (len < 2) return arr;
      int middle = len / 2;
      return merge(
              sortMerge(Arrays.copyOfRange(arr, 0, middle)),
              sortMerge(Arrays.copyOfRange(arr, middle, len)));
   }

   private static int[] merge(int[] a1, int[] a2) {
      int l1 = a1.length, l2 = a2.length;
      int len = l1 + l2;
      int[] res = new int[len];
      int i = 0, j = 0;
      for (int k = 0; k < len; k++) {
         if (i < l1 && j < l2) {
            if (a1[i] < a2[j]) {
               res[k] = a1[i++];
            } else {
               res[k] = a2[j++];
            }
         } else if (i >= l1) {
            res[k] = a2[j++];
         } else {
            res[k] = a1[i++];
         }
      }
      return res;
   }
}