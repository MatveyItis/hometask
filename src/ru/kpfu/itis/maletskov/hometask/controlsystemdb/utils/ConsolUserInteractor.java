package ru.kpfu.itis.maletskov.hometask.controlsystemdb.utils;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Maletskov on 01.04.2018.
 */
public class ConsolUserInteractor implements UserInteractor {
    private final Scanner sc;

    public ConsolUserInteractor() {
        this.sc = new Scanner(System.in);
    }

    @Override
    public String readCommand() {
        return sc.next();
    }

    @Override
    public byte readInt() throws IOException {
        return sc.nextByte();
    }

    @Override
    public void print(String output) {
        System.out.println(output);
    }
}
