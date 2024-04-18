package com.xc.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SiteSpread
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Integer id;
  private String typeName;
  private String unit;
  private Integer startInterval;
  private Integer endInterval;
  private BigDecimal spreadRate;
  private Date addTime;
  private Date updateTime;
  
  public Integer getId()
  {
    return this.id;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  public String getTypeName()
  {
    return this.typeName;
  }
  
  public void setTypeName(String typeName)
  {
    this.typeName = typeName;
  }
  
  public String getUnit()
  {
    return this.unit;
  }
  
  public void setUnit(String unit)
  {
    this.unit = unit;
  }
  
  public Integer getStartInterval()
  {
    return this.startInterval;
  }
  
  public void setStartInterval(Integer startInterval)
  {
    this.startInterval = startInterval;
  }
  
  public Integer getEndInterval()
  {
    return this.endInterval;
  }
  
  public void setEndInterval(Integer endInterval)
  {
    this.endInterval = endInterval;
  }
  
  public BigDecimal getSpreadRate()
  {
    return this.spreadRate;
  }
  
  public void setSpreadRate(BigDecimal spreadRate)
  {
    this.spreadRate = spreadRate;
  }
  
  public Date getAddTime()
  {
    return this.addTime;
  }
  
  public void setAddTime(Date addTime)
  {
    this.addTime = addTime;
  }
  
  public Date getUpdateTime()
  {
    return this.updateTime;
  }
  
  public void setUpdateTime(Date updateTime)
  {
    this.updateTime = updateTime;
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.pojo.SiteSpread
 * JD-Core Version:    0.7.0.1
 */