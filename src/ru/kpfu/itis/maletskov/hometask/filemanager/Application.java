package ru.kpfu.itis.maletskov.hometask.filemanager;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Maletskov on 29.03.2018.
 */
public abstract class Application {
    protected String[] args;

    public Application(String[] args) throws IOException {
        this.args = args;
        this.init();
        this.start();
    }

    public abstract void init() throws IOException;

    public abstract void start() throws IOException;

}
