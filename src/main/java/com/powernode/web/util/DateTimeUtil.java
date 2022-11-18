package com.powernode.web.util;

import java.util.Date;

@SuppressWarnings("all")
public class DateTimeUtil {
    private final static String DATE_FORMAT = "%1$tY-%1$tm-%1$td";
    private final static String TIME_FORMAT = "%1$tY-%1$tm-%1$td %1$tT";

    private DateTimeUtil() {
    }

    /**
     * <pre>
     *  返回当前时间的19位表示方式
     *  example 2022-11-14 19:54:19</pre>
     *   @return 返回当前时间
     */
    public static String generateNowTime() {
        return String.format(TIME_FORMAT, new Date());
    }

    /**
     * <pre>
     *  返回当前日期的10位表示方式
     *  example 2022-11-14</pre>
     * @return 返回当前日期
     */
    public static String generateNowDate() {
        return String.format(DATE_FORMAT, new Date());
    }

    /**
     *  时间格式化
     * @param time 要格式化的时间
     * @return 时间的字符串表达形式
     */
    public static String formatTime(Date time) {
        return String.format(TIME_FORMAT, time);
    }

    /**
     *  时间格式化
     * @param time 要格式化的时间
     * @return 时间的字符串表达形式
     */
    public static String formatTime(java.sql.Date time) {
        return String.format(TIME_FORMAT, time);
    }

    /**
     *  日期格式化
     * @param date 要格式化的日期
     * @return 日期的字符串表达形式
     */
    public static String formatDate(Date date) {
        return String.format(DATE_FORMAT, date);
    }

    /**
     *  日期格式化
     * @param date 要格式化的日期
     * @return 日期的字符串表达形式
     */
    public static String formatDate(java.sql.Date date) {
        return String.format(DATE_FORMAT, date);
    }
}
