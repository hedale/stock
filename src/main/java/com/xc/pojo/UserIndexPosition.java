package com.xc.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class UserIndexPosition
{
  private Integer id;
  private Integer positionType;
  private String positionSn;
  private Integer userId;
  private String realName;
  private Integer agentId;
  private String indexName;
  private String indexCode;
  private String indexGid;
  private Date buyOrderTime;
  private BigDecimal buyOrderPrice;
  private Date sellOrderTime;
  private BigDecimal sellOrderPrice;
  private String orderDirection;
  private Integer orderNum;
  private BigDecimal allDepositAmt;
  private BigDecimal orderFee;
  private Integer orderStayDays;
  private BigDecimal eachPoint;
  private BigDecimal profitAndLose;
  private BigDecimal allProfitAndLose;
  private Integer isLock;
  private String lockMsg;
  private Integer orderLever;
  
  public UserIndexPosition(Integer id, Integer positionType, String positionSn, Integer userId, String realName, Integer agentId, String indexName, String indexCode, String indexGid, Date buyOrderTime, BigDecimal buyOrderPrice, Date sellOrderTime, BigDecimal sellOrderPrice, String orderDirection, Integer orderNum, BigDecimal allDepositAmt, BigDecimal orderFee, Integer orderStayDays, BigDecimal eachPoint, BigDecimal profitAndLose, BigDecimal allProfitAndLose, Integer isLock, String lockMsg, Integer orderLever)
  {
    this.id = id;
    this.positionType = positionType;
    this.positionSn = positionSn;
    this.userId = userId;
    this.realName = realName;
    this.agentId = agentId;
    this.indexName = indexName;
    this.indexCode = indexCode;
    this.indexGid = indexGid;
    this.buyOrderTime = buyOrderTime;
    this.buyOrderPrice = buyOrderPrice;
    this.sellOrderTime = sellOrderTime;
    this.sellOrderPrice = sellOrderPrice;
    this.orderDirection = orderDirection;
    this.orderNum = orderNum;
    this.allDepositAmt = allDepositAmt;
    this.orderFee = orderFee;
    this.orderStayDays = orderStayDays;
    this.eachPoint = eachPoint;
    this.profitAndLose = profitAndLose;
    this.allProfitAndLose = allProfitAndLose;
    this.isLock = isLock;
    this.lockMsg = lockMsg;
    this.orderLever = orderLever;
  }
  
  public UserIndexPosition() {}
  
  public Integer getId()
  {
    return this.id;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  public Integer getPositionType()
  {
    return this.positionType;
  }
  
  public void setPositionType(Integer positionType)
  {
    this.positionType = positionType;
  }
  
  public String getPositionSn()
  {
    return this.positionSn;
  }
  
  public void setPositionSn(String positionSn)
  {
    this.positionSn = positionSn;
  }
  
  public Integer getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(Integer userId)
  {
    this.userId = userId;
  }
  
  public String getRealName()
  {
    return this.realName;
  }
  
  public void setRealName(String realName)
  {
    this.realName = realName;
  }
  
  public Integer getAgentId()
  {
    return this.agentId;
  }
  
  public void setAgentId(Integer agentId)
  {
    this.agentId = agentId;
  }
  
  public String getIndexName()
  {
    return this.indexName;
  }
  
  public void setIndexName(String indexName)
  {
    this.indexName = indexName;
  }
  
  public String getIndexCode()
  {
    return this.indexCode;
  }
  
  public void setIndexCode(String indexCode)
  {
    this.indexCode = indexCode;
  }
  
  public String getIndexGid()
  {
    return this.indexGid;
  }
  
  public void setIndexGid(String indexGid)
  {
    this.indexGid = indexGid;
  }
  
  public Date getBuyOrderTime()
  {
    return this.buyOrderTime;
  }
  
  public void setBuyOrderTime(Date buyOrderTime)
  {
    this.buyOrderTime = buyOrderTime;
  }
  
  public BigDecimal getBuyOrderPrice()
  {
    return this.buyOrderPrice;
  }
  
  public void setBuyOrderPrice(BigDecimal buyOrderPrice)
  {
    this.buyOrderPrice = buyOrderPrice;
  }
  
  public Date getSellOrderTime()
  {
    return this.sellOrderTime;
  }
  
  public void setSellOrderTime(Date sellOrderTime)
  {
    this.sellOrderTime = sellOrderTime;
  }
  
  public BigDecimal getSellOrderPrice()
  {
    return this.sellOrderPrice;
  }
  
  public void setSellOrderPrice(BigDecimal sellOrderPrice)
  {
    this.sellOrderPrice = sellOrderPrice;
  }
  
  public String getOrderDirection()
  {
    return this.orderDirection;
  }
  
  public void setOrderDirection(String orderDirection)
  {
    this.orderDirection = orderDirection;
  }
  
  public Integer getOrderNum()
  {
    return this.orderNum;
  }
  
  public void setOrderNum(Integer orderNum)
  {
    this.orderNum = orderNum;
  }
  
  public BigDecimal getAllDepositAmt()
  {
    return this.allDepositAmt;
  }
  
  public void setAllDepositAmt(BigDecimal allDepositAmt)
  {
    this.allDepositAmt = allDepositAmt;
  }
  
  public BigDecimal getOrderFee()
  {
    return this.orderFee;
  }
  
  public void setOrderFee(BigDecimal orderFee)
  {
    this.orderFee = orderFee;
  }
  
  public Integer getOrderStayDays()
  {
    return this.orderStayDays;
  }
  
  public void setOrderStayDays(Integer orderStayDays)
  {
    this.orderStayDays = orderStayDays;
  }
  
  public BigDecimal getEachPoint()
  {
    return this.eachPoint;
  }
  
  public void setEachPoint(BigDecimal eachPoint)
  {
    this.eachPoint = eachPoint;
  }
  
  public BigDecimal getProfitAndLose()
  {
    return this.profitAndLose;
  }
  
  public void setProfitAndLose(BigDecimal profitAndLose)
  {
    this.profitAndLose = profitAndLose;
  }
  
  public BigDecimal getAllProfitAndLose()
  {
    return this.allProfitAndLose;
  }
  
  public void setAllProfitAndLose(BigDecimal allProfitAndLose)
  {
    this.allProfitAndLose = allProfitAndLose;
  }
  
  public Integer getIsLock()
  {
    return this.isLock;
  }
  
  public void setIsLock(Integer isLock)
  {
    this.isLock = isLock;
  }
  
  public String getLockMsg()
  {
    return this.lockMsg;
  }
  
  public void setLockMsg(String lockMsg)
  {
    this.lockMsg = lockMsg;
  }
  
  public Integer getOrderLever()
  {
    return this.orderLever;
  }
  
  public void setOrderLever(Integer orderLever)
  {
    this.orderLever = orderLever;
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.pojo.UserIndexPosition
 * JD-Core Version:    0.7.0.1
 */