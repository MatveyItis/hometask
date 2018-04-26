package ru.kpfu.itis.maletskov.hometask.fabric;

/**
 * Created by User on 05.12.2017.
 */
public class RoadLogistics extends Logistics {
    @Override
    Truck createTransport() {
        return new Truck();
    }
}
