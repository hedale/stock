package com.xc.dao;

import com.xc.pojo.StockOption;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public abstract interface StockOptionMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(StockOption paramStockOption);
  
  public abstract int insertSelective(StockOption paramStockOption);
  
  public abstract StockOption selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByPrimaryKeySelective(StockOption paramStockOption);
  
  public abstract int updateByPrimaryKey(StockOption paramStockOption);
  
  public abstract StockOption findMyOptionIsExistByCode(@Param("uid") Integer paramInteger, @Param("stockCode") String paramString);
  
  public abstract List findMyOptionByKeywords(@Param("uid") Integer paramInteger, @Param("keyWords") String paramString);
  
  public abstract StockOption isOption(@Param("uid") Integer paramInteger, @Param("code") String paramString);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.StockOptionMapper

 * JD-Core Version:    0.7.0.1

 */