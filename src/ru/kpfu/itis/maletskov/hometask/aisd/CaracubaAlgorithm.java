package ru.kpfu.itis.maletskov.hometask.aisd;

import java.util.Arrays;

/**
 * Created by Maletskov on 09.04.2018.
 */
public class CaracubaAlgorithm {

    public static void main(String[] args) {
        //System.out.println(multiply(132, 167));
        //System.out.println(add(123, 205));
        System.out.println(fromBinToNum(addition(new boolean[]{true, true, true, false}, new boolean[]{true, true, false, true})));
        System.out.println(fromBinToNum(subtraction(new boolean[]{true, true, true, false}, new boolean[]{true, true, false, true})));

    }

    //метод может складывать только равные по длине числа
    public static boolean[] addition(boolean[] a, boolean[] b) {
        if (a.length < b.length) {
            int raz = b.length - a.length;
            boolean[] nb = new boolean[b.length];
            for (int i = raz; i < b.length; i++) {
                nb[i] = a[i - raz];
            }
            a = Arrays.copyOf(nb, nb.length);
            System.out.println(Arrays.toString(a));
        } else if (a.length > b.length){
            int raz = a.length - b.length;
            boolean[] na = new boolean[a.length];
            for (int i = raz; i < a.length; i++) {
                na[i] = b[i - raz];
            }
            b = Arrays.copyOf(na, na.length);
            System.out.println(Arrays.toString(b));
        }
        int n = a.length;

        byte buf = 0, f, s;
        boolean[] res = new boolean[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            f = (byte)(a[i] ? 1 : 0);
            s = (byte)(b[i] ? 1 : 0);
            if (buf == 1) {
                if (f + s + buf == 1) {
                    res[i + 1] = true;
                    buf = 0;
                } else if (f + s + buf == 2) {
                    res[i + 1] = false;
                } else if (f + s + buf == 3) {
                    res[i + 1] = true;
                }
            } else {
                if (f + s > 1) {
                    buf = 1;
                    res[i + 1] = false;
                } else if (f + s == 0) {
                    res[i + 1] = false;
                } else if (f + s == 1) {
                    res[i + 1] = true;
                }
            }
            if (buf == 1) {
                res[0] = true;
            }
        }
        return res;
    }

    public static boolean[] subtraction(boolean[] a, boolean[] b) {
        for (int i = 0; i < b.length; i++) {
            b[i] = !b[i];
        }
        b = addition(b, new boolean[]{true});
        int n = a.length < b.length ? a.length : b.length;
        byte buf = 0, f, s;
        boolean[] res = new boolean[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            f = (byte)(a[i] ? 1 : 0);
            s = (byte)(b[i] ? 1 : 0);
            if (buf == 1) {
                if (f + s + buf == 1) {
                    res[i + 1] = true;
                    buf = 0;
                } else if (f + s + buf == 2) {
                    res[i + 1] = false;
                } else if (f + s + buf == 3) {
                    res[i + 1] = true;
                }
            } else {
                if (f + s > 1) {
                    buf = 1;
                    res[i + 1] = false;
                } else if (f + s == 0) {
                    res[i + 1] = false;
                } else if (f + s == 1) {
                    res[i + 1] = true;
                }
            }
            if (buf == 1) {
                res[0] = true;
            }
        }
        return res;
    }

    public static int multiply(int a, int b) {
        int lengthA = rankInBinary(a);
        int lengthB = rankInBinary(b);
        int n = lengthA > lengthB ? lengthA : lengthB;
        boolean[] x = new boolean[n];
        boolean[] y = new boolean[n];

        for (int i = n - 1; i >= 0; i--) {
            x[i] = a % 2 == 0 ? false : true;
            y[i] = b % 2 == 0 ? false : true;
            a = a / 2;
            b = b / 2;
        }
        //здесь a и b обнуляются

        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));

        boolean[] xl = copyFirstHalfArray(x);
        boolean[] xr = copySecondHalfArray(x);
        boolean[] yl = copyFirstHalfArray(y);
        boolean[] yr = copySecondHalfArray(y);

        int sum = 0;
        return sum;
    }

    public static boolean[] shiftArr(boolean[] a, int n) {
        boolean[] res = new boolean[n + a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = a[i];
        }

        return res;
    }

    public static int rankInBinary(int n) {
        int rank = 0;
        while (n > 0) {
            n = n / 2;
            rank++;
        }
        return rank;
    }

    public static boolean[] copyFirstHalfArray(boolean[] x) {
        boolean[] x1 = new boolean[x.length / 2];
        for (int i = 0; i < x.length / 2; i++) {
            x1[i] = x[i];
        }
        return x1;
    }

    public static boolean[] copySecondHalfArray(boolean[] x) {
        int l = x.length - x.length / 2;
        boolean[] x2 = new boolean[l];
        for (int i = 0; i < l; i++) {
            x2[i] = x[i + l - 1];
        }
        return x2;
    }

    public static int power2(int p) {
        if (p == 0) return 1;
        if (p < 0) return 0;
        int pr = 1;
        for (int i = 0; i < p; i++) {
            pr*=2;
        }
        return pr;
    }


    public static boolean[] multBin(boolean[] a, boolean[] b) {
        int length = a.length < b.length ? a.length : b.length;
        boolean[] res = new boolean[length];
        //?????? может вылететь эррэйиндексофбаундэксепшн
        for (int i = length - 1; i >= 0; i--) {
            res[i] = a[i] && b[i];
        }
        return res;
    }

    public static boolean[] subtBin(boolean[] a, boolean[] b) {
        int a1 = fromBinToNum(a);
        int b1 = fromBinToNum(b);
        int sum = a1 - b1;
        boolean[] res = new boolean[rankInBinary(sum)];
        for (int i = rankInBinary(sum) - 1; i >= 0; i--) {
            res[i] = sum % 2 == 0 ? false : true;
            sum = sum / 2;
        }
        return res;
    }

    public static boolean[] mergeArrays(boolean[] a, boolean[] b) {
        boolean[] res = new boolean[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = a[i];
        }
        for (int i = a.length; i < a.length + b.length; i++) {
            res[i] = b[i - a.length];
        }
        return res;
    }

    public static int fromBinToNum(boolean[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i]) sum+=power2(a.length - i - 1);
        }
        return sum;
    }

    public static boolean[] fromNumToBin(int n) {
        boolean[] res = new boolean[rankInBinary(n)];
        for (int i = rankInBinary(n) - 1; i >= 0; i--) {
            res[i] = n % 2 == 0 ? false : true;
        }
        return res;
    }

}
