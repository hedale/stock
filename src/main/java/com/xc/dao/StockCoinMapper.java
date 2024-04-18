package com.xc.dao;

import com.xc.pojo.StockCoin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public abstract interface StockCoinMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(StockCoin paramStockCoin);
  
  public abstract int insertSelective(StockCoin paramStockCoin);
  
  public abstract StockCoin selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByPrimaryKeySelective(StockCoin paramStockCoin);
  
  public abstract int updateByPrimaryKey(StockCoin paramStockCoin);
  
  public abstract List listByAdmin(@Param("coinName") String paramString1, @Param("coinCode") String paramString2);
  
  public abstract StockCoin selectCoinByName(String paramString);
  
  public abstract StockCoin selectCoinByCode(String paramString);
  
  public abstract StockCoin selectCoinByGid(String paramString);
  
  public abstract List getSelectCoin();
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.StockCoinMapper

 * JD-Core Version:    0.7.0.1

 */