package ru.kpfu.itis.maletskov.hometask.controlsystemdb.db;

/**
 * Created by Maletskov on 01.04.2018.
 */
public class DbException extends Exception {

    public DbException() {}

    public DbException(String msg) {
        super(msg);
    }
}
