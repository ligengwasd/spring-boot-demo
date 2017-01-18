package com.ydb.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ligeng on 17/1/5.
 */
public class DateUtil {
    public static final String DATETIME_FROMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FROMAT = "yyyy-MM-dd";
    public static Date strToDate(String str, String format){
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        Date date=null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static void main(String... args){
        Date date = strToDate("2016-10-10 10:10:10", DATETIME_FROMAT);
        System.out.println();
    }
}
