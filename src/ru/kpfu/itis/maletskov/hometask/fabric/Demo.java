package ru.kpfu.itis.maletskov.hometask.fabric;

/**
 * Created by User on 05.12.2017.
 */
public class Demo {
    private static Transport transport;

    public static void main(String[] args) {
        int distance = Integer.parseInt(args[0]);
        configure(distance);
        goDelivery();
    }

    static void configure(int distance) {
        if (distance > 5000) {
            transport = new Ship();
        } else {
            transport = new Truck();
        }
    }

    static void goDelivery() {
        transport.deliver();
    }


}
