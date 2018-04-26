package ru.kpfu.itis.maletskov.hometask.musicplayer1.utils;

/**
 * Created by Maletskov on 04.03.2018.
 */
public interface UserInteractor {
    public String readCommand() throws UserInteractorReadException;
    public void print(String output) throws UserInteractorWriteException;
}
