package ru.kpfu.itis.maletskov.hometask.controlsystemdb;

import ru.kpfu.itis.maletskov.hometask.controlsystemdb.db.DbException;

import java.io.IOException;

/**
 * Created by Maletskov on 01.04.2018.
 */
public abstract class Application {
    private String[] args;

    Application(String[] msg) throws DbException, IOException {
        args = msg;
        this.init();
        this.start();
    }

    public abstract void init();
    public abstract void start() throws DbException, IOException;
}
