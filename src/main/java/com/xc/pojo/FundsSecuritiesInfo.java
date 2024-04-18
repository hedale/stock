package com.xc.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FundsSecuritiesInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Integer id;
  private Integer dealerInstitutionsId;
  private String dealerInstitutionsName;
  private String salesDepartment;
  private String accountName;
  private String transactAccount;
  private String transactPassword;
  private String communicationPassword;
  private BigDecimal commissionRatio;
  private BigDecimal minimumCommissions;
  private Integer status;
  private Date addTime;
  private Date updateTime;
  
  public void setDealerInstitutionsName(String dealerInstitutionsName)
  {
    this.dealerInstitutionsName = dealerInstitutionsName;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $id = getId();result = result * 59 + ($id == null ? 43 : $id.hashCode());Object $dealerInstitutionsId = getDealerInstitutionsId();result = result * 59 + ($dealerInstitutionsId == null ? 43 : $dealerInstitutionsId.hashCode());Object $dealerInstitutionsName = getDealerInstitutionsName();result = result * 59 + ($dealerInstitutionsName == null ? 43 : $dealerInstitutionsName.hashCode());Object $salesDepartment = getSalesDepartment();result = result * 59 + ($salesDepartment == null ? 43 : $salesDepartment.hashCode());Object $accountName = getAccountName();result = result * 59 + ($accountName == null ? 43 : $accountName.hashCode());Object $transactAccount = getTransactAccount();result = result * 59 + ($transactAccount == null ? 43 : $transactAccount.hashCode());Object $transactPassword = getTransactPassword();result = result * 59 + ($transactPassword == null ? 43 : $transactPassword.hashCode());Object $communicationPassword = getCommunicationPassword();result = result * 59 + ($communicationPassword == null ? 43 : $communicationPassword.hashCode());Object $commissionRatio = getCommissionRatio();result = result * 59 + ($commissionRatio == null ? 43 : $commissionRatio.hashCode());Object $minimumCommissions = getMinimumCommissions();result = result * 59 + ($minimumCommissions == null ? 43 : $minimumCommissions.hashCode());Object $status = getStatus();result = result * 59 + ($status == null ? 43 : $status.hashCode());Object $addTime = getAddTime();result = result * 59 + ($addTime == null ? 43 : $addTime.hashCode());Object $updateTime = getUpdateTime();result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());return result;
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof FundsSecuritiesInfo;
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof FundsSecuritiesInfo)) {
      return false;
    }
    FundsSecuritiesInfo other = (FundsSecuritiesInfo)o;
    if (!other.canEqual(this)) {
      return false;
    }
    Object this$id = getId();Object other$id = other.getId();
    if (this$id == null ? other$id != null : !this$id.equals(other$id)) {
      return false;
    }
    Object this$dealerInstitutionsId = getDealerInstitutionsId();Object other$dealerInstitutionsId = other.getDealerInstitutionsId();
    if (this$dealerInstitutionsId == null ? other$dealerInstitutionsId != null : !this$dealerInstitutionsId.equals(other$dealerInstitutionsId)) {
      return false;
    }
    Object this$dealerInstitutionsName = getDealerInstitutionsName();Object other$dealerInstitutionsName = other.getDealerInstitutionsName();
    if (this$dealerInstitutionsName == null ? other$dealerInstitutionsName != null : !this$dealerInstitutionsName.equals(other$dealerInstitutionsName)) {
      return false;
    }
    Object this$salesDepartment = getSalesDepartment();Object other$salesDepartment = other.getSalesDepartment();
    if (this$salesDepartment == null ? other$salesDepartment != null : !this$salesDepartment.equals(other$salesDepartment)) {
      return false;
    }
    Object this$accountName = getAccountName();Object other$accountName = other.getAccountName();
    if (this$accountName == null ? other$accountName != null : !this$accountName.equals(other$accountName)) {
      return false;
    }
    Object this$transactAccount = getTransactAccount();Object other$transactAccount = other.getTransactAccount();
    if (this$transactAccount == null ? other$transactAccount != null : !this$transactAccount.equals(other$transactAccount)) {
      return false;
    }
    Object this$transactPassword = getTransactPassword();Object other$transactPassword = other.getTransactPassword();
    if (this$transactPassword == null ? other$transactPassword != null : !this$transactPassword.equals(other$transactPassword)) {
      return false;
    }
    Object this$communicationPassword = getCommunicationPassword();Object other$communicationPassword = other.getCommunicationPassword();
    if (this$communicationPassword == null ? other$communicationPassword != null : !this$communicationPassword.equals(other$communicationPassword)) {
      return false;
    }
    Object this$commissionRatio = getCommissionRatio();Object other$commissionRatio = other.getCommissionRatio();
    if (this$commissionRatio == null ? other$commissionRatio != null : !this$commissionRatio.equals(other$commissionRatio)) {
      return false;
    }
    Object this$minimumCommissions = getMinimumCommissions();Object other$minimumCommissions = other.getMinimumCommissions();
    if (this$minimumCommissions == null ? other$minimumCommissions != null : !this$minimumCommissions.equals(other$minimumCommissions)) {
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
  
  public void setMinimumCommissions(BigDecimal minimumCommissions)
  {
    this.minimumCommissions = minimumCommissions;
  }
  
  public void setCommissionRatio(BigDecimal commissionRatio)
  {
    this.commissionRatio = commissionRatio;
  }
  
  public void setCommunicationPassword(String communicationPassword)
  {
    this.communicationPassword = communicationPassword;
  }
  
  public void setTransactPassword(String transactPassword)
  {
    this.transactPassword = transactPassword;
  }
  
  public void setTransactAccount(String transactAccount)
  {
    this.transactAccount = transactAccount;
  }
  
  public void setAccountName(String accountName)
  {
    this.accountName = accountName;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  public void setDealerInstitutionsId(Integer dealerInstitutionsId)
  {
    this.dealerInstitutionsId = dealerInstitutionsId;
  }
  
  public String toString()
  {
    return "FundsSecuritiesInfo(id=" + getId() + ", dealerInstitutionsId=" + getDealerInstitutionsId() + ", dealerInstitutionsName=" + getDealerInstitutionsName() + ", salesDepartment=" + getSalesDepartment() + ", accountName=" + getAccountName() + ", transactAccount=" + getTransactAccount() + ", transactPassword=" + getTransactPassword() + ", communicationPassword=" + getCommunicationPassword() + ", commissionRatio=" + getCommissionRatio() + ", minimumCommissions=" + getMinimumCommissions() + ", status=" + getStatus() + ", addTime=" + getAddTime() + ", updateTime=" + getUpdateTime() + ")";
  }
  
  public void setSalesDepartment(String salesDepartment)
  {
    this.salesDepartment = salesDepartment;
  }
  
  public Integer getId()
  {
    return this.id;
  }
  
  public Integer getDealerInstitutionsId()
  {
    return this.dealerInstitutionsId;
  }
  
  public String getDealerInstitutionsName()
  {
    return this.dealerInstitutionsName;
  }
  
  public String getSalesDepartment()
  {
    return this.salesDepartment;
  }
  
  public String getAccountName()
  {
    return this.accountName;
  }
  
  public String getTransactAccount()
  {
    return this.transactAccount;
  }
  
  public String getTransactPassword()
  {
    return this.transactPassword;
  }
  
  public String getCommunicationPassword()
  {
    return this.communicationPassword;
  }
  
  public BigDecimal getCommissionRatio()
  {
    return this.commissionRatio;
  }
  
  public BigDecimal getMinimumCommissions()
  {
    return this.minimumCommissions;
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
 * Qualified Name:     com.xc.pojo.FundsSecuritiesInfo
 * JD-Core Version:    0.7.0.1
 */