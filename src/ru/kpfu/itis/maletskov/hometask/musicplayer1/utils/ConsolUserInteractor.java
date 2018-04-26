package ru.kpfu.itis.maletskov.hometask.musicplayer1.utils;

import java.util.Scanner;

/**
 * Created by Maletskov on 04.03.2018.
 */
public class ConsolUserInteractor implements UserInteractor {
    private final Scanner sc;

    public ConsolUserInteractor() {
        this.sc = new Scanner(System.in);
    }

    @Override
    public String readCommand() throws UserInteractorReadException {
        return sc.nextLine();
    }

    @Override
    public void print(String output) throws UserInteractorWriteException {
        System.out.println(output);
    }
}
