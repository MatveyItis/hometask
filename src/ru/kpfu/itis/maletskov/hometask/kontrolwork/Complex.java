package ru.kpfu.itis.maletskov.hometask.kontrolwork;

/**
 * Created by Maletskov on 12.12.2017.
 */
public final class Complex extends Numbers{
    private final double real;
    private final double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public Complex(Complex num) {
        this.real = num.real;
        this.imag = num.imag;
    }

    public Complex add(Complex num) {
        double re = this.real + num.real;
        double im = this.imag + num.imag;
        return new Complex(re, im);
    }

    public Complex subtract(Complex num) {
        double re = this.real - num.real;
        double im = this.imag - num.imag;
        return new Complex(re, im);
    }

    public Complex multiply(Complex num) {
        double re = this.real * num.real - this.imag * num.imag;
        double im = this.real * num.imag + this.imag * num.real;
        return new Complex(re, im);
    }

    public Complex divide(Complex num) {
        double mod = num.real * num.real + num.imag * num.imag;
        double re = (this.real * num.real + this.imag * num.imag) / mod;
        double im = (this.imag * num.real - this.real * num.imag) / mod;
        return new Complex(re, im);
    }

    public double abs() {
        double mod = Math.sqrt(this.real * this.real + this.imag * this.imag);
        return mod;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Complex complex = (Complex) o;

        if (Double.compare(complex.real, real) == 0
                && Double.compare(complex.imag, imag) == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        if (this.real == 0 && this.imag == 0) {
            return "0";
        } else if (this.real == 0) {
            return this.imag + "i";
        } else if (this.imag == 0) {
            return this.real + "";
        } else {
            return this.real + " + " + this.imag + "i";
        }
    }
}
