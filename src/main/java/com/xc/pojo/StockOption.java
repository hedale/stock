package com.xc.pojo;

import java.util.Date;

public class StockOption
{
  private Integer id;
  private Integer userId;
  private Integer stockId;
  private Date addTime;
  private String stockCode;
  private String stockName;
  private String stockGid;
  private Integer isLock;
  
  public StockOption(Integer id, Integer userId, Integer stockId, Date addTime, String stockCode, String stockName, String stockGid, Integer isLock)
  {
    this.id = id;
    this.userId = userId;
    this.stockId = stockId;
    this.addTime = addTime;
    this.stockCode = stockCode;
    this.stockName = stockName;
    this.stockGid = stockGid;
    this.isLock = isLock;
  }
  
  public StockOption() {}
  
  public Integer getId()
  {
    return this.id;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  public Integer getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(Integer userId)
  {
    this.userId = userId;
  }
  
  public Integer getStockId()
  {
    return this.stockId;
  }
  
  public void setStockId(Integer stockId)
  {
    this.stockId = stockId;
  }
  
  public Date getAddTime()
  {
    return this.addTime;
  }
  
  public void setAddTime(Date addTime)
  {
    this.addTime = addTime;
  }
  
  public String getStockCode()
  {
    return this.stockCode;
  }
  
  public void setStockCode(String stockCode)
  {
    this.stockCode = stockCode;
  }
  
  public String getStockName()
  {
    return this.stockName;
  }
  
  public void setStockName(String stockName)
  {
    this.stockName = stockName;
  }
  
  public String getStockGid()
  {
    return this.stockGid;
  }
  
  public void setStockGid(String stockGid)
  {
    this.stockGid = stockGid;
  }
  
  public Integer getIsLock()
  {
    return this.isLock;
  }
  
  public void setIsLock(Integer isLock)
  {
    this.isLock = isLock;
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.pojo.StockOption
 * JD-Core Version:    0.7.0.1
 */