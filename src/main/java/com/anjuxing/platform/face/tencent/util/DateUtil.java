package com.anjuxing.platform.face.tencent.util;



import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

/**
 * @author xiongt
 * @Description
 */
public class DateUtil {

    private DateUtil(){}

    /**
     * 将日期添加指定的小时
     * @param baseDate
     * @param hours
     * @return
     */
    public static Date calculateDateByHours(Date baseDate ,long hours){
        LocalDateTime localDateTime = convert(baseDate);
        localDateTime = localDateTime.plusHours(hours);
        return convert(localDateTime);
    }
    /**
     * 将日期添加指定的天数
     * @param baseDate
     * @param days
     * @return
     */
    public static Date calculateDateByDays(Date baseDate ,long days){
        LocalDateTime localDateTime = convert(baseDate);
        localDateTime = localDateTime.plusDays(days);

//        new Date (baseDate.getTime() + (24 * 60 * 60 * 1000) * days)
        return  convert(localDateTime);
    }

    /**
     * 将日期加上指定的月数
     * @param baseDate
     * @param months
     * @return
     */
    public  static Date calculateDateByMonths (Date baseDate ,long months){

        LocalDateTime localDateTime = convert(baseDate);
        localDateTime =localDateTime.plusMonths(months);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 将date 转换为 LocalDateTime
     * @param baseDate
     * @return
     */
    private static LocalDateTime convert(Date baseDate){
        if (Objects.isNull(baseDate)){
            throw new NullPointerException("param Date baseDate is null");
        }
        return LocalDateTime.ofInstant(baseDate.toInstant(), ZoneId.systemDefault());
    }

    /**
     * 将 LocalDateTime 转换为Date
     * @param localDateTime
     * @return
     */
    private static Date convert(LocalDateTime localDateTime){
        if (Objects.isNull(localDateTime)){
            throw new NullPointerException("param LocalDateTime is null");
        }

        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

    }




}
