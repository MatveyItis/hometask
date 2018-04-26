package ru.kpfu.itis.maletskov.hometask.notebook;

import java.util.Scanner;

/**
 * Created by Maletskov on 14.04.2018.
 */
public class ConsolUserInteractor implements UserInteractor {
    private Scanner sc = new Scanner(System.in);

    @Override
    public String readCommand() {
        return sc.nextLine();
    }

    @Override
    public String getHelp() {
        return "<< Available commands are : \n" +
                "<< 1 - help    : getting help from program;\n" +
                "<< 2 - read    : printing last note;\n" +
                "<< 3 - readAll : printing all notes from notebook;\n" +
                "<< 4 - add     : add note to notebook;\n" +
                "<< 5 - exit    : exit from program;";
    }

    @Override
    public void print(String command) {
        System.out.println(command);
    }
}
