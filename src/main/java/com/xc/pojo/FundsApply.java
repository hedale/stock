package com.xc.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FundsApply
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Integer id;
  private String orderNumber;
  private Integer userId;
  private String userName;
  private String userPhone;
  private Integer fundsType;
  private BigDecimal margin;
  private BigDecimal fundsAmount;
  private Integer lever;
  private BigDecimal totalTradingAmount;
  private BigDecimal enabledTradingAmount;
  private BigDecimal payAmount;
  private Integer tradersCycle;
  private Integer subaccountNumber;
  private BigDecimal manageFee;
  private Integer status;
  private Date addTime;
  private Date updateTime;
  private Date auditTime;
  private Date beginTime;
  private Date endTime;
  private String auditOpinion;
  private BigDecimal lineWarning;
  private BigDecimal lineUnwind;
  private BigDecimal ratioWarning;
  private BigDecimal ratioUnwind;
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  public void setOrderNumber(String orderNumber)
  {
    this.orderNumber = orderNumber;
  }
  
  public void setUserId(Integer userId)
  {
    this.userId = userId;
  }
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public void setUserPhone(String userPhone)
  {
    this.userPhone = userPhone;
  }
  
  public void setFundsType(Integer fundsType)
  {
    this.fundsType = fundsType;
  }
  
  public void setMargin(BigDecimal margin)
  {
    this.margin = margin;
  }
  
  public void setFundsAmount(BigDecimal fundsAmount)
  {
    this.fundsAmount = fundsAmount;
  }
  
  public void setLever(Integer lever)
  {
    this.lever = lever;
  }
  
  public void setTotalTradingAmount(BigDecimal totalTradingAmount)
  {
    this.totalTradingAmount = totalTradingAmount;
  }
  
  public void setEnabledTradingAmount(BigDecimal enabledTradingAmount)
  {
    this.enabledTradingAmount = enabledTradingAmount;
  }
  
  public void setPayAmount(BigDecimal payAmount)
  {
    this.payAmount = payAmount;
  }
  
  public void setTradersCycle(Integer tradersCycle)
  {
    this.tradersCycle = tradersCycle;
  }
  
  public void setSubaccountNumber(Integer subaccountNumber)
  {
    this.subaccountNumber = subaccountNumber;
  }
  
  public void setManageFee(BigDecimal manageFee)
  {
    this.manageFee = manageFee;
  }
  
  public void setStatus(Integer status)
  {
    this.status = status;
  }
  
  public void setAddTime(Date addTime)
  {
    this.addTime = addTime;
  }
  
  public void setUpdateTime(Date updateTime)
  {
    this.updateTime = updateTime;
  }
  
  public void setAuditTime(Date auditTime)
  {
    this.auditTime = auditTime;
  }
  
  public void setBeginTime(Date beginTime)
  {
    this.beginTime = beginTime;
  }
  
  public void setEndTime(Date endTime)
  {
    this.endTime = endTime;
  }
  
  public void setAuditOpinion(String auditOpinion)
  {
    this.auditOpinion = auditOpinion;
  }
  
  public void setLineWarning(BigDecimal lineWarning)
  {
    this.lineWarning = lineWarning;
  }
  
  public void setLineUnwind(BigDecimal lineUnwind)
  {
    this.lineUnwind = lineUnwind;
  }
  
  public void setRatioWarning(BigDecimal ratioWarning)
  {
    this.ratioWarning = ratioWarning;
  }
  
  public void setRatioUnwind(BigDecimal ratioUnwind)
  {
    this.ratioUnwind = ratioUnwind;
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof FundsApply)) {
      return false;
    }
    FundsApply other = (FundsApply)o;
    if (!other.canEqual(this)) {
      return false;
    }
    Object this$id = getId();Object other$id = other.getId();
    if (this$id == null ? other$id != null : !this$id.equals(other$id)) {
      return false;
    }
    Object this$orderNumber = getOrderNumber();Object other$orderNumber = other.getOrderNumber();
    if (this$orderNumber == null ? other$orderNumber != null : !this$orderNumber.equals(other$orderNumber)) {
      return false;
    }
    Object this$userId = getUserId();Object other$userId = other.getUserId();
    if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) {
      return false;
    }
    Object this$userName = getUserName();Object other$userName = other.getUserName();
    if (this$userName == null ? other$userName != null : !this$userName.equals(other$userName)) {
      return false;
    }
    Object this$userPhone = getUserPhone();Object other$userPhone = other.getUserPhone();
    if (this$userPhone == null ? other$userPhone != null : !this$userPhone.equals(other$userPhone)) {
      return false;
    }
    Object this$fundsType = getFundsType();Object other$fundsType = other.getFundsType();
    if (this$fundsType == null ? other$fundsType != null : !this$fundsType.equals(other$fundsType)) {
      return false;
    }
    Object this$margin = getMargin();Object other$margin = other.getMargin();
    if (this$margin == null ? other$margin != null : !this$margin.equals(other$margin)) {
      return false;
    }
    Object this$fundsAmount = getFundsAmount();Object other$fundsAmount = other.getFundsAmount();
    if (this$fundsAmount == null ? other$fundsAmount != null : !this$fundsAmount.equals(other$fundsAmount)) {
      return false;
    }
    Object this$lever = getLever();Object other$lever = other.getLever();
    if (this$lever == null ? other$lever != null : !this$lever.equals(other$lever)) {
      return false;
    }
    Object this$totalTradingAmount = getTotalTradingAmount();Object other$totalTradingAmount = other.getTotalTradingAmount();
    if (this$totalTradingAmount == null ? other$totalTradingAmount != null : !this$totalTradingAmount.equals(other$totalTradingAmount)) {
      return false;
    }
    Object this$enabledTradingAmount = getEnabledTradingAmount();Object other$enabledTradingAmount = other.getEnabledTradingAmount();
    if (this$enabledTradingAmount == null ? other$enabledTradingAmount != null : !this$enabledTradingAmount.equals(other$enabledTradingAmount)) {
      return false;
    }
    Object this$payAmount = getPayAmount();Object other$payAmount = other.getPayAmount();
    if (this$payAmount == null ? other$payAmount != null : !this$payAmount.equals(other$payAmount)) {
      return false;
    }
    Object this$tradersCycle = getTradersCycle();Object other$tradersCycle = other.getTradersCycle();
    if (this$tradersCycle == null ? other$tradersCycle != null : !this$tradersCycle.equals(other$tradersCycle)) {
      return false;
    }
    Object this$subaccountNumber = getSubaccountNumber();Object other$subaccountNumber = other.getSubaccountNumber();
    if (this$subaccountNumber == null ? other$subaccountNumber != null : !this$subaccountNumber.equals(other$subaccountNumber)) {
      return false;
    }
    Object this$manageFee = getManageFee();Object other$manageFee = other.getManageFee();
    if (this$manageFee == null ? other$manageFee != null : !this$manageFee.equals(other$manageFee)) {
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
    Object this$updateTime = getUpdateTime();Object other$updateTime = other.getUpdateTime();
    if (this$updateTime == null ? other$updateTime != null : !this$updateTime.equals(other$updateTime)) {
      return false;
    }
    Object this$auditTime = getAuditTime();Object other$auditTime = other.getAuditTime();
    if (this$auditTime == null ? other$auditTime != null : !this$auditTime.equals(other$auditTime)) {
      return false;
    }
    Object this$beginTime = getBeginTime();Object other$beginTime = other.getBeginTime();
    if (this$beginTime == null ? other$beginTime != null : !this$beginTime.equals(other$beginTime)) {
      return false;
    }
    Object this$endTime = getEndTime();Object other$endTime = other.getEndTime();
    if (this$endTime == null ? other$endTime != null : !this$endTime.equals(other$endTime)) {
      return false;
    }
    Object this$auditOpinion = getAuditOpinion();Object other$auditOpinion = other.getAuditOpinion();
    if (this$auditOpinion == null ? other$auditOpinion != null : !this$auditOpinion.equals(other$auditOpinion)) {
      return false;
    }
    Object this$lineWarning = getLineWarning();Object other$lineWarning = other.getLineWarning();
    if (this$lineWarning == null ? other$lineWarning != null : !this$lineWarning.equals(other$lineWarning)) {
      return false;
    }
    Object this$lineUnwind = getLineUnwind();Object other$lineUnwind = other.getLineUnwind();
    if (this$lineUnwind == null ? other$lineUnwind != null : !this$lineUnwind.equals(other$lineUnwind)) {
      return false;
    }
    Object this$ratioWarning = getRatioWarning();Object other$ratioWarning = other.getRatioWarning();
    if (this$ratioWarning == null ? other$ratioWarning != null : !this$ratioWarning.equals(other$ratioWarning)) {
      return false;
    }
    Object this$ratioUnwind = getRatioUnwind();Object other$ratioUnwind = other.getRatioUnwind();return this$ratioUnwind == null ? other$ratioUnwind == null : this$ratioUnwind.equals(other$ratioUnwind);
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof FundsApply;
  }
  
  public int hashCode()
  {
    int PRIME = 59;
    int result = 1;
    Object $id = getId();result = result * 59 + ($id == null ? 43 : $id.hashCode());Object $orderNumber = getOrderNumber();result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());Object $userId = getUserId();result = result * 59 + ($userId == null ? 43 : $userId.hashCode());Object $userName = getUserName();result = result * 59 + ($userName == null ? 43 : $userName.hashCode());Object $userPhone = getUserPhone();result = result * 59 + ($userPhone == null ? 43 : $userPhone.hashCode());Object $fundsType = getFundsType();result = result * 59 + ($fundsType == null ? 43 : $fundsType.hashCode());Object $margin = getMargin();result = result * 59 + ($margin == null ? 43 : $margin.hashCode());Object $fundsAmount = getFundsAmount();result = result * 59 + ($fundsAmount == null ? 43 : $fundsAmount.hashCode());Object $lever = getLever();result = result * 59 + ($lever == null ? 43 : $lever.hashCode());Object $totalTradingAmount = getTotalTradingAmount();result = result * 59 + ($totalTradingAmount == null ? 43 : $totalTradingAmount.hashCode());Object $enabledTradingAmount = getEnabledTradingAmount();result = result * 59 + ($enabledTradingAmount == null ? 43 : $enabledTradingAmount.hashCode());Object $payAmount = getPayAmount();result = result * 59 + ($payAmount == null ? 43 : $payAmount.hashCode());Object $tradersCycle = getTradersCycle();result = result * 59 + ($tradersCycle == null ? 43 : $tradersCycle.hashCode());Object $subaccountNumber = getSubaccountNumber();result = result * 59 + ($subaccountNumber == null ? 43 : $subaccountNumber.hashCode());Object $manageFee = getManageFee();result = result * 59 + ($manageFee == null ? 43 : $manageFee.hashCode());Object $status = getStatus();result = result * 59 + ($status == null ? 43 : $status.hashCode());Object $addTime = getAddTime();result = result * 59 + ($addTime == null ? 43 : $addTime.hashCode());Object $updateTime = getUpdateTime();result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());Object $auditTime = getAuditTime();result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());Object $beginTime = getBeginTime();result = result * 59 + ($beginTime == null ? 43 : $beginTime.hashCode());Object $endTime = getEndTime();result = result * 59 + ($endTime == null ? 43 : $endTime.hashCode());Object $auditOpinion = getAuditOpinion();result = result * 59 + ($auditOpinion == null ? 43 : $auditOpinion.hashCode());Object $lineWarning = getLineWarning();result = result * 59 + ($lineWarning == null ? 43 : $lineWarning.hashCode());Object $lineUnwind = getLineUnwind();result = result * 59 + ($lineUnwind == null ? 43 : $lineUnwind.hashCode());Object $ratioWarning = getRatioWarning();result = result * 59 + ($ratioWarning == null ? 43 : $ratioWarning.hashCode());Object $ratioUnwind = getRatioUnwind();return result * 59 + ($ratioUnwind == null ? 43 : $ratioUnwind.hashCode());
  }
  
  public String toString()
  {
    return "FundsApply(id=" + getId() + ", orderNumber=" + getOrderNumber() + ", userId=" + getUserId() + ", userName=" + getUserName() + ", userPhone=" + getUserPhone() + ", fundsType=" + getFundsType() + ", margin=" + getMargin() + ", fundsAmount=" + getFundsAmount() + ", lever=" + getLever() + ", totalTradingAmount=" + getTotalTradingAmount() + ", enabledTradingAmount=" + getEnabledTradingAmount() + ", payAmount=" + getPayAmount() + ", tradersCycle=" + getTradersCycle() + ", subaccountNumber=" + getSubaccountNumber() + ", manageFee=" + getManageFee() + ", status=" + getStatus() + ", addTime=" + getAddTime() + ", updateTime=" + getUpdateTime() + ", auditTime=" + getAuditTime() + ", beginTime=" + getBeginTime() + ", endTime=" + getEndTime() + ", auditOpinion=" + getAuditOpinion() + ", lineWarning=" + getLineWarning() + ", lineUnwind=" + getLineUnwind() + ", ratioWarning=" + getRatioWarning() + ", ratioUnwind=" + getRatioUnwind() + ")";
  }
  
  public Integer getId()
  {
    return this.id;
  }
  
  public String getOrderNumber()
  {
    return this.orderNumber;
  }
  
  public Integer getUserId()
  {
    return this.userId;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public String getUserPhone()
  {
    return this.userPhone;
  }
  
  public Integer getFundsType()
  {
    return this.fundsType;
  }
  
  public BigDecimal getMargin()
  {
    return this.margin;
  }
  
  public BigDecimal getFundsAmount()
  {
    return this.fundsAmount;
  }
  
  public Integer getLever()
  {
    return this.lever;
  }
  
  public BigDecimal getTotalTradingAmount()
  {
    return this.totalTradingAmount;
  }
  
  public BigDecimal getEnabledTradingAmount()
  {
    return this.enabledTradingAmount;
  }
  
  public BigDecimal getPayAmount()
  {
    return this.payAmount;
  }
  
  public Integer getTradersCycle()
  {
    return this.tradersCycle;
  }
  
  public Integer getSubaccountNumber()
  {
    return this.subaccountNumber;
  }
  
  public BigDecimal getManageFee()
  {
    return this.manageFee;
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
  
  public Date getAuditTime()
  {
    return this.auditTime;
  }
  
  public Date getBeginTime()
  {
    return this.beginTime;
  }
  
  public Date getEndTime()
  {
    return this.endTime;
  }
  
  public String getAuditOpinion()
  {
    return this.auditOpinion;
  }
  
  public BigDecimal getLineWarning()
  {
    return this.lineWarning;
  }
  
  public BigDecimal getLineUnwind()
  {
    return this.lineUnwind;
  }
  
  public BigDecimal getRatioWarning()
  {
    return this.ratioWarning;
  }
  
  public BigDecimal getRatioUnwind()
  {
    return this.ratioUnwind;
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.pojo.FundsApply
 * JD-Core Version:    0.7.0.1
 */