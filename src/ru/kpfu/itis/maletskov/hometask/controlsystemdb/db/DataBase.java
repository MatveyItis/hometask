package ru.kpfu.itis.maletskov.hometask.controlsystemdb.db;

import java.io.IOException;

/**
 * Created by Maletskov on 01.04.2018.
 */
public interface DataBase<T> {
    boolean save(T t) throws DbException, IOException;
    void printAll();

}
