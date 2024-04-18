package com.xc.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UserStockSubscribe
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Integer id;
  private Integer userId;
  private String realName;
  private String phone;
  private Integer adminId;
  private String adminName;
  private BigDecimal submitAmount;
  private Integer status;
  private Date addTime;
  private Date submitTime;
  private Date endTime;
  private String remarks;
  
  public void setRealName(String realName)
  {
    this.realName = realName;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $id = getId();result = result * 59 + ($id == null ? 43 : $id.hashCode());Object $userId = getUserId();result = result * 59 + ($userId == null ? 43 : $userId.hashCode());Object $realName = getRealName();result = result * 59 + ($realName == null ? 43 : $realName.hashCode());Object $phone = getPhone();result = result * 59 + ($phone == null ? 43 : $phone.hashCode());Object $adminId = getAdminId();result = result * 59 + ($adminId == null ? 43 : $adminId.hashCode());Object $adminName = getAdminName();result = result * 59 + ($adminName == null ? 43 : $adminName.hashCode());Object $submitAmount = getSubmitAmount();result = result * 59 + ($submitAmount == null ? 43 : $submitAmount.hashCode());Object $status = getStatus();result = result * 59 + ($status == null ? 43 : $status.hashCode());Object $addTime = getAddTime();result = result * 59 + ($addTime == null ? 43 : $addTime.hashCode());Object $submitTime = getSubmitTime();result = result * 59 + ($submitTime == null ? 43 : $submitTime.hashCode());Object $endTime = getEndTime();result = result * 59 + ($endTime == null ? 43 : $endTime.hashCode());Object $remarks = getRemarks();result = result * 59 + ($remarks == null ? 43 : $remarks.hashCode());return result;
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof UserStockSubscribe;
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof UserStockSubscribe)) {
      return false;
    }
    UserStockSubscribe other = (UserStockSubscribe)o;
    if (!other.canEqual(this)) {
      return false;
    }
    Object this$id = getId();Object other$id = other.getId();
    if (this$id == null ? other$id != null : !this$id.equals(other$id)) {
      return false;
    }
    Object this$userId = getUserId();Object other$userId = other.getUserId();
    if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) {
      return false;
    }
    Object this$realName = getRealName();Object other$realName = other.getRealName();
    if (this$realName == null ? other$realName != null : !this$realName.equals(other$realName)) {
      return false;
    }
    Object this$phone = getPhone();Object other$phone = other.getPhone();
    if (this$phone == null ? other$phone != null : !this$phone.equals(other$phone)) {
      return false;
    }
    Object this$adminId = getAdminId();Object other$adminId = other.getAdminId();
    if (this$adminId == null ? other$adminId != null : !this$adminId.equals(other$adminId)) {
      return false;
    }
    Object this$adminName = getAdminName();Object other$adminName = other.getAdminName();
    if (this$adminName == null ? other$adminName != null : !this$adminName.equals(other$adminName)) {
      return false;
    }
    Object this$submitAmount = getSubmitAmount();Object other$submitAmount = other.getSubmitAmount();
    if (this$submitAmount == null ? other$submitAmount != null : !this$submitAmount.equals(other$submitAmount)) {
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
    Object this$submitTime = getSubmitTime();Object other$submitTime = other.getSubmitTime();
    if (this$submitTime == null ? other$submitTime != null : !this$submitTime.equals(other$submitTime)) {
      return false;
    }
    Object this$endTime = getEndTime();Object other$endTime = other.getEndTime();
    if (this$endTime == null ? other$endTime != null : !this$endTime.equals(other$endTime)) {
      return false;
    }
    Object this$remarks = getRemarks();Object other$remarks = other.getRemarks();return this$remarks == null ? other$remarks == null : this$remarks.equals(other$remarks);
  }
  
  public void setRemarks(String remarks)
  {
    this.remarks = remarks;
  }
  
  public void setEndTime(Date endTime)
  {
    this.endTime = endTime;
  }
  
  public void setSubmitTime(Date submitTime)
  {
    this.submitTime = submitTime;
  }
  
  public void setAddTime(Date addTime)
  {
    this.addTime = addTime;
  }
  
  public void setStatus(Integer status)
  {
    this.status = status;
  }
  
  public void setSubmitAmount(BigDecimal submitAmount)
  {
    this.submitAmount = submitAmount;
  }
  
  public void setAdminName(String adminName)
  {
    this.adminName = adminName;
  }
  
  public void setAdminId(Integer adminId)
  {
    this.adminId = adminId;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  public void setUserId(Integer userId)
  {
    this.userId = userId;
  }
  
  public String toString()
  {
    return "UserStockSubscribe(id=" + getId() + ", userId=" + getUserId() + ", realName=" + getRealName() + ", phone=" + getPhone() + ", adminId=" + getAdminId() + ", adminName=" + getAdminName() + ", submitAmount=" + getSubmitAmount() + ", status=" + getStatus() + ", addTime=" + getAddTime() + ", submitTime=" + getSubmitTime() + ", endTime=" + getEndTime() + ", remarks=" + getRemarks() + ")";
  }
  
  public void setPhone(String phone)
  {
    this.phone = phone;
  }
  
  public Integer getId()
  {
    return this.id;
  }
  
  public Integer getUserId()
  {
    return this.userId;
  }
  
  public String getRealName()
  {
    return this.realName;
  }
  
  public String getPhone()
  {
    return this.phone;
  }
  
  public Integer getAdminId()
  {
    return this.adminId;
  }
  
  public String getAdminName()
  {
    return this.adminName;
  }
  
  public BigDecimal getSubmitAmount()
  {
    return this.submitAmount;
  }
  
  public Integer getStatus()
  {
    return this.status;
  }
  
  public Date getAddTime()
  {
    return this.addTime;
  }
  
  public Date getSubmitTime()
  {
    return this.submitTime;
  }
  
  public Date getEndTime()
  {
    return this.endTime;
  }
  
  public String getRemarks()
  {
    return this.remarks;
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.pojo.UserStockSubscribe
 * JD-Core Version:    0.7.0.1
 */