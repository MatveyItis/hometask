package ru.kpfu.itis.maletskov.hometask.kontrolwork1;

/**
 * Created by Maletskov on 19.12.2017.
 */
public class Task1 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Enter a number!");
            System.exit(-1);
        } else {
            int n = Integer.parseInt(args[0]);
            double summ = 0;
            for (int i = 0; i <= n; i++) {
                summ = summ + summFunction(i);
            }
            System.out.println(summ);
        }
    }

    public static double summFunction(int j) {
        double sum = 0;
        if (j != 5) {
            sum = 1.0*(Math.pow(j, j - 3)/(5 - j));
        }
        return sum;
    }
}
