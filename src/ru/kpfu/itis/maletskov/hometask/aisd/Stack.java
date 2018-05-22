package ru.kpfu.itis.maletskov.hometask.aisd;

/**
 * Created by Maletskov on 12.02.2018.
 */
public class Stack<T> extends Sequence<T> {
   private T currentT;

   @Override
   public T pop() {
      if (getCount() <= 0) {
         return null;
      } else {
         currentT = getCurrentElem(getCount() - 1);
         setCount(getCount() - 1);
         return currentT;
      }
   }

   @Override
   public int size() {
      return getCount();
   }
}
