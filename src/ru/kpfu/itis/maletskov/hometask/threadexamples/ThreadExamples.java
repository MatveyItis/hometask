package ru.kpfu.itis.maletskov.hometask.threadexamples;


public class ThreadExamples {
   public static void main(String[] args) {
      TimerProducer tp = new TimerProducer();
      TimerConsumer tc = new TimerConsumer(tp);
      Thread t1 = new Thread(tp);
      Thread t2 = new Thread(tc);
      t1.start();
      t2.start();
   }
}
