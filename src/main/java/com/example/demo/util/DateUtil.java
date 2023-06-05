/**
 * @author 12432
 * @date 2023/04/24
 */
package com.example.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static java.util.Date strToUtil(String strDate) {
        Date date = null;
        try {
            date = sdf.parse(strDate);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static java.sql.Date utilToSql(java.util.Date utilDate) {
        return new java.sql.Date(utilDate.getTime());
    }

    public static String utilToStr(java.util.Date date) {
        String strDate = sdf.format(date);
        return strDate;
    }
}
