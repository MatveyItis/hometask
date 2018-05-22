package ru.kpfu.itis.maletskov.hometask.threadexamples;

public class TimerProducer implements Runnable {
   private int count;

   public TimerProducer() {
      count = 0;
   }

   @Override
   public void run() {
      while (true) {
         try {
            count++;
            Thread.sleep(1);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }

   public int getCount() {
      return count;
   }
}
