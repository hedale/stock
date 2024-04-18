package com.xc.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class UserWithdraw
{
  private Integer id;
  private Integer userId;
  private String nickName;
  private Integer agentId;
  private BigDecimal withAmt;
  private Date applyTime;
  private Date transTime;
  private String withName;
  private String bankNo;
  private String bankName;
  private String bankAddress;
  private Integer withStatus;
  private BigDecimal withFee;
  private String withMsg;
  
  public UserWithdraw(Integer id, Integer userId, String nickName, Integer agentId, BigDecimal withAmt, Date applyTime, Date transTime, String withName, String bankNo, String bankName, String bankAddress, Integer withStatus, BigDecimal withFee, String withMsg)
  {
    this.id = id;
    
    this.userId = userId;
    
    this.nickName = nickName;
    
    this.agentId = agentId;
    
    this.withAmt = withAmt;
    
    this.applyTime = applyTime;
    
    this.transTime = transTime;
    
    this.withName = withName;
    
    this.bankNo = bankNo;
    
    this.bankName = bankName;
    
    this.bankAddress = bankAddress;
    
    this.withStatus = withStatus;
    
    this.withFee = withFee;
    
    this.withMsg = withMsg;
  }
  
  public UserWithdraw() {}
  
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
  
  public String getNickName()
  {
    return this.nickName;
  }
  
  public void setNickName(String nickName)
  {
    this.nickName = nickName;
  }
  
  public Integer getAgentId()
  {
    return this.agentId;
  }
  
  public void setAgentId(Integer agentId)
  {
    this.agentId = agentId;
  }
  
  public BigDecimal getWithAmt()
  {
    return this.withAmt;
  }
  
  public void setWithAmt(BigDecimal withAmt)
  {
    this.withAmt = withAmt;
  }
  
  public Date getApplyTime()
  {
    return this.applyTime;
  }
  
  public void setApplyTime(Date applyTime)
  {
    this.applyTime = applyTime;
  }
  
  public Date getTransTime()
  {
    return this.transTime;
  }
  
  public void setTransTime(Date transTime)
  {
    this.transTime = transTime;
  }
  
  public String getWithName()
  {
    return this.withName;
  }
  
  public void setWithName(String withName)
  {
    this.withName = withName;
  }
  
  public String getBankNo()
  {
    return this.bankNo;
  }
  
  public void setBankNo(String bankNo)
  {
    this.bankNo = bankNo;
  }
  
  public String getBankName()
  {
    return this.bankName;
  }
  
  public void setBankName(String bankName)
  {
    this.bankName = bankName;
  }
  
  public String getBankAddress()
  {
    return this.bankAddress;
  }
  
  public void setBankAddress(String bankAddress)
  {
    this.bankAddress = bankAddress;
  }
  
  public Integer getWithStatus()
  {
    return this.withStatus;
  }
  
  public void setWithStatus(Integer withStatus)
  {
    this.withStatus = withStatus;
  }
  
  public BigDecimal getWithFee()
  {
    return this.withFee;
  }
  
  public void setWithFee(BigDecimal withFee)
  {
    this.withFee = withFee;
  }
  
  public String getWithMsg()
  {
    return this.withMsg;
  }
  
  public void setWithMsg(String withMsg)
  {
    this.withMsg = withMsg;
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.pojo.UserWithdraw
 * JD-Core Version:    0.7.0.1
 */