package com.xc.pojo;

import java.io.Serializable;
import java.util.Date;

public class FundsDealerInstitutions
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Integer id;
  private Integer dealerNumber;
  private String dealerName;
  private String clientVersionNumber;
  private String remarks;
  private Integer status;
  private Date addTime;
  private Date updateTime;
  
  public void setDealerName(String dealerName)
  {
    this.dealerName = dealerName;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $id = getId();result = result * 59 + ($id == null ? 43 : $id.hashCode());Object $dealerNumber = getDealerNumber();result = result * 59 + ($dealerNumber == null ? 43 : $dealerNumber.hashCode());Object $dealerName = getDealerName();result = result * 59 + ($dealerName == null ? 43 : $dealerName.hashCode());Object $clientVersionNumber = getClientVersionNumber();result = result * 59 + ($clientVersionNumber == null ? 43 : $clientVersionNumber.hashCode());Object $remarks = getRemarks();result = result * 59 + ($remarks == null ? 43 : $remarks.hashCode());Object $status = getStatus();result = result * 59 + ($status == null ? 43 : $status.hashCode());Object $addTime = getAddTime();result = result * 59 + ($addTime == null ? 43 : $addTime.hashCode());Object $updateTime = getUpdateTime();result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());return result;
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof FundsDealerInstitutions;
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof FundsDealerInstitutions)) {
      return false;
    }
    FundsDealerInstitutions other = (FundsDealerInstitutions)o;
    if (!other.canEqual(this)) {
      return false;
    }
    Object this$id = getId();Object other$id = other.getId();
    if (this$id == null ? other$id != null : !this$id.equals(other$id)) {
      return false;
    }
    Object this$dealerNumber = getDealerNumber();Object other$dealerNumber = other.getDealerNumber();
    if (this$dealerNumber == null ? other$dealerNumber != null : !this$dealerNumber.equals(other$dealerNumber)) {
      return false;
    }
    Object this$dealerName = getDealerName();Object other$dealerName = other.getDealerName();
    if (this$dealerName == null ? other$dealerName != null : !this$dealerName.equals(other$dealerName)) {
      return false;
    }
    Object this$clientVersionNumber = getClientVersionNumber();Object other$clientVersionNumber = other.getClientVersionNumber();
    if (this$clientVersionNumber == null ? other$clientVersionNumber != null : !this$clientVersionNumber.equals(other$clientVersionNumber)) {
      return false;
    }
    Object this$remarks = getRemarks();Object other$remarks = other.getRemarks();
    if (this$remarks == null ? other$remarks != null : !this$remarks.equals(other$remarks)) {
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
  
  public void setRemarks(String remarks)
  {
    this.remarks = remarks;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  public void setDealerNumber(Integer dealerNumber)
  {
    this.dealerNumber = dealerNumber;
  }
  
  public String toString()
  {
    return "FundsDealerInstitutions(id=" + getId() + ", dealerNumber=" + getDealerNumber() + ", dealerName=" + getDealerName() + ", clientVersionNumber=" + getClientVersionNumber() + ", remarks=" + getRemarks() + ", status=" + getStatus() + ", addTime=" + getAddTime() + ", updateTime=" + getUpdateTime() + ")";
  }
  
  public void setClientVersionNumber(String clientVersionNumber)
  {
    this.clientVersionNumber = clientVersionNumber;
  }
  
  public Integer getId()
  {
    return this.id;
  }
  
  public Integer getDealerNumber()
  {
    return this.dealerNumber;
  }
  
  public String getDealerName()
  {
    return this.dealerName;
  }
  
  public String getClientVersionNumber()
  {
    return this.clientVersionNumber;
  }
  
  public String getRemarks()
  {
    return this.remarks;
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
 * Qualified Name:     com.xc.pojo.FundsDealerInstitutions
 * JD-Core Version:    0.7.0.1
 */