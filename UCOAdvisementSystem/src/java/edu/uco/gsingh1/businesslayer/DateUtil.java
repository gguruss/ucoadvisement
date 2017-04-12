/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1.businesslayer;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author guru
 */
public class DateUtil {

    private static final DateFormat utilDateFormatter = new SimpleDateFormat("dd-MM-yyyy");
    private static final DateFormat utilTimeFormatter = new SimpleDateFormat("HH:mm");
    private static final DateFormat sqlTimeFormatter = new SimpleDateFormat("HH:mm");
    private static final DateFormat sqlDateFormatter = new SimpleDateFormat("yyyy-MM-dd");

    public static java.sql.Date utilDateToSqlDate(java.util.Date uDate) throws ParseException {
        return java.sql.Date.valueOf(sqlDateFormatter.format(uDate));
    }
    
    public static Time utilTimeToSqlTime(java.util.Date uDate) throws ParseException {
        return java.sql.Time.valueOf(sqlTimeFormatter.format(uDate));
    }

    public static java.util.Date sqlDateToutilDate(java.sql.Date sDate) throws ParseException {
        return (java.util.Date) utilDateFormatter.parse(utilDateFormatter.format(sDate));
    }
}
