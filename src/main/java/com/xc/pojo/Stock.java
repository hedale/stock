package com.xc.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Stock
{
  private Integer id;
  private String stockName;
  private String stockCode;
  private String stockSpell;
  private String stockType;
  private String stockGid;
  private String stockPlate;
  private Integer isLock;
  private Integer isShow;
  private Date addTime;
  private BigDecimal spreadRate;
  
  public String toString()
  {
    return "Stock{id=" + this.id + ", stockName='" + this.stockName + '\'' + ", stockCode='" + this.stockCode + '\'' + ", stockSpell='" + this.stockSpell + '\'' + ", stockType='" + this.stockType + '\'' + ", stockGid='" + this.stockGid + '\'' + ", stockPlate='" + this.stockPlate + '\'' + ", isLock=" + this.isLock + ", isShow=" + this.isShow + ", addTime=" + this.addTime + ", spreadRate=" + this.spreadRate + '}';
  }
  
  public Stock(Integer id, String stockName, String stockCode, String stockSpell, String stockType, String stockGid, String stockPlate, Integer isLock, Integer isShow, Date addTime, BigDecimal spreadRate)
  {
    this.id = id;
    this.stockName = stockName;
    this.stockCode = stockCode;
    this.stockSpell = stockSpell;
    this.stockType = stockType;
    this.stockGid = stockGid;
    this.stockPlate = stockPlate;
    this.isLock = isLock;
    this.isShow = isShow;
    this.addTime = addTime;
    this.spreadRate = spreadRate;
  }
  
  public Stock() {}
  
  public Integer getId()
  {
    return this.id;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  public String getStockName()
  {
    return this.stockName;
  }
  
  public void setStockName(String stockName)
  {
    this.stockName = stockName;
  }
  
  public String getStockCode()
  {
    return this.stockCode;
  }
  
  public void setStockCode(String stockCode)
  {
    this.stockCode = stockCode;
  }
  
  public String getStockSpell()
  {
    return this.stockSpell;
  }
  
  public void setStockSpell(String stockSpell)
  {
    this.stockSpell = stockSpell;
  }
  
  public String getStockType()
  {
    return this.stockType;
  }
  
  public void setStockType(String stockType)
  {
    this.stockType = stockType;
  }
  
  public String getStockGid()
  {
    return this.stockGid;
  }
  
  public void setStockGid(String stockGid)
  {
    this.stockGid = stockGid;
  }
  
  public String getStockPlate()
  {
    return this.stockPlate;
  }
  
  public void setStockPlate(String stockPlate)
  {
    this.stockPlate = stockPlate;
  }
  
  public Integer getIsLock()
  {
    return this.isLock;
  }
  
  public void setIsLock(Integer isLock)
  {
    this.isLock = isLock;
  }
  
  public Integer getIsShow()
  {
    return this.isShow;
  }
  
  public void setIsShow(Integer isShow)
  {
    this.isShow = isShow;
  }
  
  public Date getAddTime()
  {
    return this.addTime;
  }
  
  public void setAddTime(Date addTime)
  {
    this.addTime = addTime;
  }
  
  public BigDecimal getSpreadRate()
  {
    return this.spreadRate;
  }
  
  public void setSpreadRate(BigDecimal spreadRate)
  {
    this.spreadRate = spreadRate;
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.pojo.Stock
 * JD-Core Version:    0.7.0.1
 */