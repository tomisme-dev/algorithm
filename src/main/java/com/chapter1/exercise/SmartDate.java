package com.chapter1.exercise;


import java.time.LocalDate;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class SmartDate {
    private final int[] maxDayPerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int year;
    private int month;
    private int day;
    private int totolDays = 365;
    private static SmartDate flagDate = new SmartDate(1999, 12, 27);

    public SmartDate(int year, int month, int day) {
        if(year < 0) {
            throw new IllegalArgumentException("年份必须大于0");
        }
        if(month < 1 || month > 12) {
            throw new IllegalArgumentException("月份必须在1-12之间");
        }

        if(day < 1) {
            throw new IllegalArgumentException("日必须大于0");
        }
//      设置最大日
        setMaxDayByMonth(year);
        if(day > maxDayPerMonth[month-1]) {
            throw new IllegalArgumentException("日必须小于或等于" + maxDayPerMonth[month-1]);
        }
        this.year = year;
        this.month = month;
        this.day = day;

    }

    private void setMaxDayByMonth(int year) {
        if(isLeapYear(year)) {
            maxDayPerMonth[1] = 29;
            totolDays = 366;
        } else {
            //            平年
            maxDayPerMonth[1] = 28;
            totolDays = 365;
        }
    }

    public static boolean isLeapYear(int year) {
        if(year % 100 == 0 && year % 400 == 0) {
//            闰年
            return true;
        } else if(year % 100 != 0 && year % 4 == 0) {
//            闰年
            return true;
        } else {
//            平年
            return false;
        }
    }

    public Weekend dayOfTheWeek() {
        int days = flagDate.daysBetween(this);
        int val = days % 7;
        return Weekend.from(val);
    }


    private int daysBetween(SmartDate day2) {
        int dayOfYear1 = dayOfYear();
        int dayOfYear2 = day2.dayOfYear();
        if(year == day2.year) {
            return dayOfYear2 - dayOfYear1;
        }

        int sumDays = totolDays - dayOfYear1;
        for(int y = year + 1; y < day2.year; y++) {
            sumDays += (isLeapYear(y) ? 366: 365);
        }
        return sumDays + dayOfYear2;
    }

    private int dayOfYear() {
        int index = month - 1;
        int daySum = 0;
        for(int i = 0; i <= index - 1; i++) {
            daySum += maxDayPerMonth[i];
        }
        return daySum+day;
    }


    static enum Weekend {
        Monday(0), Tuesday(1), WednesDay(2), Thursday(3), Friday(4), Saturday(5), Sunday(6);

        private static Map<Integer, Weekend> weekendEnumMap = new HashMap<>();

        static {
            for(Weekend w: values()) {
                weekendEnumMap.put(w.val, w);
            }
        }
        private int val;
        Weekend(int val) {
            this.val = val;
        }

        static Weekend from(int val) {
            return weekendEnumMap.get(val);
        }
    }


    public static void main(String[] args) {
        SmartDate smartDate1 = new SmartDate(2010, 11, 15);
        SmartDate smartDate2 = new SmartDate(2012, 8, 31);
        LocalDate ld1 = LocalDate.of(smartDate1.year, smartDate1.month, smartDate1.day);
        LocalDate ld2 = LocalDate.of(smartDate2.year, smartDate2.month, smartDate2.day);
        System.out.println(smartDate1.daysBetween(smartDate2));
        System.out.println(ld2.toEpochDay() - ld1.toEpochDay());
        System.out.println(smartDate1.dayOfTheWeek());
        System.out.println(ld1.getDayOfWeek());
    }
}
