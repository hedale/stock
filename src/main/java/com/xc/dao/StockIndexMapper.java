package com.xc.dao;

import com.xc.pojo.StockIndex;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public abstract interface StockIndexMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(StockIndex paramStockIndex);
  
  public abstract int insertSelective(StockIndex paramStockIndex);
  
  public abstract StockIndex selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByPrimaryKeySelective(StockIndex paramStockIndex);
  
  public abstract int updateByPrimaryKey(StockIndex paramStockIndex);
  
  public abstract StockIndex selectIndexByName(@Param("indexName") String paramString);
  
  public abstract StockIndex selectIndexByCode(@Param("indexCode") String paramString);
  
  public abstract List listByAdmin(@Param("homeShow") Integer paramInteger1, @Param("listShow") Integer paramInteger2, @Param("transState") Integer paramInteger3, @Param("indexCode") String paramString1, @Param("indexName") String paramString2);
  
  public abstract List queryHomeIndex();
  
  public abstract List queryListIndex();
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.StockIndexMapper

 * JD-Core Version:    0.7.0.1

 */