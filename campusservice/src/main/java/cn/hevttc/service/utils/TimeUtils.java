package cn.hevttc.service.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * Created by zhangdahui on 2017/5/1.
 * Add annotation by liboyang on 2017/06/07
 * 时间戳转化为当前时间
 * @author zhangdahui
 * @date 2017/5/1
 */
public class TimeUtils {

    private static final String FORMAT = "yyyy-MM-dd HH-mm-ss";


    /**
     * 获得当前时间的时间戳
     *
     * @return 系统时间
     */
    private static long currentStamp(){
        return System.currentTimeMillis();
    }
    /**将当前时间戳转化成字符串
     */
    public static String currentStampAsString(){return String.valueOf(System.currentTimeMillis());}

    /**
     * 将指定时间戳转化为固定格式的时间字符串
     * @param stamp
     * @return String
     */
    private static String toDateAsString(long stamp){
        SimpleDateFormat df = new SimpleDateFormat(FORMAT);

        Timestamp timeStamp = new Timestamp(stamp);
        String time = df.format(timeStamp);
        return time;
    }
    /**
     * 将字符串时间转化成时间戳
     * @param time  字符串时间
     * @return  时间戳
     */
    public static long getTime(String time) {
        SimpleDateFormat df = new SimpleDateFormat(FORMAT);
        Date d;
        long l = 0;
        try {
            d = df.parse(time);
            l = d.getTime();

        } catch (ParseException e) {

            e.printStackTrace();
        }
        return l;
    }
    public static String currentDateAsString(){
        return toDateAsString(currentStamp());
    }

}
