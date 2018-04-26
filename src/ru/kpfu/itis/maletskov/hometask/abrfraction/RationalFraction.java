package ru.kpfu.itis.maletskov.hometask.abrfraction;

/**
 * Created by Maletskov on 21.12.2017.
 */
public class RationalFraction {
    private int chis;
    private int znam;

    public RationalFraction() {
        chis = 0;
    }

    public RationalFraction(int chis, int znam) throws ArithmeticException {
        try {
            this.chis = chis;
            this.znam = znam;
            int pr = chis / znam;
        } catch (ArithmeticException e) {
            throw e;
        }
    }

    public void reduce() {
        int nod = nod(this.chis, this.znam);
        chis = chis / nod;
        znam = znam / nod;
        if ((znam < 0 && chis < 0) || (znam > 0 && chis > 0)) {
            chis = Math.abs(chis);
            znam = Math.abs(znam);
        } else {
            chis = - Math.abs(chis);
            znam = Math.abs(znam);
        }
    }

    public RationalFraction add(RationalFraction r) {
        if (this.znam == r.znam) {
            int chis1 = this.chis + r.chis;
            RationalFraction n = new RationalFraction(chis1, znam);
            n.reduce();
            return n;
        }
        int chis1 = this.chis * r.znam + this.znam * r.chis;
        int znam1 = this.znam * r.znam;
        RationalFraction n = new RationalFraction(chis1, znam1);
        n.reduce();
        return n;
    }

    public RationalFraction sub(RationalFraction r) {
        if (this.znam == r.znam) {
            int chis1 = this.chis - r.chis;
            RationalFraction n = new RationalFraction(chis1, znam);
            n.reduce();
            return n;
        }
        int chis1 = this.chis * r.znam - this.znam * r.chis;
        int znam1 = this.znam * r.znam;
        RationalFraction n = new RationalFraction(chis1, znam1);
        n.reduce();
        return n;
    }

    public RationalFraction mult(RationalFraction r) {
        int chis1 = this.chis * r.chis;
        int znam1 = this.znam * r.znam;
        RationalFraction n = new RationalFraction(chis1, znam1);
        n.reduce();
        return n;
    }

    public RationalFraction div(RationalFraction r) {
        int chis1 = this.chis * r.znam;
        int znam1 = this.znam * r.chis;
        RationalFraction n = new RationalFraction(chis1, znam1);
        n.reduce();
        return n;
    }

    public int nod(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while(a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }

    public double value() {
        return 1.0 * chis / znam;
    }

    public String toString() {
        if (znam != 1) {
            return chis + "/" + znam;
        } else {
            return chis + "";
        }
    }
}
