package ru.kpfu.itis.maletskov.hometask.filemanager;

import java.util.Scanner;

/**
 * Created by Maletskov on 29.03.2018.
 */
public class ConsolUserInteractor implements UserInteractor{
    private final Scanner sc;

    public ConsolUserInteractor() {
        this.sc = new Scanner(System.in);
    }

    @Override
    public String getHelp() {
        return "<< Available commands are : \n" +
               "<< 1 - help : getting help from program;\n" +
               "<< 2 - get dn : getting all names of directories or files;\n" +
               "<< 3 - back : go up the directory hierarchy;\n" +
               "<< 4 - exit : exit from program;" +
               "<< Read the name of directory if you want to go down directory hierarchy.\n" +
               "<< Or read the command \"back\" to go up directory hierarchy";
    }
    @Override
    public String readCommand() {
        return sc.nextLine();
    }

    @Override
    public void print(String output) {
        System.out.println(output);
    }
}
