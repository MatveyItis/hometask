package ru.kpfu.itis.maletskov.hometask.threadexamples;

import java.util.Scanner;

public class TimerConsumer implements Runnable {
   private Scanner sc;
   private TimerProducer tp;

   public TimerConsumer(TimerProducer tp) {
      sc = new Scanner(System.in);
      this.tp = tp;
   }

   @Override
   public void run() {
      String s;
      while ((s = this.read()) != null) {
         if (s.equals("print")) {
            System.out.println(tp.getCount());
         }
      }
   }

   public String read() {
      return sc.nextLine();
   }
}
