package ru.kpfu.itis.maletskov.hometask.controlsystemdb.utils;

import java.io.IOException;
import java.util.InputMismatchException;

/**
 * Created by Maletskov on 01.04.2018.
 */
public interface UserInteractor {
    String readCommand();
    byte readInt() throws InputMismatchException, IOException;
    void print(String output);
}
