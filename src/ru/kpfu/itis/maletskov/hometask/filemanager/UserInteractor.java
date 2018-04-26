package ru.kpfu.itis.maletskov.hometask.filemanager;

/**
 * Created by Maletskov on 29.03.2018.
 */
public interface UserInteractor {
    String readCommand();
    void print(String output);
    String getHelp();
}
