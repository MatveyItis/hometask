package ru.kpfu.itis.maletskov.hometask.notebook;

/**
 * Created by Maletskov on 14.04.2018.
 */
public interface UserInteractor {
    String readCommand();
    String getHelp();
    void print(String command);
}
