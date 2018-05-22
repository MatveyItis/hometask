package ru.kpfu.itis.maletskov.hometask.aisd;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maletskov on 19.02.2018.
 */
public abstract class Sequence<T> {
   private List<T> box;
   private int count;

   public Sequence() {
      box = new ArrayList<>();
   }

   public void add(T t) {
      box.add(count, t);
      count++;
   }

   public abstract T pop();

   public int size() {
      return count;
   }

   public T getCurrentElem(int c) {
      return box.get(c);
   }

   public int getCount() {
      return count;
   }

   protected void setCount(int count) {
      this.count = count;
   }
}
