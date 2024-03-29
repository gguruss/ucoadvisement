/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1.businesslayer;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

/**
 *
 * @author guru
 */
public class Utility {

    public static String encrypt(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(data.getBytes("UTF-8")); // Change this to "UTF-16" if needed
            byte[] digest = md.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            return bigInt.toString(16);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            return null;
        }
    }

    public static String randomCodeGenerator() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    public static DateTime getTime(String time) {
        DateTime date = DateTime.parse(time, DateTimeFormat.forPattern("HH:mm"));
        return date;
    }
    
    public static DateTime getDate(String userdate) {
        DateTime date = DateTime.parse(userdate, DateTimeFormat.forPattern("dd/MM/yyyy"));
        return date;
    }
}
