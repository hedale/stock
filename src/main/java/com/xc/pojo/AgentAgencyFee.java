package com.xc.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AgentAgencyFee
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Integer id;
  private Integer agentId;
  private Integer status;
  private Integer businessId;
  private Integer feeType;
  private Integer aymentType;
  private BigDecimal totalMoney;
  private BigDecimal profitMoney;
  private Date addTime;
  private Date updateTime;
  private String remarks;
  
  public Integer getId()
  {
    return this.id;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  public Integer getAgentId()
  {
    return this.agentId;
  }
  
  public void setAgentId(Integer agentId)
  {
    this.agentId = agentId;
  }
  
  public Integer getStatus()
  {
    return this.status;
  }
  
  public void setStatus(Integer status)
  {
    this.status = status;
  }
  
  public Integer getBusinessId()
  {
    return this.businessId;
  }
  
  public void setBusinessId(Integer businessId)
  {
    this.businessId = businessId;
  }
  
  public Integer getFeeType()
  {
    return this.feeType;
  }
  
  public void setFeeType(Integer feeType)
  {
    this.feeType = feeType;
  }
  
  public Integer getAymentType()
  {
    return this.aymentType;
  }
  
  public void setAymentType(Integer aymentType)
  {
    this.aymentType = aymentType;
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
  
  public String getRemarks()
  {
    return this.remarks;
  }
  
  public void setRemarks(String remarks)
  {
    this.remarks = remarks;
  }
  
  public BigDecimal getTotalMoney()
  {
    return this.totalMoney;
  }
  
  public void setTotalMoney(BigDecimal totalMoney)
  {
    this.totalMoney = totalMoney;
  }
  
  public BigDecimal getProfitMoney()
  {
    return this.profitMoney;
  }
  
  public void setProfitMoney(BigDecimal profitMoney)
  {
    this.profitMoney = profitMoney;
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.pojo.AgentAgencyFee
 * JD-Core Version:    0.7.0.1
 */