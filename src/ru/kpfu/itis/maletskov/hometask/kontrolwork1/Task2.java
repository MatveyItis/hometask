package ru.kpfu.itis.maletskov.hometask.kontrolwork1;

/**
 * Created by Maletskov on 19.12.2017.
 */
public class Task2 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Enter two numbers");
            System.exit(-1);
        } else {
            String s1 = args[0];
            int n = Integer.parseInt(args[1]);
            if (n <= 0) {
                System.out.println("Enter a positive n!");
                System.exit(-1);
            }
            for (int i = 0; i < n; i++) {
                System.out.print(s1);
            }
        }
    }
}
