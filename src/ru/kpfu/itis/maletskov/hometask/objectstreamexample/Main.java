package ru.kpfu.itis.maletskov.hometask.objectstreamexample;

import ru.kpfu.itis.maletskov.hometask.reflection.Student;

import java.io.*;
import java.util.Arrays;

/**
 * Created by Maletskov on 02.04.2018.
 */
public class Main {
    private static final String DB_PATH = "C:/Users/User/IdeaProjects/hometask/src/ru/kpfu/itis/maletskov/hometask/controlsystemdb/db/students.txt";

    public static void main(String[] args) throws FileNotFoundException {
        StudentOutputStream so = new StudentOutputStream(new DataOutputStream(new FileOutputStream(new File("1.csv"))));
        so.write(new Student("Danis", 19));
    }
}
