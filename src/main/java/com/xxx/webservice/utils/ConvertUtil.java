package com.xxx.webservice.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertUtil {

    /**
     * 字符串转换成时间格式yyyy-MM-dd HH:mm:ss
     *
     * @param String strDate
     * @return yyyy-MM-dd HH:mm:ss格式
     */
    public static Date stringConvertToDate(String strDate, String formMatStr) {
        try {
            SimpleDateFormat sDateFormat = new SimpleDateFormat(formMatStr); // 加上时间
            return sDateFormat.parse(strDate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取现在时间string
     *
     * @param String formatDate  转换格式
     * @return string
     */
    public static String getNowString(String formatDate) {
        try {
            SimpleDateFormat f = new SimpleDateFormat(formatDate);
            return f.format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取现在时间date
     *
     * @param String formatDate  转换格式
     * @return string
     */
    public static Date getNowDate(String formatDate) {
        try {
            SimpleDateFormat f = new SimpleDateFormat(formatDate);
            return stringConvertToDate(f.format(new Date()), formatDate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 将mysql数据库中取出的时间格式转换成想要的String类型
    public static String getJavaDateOfString(Date date,String formatDate){
//        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(formatDate);
        return sdf.format(date);
    }

    // 将mysql数据库中取出的时间格式转换成想要的Date类型
    public static Date getJavaDateOfDate(Date date,String formatDate){
//        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(formatDate);
        return stringConvertToDate(sdf.format(date),formatDate);
    }
}
