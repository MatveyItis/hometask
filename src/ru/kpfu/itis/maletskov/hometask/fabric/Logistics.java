package ru.kpfu.itis.maletskov.hometask.fabric;

/**
 * Created by User on 05.12.2017.
 */
public abstract class Logistics {
     abstract Transport createTransport();

     public void planDelivery() {
         Transport t = createTransport();
         t.deliver();
     }
}
