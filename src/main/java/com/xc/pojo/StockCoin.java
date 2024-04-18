package com.xc.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class StockCoin
{
  private Integer id;
  private String coinName;
  private String coinCode;
  private String coinGid;
  private Integer dynamicRate;
  private BigDecimal defaultRate;
  private Integer isUse;
  private Date addTime;
  private String tDesc;
  
  public StockCoin(Integer id, String coinName, String coinCode, String coinGid, Integer dynamicRate, BigDecimal defaultRate, Integer isUse, Date addTime, String tDesc)
  {
    this.id = id;
    this.coinName = coinName;
    this.coinCode = coinCode;
    this.coinGid = coinGid;
    this.dynamicRate = dynamicRate;
    this.defaultRate = defaultRate;
    this.isUse = isUse;
    this.addTime = addTime;
    this.tDesc = tDesc;
  }
  
  public StockCoin() {}
  
  public Integer getId()
  {
    return this.id;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  public String getCoinName()
  {
    return this.coinName;
  }
  
  public void setCoinName(String coinName)
  {
    this.coinName = coinName;
  }
  
  public String getCoinCode()
  {
    return this.coinCode;
  }
  
  public void setCoinCode(String coinCode)
  {
    this.coinCode = coinCode;
  }
  
  public String getCoinGid()
  {
    return this.coinGid;
  }
  
  public void setCoinGid(String coinGid)
  {
    this.coinGid = coinGid;
  }
  
  public Integer getDynamicRate()
  {
    return this.dynamicRate;
  }
  
  public void setDynamicRate(Integer dynamicRate)
  {
    this.dynamicRate = dynamicRate;
  }
  
  public BigDecimal getDefaultRate()
  {
    return this.defaultRate;
  }
  
  public void setDefaultRate(BigDecimal defaultRate)
  {
    this.defaultRate = defaultRate;
  }
  
  public Integer getIsUse()
  {
    return this.isUse;
  }
  
  public void setIsUse(Integer isUse)
  {
    this.isUse = isUse;
  }
  
  public Date getAddTime()
  {
    return this.addTime;
  }
  
  public void setAddTime(Date addTime)
  {
    this.addTime = addTime;
  }
  
  public String gettDesc()
  {
    return this.tDesc;
  }
  
  public void settDesc(String tDesc)
  {
    this.tDesc = tDesc;
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.pojo.StockCoin
 * JD-Core Version:    0.7.0.1
 */