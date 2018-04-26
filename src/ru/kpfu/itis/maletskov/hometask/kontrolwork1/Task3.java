package ru.kpfu.itis.maletskov.hometask.kontrolwork1;

/**
 * Created by Maletskov on 19.12.2017.
 */
public class Task3 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Enter x and y!");
            System.exit(-1);
        } else {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            if (x <= 0) {
                System.out.println("Enter a positive x!");
                System.exit(-1);
            }
            int p = 1;
            for (int i = 1; i <= y; i++) {
                p*= 2;
            }
            if (p == x) {
                System.out.println("Принадлежит");
            } else {
                System.out.println("No");
            }
        }
    }
}
