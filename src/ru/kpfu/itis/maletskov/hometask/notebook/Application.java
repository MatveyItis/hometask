package ru.kpfu.itis.maletskov.hometask.notebook;

import java.io.IOException;

/**
 * Created by Maletskov on 14.04.2018.
 */
public abstract class Application {
    private String[] args;

    public Application(String[] args) throws IOException {
        this.args = args;
        this.init();
        this.start();
    }

    public abstract void init() throws IOException;

    public abstract void start() throws IOException;
}
