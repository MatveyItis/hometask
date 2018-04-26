package ru.kpfu.itis.maletskov.hometask.objectstreamexample;

import java.io.*;
import java.util.Arrays;

/**
 * Created by Maletskov on 02.04.2018.
 */
public class Main {
    private static final String DB_PATH = "C:/Users/User/IdeaProjects/hometask/src/ru/kpfu/itis/maletskov/hometask/controlsystemdb/db/students.txt";

    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream(new File(DB_PATH));
            byte[] b = new byte[512];
            fin.read(b);
            for (int i = 0; i < b.length; i++) {
                System.out.print((char)b[i]);
            }
            //System.out.println(ois.readChar());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
