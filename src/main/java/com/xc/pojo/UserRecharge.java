package com.xc.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class UserRecharge
{
  private Integer id;
  private Integer userId;
  private String nickName;
  private Integer agentId;
  private String orderSn;
  private String paySn;
  private String payChannel;
  private BigDecimal payAmt;
  private Integer orderStatus;
  private String orderDesc;
  private Date addTime;
  private Date payTime;
  private Integer payId;
  
  public UserRecharge(Integer id, Integer userId, String nickName, Integer agentId, String orderSn, String paySn, String payChannel, BigDecimal payAmt, Integer orderStatus, String orderDesc, Date addTime, Date payTime, Integer payId)
  {
    this.id = id;
    
    this.userId = userId;
    
    this.nickName = nickName;
    
    this.agentId = agentId;
    
    this.orderSn = orderSn;
    
    this.paySn = paySn;
    
    this.payChannel = payChannel;
    
    this.payAmt = payAmt;
    
    this.orderStatus = orderStatus;
    
    this.orderDesc = orderDesc;
    
    this.addTime = addTime;
    
    this.payTime = payTime;
    
    this.payId = payId;
  }
  
  public UserRecharge() {}
  
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
  
  public String getOrderSn()
  {
    return this.orderSn;
  }
  
  public void setOrderSn(String orderSn)
  {
    this.orderSn = orderSn;
  }
  
  public String getPaySn()
  {
    return this.paySn;
  }
  
  public void setPaySn(String paySn)
  {
    this.paySn = paySn;
  }
  
  public String getPayChannel()
  {
    return this.payChannel;
  }
  
  public void setPayChannel(String payChannel)
  {
    this.payChannel = payChannel;
  }
  
  public BigDecimal getPayAmt()
  {
    return this.payAmt;
  }
  
  public void setPayAmt(BigDecimal payAmt)
  {
    this.payAmt = payAmt;
  }
  
  public Integer getOrderStatus()
  {
    return this.orderStatus;
  }
  
  public void setOrderStatus(Integer orderStatus)
  {
    this.orderStatus = orderStatus;
  }
  
  public String getOrderDesc()
  {
    return this.orderDesc;
  }
  
  public void setOrderDesc(String orderDesc)
  {
    this.orderDesc = orderDesc;
  }
  
  public Date getAddTime()
  {
    return this.addTime;
  }
  
  public void setAddTime(Date addTime)
  {
    this.addTime = addTime;
  }
  
  public Date getPayTime()
  {
    return this.payTime;
  }
  
  public void setPayTime(Date payTime)
  {
    this.payTime = payTime;
  }
  
  public Integer getPayId()
  {
    return this.payId;
  }
  
  public void setPayId(Integer payId)
  {
    this.payId = payId;
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.pojo.UserRecharge
 * JD-Core Version:    0.7.0.1
 */