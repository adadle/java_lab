package org.tony.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by TonyLee on 2014/12/25.
 * By IDEA
 */
public class DateTest {

    private static SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);


    public static void main(String[] args) throws ParseException {

        String map="2014-12-25 00:00:00";

        while(true){
            long cur = System.currentTimeMillis();
            String log = from_unixtime(cur,"yyyy-MM-dd HH:mm:ss");
            int ret = timeFormat.parse(log).compareTo(timeFormat.parse(map));
//            System.out.println("log time:"+log);
            if(ret != 1){
                System.out.println(ret);
                System.out.println("log time:"+log);
            }
        }
    }



    public static long getTime(Long unixTime , String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date d = new Date(unixTime);
        return d.getTime();
    }

    public static String from_unixtime(Long unixTime , String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date d = new Date(unixTime);
        return sdf.format(d);
    }




}
