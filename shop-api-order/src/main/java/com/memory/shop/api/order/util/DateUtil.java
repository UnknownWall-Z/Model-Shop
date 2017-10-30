package com.memory.shop.api.order.util;

import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * Created by 76585 on 2017/8/5.
 */
public class DateUtil {
    /**
     * 获取到一天的最开始时间,即时分秒都为0
     *
     * @param currentDate
     * @return
     */
    public static Date getBeginDate(Date currentDate) {
        //获取当前日期的Calendar
        Calendar c = Calendar.getInstance();
        //设置时间
        c.setTime(currentDate);
        //设置时分秒
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 获取到一天的最后一秒时间 23:59:59
     *
     * @param currentDate
     * @return
     */
    public static Date getEndDate(Date currentDate) {
        //获取当前日期的Calendar
        Calendar c = Calendar.getInstance();
        //设置时间
        c.setTime(currentDate);
        //设置时分秒
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    }

    /**
     * 获取两个时间之间的秒数
     * @param d1
     * @param d2
     * @return
     */
    public static long getSecondsBetween(Date d1, Date d2) {
        return Math.abs((d1.getTime() - d2.getTime()) / 1000);
    }

}
