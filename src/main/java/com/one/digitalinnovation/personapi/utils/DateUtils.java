package com.one.digitalinnovation.personapi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String toString(Date date, String pattern){
        SimpleDateFormat  simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    public static Date toDate(String date, String pattern) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return  simpleDateFormat.parse(date);
    }
}
