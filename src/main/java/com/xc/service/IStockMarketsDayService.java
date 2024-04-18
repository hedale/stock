package com.xc.service;

import java.math.BigDecimal;

public abstract interface IStockMarketsDayService
{
  public abstract void saveStockMarketDay();
  
  public abstract void saveHoliday();
  
  public abstract BigDecimal selectRateByDaysAndStockCode(Integer paramInteger, int paramInt);
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.service.IStockMarketsDayService
 * JD-Core Version:    0.7.0.1
 */