package com.xc.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FundsLever
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Integer id;
  private Integer cycleType;
  private Integer lever;
  private BigDecimal manageRate;
  private BigDecimal singleHoldingRatio;
  private Integer status;
  private Date addTime;
  private Date updateTime;
  
  public void setLever(Integer lever)
  {
    this.lever = lever;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $id = getId();result = result * 59 + ($id == null ? 43 : $id.hashCode());Object $cycleType = getCycleType();result = result * 59 + ($cycleType == null ? 43 : $cycleType.hashCode());Object $lever = getLever();result = result * 59 + ($lever == null ? 43 : $lever.hashCode());Object $manageRate = getManageRate();result = result * 59 + ($manageRate == null ? 43 : $manageRate.hashCode());Object $singleHoldingRatio = getSingleHoldingRatio();result = result * 59 + ($singleHoldingRatio == null ? 43 : $singleHoldingRatio.hashCode());Object $status = getStatus();result = result * 59 + ($status == null ? 43 : $status.hashCode());Object $addTime = getAddTime();result = result * 59 + ($addTime == null ? 43 : $addTime.hashCode());Object $updateTime = getUpdateTime();result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());return result;
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof FundsLever;
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof FundsLever)) {
      return false;
    }
    FundsLever other = (FundsLever)o;
    if (!other.canEqual(this)) {
      return false;
    }
    Object this$id = getId();Object other$id = other.getId();
    if (this$id == null ? other$id != null : !this$id.equals(other$id)) {
      return false;
    }
    Object this$cycleType = getCycleType();Object other$cycleType = other.getCycleType();
    if (this$cycleType == null ? other$cycleType != null : !this$cycleType.equals(other$cycleType)) {
      return false;
    }
    Object this$lever = getLever();Object other$lever = other.getLever();
    if (this$lever == null ? other$lever != null : !this$lever.equals(other$lever)) {
      return false;
    }
    Object this$manageRate = getManageRate();Object other$manageRate = other.getManageRate();
    if (this$manageRate == null ? other$manageRate != null : !this$manageRate.equals(other$manageRate)) {
      return false;
    }
    Object this$singleHoldingRatio = getSingleHoldingRatio();Object other$singleHoldingRatio = other.getSingleHoldingRatio();
    if (this$singleHoldingRatio == null ? other$singleHoldingRatio != null : !this$singleHoldingRatio.equals(other$singleHoldingRatio)) {
      return false;
    }
    Object this$status = getStatus();Object other$status = other.getStatus();
    if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
      return false;
    }
    Object this$addTime = getAddTime();Object other$addTime = other.getAddTime();
    if (this$addTime == null ? other$addTime != null : !this$addTime.equals(other$addTime)) {
      return false;
    }
    Object this$updateTime = getUpdateTime();Object other$updateTime = other.getUpdateTime();return this$updateTime == null ? other$updateTime == null : this$updateTime.equals(other$updateTime);
  }
  
  public void setUpdateTime(Date updateTime)
  {
    this.updateTime = updateTime;
  }
  
  public void setAddTime(Date addTime)
  {
    this.addTime = addTime;
  }
  
  public void setStatus(Integer status)
  {
    this.status = status;
  }
  
  public void setSingleHoldingRatio(BigDecimal singleHoldingRatio)
  {
    this.singleHoldingRatio = singleHoldingRatio;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  public void setCycleType(Integer cycleType)
  {
    this.cycleType = cycleType;
  }
  
  public String toString()
  {
    return "FundsLever(id=" + getId() + ", cycleType=" + getCycleType() + ", lever=" + getLever() + ", manageRate=" + getManageRate() + ", singleHoldingRatio=" + getSingleHoldingRatio() + ", status=" + getStatus() + ", addTime=" + getAddTime() + ", updateTime=" + getUpdateTime() + ")";
  }
  
  public void setManageRate(BigDecimal manageRate)
  {
    this.manageRate = manageRate;
  }
  
  public Integer getId()
  {
    return this.id;
  }
  
  public Integer getCycleType()
  {
    return this.cycleType;
  }
  
  public Integer getLever()
  {
    return this.lever;
  }
  
  public BigDecimal getManageRate()
  {
    return this.manageRate;
  }
  
  public BigDecimal getSingleHoldingRatio()
  {
    return this.singleHoldingRatio;
  }
  
  public Integer getStatus()
  {
    return this.status;
  }
  
  public Date getAddTime()
  {
    return this.addTime;
  }
  
  public Date getUpdateTime()
  {
    return this.updateTime;
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.pojo.FundsLever
 * JD-Core Version:    0.7.0.1
 */