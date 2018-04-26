package ru.kpfu.itis.maletskov.hometask.musicplayer;

/**
 * Created by Maletskov on 01.03.2018.
 */
public abstract class Application {
    protected String[] args;

    public Application(String[] args) {
        this.args = args;
        this.init();
        this.start();
    }

    public abstract void init();

    public abstract void start();
}
