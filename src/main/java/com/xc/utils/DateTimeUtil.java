package com.xc.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil
{
  private static final Logger log = LoggerFactory.getLogger(DateTimeUtil.class);
  public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";
  public static final String YMD_FORMAT = "yyyy-MM-dd";
  public static final String HM_FORMAT = "HH:mm";
  
  public static Date getCurrentDate()
  {
    return new Date();
  }
  
  public static Date strToDate(String dateTimeStr, String formatStr)
  {
    DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(formatStr);
    DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
    return dateTime.toDate();
  }
  
  public static String dateToStr(Date date, String formatStr)
  {
    if (date == null) {
      return "";
    }
    DateTime dateTime = new DateTime(date);
    return dateTime.toString(formatStr);
  }
  
  public static Date strToDate(String dateTimeStr)
  {
    DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
    return dateTime.toDate();
  }
  
  public static String dateToStamp(String time)
  {
    String stamp = "";
    if (!"".equals(time))
    {
      try
      {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(time);
        long ts = date.getTime();
        return String.valueOf(ts);
      }
      catch (Exception e)
      {
        System.out.println("参数为空！");
      }
    }
    else
    {
      long current_time = System.currentTimeMillis();
      stamp = String.valueOf(current_time / 1000L);
    }
    return stamp;
  }
  
  public static String stampToDate(String s)
  {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    long lt = Long.parseLong(s);
    Date date = new Date(lt);
    String res = simpleDateFormat.format(date);
    return res;
  }
  
  public static String getStampNow()
  {
    Long startTs = Long.valueOf(System.currentTimeMillis());
    return startTs.toString();
  }
  
  public static Timestamp searchStrToTimestamp(String dateTimeStr)
  {
    return Timestamp.valueOf(dateTimeStr);
  }
  
  public static String dateToStr(Date date)
  {
    if (date == null) {
      return "";
    }
    DateTime dateTime = new DateTime(date);
    return dateTime.toString("yyyy-MM-dd HH:mm:ss");
  }
  
  public static Date longToDate(Long time)
  {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    String d = format.format(time);
    
    Date date = null;
    try
    {
      date = format.parse(d);
    }
    catch (Exception e)
    {
      log.error("datetime utils longToDate error");
    }
    return date;
  }
  
  public static Date doEndTime(Date begintime, int month)
  {
    Long begintimelong = Long.valueOf(begintime.getTime() / 1000L);
    log.info("计算时间 传入时间 = {} , 时间戳 = {}", dateToStr(begintime), begintimelong);
    
    Long endtimelong = Long.valueOf(begintimelong.longValue() + 2592000 * month);
    Date endtimedate = longToDate(Long.valueOf(endtimelong.longValue() * 1000L));
    
    log.info("endtime 时间戳 = {},时间 = {} , 格式化时间={}", new Object[] { endtimelong, endtimedate, 
      dateToStr(endtimedate) });
    
    return endtimedate;
  }
  
  public static String getCurrentTimeMiao()
  {
    return String.valueOf(System.currentTimeMillis() / 1000L);
  }
  
  public static Date parseToDateByMinute(int minuteTimes)
  {
    Date nowDate = new Date();
    Long nowtimes = Long.valueOf(nowDate.getTime() / 1000L);
    
    Long beginTimesLong = Long.valueOf(nowtimes.longValue() - minuteTimes * 60);
    return longToDate(Long.valueOf(beginTimesLong.longValue() * 1000L));
  }
  
  public static boolean isCanSell(Date buyDate, int maxMinutes)
  {
    Long buyDateTimes = Long.valueOf(buyDate.getTime() / 1000L);
    
    buyDateTimes = Long.valueOf(buyDateTimes.longValue() + maxMinutes * 60);
    
    Long nowDateTimes = Long.valueOf(new Date().getTime() / 1000L);
    if (nowDateTimes.longValue() > buyDateTimes.longValue()) {
      return true;
    }
    return false;
  }
  
  public static boolean sameDate(Date d1, Date d2)
  {
    SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
    
    return fmt.format(d1).equals(fmt.format(d2));
  }
  
  public static Date addDay(Date date, int num)
  {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(5, num);
    return cal.getTime();
  }
  
  public static void main(String[] args)
  {
    parseToDateByMinute(10);
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.utils.DateTimeUtil

 * JD-Core Version:    0.7.0.1

 */