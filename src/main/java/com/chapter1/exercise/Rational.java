package com.chapter1.exercise;

import java.util.Objects;

public class Rational {
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        if(denominator == 0) {
            throw new ArithmeticException("分母不能为0");
        }

        int maxCommonDivisor = denominator;
        if(numerator != 0) {
            maxCommonDivisor = maxCommonDivisor(numerator, denominator);
        }

        this.numerator = numerator/maxCommonDivisor;
        this.denominator = denominator/maxCommonDivisor;
    }

    Rational plus(Rational b) {
        return new Rational(this.numerator * b.denominator + this.denominator * b.numerator,
                this.denominator * b.denominator);
    }

    Rational minus(Rational b) {
        return plus(new Rational(-1*b.numerator, b.denominator));
    }

    Rational times(Rational b) {
        return new Rational(this.numerator * b.numerator, this.denominator * b.denominator);
    }

    Rational divides(Rational b) {
        return this.times(new Rational(b.denominator, b.numerator));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof  Rational)) return false;
        Rational rational = (Rational) o;
        return numerator == rational.numerator &&
                denominator == rational.denominator;
    }

    @Override
    public String toString() {
        return "[" + numerator + "/" + denominator + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    static int maxCommonDivisor(int a, int b) {
        if(a < b) {
            maxCommonDivisor(b, a);
        }

        if(a%b == 0) {
            return b;
        }

        return maxCommonDivisor(b, a%b);
    }

    public static void main(String[] args) {
        Rational rational = new Rational(0, 5);
        Rational r2 = rational.plus(new Rational(1,6));
        Rational r3 = rational.times(new Rational(1, 3));
        Rational r4 = rational.divides(new Rational(3, 2));
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
    }
}
