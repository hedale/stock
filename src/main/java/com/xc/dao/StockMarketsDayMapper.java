package com.xc.dao;

import com.xc.pojo.StockMarketsDay;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public abstract interface StockMarketsDayMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(StockMarketsDay paramStockMarketsDay);
  
  public abstract int insertSelective(StockMarketsDay paramStockMarketsDay);
  
  public abstract StockMarketsDay selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByPrimaryKeySelective(StockMarketsDay paramStockMarketsDay);
  
  public abstract int updateByPrimaryKey(StockMarketsDay paramStockMarketsDay);
  
  public abstract BigDecimal selectRateByDaysAndStockCode(@Param("stockId") Integer paramInteger1, @Param("days") Integer paramInteger2);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.StockMarketsDayMapper

 * JD-Core Version:    0.7.0.1

 */