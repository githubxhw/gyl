package cn.cuit.gyl.utils;

import java.util.Calendar;
import java.util.Date;

public class TimeUtils {

    /**
     * 返回两天之间的距离： 天、时、分
     * @param beginDate
     * @param endDate
     * @return
     * @throws Exception
     */
    public static String getTimeDifference(Date beginDate, Date endDate) throws Exception{
        if (beginDate.after(endDate)){
            return null;
        }
        long d = 1000*60*60*24;
        long h = d/24;
        long m = h/60;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(beginDate);
        long beginDateMillis = calendar.getTimeInMillis();
        calendar.setTime(endDate);
        long endDateMillis = calendar.getTimeInMillis();
        long away = endDateMillis-beginDateMillis;
        long day = away/d;
        long hours = (away%d)/h;
        long minutes = ((away%d)%h)/m;
        return day+"天"+hours+"时"+minutes+"分";
    }
}
