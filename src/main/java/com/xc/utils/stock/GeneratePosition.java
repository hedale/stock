package com.xc.utils.stock;

import com.xc.utils.DateTimeUtil;

import java.util.Date;
import java.util.Random;

public class GeneratePosition
{
  public static String getPositionId()
  {
    Random random = new Random();
    Integer number = Integer.valueOf(random.nextInt(90000) + 10000);
    

    String datestr = DateTimeUtil.dateToStr(new Date(), "yyyyMMdd");
    return datestr + number;
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.utils.stock.GeneratePosition

 * JD-Core Version:    0.7.0.1

 */