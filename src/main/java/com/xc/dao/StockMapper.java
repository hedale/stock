package com.xc.dao;

import com.xc.pojo.Stock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public abstract interface StockMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(Stock paramStock);
  
  public abstract int insertSelective(Stock paramStock);
  
  public abstract Stock selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByPrimaryKeySelective(Stock paramStock);
  
  public abstract int updateByPrimaryKey(Stock paramStock);
  
  public abstract List findStockListByKeyWords(@Param("keyWords") String paramString1, @Param("stockPlate") String paramString2, @Param("stockType") String paramString3, @Param("show") Integer paramInteger);
  
  public abstract List findStockCode(@Param("stockType") String paramString, @Param("stock_num") Integer paramInteger1, @Param("stock_nums") Integer paramInteger2);
  
  public abstract Stock findStockByCode(String paramString);
  
  public abstract Stock findStockByName(String paramString);
  
  public abstract List listByAdmin(@Param("showState") Integer paramInteger1, @Param("lockState") Integer paramInteger2, @Param("code") String paramString1, @Param("name") String paramString2, @Param("stockPlate") String paramString3, @Param("stockType") String paramString4);
  
  public abstract int CountStockNum();
  
  public abstract int CountShowNum(Integer paramInteger);
  
  public abstract int CountUnLockNum(Integer paramInteger);
  
  public abstract List findStockList();
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.StockMapper

 * JD-Core Version:    0.7.0.1

 */