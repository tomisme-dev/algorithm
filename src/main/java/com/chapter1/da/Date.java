package com.chapter1.da;

public class Date {
    private final int value;
    public Date(int year, int month, int day) {
        this.value = year*512 + month*32 + day;
    }

    public int year() {
        return value/512;
    }

    public int month() {
        return (value%512)/32;
    }

    public int day() {
        return (value%512)%32;
    }

    @Override
    public String toString() {
        return String.format("%4d-%02d-%02d",year(), month(), day());
    }


    public static void main(String[] args) {
        Date date = new Date(2019, 9, 29);
        System.out.println(date);
    }
}
