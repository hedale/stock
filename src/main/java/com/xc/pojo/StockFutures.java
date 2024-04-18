package com.xc.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class StockFutures
{
  private Integer id;
  private String futuresName;
  private String futuresCode;
  private String futuresGid;
  private String futuresUnit;
  private Integer futuresStandard;
  private String coinCode;
  private Integer homeShow;
  private Integer listShow;
  private Integer depositAmt;
  private Integer transFee;
  private Integer minNum;
  private Integer maxNum;
  private Integer transState;
  private String transAmBegin;
  private String transAmEnd;
  private String transPmBegin;
  private String transPmEnd;
  private Date addTime;
  private String tDesc;
  private String transPmBegin2;
  private String transPmEnd2;
  private BigDecimal eachPoint;
  
  public StockFutures(Integer id, String futuresName, String futuresCode, String futuresGid, String futuresUnit, Integer futuresStandard, String coinCode, Integer homeShow, Integer listShow, Integer depositAmt, Integer transFee, Integer minNum, Integer maxNum, Integer transState, String transAmBegin, String transAmEnd, String transPmBegin, String transPmEnd, Date addTime, String tDesc, String transPmBegin2, String transPmEnd2, BigDecimal eachPoint)
  {
    this.id = id;
    this.futuresName = futuresName;
    this.futuresCode = futuresCode;
    this.futuresGid = futuresGid;
    this.futuresUnit = futuresUnit;
    this.futuresStandard = futuresStandard;
    this.coinCode = coinCode;
    this.homeShow = homeShow;
    this.listShow = listShow;
    this.depositAmt = depositAmt;
    this.transFee = transFee;
    this.minNum = minNum;
    this.maxNum = maxNum;
    this.transState = transState;
    this.transAmBegin = transAmBegin;
    this.transAmEnd = transAmEnd;
    this.transPmBegin = transPmBegin;
    this.transPmEnd = transPmEnd;
    this.addTime = addTime;
    this.tDesc = tDesc;
    this.transPmBegin2 = transPmBegin2;
    this.transPmEnd2 = transPmEnd2;
    this.eachPoint = eachPoint;
  }
  
  public StockFutures() {}
  
  public Integer getId()
  {
    return this.id;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  public String getFuturesName()
  {
    return this.futuresName;
  }
  
  public void setFuturesName(String futuresName)
  {
    this.futuresName = futuresName;
  }
  
  public String getFuturesCode()
  {
    return this.futuresCode;
  }
  
  public void setFuturesCode(String futuresCode)
  {
    this.futuresCode = futuresCode;
  }
  
  public String getFuturesGid()
  {
    return this.futuresGid;
  }
  
  public void setFuturesGid(String futuresGid)
  {
    this.futuresGid = futuresGid;
  }
  
  public String getFuturesUnit()
  {
    return this.futuresUnit;
  }
  
  public void setFuturesUnit(String futuresUnit)
  {
    this.futuresUnit = futuresUnit;
  }
  
  public Integer getFuturesStandard()
  {
    return this.futuresStandard;
  }
  
  public void setFuturesStandard(Integer futuresStandard)
  {
    this.futuresStandard = futuresStandard;
  }
  
  public String getCoinCode()
  {
    return this.coinCode;
  }
  
  public void setCoinCode(String coinCode)
  {
    this.coinCode = coinCode;
  }
  
  public Integer getHomeShow()
  {
    return this.homeShow;
  }
  
  public void setHomeShow(Integer homeShow)
  {
    this.homeShow = homeShow;
  }
  
  public Integer getListShow()
  {
    return this.listShow;
  }
  
  public void setListShow(Integer listShow)
  {
    this.listShow = listShow;
  }
  
  public Integer getDepositAmt()
  {
    return this.depositAmt;
  }
  
  public void setDepositAmt(Integer depositAmt)
  {
    this.depositAmt = depositAmt;
  }
  
  public Integer getTransFee()
  {
    return this.transFee;
  }
  
  public void setTransFee(Integer transFee)
  {
    this.transFee = transFee;
  }
  
  public Integer getMinNum()
  {
    return this.minNum;
  }
  
  public void setMinNum(Integer minNum)
  {
    this.minNum = minNum;
  }
  
  public Integer getMaxNum()
  {
    return this.maxNum;
  }
  
  public void setMaxNum(Integer maxNum)
  {
    this.maxNum = maxNum;
  }
  
  public Integer getTransState()
  {
    return this.transState;
  }
  
  public void setTransState(Integer transState)
  {
    this.transState = transState;
  }
  
  public String getTransAmBegin()
  {
    return this.transAmBegin;
  }
  
  public void setTransAmBegin(String transAmBegin)
  {
    this.transAmBegin = transAmBegin;
  }
  
  public String getTransAmEnd()
  {
    return this.transAmEnd;
  }
  
  public void setTransAmEnd(String transAmEnd)
  {
    this.transAmEnd = transAmEnd;
  }
  
  public String getTransPmBegin()
  {
    return this.transPmBegin;
  }
  
  public void setTransPmBegin(String transPmBegin)
  {
    this.transPmBegin = transPmBegin;
  }
  
  public String getTransPmEnd()
  {
    return this.transPmEnd;
  }
  
  public void setTransPmEnd(String transPmEnd)
  {
    this.transPmEnd = transPmEnd;
  }
  
  public Date getAddTime()
  {
    return this.addTime;
  }
  
  public void setAddTime(Date addTime)
  {
    this.addTime = addTime;
  }
  
  public String gettDesc()
  {
    return this.tDesc;
  }
  
  public void settDesc(String tDesc)
  {
    this.tDesc = tDesc;
  }
  
  public String getTransPmBegin2()
  {
    return this.transPmBegin2;
  }
  
  public void setTransPmBegin2(String transPmBegin2)
  {
    this.transPmBegin2 = transPmBegin2;
  }
  
  public String getTransPmEnd2()
  {
    return this.transPmEnd2;
  }
  
  public void setTransPmEnd2(String transPmEnd2)
  {
    this.transPmEnd2 = transPmEnd2;
  }
  
  public BigDecimal getEachPoint()
  {
    return this.eachPoint;
  }
  
  public void setEachPoint(BigDecimal eachPoint)
  {
    this.eachPoint = eachPoint;
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.pojo.StockFutures
 * JD-Core Version:    0.7.0.1
 */