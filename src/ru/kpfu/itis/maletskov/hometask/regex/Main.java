package ru.kpfu.itis.maletskov.hometask.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Maletskov on 12.03.2018.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(isMail(sc.nextLine()));
    }

    public static boolean isMail(String mail) {
        Pattern p = Pattern.compile("(\\w+[\\-]?\\w+[\\.]?\\w+)+@(\\w+[\\-]?\\w+[\\.]?\\w+)+[\\.][a-z]{2,}");
        Matcher m = p.matcher(mail);
        return m.matches();
    }
}
