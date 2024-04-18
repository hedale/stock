package com.xc.utils.stock;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BuyAndSellUtils
{
  private static final Logger log = LoggerFactory.getLogger(BuyAndSellUtils.class);
  
  public static boolean isTransTime(String begin_time, String end_time)
    throws Exception
  {
    if ((StringUtils.isBlank(begin_time)) || (StringUtils.isBlank(end_time))) {
      return false;
    }
    Date nowDate = new Date();
    if (!isWorkDay(nowDate)) {
      return false;
    }
    SimpleDateFormat df = new SimpleDateFormat("HH:mm");
    
    Date now = null;
    
    Date beginTime = null;
    
    Date endTime = null;
    try
    {
      now = df.parse(df.format(nowDate));
      
      beginTime = df.parse(begin_time);
      
      endTime = df.parse(end_time);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    Boolean flag = Boolean.valueOf(belongCalendar(now, beginTime, endTime));
    

    return flag.booleanValue();
  }
  
  public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime)
  {
    Calendar date = Calendar.getInstance();
    
    date.setTime(nowTime);
    
    Calendar begin = Calendar.getInstance();
    
    begin.setTime(beginTime);
    
    Calendar end = Calendar.getInstance();
    
    end.setTime(endTime);
    if ((begin.before(end)) && 
      (date.after(begin)) && (date.before(end))) {
      return true;
    }
    if ((begin.after(end)) && (
      (date.after(begin)) || (date.before(end)))) {
      return true;
    }
    return false;
  }
  
  public static boolean isWorkDay(Date currentDate)
    throws Exception
  {
    Calendar cal = Calendar.getInstance();
    
    cal.setTime(currentDate);
    if ((cal.get(7) == 7) || (cal.get(7) == 1)) {
      return false;
    }
    return true;
  }
  
  public static void main(String[] args)
    throws Exception
  {
    System.out.println(isTransTime("9:40", "16:31"));
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.utils.stock.BuyAndSellUtils

 * JD-Core Version:    0.7.0.1

 */