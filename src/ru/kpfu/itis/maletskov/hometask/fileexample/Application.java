package ru.kpfu.itis.maletskov.hometask.fileexample;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Maletskov on 29.03.2018.
 */
public class Application {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        //CheckerFile f = new CheckerFile(sc.nextLine());
        //f.checkDirectory();
        //CharReader cr = new CharReader();
        //cr.writeChar();
        String path = "C:/Users/User/IdeaProjects";
        String[] arr = path.split("/");
        System.out.println(Arrays.toString(arr));
    }
}
