package com.xc.dao;

import com.xc.pojo.StockFutures;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public abstract interface StockFuturesMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(StockFutures paramStockFutures);
  
  public abstract int insertSelective(StockFutures paramStockFutures);
  
  public abstract StockFutures selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByPrimaryKeySelective(StockFutures paramStockFutures);
  
  public abstract int updateByPrimaryKey(StockFutures paramStockFutures);
  
  public abstract List listByAdmin(@Param("fuName") String paramString1, @Param("fuCode") String paramString2);
  
  public abstract StockFutures selectFuturesByName(String paramString);
  
  public abstract StockFutures selectFuturesByCode(String paramString);
  
  public abstract List queryHome();
  
  public abstract List queryList();
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.StockFuturesMapper

 * JD-Core Version:    0.7.0.1

 */