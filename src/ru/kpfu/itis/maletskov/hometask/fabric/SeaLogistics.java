package ru.kpfu.itis.maletskov.hometask.fabric;

/**
 * Created by Maletskov on 05.12.2017.
 */
public class SeaLogistics extends Logistics{
    @Override
    Ship createTransport() {
        return new Ship();
    }
}
