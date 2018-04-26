package ru.kpfu.itis.maletskov.hometask.musicplayer.utils;

import java.util.Scanner;

/**
 * Created by Maletskov on 01.03.2018.
 */
public class ConsolUserInteractor implements UserInteractor {
    private Scanner sc;

    private ConsolUserInteractor() {
        sc = new Scanner(System.in);
    }

    private static class ConsolUserInteractorHolder {
        private final static ConsolUserInteractor terminal = new ConsolUserInteractor();
    }

    public static ConsolUserInteractor getTerminal() {
        return ConsolUserInteractorHolder.terminal;
    }

    @Override
    public String readCommand() {
        return null;
    }

    @Override
    public void print(String output) {

    }
}
